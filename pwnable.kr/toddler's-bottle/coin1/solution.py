from pwn import * 

e


for _ in range(100):
    game_data = io.recvline().decode().strip().split()
    RANGE_START = 0 
    N = int(game_data[0].split('=')[1])
    C = int(game_data[1].split('=')[1])
    
    for i in range(C):
        msg = ' '.join(map(str, range(RANGE_START,  RANGE_START + N // 2)))
        io.sendline(msg.encode())
        weight = int(io.recvline().decode().strip()) 
        if N == 2 or weight == 9:
            counterfeit_coin = RANGE_START + (weight == 10)
        elif weight % 10 == 0:
            RANGE_START = RANGE_START + N // 2
            N = N // 2 if N % 2 == 0 else (N + 1) // 2
        else:
            N = N // 2 
        
    io.sendline(str(counterfeit_coin).encode()) 
    print(io.recvline().decode().strip())
    
print(io.recvline().decode())
print(io.recvline().decode())
