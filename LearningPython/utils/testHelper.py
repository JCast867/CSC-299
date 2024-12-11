import random

BASE_MESSAGE  = "Your result did not match the expected."
INPUT_MESSAGE = "Your result did not match the expected for the input {}."

def checkEquals(expected, actual, inputValue=None, errorMessage=None, errorPrefix = ""):
    if (expected == actual):
        return True
    else:
        if not errorMessage == None:
            message = errorMessage
        elif inputValue == None:
            message = BASE_MESSAGE
        else:
            message = INPUT_MESSAGE.format(inputValue)
        print(errorPrefix, message, "You returned", actual, "but I expected", expected)
        return False

def checkNotEquals(expected, actual, inputValue=None, errorMessage=None, errorPrefix = ""):
    if (not expected == actual):
        return True
    else:
        if not errorMessage == None:
            message = errorMessage
        elif inputValue == None:
            message = BASE_MESSAGE
        else:
            message = INPUT_MESSAGE.format(inputValue)
        print(errorPrefix, message, "You returned", actual, "which is equal to", expected, "but should not be")
        return False

ERROR_MESSAGE = "You returned the string (length = {}):\n<{}> but I expected (length ={})" 
def checkAnswer(expected, actual, inputValue=None, errorPrefix = ""):
    '''
Checks the expected value against the actual and prints details on where
they do not match.
   expected - the expected answer
   actual - the actual answer
 returns True if they match
    '''
    if (expected == actual):
        return True
    else:
        if inputValue == None:
            message = BASE_MESSAGE
        else:
            message = INPUT_MESSAGE.format(inputValue)
        
        print(errorPrefix, message, ERROR_MESSAGE.format(len(actual), actual, len(expected), expected))
        for index, c in enumerate(expected):
            if index >= len(actual):
                break
            actualChar = actual[index]
            if c != actualChar:
                if c == '\n': c = "\\n"
                if actual[index] == '\n': actualChar = "\\n"
                if c == ' ': c = "<space>"
                if actual[index] == ' ': actualChar = "<space>"
                if c == '\t': c = "\\t"
                if actual[index] == '\t': actualChar = "\\t"
                
                print("The first difference occured at index", index, "where I expected", c, "but got", actualChar)
                return False

        print("Your code contained the following extra characters (more than expected):")
        for index in range(len(expected), len(actual)):
            c = actual[index]
            if c == '\n': c = "\\n"
            if c == '\n': c = "\\n"
            if c == ' ': c = "<space>"
            if c == ' ': c = "<space>"
            if c == '\t': c = "\\t"
            if c == '\t': c = "\\t"
            print(c, end='')
        print()
        return False

def pickRandom(fromList):
    '''
Pick a random item from the list
   fromList a list of items
 returns a random value from the list
    '''
    randomIndex = random.randint(0, len(fromList) - 1)
    return fromList[randomIndex]


def findInCode(filename, findMe, onePerLine=False):
    '''
Searches the lines of code to see if the token exists, but not in a string or block string
   line - the line of code to search
   findMe - the thing to search
   onePerLine - if True, the algorithm stops searching when one has been found
                if False, multiple can exist on a line
 returns the count for the token searched
    '''

    file = open(filename+".py", 'r')

    total = 0
    inBlockQuote = False
    blockQuoteStart = None
    for line in file:
        #The challenges is when you have a full quote before the comment
        # so you have to check if you are in a quote before you count any character
        inQuote = False
        inComment = False
        for index in range(len(line) - len(findMe)):
            if line[index] == "#":
                inComment = True

            # This logic is not perfect, as if you have ''''' it will get confused
            if not inQuote and not inComment and \
               index + 3 < len(line) and \
              (line[index:index + 3] == "'''" or line[index:index + 3] == '"""'):
                if inBlockQuote and line[index:index + 3] == blockQuoteStart:
                    blockQuoteStart = None
                    inBlockQuote = False
                else:
                    blockQuoteStart = line[index:index + 3]
                    inBlockQuote = True
                
            # This logic is also flawed, as it does not look for ' and " strings 
            if not inBlockQuote and line[index] == "\"":
                if inQuote and line[index - 1] == "\\":
                    pass # it is a quote character literal
                else:
                    inQuote = not inQuote

            if not inQuote and not inBlockQuote and \
               index + len(findMe) < len(line) and line[index:index + len(findMe)] == findMe:
                total = total + 1
                if onePerLine:
                    break # can't have a second on a line
    return total    
