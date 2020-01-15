/*
 * 점수를 입력 받아서 합격 여부를 출력하는 프로그램
 * 2019.10.10
 * 정태환
 */
package ch04condition;

import java.util.Scanner;

public class FlowEx3if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//점수를 입력받는다.
		//콘솔창이 자동으로 열리게 하려면 출력을 해야만 한다. 
		
	    System.out.println("점수를 입력해 주세요 :");
	    Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();
//		int score = Interger.parseInt(str);
		int score = Integer.parseInt(scanner.nextLine());
		
		System.out.println("점수 : " + score);
		
		//60점 이상이면 "합격" 그렇지 않으면 "불합격"을 출력한다. 점수도 함께 출력한다.
		//if문의 경우 ";" 처리문이 다끝난 뒤에 else문이 뒤에 있는지 확인 한다. 
//		if(score >= 60) System.out.println("합격");
//		else System.out.println("불합격");
		
		// 유효한 데이터 인지 처리(0~100) 
		if(score > 100) System.out.println("오류:100이 넘었음");
		else if(score >= 60)System.out.println("합격");
		else if(score >= 0) System.out.println("불합격");
	    else System.out.println("오류:0점 미만입니다.");
		
		scanner.close();
	}

}
