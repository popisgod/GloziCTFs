import random 
input_length = 0x54 
char_list = ['!', '_', 'a']
win_values = [
    -0x90ee47fcb5, 0x673420daf2, 0x45eb817f02c, 0xfffffe3099503945,
    0x18f8dce1227, 0x26050ea6875, 0x298599c4bf0, 0xfffff8a356ce9e58,
    0xfffffed3c712cf36, 0xfffffe96846d630f, 0x58cb1ce3ff3, 0xfffffccf182c2a63,
    0xfffffe57fdf3f1de, 0xfffffa603f35f962, 0xffffff7884570b57,
    0x4897c4d9c1, 0xfffffeb9355e5cb4, 0xdcedf7d094, 0x3602e9cac47,
    0xfffffee3667219d6, 0xfffffdc326c9b063
]
local_248 = [0] * 0x15
local_198 = [0] * 0x15 
input_code = [0] * 0x54
input_code = [ord(random.choice(char_list)) for _ in range(input_length)]


def hash_64(index, size):
    local_20 = 0xcbf29ce484222325
    
    for i in range(size):
        local_20 = (local_20 ^ input_code[index + i]) * 0x100000001b3

    return local_20
       
for index in range(0x15): 
    local_248[index] = hash_64(index << 2, 4)
    
x = 0x75bcd15
y = 0x159a55e5
z = 0x1f123bb5
w = 0xdeadbeef

def xorshift128(): 
    global x, y, z, w 
    uVar1 = x ^ x << 0xb
    x = y
    y = z
    z = w
    w = w ^ w >> 0x13 ^ uVar1 ^ uVar1 >> 8
    return w 
    

for i in range(0x15):
    for j in range(0x15): 
        lvar1 = local_248[j]
        iVar2 = xorshift128()
        local_198[i] = lvar1 * (iVar2 % 400) + local_198[i]
        
        
if win_values == local_198:
    print('success') 
    print(input_code)
print([hex(value) for value in local_198])