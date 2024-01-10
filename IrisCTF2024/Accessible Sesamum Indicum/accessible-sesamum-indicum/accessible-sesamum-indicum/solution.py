import random
from pwn import * 
import itertools


MAX_DIGITS = 65536
i = 0 
sock = remote('accessible-sesasum-indicum.chal.irisc.tf', 10104)

for _ in range(21):
    initial_output = sock.recvline()
    print(initial_output)
print('------')

while True: 
    # Define the characters available for the PIN
    characters = '0123456789abcdef'

    # Generate a string of 65536 characters
    all_characters = ''.join(characters for _ in range(4096))

    # Create a list to store PIN attempts
    pin_attempts = []

    # Extract adjacent 4-character substrings and concatenate them
    for idx in range(len(all_characters) - 3):
        pin_attempt = all_characters[idx:idx + 4]
        pin_attempts.append(pin_attempt)

    # Create the final string by concatenating all PIN attempts
    result_string = ''.join(pin_attempts)

    print(len(result_string))
    
    sock.send(f'{result_string}\n'.encode())

    stdout = sock.recvline().decode()
    
    if 'vault' in stdout:
        i += 1
        print('Vault solved!')
    
        if i == 16: 
            print(sock.recv().decode())    
    