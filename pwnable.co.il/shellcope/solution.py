from pwn import * 

elf = ELF('./shellcope')
context.log_level = 'DEBUG'
libc = elf.libc 
context.arch = 'x86_64'
context.terminal = ["tmux", "splitw", "-h"]



if args['REMOTE']: 
    p = remote('pwnable.co.il', 9001)
else: 
    p = process([elf.path])
    gdb.attach(p, 'b main')   
    pause()


payload = (
    asm('nop'),
    asm('nop'),
)


p.sendline(payload)
p.interactive()
