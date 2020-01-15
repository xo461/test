# 별개의 새로운 리스트를 만든다. 예전에 데이터를 그대로 사용
# 리스트 복사 - 주소 복사 데이터 변경시 리스트 두개 다 동시에 변경됨.
oldList = ['짜장면', '탕수육', '군만두']
newList = oldList
print('oldList :', oldList)
print('newList :', newList)

oldList.append('깐풍기')

print("oldlist : ", oldList)
print("newlist : ", newList)

newList.append('라조기')

print("oldlist : ", oldList)
print("newlist : ", newList)

# 리스트 복사2 = 별개로 복사 하기 데이터를 추가 하여도 별개로 리스트에 추가됨.
# 리스트 별개 복사 2-1
newList = oldList[:]
oldList.append('깐풍기')

print("oldlist[:] : ", oldList)
print("newlist[:] : ", newList)


# 리스트 별개 복사 2-2
newList = oldList.copy()

newList.append('볶음밥')

print("oldlist.copy : ", oldList)
print("newlist.copy : ", newList)

# 별개 리스트 중간 데이터 삭제
oldList.remove("탕수육")
print("oldlist : ", oldList)
print("newlist : ", newList)