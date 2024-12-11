
EXAMPLE_SOLID_BOX = "*****\n*****\n*****\n*****\n*****\n"
def drawSolidBox(width, height):
    '''
Draw a solid box of the specified width and height
   width - the width of the box
   height - the height of the box
 returns the string that is the box (with new line - \n - included)
    '''
    out = ''
    for i in range(height):
        for j in range(width):
            out += '*'
        out += '\n'
    return out

EXAMPLE_EMPTY_BOX = "*****\n*   *\n*   *\n*   *\n*****\n"
def drawEmptyBox(width, height):
    '''
Draw an outlined box of the specified width and height
   width - the width of the box
   height - the height of the box
 returns the string that is the box (with new line - \n - included)
    '''
    out = ""

    for i in range(height):
        for j in range(width):
            if i == 0 or i == height - 1 or j == 0 or j == width - 1:
                out += '*'
            else:
                out += ' '
        out += '\n'
    return out

EXAMPLE_RIGHT_TRIANGLE = "*\n**\n***\n****\n*****\n"
def drawRightTriangle(size):
    '''
Draw a right triangle of the specified size (base facing down and left)
   size - the length of the triangle's two legs
 returns the string that is the triangle (with new line - \n - included)
    '''
    out = ""

    for i in range(size):
        for j in range(i+1):
            out += '*'
        out += '\n'
    return out

EXAMPLE_FLIPPED_RIGHT_TRIANGLE = "*****\n****\n***\n**\n*\n"
def drawFlippedRightTriangle(size):
    '''
Draw a right triangle of the specified size (base facing up and left)
   size - the length of the triangle's two legs
 returns the string that is the triangle (with new line - \n - included)
    '''
    out = ""

    for i in range(size):
        for j in range(size-i):
            out += '*'
        out += '\n'
    return out
    
EXAMPLE_MIRRORED_RIGHT_TRIANGLE = "    *\n   **\n  ***\n ****\n*****\n"
def drawMirroredRightTriangle(size):
    '''
Draw a right triangle of the specified size (bases facing up and right)
   size - the length of the triangle's two legs
 returns the string that is the triangle (with new line - \n - included)
    '''
    out = ""

    for i in range(size):
        for j in range(size-i-1):
            out += ' '
        for k in range(i+1):
            out += '*'
        out += '\n'
    return out

EXAMPLE_ISOSOLESE_TRIANGLE = "    *\n   ***\n  *****\n *******\n*********\n"
def drawIsosoleseTriangle(size):
    '''
Draw an isosolese triangle of the specified base size
   size - the length of the triangle's base
 returns the string that is the triangle (with new line - \n - included)
    '''
    out = ""

    for i in range(size):
        for j in range(size-i-1):
            out += ' '
        for k in range(2*i+1):
            out += '*'
        out += '\n'
    return out

#===================================================
# Test code below, do not modify
def printTest():
    allSuccessful = True
    solid = drawSolidBox(5, 5)
    if solid != EXAMPLE_SOLID_BOX:
        print("Solid Box is not there yet, this is what was expected:")
        print(EXAMPLE_SOLID_BOX)
        print(".............Your Drawing::")
        allSuccessful = False
    else:
        print("Solid Box is Perfect!")
    print(solid)
    print()

    empty = drawEmptyBox(5, 5)
    if empty != EXAMPLE_EMPTY_BOX:
        print("Empty Box is not there yet, this is what was expected:")
        print(EXAMPLE_EMPTY_BOX)
        print(".............Your Drawing::")
        allSuccessful = False
    else:
        print("Empty Box is Perfect!")
    print(empty)
    print()

    triangle1 = drawRightTriangle(5)
    if triangle1 != EXAMPLE_RIGHT_TRIANGLE:
        print("Right Triangle is not there yet, this is what was expected:")
        print(EXAMPLE_RIGHT_TRIANGLE)
        print(".............Your Drawing::")
        allSuccessful = False
    else:
        print("Right Triangle is Perfect!")
    print(triangle1)
    print()

    triangle2 = drawFlippedRightTriangle(5)
    if triangle2 != EXAMPLE_FLIPPED_RIGHT_TRIANGLE:
        print("Flipped Triangle is not there yet, this is what was expected:")
        print(EXAMPLE_FLIPPED_RIGHT_TRIANGLE)
        print(".............Your Drawing::")
        allSuccessful = False
    else:
        print("Flipped Triangle is Perfect!")
    print(triangle2)

    print()
    triangle3 = drawMirroredRightTriangle(5)
    if triangle3 != EXAMPLE_MIRRORED_RIGHT_TRIANGLE:
        print("Mirrored Right Triangle is not there yet, this is what was expected:")
        print(EXAMPLE_MIRRORED_RIGHT_TRIANGLE)
        print(".............Your Drawing::")
        allSuccessful = False
    else:
        print("Mirrored Right Triangle is Perfect!")
    print(triangle3)


    print()
    triangle4 = drawIsosoleseTriangle(5)
    if triangle4 != EXAMPLE_ISOSOLESE_TRIANGLE:
        print("Isosolese Triangle is not there yet, this is what was expected:")
        print(EXAMPLE_ISOSOLESE_TRIANGLE)
        print(".............Your Drawing::")
        allSuccessful = False
    else:
        print("Isosolese Triangle is Perfect!")
    print(triangle4)

if __name__ == '__main__':
    import sys
    sys.path.append('..')
    from utils.ledger import grab
    FILE = "boxDrawing"
    grab(FILE)
    printTest()
