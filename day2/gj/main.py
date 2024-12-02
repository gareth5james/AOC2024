#prep

reports = open("input.txt", "r")

def running_diff(line):
    if len(line) <= 1:
        return []
    else:
        return [line[1] - line[0]] + running_diff(line[1:])

diff_lists = [running_diff([int(num) for num in line.strip().split()]) for line in reports]

#Part 1

def safe(line):
    if any(num == 0 for num in line):
        return False
    elif any(abs(num) > 3 for num in line):
        return False
    elif all(num > 0 for num in line) or all(num < 0 for num in line):
        return True
    else:
        return False
    
safe_lists = [safe(line) for line in diff_lists]

print(safe_lists.count(True), "<< part 1")

#Part 2

def less_safe(line):
    if safe(line):
        return True
    else:
        for index, num in enumerate(line):
            tempLine = line[:]
            tempLine.pop(index)
            if safe(tempLine):
                return True  
    return False

less_safe_lists = [less_safe(line) for line in diff_lists]

print(less_safe_lists.count(True), "<< part 2")

##I'm not sure what I did wrong on part 2, and I can't see it. Feedback appreciated