import hashlib
from itertools import product


# Define the characters
characters = ['d', 'p']

# Generate all combinations of length 8
combinations = product(characters, repeat=8)


# Convert combinations to strings and hash them
for combination in combinations:
    string = ''.join(combination)
    sha256_hash = hashlib.sha256(string.encode('utf-8')).digest()
    if sha256_hash[:2] == b'EF':
        print(f"Found matching hash for string: {string}")
        break
