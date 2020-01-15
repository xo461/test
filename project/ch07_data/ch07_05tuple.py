# 읽기전용으로 쓴다. 삭제는 가능하다. 추가, 변경,복사 기능 사용불가
# list 는 데이터 변경이 가능, tuple은 변경 불가.
# tuple 연산은 된다. 합치기,곱하기.
tt = (10, 20, 30)

print(tt,type(tt))

print(tt[2])
# tt[2] = 300
# tt.append(40)

print(tt, type(tt))

print(tt[0:2])

tt1 = tt
print(tt1)
print(tt1+tt)
print(tt*3)

# tuple(10, 20, 30) -->(10, 200, 30) 중간 값 교체
# tuple -> list로 변경 가능, 데이터 수정 가능 -> tuple

tt2 = list(tt)
print(tt2)
tt2[tt.index(20)] = 200
print(tt2)

tt3 = tuple(tt2)
print(tt3)




