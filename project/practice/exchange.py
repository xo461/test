
a = int(input('교환할 돈은 얼마 ? ==>'))
print('\n')
b = a // 500
print('500원짜리==>', b,'개')

c = (a-b * 500)//100
print('100원짜리 ==>', c,'개')

d = (a-b*500-c*100)//50
print('50원짜리 ==>', d,'개')

e = (a-b*500-c*100-d*50)//10
print('10원짜리 ==>', e,'개')

f = (a-b*500-c*100-d*50-e*10)
print('바꾸지 못한 잔돈  ==>', f,'원')


'''
또다른 이용 방법 
m = int(input('교환할 돈을 입력'))

ch_m = 500
c500 = m // ch_m

m = m % ch_m
ch_m = 100
c100 = m // ch_m

m = m % ch_m
ch_m = 50
c50 = m // ch_m

m = m % ch_m
ch_m = 10
c10 = m // ch_m

c = m % ch_m

print(c500)
print(c100)
print(c50)
print(c10)
print(c)

'''









