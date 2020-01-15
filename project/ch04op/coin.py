# calcu(바꿔야할 돈, 지급된 돈)
def calcu(a, money):
    print("지급된 금액 : ", money)
    # 바꿔야할 돈의 갯수
    cnt = money // a
    print(a, "원 갯수 : ", cnt)
    # 남아있는 지급된 돈 계산
    money = money % a
    return money


money = int(input('교환할 돈을 입력 하세요 :'))
ch_money = 500
money = calcu(ch_money, money)
ch_money = 100
money = calcu(ch_money, money)
ch_money = 50
money = calcu(ch_money, money)
ch_money = 10
money = calcu(ch_money, money)
print("최종 잔액 : ", money)

'''
a = 500
money = int(input('교환할 돈을 입력 하세요'))

print(a, "원짜리 ==>", calcu(a,money), "개")
money = money - (500 * calcu(a, money))

a = 100
print(a, "원짜리 ==>", calcu(a,money), "개")
money = money - (100 * calcu(a, money))

a = 50
print(a, "원짜리 ==>", calcu(a,money), "개")
money = money - (50 * calcu(a, money))

a = 10
print(a, "원짜리 ==>", calcu(a,money), "개")
print("바꾸지 못한 잔돈 ==>", money - (10 * calcu(a, money)), "원")

money = int(input('교환할 돈을 입력 하세요 :'))

ch_money = 500
c500 = money // ch_money

money = money % ch_money
ch_money = 100
c100 = money // ch_money

money = money % ch_money
ch_money = 50
c50 = money // ch_money

money = money % ch_money
ch_money = 10
c10 = money // ch_money

c = money % ch_money

print('500원 짜리 :', c500)
print('100원 짜리 :', c100)
print('50원 짜리 :', c50)
print('10원 짜리 :', c10)
print('잔돈 짜리 :', c)
'''
