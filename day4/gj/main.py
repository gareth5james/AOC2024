import sys
import pyperclip as pc
def pr(s):
    print(s)
    pc.copy(s)
sys.setrecursionlimit(10**6)
infile = sys.argv[1] if len(sys.argv)>=2 else 'input.txt'
p1 = 0
p2 = 0
data = open(infile).read().strip()

graph = data.split('\n')
R = len(graph)
C = len(graph[0])
for r in range(R):
    for c in range(C):
        if c+3<C and graph[r][c]=='X' and graph[r][c+1]=='M' and graph[r][c+2]=='A' and graph[r][c+3]=='S':
            p1 += 1
        if r+3<R and graph[r][c]=='X' and graph[r+1][c]=='M' and graph[r+2][c]=='A' and graph[r+3][c]=='S':
            p1 += 1
        if r+3<R and c+3<C and graph[r][c]=='X' and graph[r+1][c+1]=='M' and graph[r+2][c+2]=='A' and graph[r+3][c+3]=='S':
            p1 += 1
        if c+3<C and graph[r][c]=='S' and graph[r][c+1]=='A' and graph[r][c+2]=='M' and graph[r][c+3]=='X':
            p1 += 1
        if r+3<R and graph[r][c]=='S' and graph[r+1][c]=='A' and graph[r+2][c]=='M' and graph[r+3][c]=='X':
            p1 += 1
        if r+3<R and c+3<C and graph[r][c]=='S' and graph[r+1][c+1]=='A' and graph[r+2][c+2]=='M' and graph[r+3][c+3]=='X':
            p1 += 1
        if r-3>=0 and c+3<C and graph[r][c]=='S' and graph[r-1][c+1]=='A' and graph[r-2][c+2]=='M' and graph[r-3][c+3]=='X':
            p1 += 1
        if r-3>=0 and c+3<C and graph[r][c]=='X' and graph[r-1][c+1]=='M' and graph[r-2][c+2]=='A' and graph[r-3][c+3]=='S':
            p1 += 1

        if r+2<R and c+2<C and graph[r][c]=='M' and graph[r+1][c+1]=='A' and graph[r+2][c+2]=='S' and graph[r+2][c]=='M' and graph[r][c+2]=='S':
            p2 += 1
        if r+2<R and c+2<C and graph[r][c]=='M' and graph[r+1][c+1]=='A' and graph[r+2][c+2]=='S' and graph[r+2][c]=='S' and graph[r][c+2]=='M':
            p2 += 1
        if r+2<R and c+2<C and graph[r][c]=='S' and graph[r+1][c+1]=='A' and graph[r+2][c+2]=='M' and graph[r+2][c]=='M' and graph[r][c+2]=='S':
            p2 += 1
        if r+2<R and c+2<C and graph[r][c]=='S' and graph[r+1][c+1]=='A' and graph[r+2][c+2]=='M' and graph[r+2][c]=='S' and graph[r][c+2]=='M':
            p2 += 1

pr(p1)
pr(p2)