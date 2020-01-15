package ch03Operator;

public class OperatorEx5Arith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		int b = 4;
		int resi;
		short ress;
		short sa = 10;
		short sb = 4;
		long la = 10;
		double da = 10;
		
		
		System.out.println(a + " + " + b + " = " + a + b);
		System.out.println(a + " + " + b + " = " + (a+b));
		System.out.printf("%d + %d = %d %n", a, b, a+b);
		
		// 연산 시에 형변환 
		resi = a + b;
		System.out.println(resi);
		ress = (short) (a + b);
		// short + short -> int : 하드웨어적으로 구조가 정해져 있어서 int 값이 나온다. 
		ress = (short) (sa + sb);
		// 큰 크기의 데이터에 맞춰서 연산이 된다. 
		// long + int -> long -> long
		resi = (int) (la + a);
		System.out.println(da);
		System.out.println(da + b);
		a = (int) (da + b); 
		System.out.println(a);
		
		// /(나눗셈) - 소수점이 생기는 경우가 많다. 자바에서는 int 연산 시  소수점 아래를 버린다.(자바만의 특징)   
		System.out.println(a / b); // 14/4 -> 3.5 => 3
		// 만약에 소수점이 필요한 연산인 경우 한개 라도 데이터를 소숫점이 있는 데이터로 변환해준다. 
		System.out.println((double)a / b);
//		System.out.println(a / 0);
		System.out.println(a % b); // 2 - % 나머지 연산 
	}
}
