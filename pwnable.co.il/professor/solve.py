#!/usr/bin/env python3

from pwn import *

elf = ELF('./professor')
libpthread = ELF("./libpthread-2.31.so")
libc = ELF("./libc.so.6")
ld = ELF("./ld-2.31.so")

context.binary = elf
context.log_level = 'DEBUG'

def conn():
    if args['remote']:
        r = remote("addr", 1337)

    else:
        r = process([elf.path])
        if args['DEBUG']:
            gdb.attach(r)
        
    return r


def main():
    r = conn()

    # good luck pwning :)

    r.interactive()


if __name__ == "__main__":
    main()
