package ch05Array;

public class 구구단만들기 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			// break : switch, for, while - 제일 가깝고 감싸고 있는 한개
			for(int i = 2; i<=9; i++) {
				for(int j = 1; j <= 9; j++) {
					System.out.println(i + "*" + j + "=" + (i*j));
				}
				System.out.println();
			}
			
		}

	}

	

