print("\u2605")

# for문을 이용해서 별 모양 마름모 만들기

totalRow = 9
inc = 1
# blankcnt -> 4,3,2,1,0,1,2,3,4
# totalRow // 2 -> 4 ==> range(1, totalRow // 2 + 1
# multi -> - 값이 나오면 안되니 곱하여 절대값으로 만들어 주는 변수
blankcnt, starcnt, multi = 4, 1, 1
for i in range(1,totalRow+1):
    # 빈공간을 출력
    blankcnt = ((totalRow // 2) - i + 1) * multi
    # print(blankcnt)
    for j in range(1,blankcnt + 1):
        print("  ", end="")
    # 별 출력
    for k in range(1, starcnt + 1):
        print("\u2605",end="")
    print()
    starcnt += 2 * multi
    # 별을 최대치를 출력하면 공백은 감속(+값)해야하고 별의 갯수 감소(-)
    if i == totalRow // 2 :
        multi = multi * -1
