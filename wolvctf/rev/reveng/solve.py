#!/usr/bin/env python3 

def rol(value, shift, bits=32):
    return ((value << shift) | (value >> (bits - shift))) & ((1 << bits) - 1)


with open('flag.txt', 'rb') as fout: 
    flag = b''
    for _ in range(12):
        byte_array = fout.read(4)
        number = int.from_bytes(byte_array, byteorder='little')
        byte_array = rol(number, 32 - 13).to_bytes(4, 'little')
        flag += byte_array
    
print(flag)