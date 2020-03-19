import random
import sys

numOfdates = int(sys.argv[1])

def genDates ():
    month = random.randrange(1,13)

    if month == 1:
        day = random.randrange(1,32)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 31 ,day)
    elif month == 2:
        day = random.randrange(1,29)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 28 ,day)
    elif month == 3:
        day = random.randrange(1,32)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 31 ,day)
    elif month == 4:
        day = random.randrange(1,31)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 30 ,day)
    elif month == 5:
        day = random.randrange(1,32)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 31 ,day)
    elif month == 6:
        day = random.randrange(1,31)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 30 ,day)
    elif month == 7:
        day = random.randrange(1,32)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 31 ,day)
    elif month == 8:
        day = random.randrange(1,32)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 31 ,day)
    elif month == 9:
        day = random.randrange(1,31)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 30 ,day)
    elif month == 10:
        day = random.randrange(1,32)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 31 ,day)
    elif month == 11:
        day = random.randrange(1,31)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 31 ,day)
    elif month == 12:
        day = random.randrange(1,32)
        checkIn = [2020, month, day]
        checkOut = genCheckOut(month, 31 ,day)

    return [checkIn, checkOut]

def genCheckOut(month, daysInMonth, checkIn):
    stay = random.randrange(1,15)
    checkOut = (checkIn + stay) % daysInMonth
    if checkOut < checkIn:
        month = month + 1
    if month > 12:
        month = 1
        return [2021, month, checkOut]
    return [2020, month, checkOut]

def printDates(dates):
    checkIn = dates[0]
    checkOut = dates[1]

    if checkIn[1] < 10:
        checkInMonth = '-0' + str(checkIn[1])
    else:
        checkInMonth = '-' + str(checkIn[1])
    if checkIn[2] < 10:
        checkInDay = '-0' + str(checkIn[2])
    else:
        checkInDay = '-' + str(checkIn[2])

    if checkOut[1] < 10:
        checkOutMonth = '-0' + str(checkOut[1])
    else:
        checkOutMonth = '-' + str(checkOut[1])
    if checkOut[2] < 10:
        checkOutDay = '-0' + str(checkOut[2])
    else:
        checkOutDay = '-' + str(checkOut[2])
    
    checkIn = str(checkIn[0]) + checkInMonth + checkInDay
    checkOut = str(checkOut[0]) + checkOutMonth + checkOutDay  
    print(checkIn + ';' + checkOut)

for i in range (0, numOfdates):
    dates = genDates()
    printDates(dates) 
