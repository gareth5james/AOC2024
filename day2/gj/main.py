reports = open("input.txt", "r")

def analyze(line):
    ascending = True
    success = True
    
    for i in range(len(line) - 1):
        num = line[i]
        num2 = line[i + 1]
        if i == 0:
            if num > num2:
                ascending = False

        if num == num2:
            success = False
            break
        
        if ascending:
            if num > num2 or (num2 - num) > 3:
                success = False
                break
        else:
            if num < num2 or (num - num2) > 3:
                success = False
    
    return success

#part1

fails_per_report = [analyze([int(num) for num in line.strip().split()]) for line in reports]

print(fails_per_report.count(True), "<< part 1")

#part2

def loss_prevention(line):
    if analyze(line):
        return True
    else:
        for index, num in enumerate(line):
            tempLine = line[:]
            tempLine.pop(index)
            if analyze(tempLine):
                return True
    
    return False

reports2 = open("input.txt", "r")

saved_fails_per_report = [loss_prevention([int(num) for num in line.strip().split()]) for line in reports2]

print(saved_fails_per_report.count(True), "<< part 2")