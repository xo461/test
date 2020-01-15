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

public class FlowExifbusfee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 정상요금 
		int nomalprice = 1250;
		int price = nomalprice;
		
		// 승객의 나이를 입력
		Scanner scanner = new Scanner(System.in);
		System.out.println("승객의 나이를 입력하세요");
		int age = Integer.parseInt(scanner.nextLine());
		// 요금을 계산 
		if(age >= 65) price = (int) (nomalprice * 0.5);
		else if(age >=20)price = nomalprice;
		else if(age >=14)price = (int) (nomalprice * 0.7);
		else if(age >=7)price = (int) (nomalprice * 0.5);
		else if(age >=7)price =  0;
		else price = -100;
		// 10단위 절삭
		price = price / 100 * 100;
		// 출력
		if(price >= 0)
			System.out.println("지불 하셔야 할 요금은 "+price+"원입니다.");
		else System.out.println("나이가 잘 못 입력 되었습니다.");
		
		scanner.close();
	}

}
