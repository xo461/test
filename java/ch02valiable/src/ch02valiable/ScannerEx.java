// class의 위치 지정
package ch02valiable;

// 다른 패키지에 위치해 있는 클래스는 import(포함시킨다.)해서 사용한다. 
// 엄청 자주 사용하는 패키지의 내용들은 import를 사용하지 않더라도 자동 import 한다. 
// --> java.lang 패키지는 자동 import 한다. 
// import java.util.*; -> java.util.모든 것을 다 import 하겠다.
import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 데이터를 입력할 때 사용하는 클래스 - 표준입력을 위해서 System.in을 전달해 준다. 
		// new : 새로 만든다. 메인메모리에 없던 것을 HDD에서 올린다.new 는 크기가 정해져
		//    있지 않은 내용을 메모리에 올리고 다시 사용하기 위해서 변수에 올린 위치(주소)를 저장한다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("두자리 정수를 하나 입력해 주세요:-->");
		String input = scanner.nextLine();
		System.out.println(input);
		System.out.println(input + 10);
		// Integer 클래스 : int 데이터를 가지고 있는 변수가 있다.
		//               그외 int 처리를 할 수 있는  메서드등이 있다.
		// 렙퍼클래스- 기본형 데이터를 감싸고 있는 클래스 - 처리에 필요한 메서드들을 가지고 있다. 
		int num = Integer.parseInt(input);
		System.out.println(num+10);
		System.out.println("int의 최고 큰 숫자:" + Integer.MAX_VALUE);
		
		scanner.close();
	}

}