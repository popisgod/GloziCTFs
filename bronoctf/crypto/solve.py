
line = ''

with open('abc.txt', 'r') as file: 
    ency = file.read()
    for char in ency:
        if char == 'a': 
            line = line + ('1')
        elif char == 'b': 
            line = line + ('2')
        elif char == 'c': 
            line = line + ('3')
               
               
with open('123.txt', 'w') as file:
    file.write(line)