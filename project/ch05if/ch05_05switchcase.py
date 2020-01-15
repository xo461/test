# 파이썬은 switch case이 없다.

def sf1():
    print("첫번째")

def sf2():
    print("두번째")

def sf3():
    print("세번째")

def switch(key):
    return {"1" : sf1, "2" : sf2, "3" : sf3}.get(key,'잘못된 선택')

# 함수를 가져와서 result에 저장한다.
result = switch("1")
print(result)
# print(result())
result()
switch("2")()
switch("3")()
print(switch("4"))
