import binascii 
from Crypto.Cipher import AES
from os import urandom
from string import printable
import random
from time import time


flag = "brck{not_a_flag}"
key = urandom(32)

def encrypt(raw):
	cipher = AES.new(key, AES.MODE_ECB)
	return binascii.hexlify(cipher.encrypt(raw.encode()))

# Generate random bytes
random.seed(int(time()))
rand_printable = [x for x in printable]
random.shuffle(rand_printable)

# Generate ciphertext
with open('demo.txt','w') as fout:
    for x in flag:
        fout.write(encrypt(x * 32).decode() + '\n')