import os
import sys
import string
import argparse

class php_encoder():

    def __init__(self,**kwargs):
        print("="*60 + " mucomplex " + "="*60)
        self.symbolic_list = string.digits + string.printable[62:94] 
        self.payload = kwargs.get('payload')
        self.method = kwargs.get('method')
        self.badchar(kwargs.get('badchar'))
        self.counter=0
        self.xor_list = []
        self.or_list = []
        self.php_encoder()

    def badchar(self,badchar):
        for char in badchar:
            self.symbolic_list = self.symbolic_list.replace(char,'')

    def php_encoder(self):
        while(self.counter != len(self.payload)):
            try:
                for x in self.symbolic_list:
                    for y in self.symbolic_list:
                        if(self.payload[self.counter] in self.symbolic_list):
                            self.xor_list.append("\"" + self.payload[self.counter] +"\".")
                            self.or_list.append("\"" + self.payload[self.counter] +"\".")
                            self.counter += 1
                            break
                        elif(chr(ord(y) ^ ord(x)) == self.payload[self.counter] and self.method == 'xor'):
                            self.xor_list.append("('"+x+"'^'"+y+"').")
                            self.counter += 1
                            #break
                        elif(chr(ord(y) | ord(x)) == self.payload[self.counter] and self.method == 'or'):
                            self.or_list.append("('"+x+"'|'"+y+"').")
                            self.counter += 1
                            #break
            except:
                None
        self.print_output()

    def print_output(self):
        if self.method == 'xor':
            print(''.join(self.xor_list)[:-1])
        if self.method == 'or' :
            print(''.join(self.or_list)[:-1])

parser = argparse.ArgumentParser()
parser.add_argument("payload", help="input payload")
parser.add_argument("encoder", help="xor or")
parser.add_argument("badchar", help="including badchar")
args = parser.parse_args()
make = php_encoder(payload=args.payload,method=args.encoder,badchar=args.badchar)