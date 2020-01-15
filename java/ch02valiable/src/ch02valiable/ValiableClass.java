// package : 클래스가 위치하는 위치 정보를 정의 한다. 
package ch02valiable;

// public : 공공의 - 다른 위치의 외부(다른위치:package)에서 접근가능
public class ValiableClass {
	//static : 주소가 고정인- 참조형 변수 (중간에 생성해서  저장해서 쓰는 경우)로 사용하지 않는다.
	//         class이름.main()을 사용한다.ValiableClass.main()
	//void : 없다. - 메서드 앞에 붙여서 사용
	//main() : ()이 있으면 처리문을 선언(앞에 리턴타입을 놓는다.)해 놓은 메서드
	//String : 문자열=문자배열=여러개의 문자(char) : 참조형 변수 
	//[] : 배열 => String[] : String(문자열)이 여러개
	//args : 변수
	//{} : 0개 이상 여러개의 선언
	//main() : 프로젝트의 시작부분 선언 
	public static void main(String[] args) {
		
		byte b = 123; // 1byte
		short s = 123; // 2byte
		// 큰 범위의 타입에서 작은 범위의 타입으로 데이터를 이동시킬때 큰 범위의 타입에 들어 데이터가 
		// 유실될수 있으나 강제적으로 타입을 맟춰 주는 작업을 해주는 것 -> 캐스팅 casting
		// 캐스팅을 전혀 상관이 없는 것은 가능하지 않다. 
		// 예 ) int i = 123L; (실행오류.) ---> int i = (int) 123L;
		int i = (int) 123L; // 4byte - 기본
		long l = 123L; // 8byte
		
		System.out.println(b); 
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		
		// 자동 캐스팅 테스트 
		// 작은 범위의 타입 -> 큰 범위
		s = b;
		i = b;
		l = b;
		
		// 큰 범위의 타입  -> 작은 범위의 타입 (강제로 캐스팅 선언해서 사용 : 데이터 유실이 생길 수 있다.)
//		b = i;
		b = (byte) i; // 강제 캐스팅 실행 
		
		// int 보다 작은 타입의 데이터를 연산을 하면 CPU에 들어가는데 CPU에서 저장하는 장치가 
		// 4바이트이다. 그래서 결과가 int가 나온다. int(4) -> short(2) : 캐스팅 필요 
		s = (short) (b + b);
		
		//final -> 끝 : 변경 불가능  -- 변수, 메서드, 클래스 의 값들을 변경 불가 할 수없는 값으로 선언 할때  final로 선언한다.  
		final int fi;
    	fi = 10; // 초기 (맨처음)에만 값을 넣을 수 있다. 
    	System.out.println(fi);
//		fi = 20; // 변경은 불가능하다. -> 상수(상수변수)
		
		// char - 2 byte : 문자한개: 숫자로 운영: -(마이너스)값이 존재하지 않는다.
		char c = 'A';
		System.out.println(c);
		System.out.println((int)c);
		System.out.println(c+1);
		System.out.println((int)c+1);
		System.out.println((char)(c+1));
//		c = i; // i type은 4바이트 -> char 2바이트: 캐스팅 필요/아래 참고
		c = (char) i; 
		i = c;
//		c = s; // s type 2바이트 -> c 2바이트 : 캐스팅필요/아래참고
		c = (char) s; 
//		s = c;
	}
}







