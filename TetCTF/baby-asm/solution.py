import string
from concurrent.futures import ThreadPoolExecutor, as_completed
import itertools 

global_values = [96, 101, 20, 177, 155, 116, 108, 69, 84, 109, 103, 110, 111, 95, 116, 103, 97, 72, 20, 59]
results = [38793, 584, 738, 38594, 63809, 647, 833, 63602, 47526, 494, 663, 47333, 67041, 641, 791, 66734, 35553, 561, 673, 35306]
index_order = [1, 2, 3, 0, 5, 6, 7, 4, 9, 10, 11, 8, 13, 14, 15, 12, 17, 18, 19, 16]
xor_values_global = [19, 55, 32, 36]
xor_values_char = [32, 36, 19, 55]
input_length = 20
operations = [lambda x, y: x + y, 
			  lambda x, y: y - x , 
			  lambda x, y: x * y, 
			  lambda x, y: x ^ y]



for i in range(input_length): 
	global_values[i] = xor_values_global[i % 4] ^ global_values[i]


def algorithm(input):
	# Initialization
	input_codes = []
	for i in range(input_length): 
		input_codes.append(ord(input[i]) + 19 + 64)

	# Computing results  
	for i in range(input_length):
		temp = operations[i % 4](global_values[i], input_codes[i])
		temp += input_codes[index_order[i]]
		temp ^= xor_values_char[i % 4]
		input_codes[index_order[i]] = temp + 19 + 64


	# Checking result 
	counter = 0
	for i in range(input_length):
		if input_codes[i] == results[i]: 
			counter += 1  

	# Final check 
	if counter > 3: 
		print(input_codes, input)
	else:
		return





# Use ThreadPoolExecutor for parallelism
with ThreadPoolExecutor() as executor:
    futures = [executor.submit(lambda x: algorithm(x), 12 * 'a' + i + j + d + b + 4 * 'a') 
               for i, j, d, b in itertools.product(string.printable, repeat=4)]

    # Wait for all threads to finish
    for future in as_completed(futures):
        future.result()
