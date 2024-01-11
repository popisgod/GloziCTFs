hashcode = int('0x21DD09EC', 16) 
portion = hashcode // 5 
remainder = hashcode - (portion * 4) 
assert portion * 4 + remainder == hashcode 
print(f'$(python -c \'print "{repr(portion.to_bytes(4, 'little'))[2:-1]}"*4 + "{repr(remainder.to_bytes(4, 'little'))[2:-1]}"\')')




