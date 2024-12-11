def startHere():
    print("Run before you code!")
    value = input("Did you run before writing code? ")
    print("I  added  code?")
    
        
#=============================================================
# Testing code below - DO NOT EDIT
import subprocess

def testPythonUI():
    uut = subprocess.Popen('python3 aPlaceToStart.py -test'.split(),
                            stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    output, err = uut.communicate("Of course!".encode(), 1)
    result = output.decode('utf-8')

    if len(err) > 0:
        print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        print("Your code produced an error:")
        print(err.decode('utf-8'))
        print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")

    elif len(result) == 0:
        print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        print("Your program did not provide output and you may need to tweak your tester.",
              "It probably is becuase of the OS you are working on.  For Macs, you may need to",
              "change the tester to call 'python3' instead of 'python' (or vice versa).",
              "See the info on the course page or check with your instructor")
        print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")

    expected = "I  added  code"
    if result.find(expected) == -1:
        success = False
        print("...... Test Failed......")
        print("Did not find the expected value in your output:")
        print(result)
    else:
        print("Test Passed!")

# Only run this code below if this is called as the main, not imported
if __name__ == '__main__':
    import sys
    if len(sys.argv) == 1: #Ignore this for the automated tester, which adds a parameter
        sys.path.append('..')
        from utils.ledger import grab
        FILE = "aPlaceToStart"
        grab(FILE)

        testPythonUI()

    startHere()
