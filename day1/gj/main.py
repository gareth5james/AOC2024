lists = open("input.txt", "r")

list_one = []
list_two = []

for line in lists:
    split_line = line.split("   ")
    list_one.append(int(split_line[0]))
    list_two.append(int(split_line[1].strip()))

list_one.sort()
list_two.sort()

sums = []

for index, number in enumerate(list_one):
    sums.append(abs(number - list_two[index]))

print(sum(sums))