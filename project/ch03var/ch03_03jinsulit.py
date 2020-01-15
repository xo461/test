# 16진수 FF를 10진수 -> 255
a = 0xFF

# 8진수의 77을 10진수 -> 63
b = 0o77

# 2진수 1111 - 15
c = 0b1111

print(a, b, c)

# 변수 a의 타입을 출력해보자
print(a, "의 타입은", type(a))

# 실수형 데이터 입력
a = 3.14
# 3.14e5 -> 3.14 * 100000 -> 314000.0
b = 3.14e5

print(a, b)

# 변수 a의 타입을 출력해보자
print(a, "의 타입은 ", type(a))


# ;은 두개의 처리문을 구분 , 이것과 같다
# 2개의 처리문을 한 줄에 사용하기 위한 ";"
a = 10; b = 20
print(a+b, a-b, a*b, a/b)

a, b = 10, 20
print(a**b, a%b, a//b)

b = 3
# 나눗셈 후 소수점 자리까지 출력(float 형식)
print(a / b)
# 나눗셈 후 소수점 을 버린다.(int 형식의 데이터)
print(a // b)

print(a % b)

# 자바는 true (소문자) / 파이썬은 True(맨앞글자 대문자)
a = True
b = False
# a 타입 확인
print(a, type(a))

a = (100 == 100)
b = (10 > 100)
print(a, b)



















