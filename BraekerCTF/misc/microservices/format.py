from Crypto.Util.number import bytes_to_long, long_to_bytes

 
# Read the input data from a file
with open('solve.txt', 'r') as file:
    lines = file.readlines()

# Initialize a dictionary to store the values
values = {}

# Parse the lines and store values in the dictionary
for line in lines:
    index = int(line.split(" ")[3])
    value = int(line.split(" ")[-1])
    values[index] = value

# Reformat the data into lines of 8 characters each
formatted_line = ''
for i in range(len(values)):
    formatted_line += str(values[i])
    
long_integer = int(formatted_line, 2)
# Convert long integer back to bytes
reversed_bytes = long_to_bytes(long_integer)

print("Reversed bytes:", reversed_bytes)