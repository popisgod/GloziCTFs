# Define the values
values = [
    0x7830, 
    0x38303037, 0x44313637,
    0x43304531, 0x33303343,
    0x41413131, 0x34304130, 
    0x44354442, 0x39413434, 
    0x32363346, 0x32393333,
    0x35363831, 0x44394541, 
    0x34443444, 0x30463137, 
    0x38393236, 0x44463242,  
    0x463439
]

# Convert each value to its corresponding ASCII character
long_string = ''
for value in values:
    if value != 0:
        for i in range(4):
            byte = (value >> (8 * i)) & 0xff
            if byte != 0:
                long_string += chr(byte)

print(long_string[12:])
