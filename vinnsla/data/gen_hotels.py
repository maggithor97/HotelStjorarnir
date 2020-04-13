import sys

# Name;Address;City
hotel = sys.argv[1] + '\n'

# Path hotels/hotel_<name>
filename = sys.argv[2]

output = open(filename, 'w')
output.write(hotel)

for i in range(100, 105):
    s = '2-bedroom;' + str(i) + ';20000\n'
    output.write(s)

for i in range(200,205):
    s = '3-bedroom;' + str(i) + ';30000\n'
    output.write(s)

for i in range(400,400):
    s = 'Suite;' + str(i) + ';50000\n'
    output.write(s)
