#!/usr/bin/env python3 
with open('ciphertext','rb') as cipher_text: 
    data = cipher_text.read()
    print(len(data))
    
for size_secret in range(10, 60):
    temp = [data[i:i+size_secret] for i in range(0, len(data), size_secret)]
    if len(temp) * size_secret == len(data):
        print(len(temp), size_secret)
        
    