import matplotlib.pyplot as plt
import numpy as np
import os
import PIL
import tensorflow as tf

from tensorflow import keras
from tensorflow.keras import layers
from tensorflow.keras.models import Sequential

import pathlib

img_height = 180
img_width = 180

def createDataset(dataDirectory, name,
                  batch_size = 32):
    dataset = tf.keras.preprocessing.image_dataset_from_directory(
      dataDirectory,
      validation_split=0.2,
      subset=name,
      seed=123,
      image_size=(img_height, img_width),
      batch_size=batch_size)
    return dataset

def showSampleImages(trainingDataset):
    class_names = trainingDataset.class_names
    plt.figure(figsize=(10, 10))
    for images, labels in trainingDataset.take(1):
      for i in range(9):
        ax = plt.subplot(3, 3, i + 1)
        print(images[i])
        plt.imshow(images[i].numpy().astype("uint8"))
        plt.title(class_names[labels[i]])
        plt.axis("off")
    plt.show()

def prepareData(trainingDataset, validationDataset):
    AUTOTUNE = tf.data.AUTOTUNE

    trainingDataset = trainingDataset.cache().shuffle(1000).prefetch(buffer_size=AUTOTUNE)
    validationDataset = validationDataset.cache().prefetch(buffer_size=AUTOTUNE)

    normalization_layer = layers.experimental.preprocessing.Rescaling(1./255)

    normalized_ds = trainingDataset.map(lambda x, y: (normalization_layer(x), y))
    image_batch, labels_batch = next(iter(normalized_ds))
    first_image = image_batch[0]
    return (trainingDataset, validationDataset)

def createModel():
    num_classes = 5
    model = Sequential([
      layers.experimental.preprocessing.Rescaling(1./255, input_shape=(img_height, img_width, 3)),
      layers.Conv2D(16, 3, padding='same', activation='relu'),
      layers.MaxPooling2D(),
      layers.Conv2D(32, 3, padding='same', activation='relu'),
      layers.MaxPooling2D(),
      layers.Conv2D(64, 3, padding='same', activation='relu'),
      layers.MaxPooling2D(),
      layers.Flatten(),
      layers.Dense(128, activation='relu'),
      layers.Dense(num_classes)
    ])

    model.compile(optimizer='adam',
                  loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
                  metrics=['accuracy'])
    return model    

def trainModel(model, trainingDataset, validationDataset, epochs=10):
    history = model.fit(trainingDataset,
                        validation_data=validationDataset,
                        epochs=epochs)

    return history

def saveModel(model, location):
    model.save(location)

def showTrainingStats(history, epochs=10):
    acc = history.history['accuracy']
    val_acc = history.history['val_accuracy']

    loss = history.history['loss']
    val_loss = history.history['val_loss']

    epochs_range = range(epochs)

    plt.figure(figsize=(8, 8))
    plt.subplot(1, 2, 1)
    plt.plot(epochs_range, acc, label='Training Accuracy')
    plt.plot(epochs_range, val_acc, label='Validation Accuracy')
    plt.legend(loc='lower right')
    plt.title('Training and Validation Accuracy')

    plt.subplot(1, 2, 2)
    plt.plot(epochs_range, loss, label='Training Loss')
    plt.plot(epochs_range, val_loss, label='Validation Loss')
    plt.legend(loc='upper right')
    plt.title('Training and Validation Loss')
    plt.show()

def testModel(testImageURL, model, class_names):
    testImagePath = tf.keras.utils.get_file(origin=testImageURL)

    img = keras.preprocessing.image.load_img(testImagePath, target_size=(img_height, img_width))
    img_array = keras.preprocessing.image.img_to_array(img)
    img_array = tf.expand_dims(img_array, 0) # Create a batch

    predictions = model.predict(img_array)
    score = tf.nn.softmax(predictions[0])

    print(
        "This image most likely belongs to {} with a {:.2f} percent confidence."
        .format(class_names[np.argmax(score)], 100 * np.max(score))
    )

    plt.figure(figsize=(10, 10))
    plt.imshow(img)
    plt.title("Test Image")
    plt.axis("off")
    plt.show()


def fullTrainingCycle(data_dir, modelDirectory):
    train_ds = createDataset(data_dir, "training")
    val_ds = createDataset(data_dir, "validation")

    showSampleImages(train_ds)

    train_ds, val_ds = prepareData(train_ds, val_ds)

    model = createModel()
    model.summary()

    history =  trainModel(model, train_ds, val_ds)

    saveModel(model, modelDirectory)

    showTrainingStats(history)


def loadPrior(data_dir, modelDirectory):
    print("Load prior training data")
    train_ds = createDataset(data_dir, "training")
    val_ds = createDataset(data_dir, "validation")

    print("Setup the AI/ML Model")
    model = createModel()
    model.load_weights(modelDirectory)
    model.summary()

    print("Start tests")
    while True:
        import tkinter as tk
        root = tk.Tk()
        root.withdraw() 

        print("got root", data_dir)
        from tkinter import filedialog
        testImageURL = "file://" + filedialog.askopenfile(initialfile=data_dir).name[2:]
        print("got url")
        testModel(testImageURL, model, train_ds.class_names)

        if input("Test another?") != "y":
            break

data_dir = pathlib.Path("E:\\Downloads\\testImages")
modelFolder = "imageModel"
#fullTrainingCycle(data_dir, modelFolder)
loadPrior(data_dir, modelFolder)
