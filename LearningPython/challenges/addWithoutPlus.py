
def addWithoutPlus(first, second):
    result = first - (-1) * second
    return result

def addWithoutPlus2(first, second):
    result = second - (-1) * first
    return result

def addWithoutPlus3(first, second):
    return sum([first, second])

def addWithoutPlus4(first, second):
    return None

def addWithoutPlus5(first, second):
    return None

#====================================================
# Test code below DO NOT MODIFY
import sys
sys.path.append('..')
from utils.testHelper import *
from utils.ledger import grab
    
def check(plusFunction):
    success = True
    if (plusFunction(0,0) == None):
        print("Skipped", plusFunction)
        return success
    success &= checkEquals(4, plusFunction(2, 2), errorMessage="Did not properly add 2 + 2")
    success &= checkEquals(2, plusFunction(0, 2), errorMessage="Did not properly add 0 + 2")
    success &= checkEquals(0, plusFunction(-2, 2), errorMessage="Did not properly add -2 + 2")
    return success


# Only run this code below if this is called as the main, not imported
if __name__ == '__main__':
    FILE = "addWithoutPlus"
    grab(FILE)
    plusCount = findInCode(FILE, "+")
    
    if check(addWithoutPlus) and\
       check(addWithoutPlus2) and\
       check(addWithoutPlus3) and\
       check(addWithoutPlus4) and\
       check(addWithoutPlus5):
        print("All tests passed!")
        if (plusCount > 0):
           print("But your code had", plusCount, "+ signs in it")
