import re

# test input
def test():
    calc_list = [[int(num) for num in re.compile(r"(\d+)").findall(calc)] for calc in re.compile(r"(mul\(\d+,\d+\))").findall(open("input-test.txt", "r").read())]

    sum_list = []

    for calc in calc_list:
        sum_list.append(calc[0] * calc[1])

    print(sum(sum_list))

test()

#part 1

def part1():
    calc_list = [[int(num) for num in re.compile(r"(\d+)").findall(calc)] for calc in re.compile(r"(mul\(\d+,\d+\))").findall(open("input.txt", "r").read())]

    sum_list = []

    for calc in calc_list:
        sum_list.append(calc[0] * calc[1])

    print(sum(sum_list))

part1()  