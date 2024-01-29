def transform_string(input_string):
    transformed_string = ""

    for char in input_string:
        if not ('a' <= char <= 'z'):
            if '@' <= char <= '[':
                char = chr(ord(char) - 0x34 + ((ord(char) - 0x34) // 0x1a) * -0x1a + ord('A'))
        else:
            char = chr(ord(char) - 0x54 + ((ord(char) - 0x54) // 0x1a) * -0x1a + ord('a'))

        transformed_string += char

    return transformed_string

def transform_string2(Imknight_string, param_2):
    result_string = ""

    for char in Imknight_string:
        if char.isalpha():
            if char.isupper():
                result_char = chr((ord(char) + param_2 - ord('A')) % 26 + ord('A'))
            else:
                result_char = chr((ord(char) + param_2 - ord('a')) % 26 + ord('a'))
        else:
            result_char = char

        result_string += result_char

    return result_string

Imknight_string = 'IaMaKnight'
transform_string_result = transform_string(Imknight_string)
transform_string_result = transform_string2(transform_string_result , 3)
print(transform_string_result)