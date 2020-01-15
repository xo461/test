# 구구단 처리를 하는데 시작 단수를 마지막 단수를 입력 받아서
# 시작 단수 부터 마지막 단수 사이의 모든 단수를 출력한다.
# 단 한 줄에 시작 단수 ~ 마지막 단수 출력 한다.

Sdan, Ldan, a = 0, 0, 0

Sdan = int(input("시작 단 ->"))
Ldan = int(input("마지막 단->"))

for a in range(1, 10):
    for i in range(Sdan, Ldan+1):
        print("%d x %d = %2d" % (i, a, i*a), end="   ")
    print()