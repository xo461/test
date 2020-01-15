// 클래스의 위치 파일이 있는 폴더 확인해서 작성 
package ch03Operator;

// 클래스 선언
public class OperatorEx1SingleOp {
	// 자동적으로 인식해서 실행이 되는 메서드 main() 작성
	public static void main(String[] args) {
		// i 변수 선언 + 초기값
		int i = 5;
		System.out.println("i = " + i);
		// i 변수에 1증가 시키자.
		i = i + 1;
		System.out.println("i = " + i);
		i += 1; // = i = i + 1;
		System.out.println("i = " + i);
		// ++1 : 선 증가 후 처리
		// 단독으로 증가문만 사용할 때는 선 증가나 후 증가 상관이 없다. 
		++i;
		System.out.println("i = " + i);
		// i++ : 선 처리 후 증가 
		i++; 
		System.out.println("i = " + ++i + "// i = " + ++i);		
		System.out.println("i = " + i++ + "// i = " + i++);		
		System.out.println("i = " + i);
		// 1증가 - 출력 전에 처리 
		i++; // 14출력
		System.out.println("i = " + i);
		// 위에 2 줄을 한 줄로 만들 수 있다. 
		System.out.println("i = " + ++i);

		// 출력 - 증가 하기 전에 출력 
		System.out.println("i = " + i);//15 출력
        // 1증가 - 출력 후 처리 
		i++; // 16 출력
		// 위에 2 줄을 한 줄로 만들 수 있다. 
		System.out.println("i = " + i++);
	}
}