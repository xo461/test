# dictionary -> {key, value[,key:value]}  -> js에서는 json형식이다.
# 값이 겹치면 덮어쓰기가 된다. 키값은 중복이 되지 않는다.
# 같은 키를 사용한 경우 뒤에 있는 데이터로 덮어 쓰기가 된다.

dic1 = {1: 'a', 2: 'b', 3: 'c', 3: 'e'}
print(dic1, type(dic1))


# 학생 딕션너리 생성
student = {'학번': 1000, '이름': '홍길동', '학과': '파이썬학과'}
print(student, type(student))

# 학생의 이름 데이터 가져오기
print(student['이름'])
print(student.get('이름'))

# 모든 키를 출력, 리스트로도 변경 가능 함.
keylist = student.keys()
keylist = list(student.keys())
print(keylist)

# 모든 값을 출력
valuelist = student.values()
print(valuelist)

# 학생 딕셔너리가 가지고 있는 모든 데이터 출력해 보기
for a in keylist:
    print(a, ":", student[a])


# items로 출력하면 데이터 형식은 tuple로 나온다.
print(student.items())
studentlist=list(student.items())
# 리스트로 바꾸기 - 전체적으로는 리스트안에 값으로  튜플임으로 튜플안에 내용은 수정 불가
print(studentlist)

studentlist.append(('연락처','010-1234-4567'))

print(studentlist)

print(studentlist.pop())

print(studentlist)



# 딕셔너리의 데이터 추가

singer = {}

singer["이름"] = "트와이스"
singer["구성원수"] = 9
# 같은 키를 사용해서 데이터를 넣으면 수정이 된다 .
singer["구성원수"] = 10
singer["대표곡"] = "SIGNAL"


print(singer)
# del 딕셔너리 항목 삭제 방법
del singer["대표곡"]

print(singer)



foods = {"떡볶이": "오뎅",
         "짜장면": "단무지",
         "라면": "김치",
         "피자": "피클",
         "맥주": "땅콩",
         "치킨": "치킨무",
         "삼겹살": "상추"};


while(True):
    myfood = input(str(list(foods.keys()))+"중 가장 좋아하는 음식은 ?->")
    if myfood in foods:
        print("<%s>궁합 음식은 <%s>입니다." % (myfood, foods.get(myfood)))
    elif myfood == "끝" :
        break
    else:
        print("그런 음식이 없습니다. 확인해 보세요.")





















