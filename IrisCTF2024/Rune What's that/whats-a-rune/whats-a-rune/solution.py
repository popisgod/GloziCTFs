def decrypt_flag(encrypted):
    decrypted = []
    z = 0
    
    for v in encrypted:
        decrypt_char = chr(ord(v) - z)
        decrypted.append(decrypt_char)
        z = ord(decrypt_char)

    return ''.join(decrypted)

with open('./the', 'r') as encrypted_flag:
    encrypted_flag = encrypted_flag.readline() 
decrypted_flag = decrypt_flag(encrypted_flag)
print("Decrypted flag:", decrypted_flag)
