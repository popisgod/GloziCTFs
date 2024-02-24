import ctypes 


def token_generator(part1_pointer, array):
    counter2 = ctypes.c_int(0)
   
    for _ in range(0x20):
        part1_pointer[0] = part1_pointer[0] + (array[1] + (part1_pointer[1] >> 5) ^
                           part1_pointer[1] * 0x10 + array[0] ^ counter2.value + part1_pointer[1])
        counter2.value = counter2.value + 0x61c88647
        part1_pointer[1] = part1_pointer[1] + (
                            part1_pointer[0] * 0x10 + array[2] ^ counter2.value + part1_pointer[0] ^
                            array[3] + (part1_pointer[0] >> 5))


# Define the input values
array = [0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476]
part1_and_part2_values = [0xf27aedbf, 0xed00b66c]  # Values for part1 and part2

# Convert the input values to appropriate types
array_ptr = (ctypes.c_int * len(array))(*array)
part1_and_part2_ptr = (ctypes.c_uint * len(part1_and_part2_values))(*part1_and_part2_values)

# Call FUNC_A with the converted input values
token_generator(part1_and_part2_ptr, array_ptr)
token = f'{part1_and_part2_ptr[0]}_{part1_and_part2_ptr[1]}'
print(token)

# hex_values = [
#     0x655362532f474470,
#     0x7336316c324d4768,
#     0x5a4452786d467a52,
#     0x584e50326974434e,
#     0x5a39597a
# ]

# long_string = ""

# for value in hex_values:
#     hex_string = hex(value)[2:]  # Removing '0x' prefix
#     byte_array = bytes.fromhex(hex_string)
#     string = byte_array.decode('utf-8')
#     long_string += string


# token = f'{part1}_{part2}'
# print(token)
# print(len(token))
# print(long_string)
# print(len(long_string))