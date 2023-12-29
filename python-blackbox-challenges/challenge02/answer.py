import random, string


class Answer:
    def __init__(self, *args, **kwargs):
        self.index = -1 
        self.starting_point = random.randint(0, len(string.printable)) 
        self.solution = [78, 79, 80]
        
    def iteration(self, *args, **kwargs):
        args = args[0]
        print(args)
        print(self.starting_point, 'start')
        print(self.starting_point - (args[0] - args[1]) or 1, 'new_start')
        self.starting_point = self.starting_point - (args[0] - args[1]) or 1 
        print(string.printable[self.starting_point] )

        #return string.printable[self.starting_point] 
        self.index += 1
        return string.printable[self.solution[self.index]]