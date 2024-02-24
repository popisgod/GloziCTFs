from pwn import * 
context.binary = elf = ELF('./pizza')
libc = ELF('./libc.so.6')
context.log_level = 'DEBUG'
preload_env = {"LD_PRELOAD": './libc.so.6'}

if args['REMOTE']:
	io = remote('chall.lac.tf', 31134)
else:
	io = process([elf.path], env=preload_env)
	gdb.attach(io)

