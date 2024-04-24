n = int(input());
for i in range(n,-1, -1):
    for _ in range(i):
        print("*", end="")
    print()