package ch12enum;

import java.util.Scanner;

//enum 선언  
enum Days{SUN, MON, TUE, WED, THU, FRI, SAT}

public class EnumDaysTest {

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("요일을 입력하세요.");
		String input = scanner.nextLine();
		
		try {
			// 받은 문자열을 Days 값으로 변환해서 Days 타입의 변수에 입력 
			Days d = Days.valueOf(input);
			System.out.println(d);
		}catch(Exception e){
		 System.out.println("잘못된 요일 입니다.");
		
		}
	}
}