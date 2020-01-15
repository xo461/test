# 리스트 함수 사용
aa = [85, 100, 90, 70, 95, 90]



# 1. 리스트의 갯수를 출력

print(len(aa))

# 2. 리스트의 데이터를 바꾸지 않으면서 정렬해서 출력
aa1 = aa.copy()
aa1.sort()
print(aa1)

# 3. 90 데이터의 위치를 출력
print(aa.index(90))
# 90 두 개 위치 출력 방법 , for문 이용 여러위치를 출력하는 함수 없음. 
for i in range(len(aa)):
    if aa[i] == 90:
        print(i)
# 4. 마지막 데이터를 꺼내면서 제거해 보세요.
print("pop()으로 추출 한 값 : %s" % aa.pop())
print(aa)

# 5. bb 라는 리스트에 동일한 데이터를 가지도록 처리 보세요.

bb = aa.copy()
print("bb-> %s" % bb)

# 6. aa 리스트에서 값이 100인 데이터를 지운다.
aa.remove(100)
print(aa)

# 7. aa 리스트의 내용을 지운다.
aa.clear()
print(aa)
