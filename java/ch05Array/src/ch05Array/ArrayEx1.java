package ch05Array;

import java.util.Arrays;

public class ArrayEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 점수 : 50, 60, 70, 80, 90 - 점수를 출력하고 합계를 구하자.  
		
		// 배열을 선언 = 배열 생성 -> 배열 문장 첫번째
//		int[] score = new int [5]; 
		// 값을 넣는다. 
//		score[0] = 50;
//		score[1] = 60;
//		score[2] = 70;
//		score[3] = 80;
//		score[4] = 90;
		
		// 값이 정해져 있고 데이터가 많지 않은 경우 (배열 문장 두번째)
//		int[] score = new int [] {50,60,70,80,90};
		
		// 값이 정해져 있고 데이터가 많지 않은 경우 - new와 배열을 생략 (배열 문장 세번째) 
		int[] score = {50,60,70,80,90}; // -> 가장 많이 쓰이는 배열 문장. 
		
		
		// 합계를 저장 변수
		int sum = 0;
		
		// 배열 0 ~ 4 : 초기값 - 0, 증감값: +1, 조건 : i <= 4 / i < 5
		for (int i = 0; i <=4; i++) {
			// 출력한다.
			System.out.println(score[i]);
			//합계
			sum += score[i];
		}
		System.out.println("합계"+sum);
		// 배열 객체 출력
		System.out.println(score); //[I@15db9742 -> 결과값 주소가 나옴. [ 는 배열이라는 뜻 I 는 int자라는 뜻
		// 배열을 출력하게 되면 타입과 주소관련 정보가 출력이 된다. 
		// 데이터 출력은 한 개씩 출력해야 한다.
		// 1. 인덱스를 사용하는 방법 -> 위에 코딩
		// 2. foreach (향상된 for) -> 모든 데이터 각각에 대해서 처리하고자 할때  
		sum = 0;
		for(int s : score) {
			System.out.println(s);
			sum += s;
					
		}
		System.out.println("합계"+sum);
		
		//1. 인덱스를 사용할때 모든 배열의 개수(배열의 갯수가 변경이 되어도 가능)만큼 처리 
		for(int i = 0; i < score.length ; i++)
			System.out.println(score[i]);
		
		// 배열의 모든 데이터를 출력하는 형식의 문자열로 만들어주는 메서드 
		// Arrays.toStringln(배열 []) -> Arrays 컨트롤 스페이스 바 해야 한다. 그래야 위에 import가 생성 된다. 
		System.out.println(Arrays.toString(score));
	
	}

}




























