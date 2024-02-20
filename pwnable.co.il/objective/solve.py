from pwn import * 

context.log_level = 'DEBUG'
context.binary = elf = ELF('./objective')

#Nulify alarm function
elf.asm(elf.symbols['alarm'], 'ret')
elf.save('./patched_objective')

context.binary = elf = ELF('./patched_objective')

if args['REMOTE']:
    io = remote('pwnable.co.il', 9005)
else: 
    io = process([elf.path])
    