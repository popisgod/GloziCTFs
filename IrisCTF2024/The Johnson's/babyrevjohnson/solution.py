import subprocess
from itertools import permutations

colors = ['red', 'blue', 'green', 'yellow']
foods = ['pizza', 'pasta', 'steak', 'chicken']

color_permutations = permutations(colors)
for color_order in color_permutations:
    food_permutations = permutations(foods)
    for food_order in food_permutations:
        proc = subprocess.Popen(['./main'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
        
        for color in color_order:
            proc.stdin.write(f"{color}\n")
            proc.stdin.flush()  

        for food in food_order:
            proc.stdin.write(f"{food}\n")
            proc.stdin.flush()  


        if not 'Incorrect.' in proc.stdout.read():
            print(color_order, 'correct')
            print(food_order, 'correct')
            
        proc.terminate()  
        proc.wait()  

