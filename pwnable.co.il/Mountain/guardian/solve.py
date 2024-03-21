#!/usr/bin/env python3 
from pwn import * 

context.log_level = 'DEBUG'
context.binary = elf = ELF('./guardian')

if args['REMOTE']:
    io = remote('pwnable.co.il', 9018)
else:
    io = process([elf.path])
    gdb.attach(io)

def create_guardian(index, name, Weapon):
    global io 
    
    io.recvuntil(b'> ')
    io.sendline(b'1')
    io.recvuntil(b'Index: ')
    io.sendline(str(index).encode())
    io.recvuntil(b'name: ')
    io.sendline(str(len(name)).encode())
    io.recvuntil(b'Name: ')
    io.sendline(name.encode())
    io.recvuntil(b'power\n')
    io.sendline(b'1')
    io.recvuntil('Weapon: ')
    io.sendline(Weapon.encode())
    
def fight_monster(index, weapon): 
    pass

create_guardian(0, 'dad', 'asgard')

io.interactive()

    
    
    