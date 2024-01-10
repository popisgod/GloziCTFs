import subprocess

for length in range(1):  # Loop through input lengths from 0 to 64
    input_data = b"\0" * length  # Create input data of 'A's with varying length
    
    # Run the C code with the input data
    process = subprocess.Popen(['./a.out'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    stdout, stderr = process.communicate(input=input_data)
    
    # Print the output or do further analysis based on the result
    print(f"Input Length: {length}, Output: {stdout}")
    if stderr:
        print(f"Error: {stderr}")
