package ch05Array;

import java.util.Scanner;

public class ArrayExAverage2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double score[] = new double[5];
		
		double total = 0;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		
		for(int i = 0; i<score.length;i++) {
			score[i] = input.nextDouble();
			total += score[i];
		}
		double average = total / score.length;
		
		System.out.println("평균"+average);
		
		
	}

}
