#prep

reports = open("input.txt", "r")

def running_diff(list):
    if len(list) <= 1:
        return []
    else:
        return [list[1] - list[0]] + running_diff(list[1:])

diff_lists = [running_diff([int(num) for num in line.strip().split()]) for line in reports]

def safe(list):
    if any(item == 0 for item in list):
        return False
    elif any(item > 3 for item in list):
        return False
    elif any(item < -3 for item in list):
        return False
    elif all(item > 0 for item in list):
        return True
    elif all(item < 0 for item in list):
        return True
    else:
        return False
    
safe_lists = [safe(list) for list in diff_lists]

print(safe_lists.count(True), "<< part 1")