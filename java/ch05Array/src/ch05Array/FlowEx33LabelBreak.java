package ch05Array;

public class FlowEx33LabelBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Loop1: // 라벨(:) 붙여서 이동할 때 사용 한다.  -> switch{case 값 : ~~)
		// break : switch, for, while - 제일 가깝고 감싸고 있는 한개
		for(int i = 2; i<=9; i++) {
			for(int j = 1; j <= 9; j++) {
				// 구구단 완전종료 조건
				if(j == 5)break Loop1;
				System.out.println(i + "*" + j + "=" + (i*j));
			}// end of for j
			System.out.println();
		} // end of for i
		System.out.println("구구단 처리 끝!");
	}

}
