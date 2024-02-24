

with open('ciphertext', 'r') as fin:
    counter = 0 
    
    while True: 
        try: 
            with open(f'./blocks/{counter}.txt', 'w') as fout:
                for _ in range(100):
                    fout.write(fin.read(64) + '\n')
            counter += 1
        
        except EOFError: 
            break
        
    print(counter)