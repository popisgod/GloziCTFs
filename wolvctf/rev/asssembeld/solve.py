#!/usr/bin/env python3 
R9 = 0 
AX = 0x3148
DATA = [0x7057e21aec6c0ff2, 0x8ccf63b5baea8670, 0x4553156ee06c0bf8]
DATA= [byte for hex_value in DATA for byte in hex_value.to_bytes(8, 'little')]

XOR_ARRAY =[
    0x000000b841c68949, 0x8d4800000000b800, 0xb8660040110e251c, 0xc18841e3fff93148,
    0x0c0c8a42c9b60f4d, 0x0a1d8d48103c8a43, 0xffde0d8d4c000000, 0xb88a41e1ff41ffff,
    0x0ff9384000401183, 0x01a966ffffff4185, 0xd166c38966187400, 0x49c0ff66d80166e0,
    0xb57c18f88349c0ff, 0xff49e8d166e6ff41, 0x41a67c18f88349c0, 0x203f67616c66e6ff,
    0x2174636572726f63, 0x3a20676e6f72770a, 0xe21aec6c0ff20a28, 0x63b5baea86707057,
    0x156ee06c0bf88ccf, 0x0000000000004553, 0x0000000000000000, 0x0100000000000000,
    0x00fff10004000000, 0x0000000000000000, 0x0a00000000000000, 0x5d00010000000000,
    0x0000000000004010, 0x2000000000000000, 0x5f00010000000000, 0x0000000000004010,
    0x1e00000000000000
]
XOR_ARRAY = [byte for hex_value in XOR_ARRAY for byte in hex_value.to_bytes(8, 'little')]


def even():
    global AX 
    AX = AX >> 1 
    
def odd(): 
    global AX
    tmp = AX
    AX = AX << 1
    AX += tmp 
    AX += 1 

flag = ''

def extract_byte(number, byte_index):
    shifted_number = number >> (byte_index * 8)
    
    byte_mask = 0xFF
    
    extracted_byte = shifted_number & byte_mask
    
    return extracted_byte


for i in range(len(DATA)):
    xor_index = AX & 0xFF
    flag += chr(XOR_ARRAY[xor_index] ^ DATA[i]) 
    
    even() if AX % 2 == 0 else odd()
print(flag)
