one, two = open('input.txt').read().split('\n\n')

order_rules = [[int(num) for num in line.strip().split("|")] for line in one.split("\n")]

updates = [[int(num) for num in line.strip().split(",")] for line in two.split("\n")]

def after(x): return [a for a,b in order_rules if x==b]
def index(x, nums): return len(set(after(x)).intersection(nums))

was_sorted = {True: [], False: []}
for nums in updates:
    nums2 = sorted(nums, key=lambda x: index(x, nums=nums))
    was_sorted[nums == nums2].append(nums2)

print(*[sum(int(nums[len(nums)//2]) for nums in part) for part in was_sorted.values()])