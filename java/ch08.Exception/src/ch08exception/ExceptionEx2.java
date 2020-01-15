package ch08exception;

public class ExceptionEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//100 / 랜덤숫자(0~9)
		int number = 100;
		int result = 0;
		
		for(int i=0; i < 10; i++) {
			try {
				//100 / (0~9사이의 랜덤 숫자)로 나눈다. -> 랜덤 숫자가 0이면 예외 발생. 
				result = number / (int)(Math.random()*10);
				System.out.println(result);
				// try 안의 처리문에서 예외가 발생이 되면 그에 해당되는 예외객체를 생성해서 catch
				// 파라메터에 전달해서 넣어준다. 
			}catch(ArithmeticException e) {
				// 사용자를 위한 처리 	
				System.out.println("데이터 연산 오류(0으로 나눔)-out출력");
				System.out.println(e.getMessage());
				// 개발자를 위한 처리 
				System.err.println("데이터 연산 오류(0으로 나눔)-err출력");
				e.printStackTrace();
			}finally {
				System.out.println("finally - 반드시실행 된다.");
			}
			}
		}
		
	}


