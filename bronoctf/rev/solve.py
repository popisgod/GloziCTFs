







if guess > 20:
    return False
binString = '0'
for _ in range(0, guess):
    binString += '1'
binary = int(binString, 2)
return chr(binary) == '?'
