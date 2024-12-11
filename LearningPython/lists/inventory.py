#====================================================
# Use this class but do not modify
class InventoryItem:
    def getItem(self):
        return self.__item

    def getCount(self):
        return self.__count
    
    def __init__(self,  item, count):
        self.__item = item
        self.__count = count

    def __eq__(self, other):
        return self.__item == other.__item and self.__count == other.__count

    def __str__(self):
        return self.__item + ": " + str(self.__count)

#====================================================

def inventoryAudit(manifest, actual):
    '''
Compares the inventory in a manifest to the actual count made when a shipment is
recieved and reports the results.
    manifest - the listing of the planned inventory
    actual - the counts of what was received
 returns a tuple with (matchingStatus, listOfDiscrepencies)
    '''
    return (True, [InventoryItem("Received Too Many", 7),
                    InventoryItem("Received Too Few", -4)])
    
#====================================================
# Test code below DO NOT MODIFY
import sys
sys.path.append('..')
from utils.testHelper import *
from utils.ledger import grab
    
def check(expected, actual):
    if not checkEquals(len(expected), len(actual), errorMessage="Wrong number of mismatched items"):
       return False
    for expectedItem in expected:
        if not expectedItem in actual:
            print("The expected result", expectedItem, "was not found in your results")
            return False
    return True
           

def testFixedSimple():
    success = True
    manifest = [InventoryItem("Dog Bones", 12), InventoryItem("Cat Toys", 4),
                InventoryItem("Human Treats", 6)]
    received = [InventoryItem("Dog Bones", 12), InventoryItem("Cat Toys", 2),
                InventoryItem("Human Treats", 8)]

    expected = [InventoryItem("Cat Toys", -2), InventoryItem("Human Treats", 2)]

    actual = inventoryAudit(manifest.copy(), manifest.copy())
    success &= checkEquals(True, actual[0], errorMessage="Your result marked the audit as different")
    success &= checkEquals([], actual[1], errorMessage="Your returned items where it should not have")

    actual = inventoryAudit(manifest.copy(), received.copy())
    success &= checkEquals(False, actual[0], errorMessage="Your result did not mark the audit as different")
    success &= check(expected, actual[1])
    return success

def testFixedTricky():
    success = True
    manifest = [InventoryItem("Dog Bones", 12), InventoryItem("Cat Toys", 4),
                InventoryItem("Human Treats", 6), InventoryItem("Ghost Food", 4)]
    received = [InventoryItem("Dog Bones", 12), InventoryItem("Cat Toys", 2),
                InventoryItem("Human Treats", 8), InventoryItem("Bonus Item", 1)]

    expected = [InventoryItem("Cat Toys", -2), InventoryItem("Human Treats", 2),
                InventoryItem("Ghost Food", -4), InventoryItem("Bonus Item", 1)]

    actual = inventoryAudit(manifest.copy(), manifest.copy())
    success &= checkEquals(True, actual[0], errorMessage="Your result marked the audit as different")
    success &= checkEquals([], actual[1], errorMessage="Your returned items where it should not have")

    actual = inventoryAudit(manifest.copy(), received.copy())
    success &= checkEquals(False, actual[0], errorMessage="Your result did not mark the audit as different")
    success &= check(expected, actual[1])
    return success

def testRandom():
    success = True
    manifest = []
    for count in range(random.randint(100,500)):
        manifest.append(InventoryItem("Item" + str(count), random.randint(1, 1000)))
    received = []
    expected = []
    for item in manifest:
        if random.randint(0, 10) > 5:
            updatedAmount = random.randint(1, item.getCount())
            if random.randint(0,2) == 1:
                updatedAmount = -updatedAmount
            received.append(InventoryItem(item.getItem(), item.getCount() + updatedAmount))
            expected.append(InventoryItem(item.getItem(), updatedAmount))
        else:
            received.append(item)

    actual = inventoryAudit(manifest.copy(), manifest.copy())
    success &= checkEquals(True, actual[0], errorMessage="Your result marked the audit as different")
    success &= checkEquals([], actual[1], errorMessage="Your returned items where it should not have")

    actual = inventoryAudit(manifest.copy(), received.copy())
    success &= checkEquals(False, actual[0], errorMessage="Your result did not mark the audit as different")
    success &= check(expected, actual[1])
    return success
    

# Only run this code below if this is called as the main, not imported
if __name__ == '__main__':

    FILE = "inventory"
    grab(FILE)
    if testFixedSimple() and testFixedTricky() and testRandom():
        print("Your Inventory Audit Passed!")
    
