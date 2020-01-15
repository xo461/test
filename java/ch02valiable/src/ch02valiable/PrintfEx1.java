// 클래스의 위치와 맞쳐야 한다. 
package ch02valiable;

// 파일 이름과 같은 클래스를 작성한다. public
public class PrintfEx1{
	// 클래스가 가지고 있는 구성원 작성 
	
	// 자바가 자동으로 실행할 메서드 (main()) 작성
	// Public 공공의 : 다른 장소의 객체에서 사용가능하다.
	// static 고정 : 먼저 메모리에 올라가서 자바가 종료 될때까지 
	//             메모리의 주소를 그대로 가지고 있다. 
	// void 없다. : main()처리가 다 끝나면 돌려받는 것이 없다. 리턴타입- 메서드 앞에만 있는 타입
	// String : 문자열 - 참조형 변수
	// [] 배열 : 여러개 
	// args 변수 이름 : 주소가 들어 있는 변수 - 참조형 변수 
	public static void main(String[] args) {
		// 타입 변수명 --> 변수 선언 
		// 변수명  = 값 처음에 나오면 초기값 셋팅 
		int finger = 10;
		System.out.println(finger);
		// 데이터 이어 붙이기를 사용해서 문자열로 만들어 출력
		System.out.println("finger = " + finger);
		// 형식 문자열을 만들고 대체문자 (%형식문자)로 데이터를  대신하고 출력할 데이터를 ","를 이용해서
		// 나열해 준다. 이때 대체문자와 출력할 데이터의 갯수는 같아야한다.
		// %n : 줄바꿈 대체문자 
		System.out.printf("finger = %d%n",finger);
		// %출력할 자리수d
		System.out.printf("finger = [%5d]%n",finger);
		// %-자리수d : 숫자 정렬은 오른쪽인데 "-" 붙여서 왼쪽 정렬
		System.out.printf("finger = [%-5d]%n",finger);
		// 자릿수가 크면 공백문자가 기본인데 0으로 채우려면 %0자리수d를 사용한다.
		System.out.printf("finger = [%05d]%n",finger);
		// 진법 출력
		System.out.printf("finger(hex) = [%x]%n",finger);
		System.out.printf("finger(oct) = [%o]%n",finger);
		System.out.printf("finger(bin) = [%s]%n",
				Integer.toBinaryString(finger));
		System.out.printf("finger(hex) = [%x] / finger(oct)=  [%o]%n",finger,finger);
		
	}
}