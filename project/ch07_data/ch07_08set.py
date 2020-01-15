# set : 중복된 데이터 배제 {v,v,...}
mySet1 = {1, 2, 3, 3, 3, 4}
print(mySet1, type(mySet1))

# list -> set -> list
salesList = ['삼각김밥', '바나나', '도시락', '삼각김밥', '삼각김밥', '도시락', '삼각김밥']
print(salesList)
print(set(salesList))

# 판매된 상품과 수량을 출력하시오. 중복이 되면 안된다.
print("삼각김밥 : ", salesList.count("삼각김밥"))
print("바나나 : ", salesList.count("바나나"))
print("도시락 : ", salesList.count("도시락"))

# for i in set(salesList):
#    print("%s 판매 수량은 : %d " % (i, salesList.count(i)))

for i in set(salesList):
    print("%s 판매 수량은 : %d " % (i, salesList.count(i)))


mySet1 = {1, 2, 3, 4, 5}
mySet2 = {4, 5, 6, 7}
print(mySet1 & mySet2)
print(mySet1 | mySet2)
print(mySet1 - mySet2)
print(mySet2 - mySet1)
print(mySet1 ^ mySet2)

list1 = [1, 2, 3, 4, 5]
print("list1 :", list1)

list2 = []
for i in range(1, 5 + 1):
    list2.append(i)
print("list2 : ", list2)

# 컴프리헨션으로 리스트 만들기
list3 = [num for num in range(1, 5+1)]
print("list3:", list3)

# 1~10 사이 3의 배수로 리스트 만들기 -> [3,6,9]
# 위의 문제 for문으로 만들기
# for i in range(1,10 +1):
#   if i % 3 == 0:
#       list2.append(i)

list4 = [num for num in range(1, 10+1) if num % 3 == 0]
print("list4:", list4)

# 1~5사이의 데이터를 제곱근 구해서 리스트 만들기
list5 = []

list5 = [num * num for num in range(1, 5+1)]
print("list5 :", list5)


# zip() 함수
foods = ['떡볶이', '짜장면', '라면', '피자', '맥주', '치킨', '삼겹살']
sides = ['오뎅', '단무지', '김치']
for food,side in zip(foods, sides):
    print(food, '-->', side)


if len(foods) > len(sides):
    cnt = len(sides)
else:
    cnt = len(foods)

for i in range(cnt):
    print(foods[i],'-->',sides[i])


for i in range(len(foods)):
    print(foods[i], '-->', sides[i])
    # sides의 데이터가 더 많은 경우 빠져나가는 처리를 한다.
    if i >= len(sides)-1:
        break

# zip 함수를 이용해서 튜플 리스트, 딕셔너리 만들기

tupList = list(zip(foods, sides))
dic = dict(zip(foods, sides))

print(tupList)
print(dic)









