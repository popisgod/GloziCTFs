result_data = b''
with open('public\\a.bin', 'rb') as file:
    while True: 
        binary_data = file.read(4)
        if not binary_data:
            break 
        result_data += binary_data[::-1]
        
with open('output.png', 'wb') as output_file: 
    output_file.write(result_data)