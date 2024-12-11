def reportStats(filename):
    '''
    '''
    file = open(filename, 'r')
    file.readline()

    numberOfGames = 0
    totals = [0, 0, 0, 0, 0, 0, 0.0]
    #The totals are as shown below with the last value the batting average
    for line in file:
        tokens = line.split(",")
        attempts = int(tokens[0])
        hits     = int(tokens[1])
        so       = int(tokens[2])
        bb       = int(tokens[3])
        runs     = int(tokens[4])
        rbis     = int(tokens[5])
        totals[0] += attempts
        totals[1] += hits
        totals[3] += so
        totals[2] += bb
        totals[4] += runs
        totals[5] += rbis
        totals[6] += hits/(attempts - bb)
        numberOfGames += 1
    totals[6] = totals[6]/numberOfGames #Add the batting average at the end
    print (totals)
        


reportStats("stats.txt")
