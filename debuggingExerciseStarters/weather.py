def readWeatherData(filename):
    file = open(filename, 'r')
    file.readline() # skip the header
    tempsByStation = []
    
    for line in file:
        tokens = line.split(',')
        stationId = tokens[0][1:-1]
        date = tokens[3][1:-1]
        tavg = tokens[10][1:-1]
        if len(tavg) > 0:
            print(line)
            tempsByStation.append((stationId, date, tavg))

    return tempsByStation

def getDayOfMonth(date):
    tokens = date.split('-')
    return tokens[2]

def getBiMonthlyTemperatureVariance(data):
    weeklyTemps = []
    for entry in data:
        day = getDayOfMonth(entry[1])
        if day == 1 or 15:
            weeklyTemps.append(entry[2])
    return weeklyTemps

data = readWeatherData("2466150.csv")
temperatures = getBiMonthlyTemperatureVariance(data)
print(temperatures)
#for index in range(len(temperatures) - 1):
#    variance = temperatures[index + 1] - temperatures[index]
#    print (variance)
