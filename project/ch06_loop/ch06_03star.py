print('\u2605')

# for문을 이용
i = 9
a = int(i/2+1)
for i in range(1,2*a):
    if(i <= a):
        for d in range(a-i):
            print(" ", end="")
        for d in range(2*i-1):
            print('\u2605', end="")
        print()
    else:
        for d in range(i-a):
            print(" ", end="")
        for d in range((2*a-i)*2-1):
            print('\u2605', end="")
        print()