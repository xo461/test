# 1.수식을 작성하면 작성된 수식을 계산해서 출력하자
# 2.숫자 2개를 입력 받고 숫자 2개 사이의 모든 숫자를 더해서 출력

# 변수 선언 , 초기값 선언
select, answer, numStr, num1, num2 = 0, 0, "", 0, 0

# 메인 코드
select = int(input("1.입력한 수식 계산 " "2.두 수 사이의 모든 숫자 합계 ->"))

#조건에 의해서 수식이나 합계처리
if select == 1:
    #처리할 수식을 받는다.
    numStr = input("수식입력 :")
    #수직처리
    answer = eval(numStr)
    print("%s 결과는 % 5.1f" %(numStr, answer))

elif select == 2:
    # 시작 숫자 입력
    num1 = int(input("시작숫자 :"))
    # 마지막 숫자 입력
    num2 = int(input("마지막숫자 :"))
    for i in range(num1, num2+1):
        answer += i
    print("%d+...+%d는 %d입니다." % (num1, num2, answer))
else:
    print("1 또는 2만 입력해야 합니다. ")