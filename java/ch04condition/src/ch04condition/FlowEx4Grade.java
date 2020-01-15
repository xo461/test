package ch04condition;

import java.util.Scanner;

public class FlowEx4Grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 입력하세요 :");
		int score = Integer.parseInt(scanner.nextLine());
		
		System.out.println("입력한 점수 :" + score);
		
		String grade = "";
		if(score >100) grade = "점수 오류:100보다 크다.";
		else if (score >= 90) grade = "A";	
		else if (score >= 80) grade = "B";	
		else if (score >= 70) grade = "C";
		else if (score >= 60) grade = "D";
		else if (score >= 0) grade = "F";
		else grade ="점수오류 0 보다 작다.";
				
	}
}

		
		// TODO Auto-generated method stub
		
		
		
    //점수를 입력받는다.
	//점수를 출력한다.
		
		
	//평점을 구한다. A, B, C, D, F
	//점수가 0보다 작거나 100보다크면 점수 입력 오류로 처리 
		
	// 평점을 출력한다.  



