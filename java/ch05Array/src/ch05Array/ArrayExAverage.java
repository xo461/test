package ch05Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 학생 수를 입력받는다.
		Scanner scanner = new Scanner(System.in);
		int count = 0; 
		System.out.println("학생 수를 입력하세요.");
		count = Integer.parseInt(scanner.nextLine());
		
		
		// 학생수 만큼의 데이터를 저장할 배열을 준비
		int[] scores = new int[count];
		
		
		// 학생수 만큼 점수를 입력 받는다. - 배열사용
		for (int i = 0; i < scores.length; i++) {
			System.out.print((i + 1)+"번째 학생의 점수 : ");
			scores[i] = Integer.parseInt(scanner.next());
		}
		
		
		// 합계와 평균을 구한다. 
		int sum = 0;
		for(int score : scores) sum += score;
		int average = sum / scores.length;
//		int average = sum / count;
		
		// 출력은 학생들의 점수를 출력한다. 
		System.out.println("입력한 학생들의 점수 ===================");
		System.out.println(Arrays.toString(scores));
		
		// 합계와 평균을 출력한다. 	
		System.out.printf("합계 :%d%n", sum);
		System.out.printf("평균 :%d%n", average);
		
		scanner.close();

	}

}
