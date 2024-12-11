'''
The following variables are 'constants'.  A constant in most programming languages
is a variable that cannot be changed once set.  Python does not have any mechanism to
make a variable as constant, but I am using the convention from other languages to name
constants in capital letters.

Constants are used in code to avoid something called 'magic numbers'.  When someone reads
your code instead of seeing 2.5 and wondering what that value means, you can instead
use the constnat PENNY_WEIGHT which tells the reader exactly what the value 2.5 means.
It both makes it easier to understand your code, but also makes it easier later on
if, for example, the weight of a penny changes in the future.  Rather than changing
the value 2.5 in several places in your code, you can change the value of the constant.

Thus in this exericse, you should use the following constant rather than 'magic numbers'
when forming your logic!
'''
PENNY   = 0
NICKEL  = 1
DIME    = 2
QUARTER = 3
UNKNOWN = 4
	
PENNY_WEIGHT   = 2.5
NICKEL_WEIGHT  = 5.0
DIME_WEIGHT    = 2.268
QUARTER_WEIGHT = 5.67

PENNY_DIAMETER   = 0.75
NICKEL_DIAMETER  = 0.835
DIME_DIAMETER    = 0.705
QUARTER_DIAMETER = 0.955

WEIGHT_THRESHOLD   = 0.03
DIAMETER_THRESHOLD = 0.01

def __checkThresholds(weight, diameter, baseWeight, baseDiameter):
    weightLowerThreshold = baseWeight - (WEIGHT_THRESHOLD * baseWeight)
    weightUpperThreshold = baseWeight + (WEIGHT_THRESHOLD * baseWeight)
    diameterLowerThreshold = baseDiameter - (DIAMETER_THRESHOLD * baseDiameter)
    diameterUpperThreshold = baseDiameter + (DIAMETER_THRESHOLD * baseDiameter)

    if weight >= weightLowerThreshold and weight <= weightUpperThreshold:
        if diameter >= diameterLowerThreshold and diameter <= diameterUpperThreshold:
            return True
    return False
    

def isAPenny(weight, diameter):
    '''
Checks to see if the coin is a penny
  weight      - the weight of current coin to evaluate
  diameter    - the diameter of current coin to evaluate
 returns True if coin is a penny
    '''
    return __checkThresholds(weight, diameter, PENNY_WEIGHT, PENNY_DIAMETER)

def isANickel(weight, diameter):
    '''
Checks to see if the coin is a nickel
  weight      - the weight of current coin to evaluate
  diameter    - the diameter of current coin to evaluate
 returns True if coin is a nickel
    '''
    return __checkThresholds(weight, diameter, NICKEL_WEIGHT, NICKEL_DIAMETER)

def isADime(weight, diameter):
    '''
Checks to see if the coin is a dime
  weight      - the weight of current coin to evaluate
  diameter    - the diameter of current coin to evaluate
 returns True if coin is a dime
    '''
    return __checkThresholds(weight, diameter, DIME_WEIGHT, DIME_DIAMETER)
    

def isAQuarter(weight, diameter):
    '''
Checks to see if the coin is a quarter
  weight      - the weight of current coin to evaluate
  diameter    - the diameter of current coin to evaluate
 returns True if coin is a quarter
    '''
    return __checkThresholds(weight, diameter, QUARTER_WEIGHT, QUARTER_DIAMETER)
    
def clasifyCoin(weight, diameter):
    '''
Determine what type of coin was received based on the weight and diameter
  weight      - the weight of current coin to evaluate
  diameter    - the diameter of current coin to evaluate
 returns One of the coin types listed above, or UNKNOWN
    '''
    if isAPenny(weight, diameter):
        return PENNY
    elif isANickel(weight, diameter):
        return NICKEL
    elif isADime(weight, diameter):
        return DIME
    elif isAQuarter(weight, diameter):
        return QUARTER
    else:
        return UNKNOWN

#==================================================================
# Everything below here is tester code DO NOT MODIFY
TEST_DATA = [[2.5,  0.75,  PENNY],
            [5.0,   0.835, NICKEL],
            [2.268, 0.705, DIME],
            [5.67,  0.955, QUARTER],
            [5.67,  0.75,  UNKNOWN],
            [5.1,   0.83,  NICKEL],
            [5.7,   0.95,  QUARTER],
            [2.4,   0.705, UNKNOWN]]

# Test the coin functions
def coinTester():
    passed   = True

    #Penny Tests
    weight   = TEST_DATA[0][0]
    diameter = TEST_DATA[0][1]
    if not isAPenny(weight, diameter):
        passed = False
        print("isAPenny Fail: got False expected True",
              "for the values weight =", weight, "and diameter =", diameter)

    weight   = TEST_DATA[1][0]
    diameter = TEST_DATA[1][1]
    if isAPenny(weight, diameter):
        passed = False
        print("isAPenny Fail: got True expected False",
              "for the values weight =", weight, "and diameter =", diameter)

    #Nickel Tests
    weight   = TEST_DATA[1][0]
    diameter = TEST_DATA[1][1]
    if not isANickel(weight, diameter):
        passed = False
        print("isANickel Fail: got False expected True",
              "for the values weight =", weight, "and diameter =", diameter)

    weight   = TEST_DATA[2][0]
    diameter = TEST_DATA[2][1]
    if isANickel(weight, diameter):
        passed = False
        print("isANickel Fail: got True expected False",
              "for the values weight =", weight, "and diameter =", diameter)
        
    #Dime tests
    weight   = TEST_DATA[2][0]
    diameter = TEST_DATA[2][1]
    if not isADime(weight, diameter):
        passed = False
        print("isADime Fail: got False expected True",
              "for the values weight =", weight, "and diameter =", diameter)

    weight   = TEST_DATA[3][0]
    diameter = TEST_DATA[3][1]
    if isADime(weight, diameter):
        passed = False
        print("isADime Fail: got True expected False",
              "for the values weight =", weight, "and diameter =", diameter)

    #Quarter Tests
    weight   = TEST_DATA[3][0]
    diameter = TEST_DATA[3][1]
    if not isAQuarter(weight, diameter):
        passed = False
        print("isAQuarter Fail: got False expected True",
              "for the values weight =", weight, "and diameter =", diameter)

    weight   = TEST_DATA[4][0]
    diameter = TEST_DATA[4][1]
    if isAQuarter(weight, diameter):
        passed = False
        print("isAQuarter Fail: got True expected False",
              "for the values weight =", weight, "and diameter =", diameter)
        
    for testData in TEST_DATA:
        weight   = testData[0]
        diameter = testData[1]
        expected = testData[2]

        answer = clasifyCoin(weight, diameter)
        if answer != expected:
            passed = False
            print("Fail: got", answer, "expected", expected,
                  "for the values weight =", weight, "and diameter =", diameter)

    if passed:
        print("All coin tests passed")

# Only run this code below if this is called as the main, not imported
if __name__ == '__main__':
    import sys
    sys.path.append('..')
    from utils.ledger import grab

    FILE = "coinMeter"
    grab(FILE)
    coinTester()
