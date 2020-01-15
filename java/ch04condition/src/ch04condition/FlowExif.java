/*
 * 버스요금 계산하는 프로그램작성
 * 정상요금 :1,250원
 * 65세 이상: 50%
 * 20세 ~ 64세 : 정상 요금 
 * 14세 ~ 19세 : 청소년 70%
 * 7세~13세 : 50%
 * 0세~6세: 무료
 * 10단위에서 절삭 100원 단위로 계산하는 프로그램  
 */
package ch04condition;

import java.util.Scanner;

public class FlowExif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요 ");
		int age = Integer.parseInt(scanner.nextLine());
		
		double price = 1.250;
		if(age >=65) price = 1.250 * 0.5;
		else if (age >= 20) price = 1.250;	
		else if (age >= 14 ) price = 1.250 / 0.7;	
		else if (age >= 7 ) price = 1.250 / 0.5;	
		else  price = 0;	
	
		System.out.println("요금:" + price*1000 + "원입니다.");
		
		scanner.close();
		
	}


}
