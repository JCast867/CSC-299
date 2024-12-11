from graphics import *


def drawSnowman(win, x, y, size=1):
    head = Circle(Point(x, y), 30 * size)
    body = Circle(Point(x, y + 60), 40 * size)
    base = Circle(Point(x, y + 120), 50 * size)

    head.setFill("white")
    body.setFill("white")
    base.setFill("white")

    leftEye  = Oval(Point(x - 12, y-10), Point(x - 7, y-4))
    rightEye = Oval(Point(x + 7, y-10), Point(x + 12, y-4))

    leftEye.setFill("black")
    rightEye.setFill("black")

    base.draw(win)
    body.draw(win)
    head.draw(win)

    leftEye.draw(win)
    rightEye.draw(win)

def drawBackground(win):
    sky = Rectangle(Point(0, 0), Point(400, 400))
    sky.setFill("skyblue")
    sky.draw(win)

    ground = Rectangle(Point(0, 200), Point(400, 400))
    ground.setFill("white")
    ground.draw(win)


win = GraphWin('Snow Legion', 400, 400) # give title and dimensions
drawBackground(win)
drawSnowman(win, 170, 150)
drawSnowman(win, 50, 170, size=.5)
drawSnowman(win, 350, 70, size=2)
