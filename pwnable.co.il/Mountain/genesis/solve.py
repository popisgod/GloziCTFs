#!/usr/bin/env python3
from pwn import * 

context.binary = elf = ELF('./patched_genesis')
libc = ELF('libc-2.30.so')

if args['REMOTE']:
    io = remote('pwnable.co.il', 9000)
else: 
    io = process([elf.path])
    gdb.attach(io)

io.interactive()

'''
creatures - 0x555555558060
double free keey type 0 
leak heap address using test malloc 1 byte after free then use test to print name



'''