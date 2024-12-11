
def multiplyWithoutStar(first, second):
    result = 0
    for num in range(second):
        result += first
    return result

def multiplyWithoutStar2(first, second):
    if second == 0:
        return 0
    return first + multiplyWithoutStar2(first, second-1)
    
def multiplyWithoutStar3(first, second):
    return sum([first for num in range(second)])

def multiplyWithoutStar4(first, second):
    result = 0
    counter = second
    while counter > 0:
        result += first
        counter -= 1
    return result

def multiplyWithoutStar5(first, second):
    return None

#====================================================
# Test code below DO NOT MODIFY
import sys
sys.path.append('..')
from utils.testHelper import *
from utils.ledger import grab
    
def check(multiplyFunction):
    success = True
    if (multiplyFunction(0,0) == None):
        print("Skipped", multiplyFunction)
        return success
    success &= checkEquals(4, multiplyFunction(2, 2), errorMessage="Did not properly multiply 2 * 2")
    success &= checkEquals(0, multiplyFunction(0, 2), errorMessage="Did not properly multiply 0 * 2")
    success &= checkEquals(-4, multiplyFunction(-2, 2), errorMessage="Did not properly multiply -2 * 2")
    return success


# Only run this code below if this is called as the main, not imported
if __name__ == '__main__':
    FILE = "multiplyWithoutStar"
    grab(FILE)
    multiplyCount = findInCode(FILE, "*") - 1 # the import has one
    
    if check(multiplyWithoutStar) and\
       check(multiplyWithoutStar2) and\
       check(multiplyWithoutStar3) and\
       check(multiplyWithoutStar4) and\
       check(multiplyWithoutStar5):
        print("All tests passed!")
        if (multiplyCount > 0):
           print("But your code had", multiplyCount, "* signs in it")
