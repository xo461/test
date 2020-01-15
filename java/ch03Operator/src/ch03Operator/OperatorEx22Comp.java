package ch03Operator;

public class OperatorEx22Comp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		int b = 5;
		System.out.println(a > b);
		System.out.println(!(a > b));
		
		char ca = 'A';
		char cb = 'B';
		System.out.println(ca > cb);
		System.out.println(ca < cb);
		
		b = 10;
		System.out.println("a==b : " + (a==b));
		
		String str1 = "abcd";
		String str2 = "abcd";
		String str3 = new String("abcd");
		String str4 = new String("abcd");
		// new 와 주소값이 다름 . 밑 주소 값 참고 
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println(str3);
		System.out.println("str1 == str3 : " + (str1 == str3));
		
		// 
		// str1 ~ str4 까지의 주소를 출력하는 프로그램 작성 
		// hash code 출력 
		System.out.println("String hashCode 출력==========");
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		// identity hash code 출력 
		System.out.println("String identity hashCode 출력==========");
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		// 문자열  String을 데이터 비교를 할때는 equals()사용한다. 
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str3.equals(str4));
	
	}

}
