#!/usr/bin/env python3 
from pwn import * 

context.binary = elf = ELF(('./dragon'))

if args['REMOTE']:
    io = remote('pwnable.kr', 9012)
else: 
    io = process([elf.path])



payload = flat(
    
    

)

io.interactive()