from pwn import * 
import sys 

elf = ELF('./main')
process = process([elf.path])
context.log_level = 'DEBUG'

for i in range(-sys.maxsize - 1 , sys.maxsize):
    process.recvuntil(')')
    process.sendline(str(i))
    
    result = process.recv()
    if b'fakeflag' in result:
        print(i)
        print('won')
        break 