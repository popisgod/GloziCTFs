import ctypes
random_value = 0x18ec8348
expected_result = 0xdeadbeef

key = expected_result ^ random_value
print(key)
signed_value = ctypes.c_int32(key).value
print(signed_value)
assert (key ^ random_value) == 0xdeadbeef