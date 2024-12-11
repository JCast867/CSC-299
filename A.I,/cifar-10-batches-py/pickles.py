
class ImageFile:
    def __init__(self, filename, data, label):
        self.filename = filename
        self.data = data
        self.label = label




def unpickle(file):
    import cPickle
    with open(file, 'rb') as fo:
        dict = cPickle.load(fo)
    return dict


def unpickle(file):
    import pickle
    with open(file, 'rb') as fo:
        dict = pickle.load(fo, encoding='latin1')
    return dict


metadata = unpickle('/Users/jaimecastaneda/Downloads/A.I,/cifar-10-batches-py/batches.meta')
print(metadata)


