#!/usr/bin/env python3 


shredded_example = '  # ie.  i   d  o nl u  >dhst <c'
shredded_example1 = 'char flag[] = "REDA  f  D=E] C[r'
shredded_example2 =  ' Dc"haR    TglE;"Aa  f  D=E] C[r'
shredded_example3 = '+0f;o ;i e{ it5 n ri)n  il = < (+'

dict_match = { 0 : shredded_example.find('#'), 
              1 : shredded_example.find('i'),
            2 : shredded_example.find('n'),
            3 : shredded_example.find('c'), 
            4 : shredded_example.find('l'),
            6 : shredded_example.find('d'), 
            7 : shredded_example.find('e'), 
            5 : shredded_example.find('u'),
            8 :  12, 
            9 : shredded_example.find('<'),
            10 : shredded_example.find('s'), 
            11 : shredded_example.find('t'), 
            12 : shredded_example.find('d', 15), 
            13 : shredded_example.find('i', 9),
            14 : shredded_example.find('o'), 
            15 : shredded_example.find('.'),
            16 : shredded_example.find('h'), 
            17 : shredded_example.find('>'), 
            18 : 17, 
            19 : shredded_example1.find('C'), 
            20 : 11, 
            21 : shredded_example2.find('E'),
            22 : shredded_example2.find('D'),
            23 : 3, 
            24 : 15, 
            25 : shredded_example3.find('i'),
            26 : shredded_example3.find('+', 5), 
            27 : 0, 
            28 :  shredded_example3.find(')'),  
            29 : 23, 
            30 : shredded_example3.find('{'),
            31 : 8, 
            32 : 22}

for num in range(33):
    if num not in dict_match.values():
        print(num)
        
lines = []
for i in range(38): 
    line = ''
    for j in range(33): 
        if dict_match.get(j) != None: 
            with open(f'./out/shredFiles/shred{dict_match[j]}.txt', 'r') as shredded: 
                line += shredded.readlines()[i][0]
                continue
        with open(f'./out/shredFiles/shred{j}.txt', 'r') as shredded: 
            line += shredded.readlines()[i][0]
    print(line)
    lines.append(line)
    


