#prep

lists = open("input.txt", "r")

list_one = []
list_two = []

for line in lists:
    split_line = line.split("   ")
    list_one.append(int(split_line[0]))
    list_two.append(int(split_line[1].strip()))

list_one.sort()
list_two.sort()

#part 1

sums = []

for index, number in enumerate(list_one):
    sums.append(abs(number - list_two[index]))

print(sum(sums), "<< part 1")

#part 2

similarity = []

for number in list_one:
    similarity.append(number * list_two.count(number))


print(sum(similarity), "<< part 2")