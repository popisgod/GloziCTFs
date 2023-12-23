binary_data = b''
with open('public\\a.bin', 'rb') as file:
    while True: 
        first_part = file.read(2)
        second_part = file.read(2)

        if not second_part: 
            break 
        
        binary_data += second_part[::-1]
        binary_data += first_part[::-1]

        
with open('output.png', 'wb') as output_file: 
    output_file.write(binary_data)