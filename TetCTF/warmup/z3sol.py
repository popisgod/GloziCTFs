from z3 import *

def hash_64_fnv1a(data):
    h = 14695981039346656037
    for byte in data:
        h = (h ^ byte) * 1099511628211
    return h

def xorshift128():
    global x, y, z, w
    t = x ^ (x << 11)
    x, y, z = y, z, w
    w = w ^ (w >> 19) ^ t ^ (t >> 8)
    return w

# Define symbolic variables for the input key
key_len = 0x54
input_key = [BitVec(f'input_key_{i}', 8) for i in range(key_len)]

# Constraint: length of the key must be 0x54
constraints = [len(input_key) == key_len]

# Constraint: restrict characters to '!', '_', or 'a'
valid_chars = [0x21, 0x5f, 0x61]
for i in range(key_len):
    constraints.append(Or(
        And(i % 4 == 0, input_key[i] != valid_chars[0]),
        And(i % 4 == 1, input_key[i] != valid_chars[1]),
        And(i % 4 == 2, input_key[i] != valid_chars[2])
    ))

# Simplified symbolic execution
x, y, z, w = 0x75bcd15, 0x159a55e5, 0x1f123bb5, 0xdeadbeef
local_248 = [hash_64_fnv1a(input_key[i:i+4]) for i in range(0, key_len, 4)]
local_198 = [0] * 0x15

for _ in range(0x15):
    for i in range(0x15):
        local_198[_] += local_248[i] * (xorshift128() % 0x400)

constraints.append(local_198 == [
    -0x90ee47fcb5, 0x673420daf2, 0x45eb817f02c, 0xfffffe3099503945,
    0x18f8dce1227, 0x26050ea6875, 0x298599c4bf0, 0xfffff8a356ce9e58,
    0xfffffed3c712cf36, 0xfffffe96846d630f, 0x58cb1ce3ff3, 0xfffffccf182c2a63,
    0xfffffe57fdf3f1de, 0xfffffa603f35f962, 0xffffff7884570b57,
    0x4897c4d9c1, 0xfffffeb9355e5cb4, 0xdcedf7d094, 0x3602e9cac47,
    0xfffffee3667219d6, 0xfffffdc326c9b063
])

# Use Z3 solver to find a satisfying input
solver = Solver()
solver.add(constraints)

if solver.check() == sat:
    model = solver.model()
    solution = [model[input_key[i]].as_long() for i in range(key_len)]
    print("Solution found:")
    print(bytes(solution).decode('utf-8'))
else:
    print("No solution found.")
