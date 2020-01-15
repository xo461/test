package ch03Operator;

public class OperatorEx17Round {
	
	public static void main(String[] args) {

		System.out.println("반올림 처리=============");
		double pi = 3.141592;
		// 소숫점 4째자리에서 반올림해서 소수점 3째 자리 까지만 처리 해보자 .
		// 3.141592 * 1000 => 3141.592 +0.5 = 3142.092 -> int로 변환(뒷 소수점을 버림)-> 3141 
		// 3142 / 1000.0(소숫점이 필요함으로 두 숫자중 한개를 소수점이 있는 숫자로 만듬.) -> 3.142
		double shortpi = (int)(pi * 1000 + 0.5) / 1000.0;
		System.out.println(shortpi);
		
		// 소수점 이하 반올림을 하는  Math.round() 메서드를 이용한 프로그램 
		// 반올림 하려는 소수점 위치 처리는 코딩을 해야한다. 
		shortpi = Math.round(pi * 1000) / 1000.0;
		System.out.println(shortpi);
		
		// 메서드 호출해서 반올림 
		System.out.println("pi에서 4째 반올림 :" + round(pi,4));
	} // end of main()
	
	// 반올림하는 메서드 선언 사용 
	/**
	 * 
	 * @param d : 소수점이 있는 원본 데이터 저장 변수 
	 * @param p : 반올림 하는 위치를 저장하는 변수 
	 * @return : 반올림 연산이 된 데이터를 돌려준다. 
	 */
	public static double round(double d, int p) {
		// 반올림 하는 위치 -1 한 10의 지수승 
		int mul = (int) Math.pow(10, p-1); // 지수승 값 확인
		System.out.println(mul);
		// 반올림 값을 구해서 돌려준다. 
		return Math.round(d*mul) / (double)mul;
	} 

}
