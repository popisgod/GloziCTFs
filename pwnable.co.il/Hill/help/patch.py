#!/usr/bin/python3

from elftools.elf.elffile import ELFFile

with open('help', 'rb') as f:
    elffile = ELFFile(f)
    print("original e_shnum:\t" + str(len(elffile.get_section(1).data().decode('ascii').split('\x00')) + 1))
