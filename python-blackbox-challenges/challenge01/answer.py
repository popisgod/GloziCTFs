def answer(*args, **kwargs):
    nearest_number = ((args[0]) // 4) * 4 # round to the nearest multiplie of i + 1.
    optimal_change = (args[0]) - nearest_number # find the difference between the nearest number and the current number. 
    
    return optimal_change

  