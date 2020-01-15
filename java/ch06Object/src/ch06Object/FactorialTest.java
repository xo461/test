package ch06Object;

public class FactorialTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//factorial() 보이지 않는다. 이유: static 이 없으므로 메모리에 생성 되지 않아서 보이지 않음. 
		// 그러므로 static을 생성 하거나 
		int result =  factorial(5);
		System.out.println(result);
		result = FactorialTest.factorial(5); // 클래스 메서드 
		System.out.println(result);
	
		
		// 2번 non static 일 때 호출 방식 new 사용 
		FactorialTest f = new FactorialTest();
		result = f.factorial2(5); // 인스턴스 메서드 
		System.out.println(result);
	
	
	}
	
// static 고정 - 메인 메모리에 자동으로 올라간다. - main()메소드가 실행되는 시점에서 존재한다.  	
// 1번
	public static int factorial(int n) {
		int result;
		if(n == 1 )
			result = 1;
		else 
			result = n * factorial(n - 1);
		
		return result;
		
	}

	
// non static인 경우 가변 주소 - 메인 메모리에 올리면  new 키워드를 사용해야 한다. 
	//2번 더 간결하게 쓰기
	public int factorial2(int n) {
		return (n == 1 )?1:n* factorial2(n-1);
	}
}

// 1번 2번 동일한 호출 방식임