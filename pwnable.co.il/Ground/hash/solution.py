from pwn import * 
import hashlib

def find_md5_with_prefix(prefix):
    i = 0
    while True:
        # Create a string with an incremental value
        data = str(i) + '\n'
        
        # Calculate the MD5 hash
        md5_hash = hashlib.md5(data.encode()).hexdigest()
        
        # Check if the first two bytes match the specified prefix
        if md5_hash[:len(prefix)] == prefix:
            return data, md5_hash
        
        i += 1
        
        
        
context.log_level = 'DEBUG'
if args['LOCAL']:
    io = process('./hash')
else:
    io = remote('pwnable.co.il', 9006)
    
prefix = '537500'
payload, _ = find_md5_with_prefix(prefix)

print(_)
print(payload)

io.send(payload)
io.interactive()
