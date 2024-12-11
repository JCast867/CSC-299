import zlib
from datetime import datetime
import os.path
from os import path
import socket
import sys

DATE_TIME_FORMAT = "%d/%m/%Y %H:%M:%S"

LEDGER_EXTENSION = ".lgr"
PYTHON_EXTENSION = ".py"

def grab(pythonFilename):
    '''
Grab the code and save it to a ledger
   pythonFilename - the name of the file (no extention) to grab, which
     becomes the name of the ledger file as well
    '''
    inFile = open(pythonFilename + PYTHON_EXTENSION, "r")
    now = datetime.now()

    encodedContent = loadRaw(pythonFilename + LEDGER_EXTENSION)
    outFile = open(pythonFilename + LEDGER_EXTENSION, "wb")
    encodedContent += '<testrun time="' + \
                                now.strftime(DATE_TIME_FORMAT) + '" host="' + \
                                socket.gethostname() + '">\n'
    for line in inFile:
        encodedContent += line
    encodedContent += '</testrun>\n'
    outFile.write(zlib.compress(encodedContent.encode()))


def loadRaw(logFile):
    '''
Loads the raw file and decompresses its content
   logFile - the name of the log file
 returns a string that is the contents of the file
    '''
    if not path.exists(logFile): return ""
    
    inFile = open(logFile, "rb")
    compressed = inFile.read()
    content = zlib.decompress(compressed).decode('utf8')
    inFile.close()
    return content

SEARCHING = 0
READING   = 1

def parseHeader(line):
    '''
Parses the header of a ledger entry
   line - a string that is the XML header
 returns a tuble with the current time and current host name
    '''
    currentTime = ""
    currentHost = ""
    timeIndex = line.find('time="')
    endIndex  = line.find('"', timeIndex + 6)
    currentTime = datetime.strptime(line[timeIndex + 6: endIndex], DATE_TIME_FORMAT)

    hostIndex = line.find('host="')
    endIndex  = line.find('"', hostIndex + 6)
    currentHost = line[hostIndex + 6: endIndex]

    return (currentTime, currentHost)

def parse(logFile):
    '''
Parse a long file
   logFile - the name of the log file
 returns a list of tuples including the current time, current host and current code for each entry
    '''
    full = loadRaw(logFile)
    count = 0
    state = SEARCHING
    allEntries = []
    currentTime = ""
    currentHost = ""
    currentCode = []
    for line in full.split('\n'):
        if state == SEARCHING:
            if line.startswith("<testrun"):
                state = READING
                currentCode = []
                currentTime, currentHost = parseHeader(line)
        elif state == READING:
            if line.startswith("</testrun>"):
                state = SEARCHING
                allEntries.append((currentTime, currentHost, currentCode))
            else:
                currentCode.append(line)
    return allEntries

def parseNameOnly(logFileName):
    '''
Parse the file when you have the name but not the extension
    '''
    return parse(logFileName + LEDGER_EXTENSION)

def ledgerQuery():
    '''
A user interface to allow the user to see their ledger's contents
    '''
    allFiles = os.listdir(".")
    files = []
    for file in allFiles:
        if file.endswith(LEDGER_EXTENSION):
            files.append(file)
    
    if len(files) == 0:
        print("No ledger files found (ending in", LEDGER_EXTENSION + ")")
        return
    ledger = ""
    if len(files) == 1:
        ledger = files[0]
    else:
        index = 1
        for file in files:
            print(index, file)
            index = index + 1
        try:
            ledger =  files[int(input("Select the ledger file: ")) - 1]
        except (IndexError, ValueError):
            print("Invalid index")
            return
    
    print("1 - show history, 2 - show version from history")
    choice = input("Selection: ")
    if choice == "3":
        grab(ledger)
        allAttempts = parse(ledger)
        for attempt in allAttempts:
            print(attempt[0], attempt[1])
            for line in attempt[2]:
                print(line)
            print ("\n-------------------------------\n")
    elif choice == "1":
        id = 1;
        allAttempts = parse(ledger)
        for attempt in allAttempts:
            print(id, attempt[0])
            id = id + 1
    if choice == "2" or choice == "1":
        try:
            allAttempts = parse(ledger)
            code = allAttempts[int(input("Which index: ")) - 1]
            for line in code[2]:
                print(line)
        except (IndexError, ValueError):
            print("Invalid index")
            return
    else:
        print("Invalid choice, try again")

def report(logFilename):
    versions = parseNameOnly(logFilename)
    hosts = {}
    if len(versions) == 0:
        print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nNo Versions included in the ledger")
        return

    print("Versions:", len(versions))
    for version in versions:
        hostname = version[1]
        if hostname in hosts:
            hosts[hostname] += 1
        else:
            hosts[hostname] = 1
    print("Hosts:", hosts)
    print("Duration:", (versions[-1][0] - versions[0][0]), "(", versions[0][0], "-", versions[-1][0], ")")

        
if __name__ == '__main__':
    if len(sys.argv) > 1:
        report(sys.argv[1])
    else:
        ledgerQuery()
