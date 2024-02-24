#!/usr/bin/env python3
from scapy.all import *


TARGET_HOST = 'braekerctf.butsers.nl'
target_port = 1000

def send_syn(host, port):
    syn_packet = IP(dst=host) / TCP(dport=port, flags='S')

    # Send the TCP SYN packet and receive the SYN-ACK response
    syn_ack_response = sr1(syn_packet, verbose=False)

    if not syn_ack_response:
        return False
    return True

def find_piece(host, port):
    if not send_syn(host, port):
        return False
    
    high = 1000
    low = 0

    while True: 
        mid  = (high + low) // 2
        payload = f'GET /guess?guess={mid} '.encode()

        # Craft the TCP PSH packet with the HTTP payload
        psh_packet = IP(dst=host) / TCP(dport=port, flags='PA') / payload

        # Send packet and sniff for responses
        send(psh_packet, verbose=False)
        responses = sniff(filter=f"tcp and src host {host} and src port {port}", count=2, timeout=2)

        if responses:
            for response in responses:
                if response.haslayer(TCP):
                    if response[TCP].seq == 1338:
                        continue
                    else:
                        if response[TCP].seq == 7332:
                            high = mid - 1
                        elif response[TCP].seq == 7331:
                            low = mid + 1
                        elif response[TCP].seq > 7332: 
                            print(f'bin value at {mid} is {response[TCP].seq - 7333}')
                            return  mid , response[TCP].seq - 7333
                        
        else:
            send_syn(host, port)
            
            
pieces_dict = {}

while True: 
    piece = find_piece(TARGET_HOST, target_port)
    
    
    if piece:
        pieces_dict[piece[0]] = piece[1]
        target_port += 1 
    else: 
        break
    
with open('solve.txt', 'w') as file:
    for index in range(len(pieces_dict)): 
        piece = pieces_dict[index]

        file.write(str(piece))
        
        if index % 8 == 0:
            file.write("\n")
            
        