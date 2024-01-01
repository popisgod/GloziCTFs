with open('encrypted_message.txt', 'r') as file:
    msg = file.readline().lower()

shift_value = ord('T') - ord('G') 
decoded_msg = ''


for ch in msg: 
    if ch.isalpha(): 
        decoded_msg += chr((((ord(ch) - ord('a'))- shift_value) % 26) + ord('a')) 
    else: 
        decoded_msg += ch 
        
print(decoded_msg)

