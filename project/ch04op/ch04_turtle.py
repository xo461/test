import turtle
import random

# 전역변수 선언
# swidth : 창의 너비 , sheight : 창의 높이
swidth, sheight, pSize, exitCount = 300, 300, 3, 0
# r부터 cury 까지 0으로 채우는 방법 ↓
# r, g, b, angle, dist, curX, curY = 0,0,0,0,0,0,0 아래와 동일.
# r, g, b=색상 angle=회전각도 dist=진행거리 curX, curY : 현재 위치
r, g, b, angle, dist, curX, curY = [0]*7


turtle.title("거북이가 맘대로 다니기")
turtle.shape('turtle')
turtle.pensize(pSize)
turtle.setup(width=swidth + 30, height=sheight + 30)
turtle.screensize(swidth, sheight)

# 무한 반복 while, break가 나올때 까지 (if문 조건에 맞으면 빠져나간다)
while True:

    r = random.random()
    g = random.random()
    b = random.random()
    turtle.pencolor((r, g, b))
    # 진행 방향 각도 조절
    angle = random.randrange(0, 360)

    dist = random.randrange(1, 100)

    # 왼쪽 방향으로 angle만큼 회전
    turtle.left(angle)

    # dist 만큼 진행 -> 선이 그려 진다.
    turtle.forward(dist)

    # screen 밖으로 빠져 나갔는지 알기 위해서 거북이의 위치 구하기
    curX = turtle.xcor()
    curY = turtle.ycor()
    # 현재 위치  콘솔창 띄우기
    print("x=", curX, "/", "y=", curY)

    # 스크린 밖으로 빠져 나갔는지 확인(if문)
    # : 은 pass 닫는 표시가 없어서 :으로 닫아줘야한다. ?
    # ↓ 스크린 안에 있는 조건
    if(-swidth / 2 <= curX <= swidth / 2) and (-sheight / 2 <= curY <= sheight / 2):
        pass

    else:
        # 5회가 아닌 경우 처리, 거북이 가운데로 가져오기 선이 그려지만 안된다.
        turtle.penup()
        turtle.goto(0, 0)
        turtle.pendown()
        # 거북이가 밖으로 빠져 나갔을때의 카운트
        exitCount += 1
        # while 문 밖으로 빠져 나가는 조건문, -> 5회 이상 밖으로 나가면 종료
        if exitCount >= 5:

            break

turtle.done()












