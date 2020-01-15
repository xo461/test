/*
 * 숫자를 맞히는 프로그램
 * 랜덤하게 1 부터 100 사이의 숫자를 컴퓨터에게 받아 온다. 숫자를 입력해서 맞힌다. 
 */
package ch05Array;

import java.util.Scanner;

public class FlowEx28Dowhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 1~100 사이의 랜덤 숫자를 컴퓨터에게 받아 온다.
		// input : 사용자가 입력한 숫자
		// answer : 정답  = 컴퓨터가 발생시킨 랜덤 숫자 
		int input = 0, answer = 0;
		
		//Math.random() 범위 -> 0.0 < r < 1.0 
		//((int)Math.random() * 100 범위 -> 0.0 < r < 100.0 - = 0 <= r < 100
//		answer = (int)(Math.random() * 100)+ 1; -> +1을 해야 1부터 100까지 됨. 
		answer = (int)(Math.random() * 100)+ 1; // 정답을 받아 왔다. 
		System.out.println(answer); // 정답 미리 도출.
				
//		for (int i = 0, j = 1;;) -> = int input, anewer;
		
		// 데이터를 입력받는 객체 생성 
		Scanner scanner = new Scanner(System.in);
		System.out.println("<숫자 맞추는 게임> ^-^ㅗ ");
		// 정답을 맞히는 반복 - 맞을때 까지 반복한다. 
		do {
			System.out.println("1~100사이의 정수를 입력하세요 ");
			input = Integer.parseInt(scanner.nextLine());
			if(input > answer)
				System.out.println("더 작은 수로 시도해 보세요.");
			else if(input < answer)
				System.out.println("더 큰 수로 시도해 보세요.");
		
		}while(input != answer);
		
		// while문을 빠져 나온 후 처리 -> 정답을 맞혔다.
		System.out.println("정답입니다.");
		
		
		// 데이터를 입력 받는 객체의 자원을 반환한다. 
		scanner.close();
	}
}
