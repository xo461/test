package ch07object2;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		execute(new InterfaceImplFacFor());
		execute(new InterfaceImplFacRecall());
		execute(new InterfaceExcute() {
			// 익명 클래스 작성 -> 한번만 처리하고 버린다. : AWT-자바 창객체 -> 버튼처리 
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("a를 실행");
			}
		});
		execute(new InterfaceExcute() {
			// 익명 클래스 작성 -> 한번만 처리하고 버린다. : AWT-자바 창객체 -> 버튼처리 
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("b를 실행");
			}
		});
		
	}

	// 인터페이스를 받아서 실행하는 메서드
	// 실행하는 시간을 체크하는 프로그램
	// proxy program -> 바로 실행이 안되고 앞 뒤로 일정의 처리가 되고 나서 중간에 처리되도록 만든 프로그램 
	public static void execute(InterfaceExcute ie) {
		// 시간은 얻어오기
		long startTime = System.nanoTime();
		ie.execute();
		long endTime = System.nanoTime();
		System.out.println("소요시간:" + (endTime - startTime));
	}
	
}
