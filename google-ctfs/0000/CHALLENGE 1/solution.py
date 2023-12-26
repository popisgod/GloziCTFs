with open('encrypted_message.txt', 'r') as file:
    msg = file.readline().lower()

shift_value = [2, 0, 4, 17 ]
decoded_msg = ''

index = 0 
for ch in msg: 
    if ch.isalpha(): 
        decoded_msg += chr((((ord(ch) - ord('a')) - shift_value[index % 4]) % 26) + ord('a')) 
        index += 1
    else: 
        decoded_msg += ch 
        
print(decoded_msg)