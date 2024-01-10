from Crypto.Cipher import DES3  # 3-WAY algorithm is similar to Triple DES (DES3)
import binascii

encrypted_file = "710086"

# Function to attempt decryption with a given 4-bit key
def decrypt_with_key(key, ciphertext):
    try:
        key = binascii.unhexlify(key.zfill(2))  # Convert key from hex string to bytes
        cipher = DES3.new(key, DES3.MODE_CBC, iv=b'\x00\x00\x00\x00\x00\x00\x00\x00')
        decrypted_data = cipher.decrypt(ciphertext)
        return decrypted_data.decode(errors='ignore')  # Decode decrypted bytes to string
    except Exception as e:
        return None

# Read the encrypted file
with open(encrypted_file, 'rb') as file:
    ciphertext = file.read()

# Brute-force decryption using all possible 4-bit keys
for key in range(16):  # Try all 4-bit keys (from 0 to 15)
    key_hex = format(key, 'x')  # Convert key to hexadecimal string
    decrypted = decrypt_with_key(key_hex, ciphertext)
    
    if decrypted:
        print(f"Decryption with key {key_hex}: {decrypted}")
        # You might want to add further checks or criteria to determine if decryption was successful
