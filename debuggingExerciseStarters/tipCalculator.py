import math

def calculateTip(billTotal, tipPercent, roundup=False):
    '''
Compute the tip based on the provided amount and percentage.  If the roundUp flag is set,
the tip should round the total up to the next full dollar amount.
   billTotal - total of the purchase
   percentage - the percentage tip (e.g., .2 = 20%, 1 = 100%)
   roundUp - if true, add to the tip so the billTotal + tip is an even dollar amount
 returns the calculated tip
    '''
    tip = round(billTotal * tipPercent, 2)
   # print(tip)
    
    total = billTotal + tip

    if roundup == True:
        extraTip = math.ceil(total)
       # print(extraTip)
        tip1 = round(extraTip - total, 2)
        print(tip)
        print(tip1)
        tip = tip + tip1

    


    
   # tip = billTotal * tipPercent
   # tip = round(tip, 2)
   # print(tip)
   # if roundup == True:
  #      tip = round(tip, 2)
  #  else:
     #   pass
    return tip


#==================================================================================================
# Testing code below
def testBasicTip():
    results = ""
    TESTS = [(20, 0.15, 3.0), (100, 0.001, 0.1), (10, 1, 10)]
    for test in TESTS:
        actual = calculateTip(test[0], test[1])
        expectedHigh = test[2] + 0.01
        expectedLow  = test[2] - 0.01
        if actual <= expectedLow or actual >= expectedHigh:
            results += "Basic Test Failed: for a total of " + str(test[0]) + " and percentage " + str(test[1]) + ", I expected " + str(test[2]) + " but your code returned " + str(actual) + "\n"
    return results

def testRoundupTip():
    results = ""
    TESTS = [(10.14, 0.15, 1.86), (100.01, 0.001, 0.99), (20.01, 0.15, 3.99)]
    for test in TESTS:
        actual = calculateTip(test[0], test[1], True)
        expectedHigh = test[2] + 0.01
        expectedLow  = test[2] - 0.01
        if actual <= expectedLow or actual >= expectedHigh:
            results += "Roundup Test Failed: for a total of " + str(test[0]) + " and percentage " + str(test[1]) + ", I expected " + str(test[2]) + " but your code returned " + str(actual) + "\n"
    return results

result = ""
result += testBasicTip()
result += testRoundupTip()

if len(result) == 0:
    print("All Tests Passed!")
else:
    print(result)
