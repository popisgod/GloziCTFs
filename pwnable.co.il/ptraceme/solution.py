from pwn import * 

context.log_level = 'DEBUG'
if args['REMTOE']:
    pass
else: 
    io = process('./ptraceme')
    gdb.attach(io, 'b main')
    pause()

