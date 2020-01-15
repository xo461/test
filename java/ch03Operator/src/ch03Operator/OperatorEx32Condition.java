package ch03Operator;

import java.util.Scanner;

public class OperatorEx32Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 값을 넣어서 처리 할 변수 선언
		int x;
		String str;
	
		// 값을 키보드로 값을 입력 받는다. str 저장 : 숫자 입력 
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력해 주세요");
		str = scanner.nextLine();
	
		// 문자열로 저장된 str의 값을 int로 변환 
		x = Integer.parseInt(str);
		// 입력된 값의 절대값을 구한다. -값을 +값으로 변환 시킨다. -5 -> +5
		// if(조건:-값) -x
		//if(x < 0) x = -x;
		// 조건? true일때 값 : flase일때 값
		x = (x < 0) ? -x : x;
		
		
		// 값을 출력한다. 
		System.out.println(str);
		System.out.println(x);
		// 스캐너 닫기
		scanner.close();
	}

}
