package ch13thread;

import javax.swing.JOptionPane;

public class ThreadEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread time = new ThreadEx6_1();
		// 데몬쓰레드로 만들어서 main()가 끝나면 자동으로 끝내도록 처리하자.
		time.setDaemon(true);
		time.start();
		
		// 자바창을 열어서 문제를 푸는 프로그램 작성 
		// 자바 창 GUI 패키지 -> awt, swing
		String input = JOptionPane.showInputDialog("402호 담임선생님 이름은?");
		if(input.equals("이영환"))System.out.println("정답입니다.");
		else System.out.println("오답입니다.");
	//  stop() -> 지양한다. 버전업 하면서 다른 메서드 사용하도록 한다.
	//	time.stop();
	}// end of main()

}//end of ThreadEx6 class


// 시간을 카운트 하는 프로그램 작성
class ThreadEx6_1 extends Thread{
	
	//요구 되어지는  run method
	@Override
	public void run() {
		for(int i = 10; i > 0; i--) {
			try {
				// 1초 동안 재운다. 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("남은시간 : " + i);
			
		}
	}	
}