import hashlib


flag_hash = '537500469ddfc5b29e9379cdcc2f3c86'

def calculate_md5(data):
    md5_hash = hashlib.md5()
    md5_hash.update(data.encode('utf-8'))  # Assuming 'data' is a string; encode to bytes if it's not
    return md5_hash.hexdigest()

data_to_hash = "Hello, MD5!"
while True:   
    md5_result = calculate_md5(data_to_hash)
    print(md5_result)
    for i in range(len(data_to_hash)):
        if md5_result[i] > flag_hash[i]:
            print('found the hash')
            print(data_to_hash)
            print(md5_result)
            exit()
        elif md5_result[i] == flag_hash[i]:
            continue
        else: 
            break
        
    data_to_hash += 'a'