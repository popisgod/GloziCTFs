#!/usr/bin/env python3
from pwn import * 

while True:
    io = remote('0.cloud.chals.io', 26265)
    encrypted = io.recv()
    io.close()

    start_secret = 'brck{'
    key = []

    for i, char in enumerate(encrypted): 
        if i < 5:
            key.append(char ^ ord(start_secret[i]))
        
    if key[0] in key[1:]:
        with open('secret.txt', 'wb') as file:
            file.write(encrypted)
    
    if key[0] == key[-1]: 
        dec = ''
        for i, char in enumerate(encrypted):
            dec += chr(char ^ key[i % 4])
        
        print(dec)
        break