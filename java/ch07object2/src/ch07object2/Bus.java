package ch07object2;

// 추상메서드가 있는 추상 클래스를 상속받으면 반드시 추상 메서드를 재정의 (Override)해야한다.
public class Bus extends Transport {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("버스로 이동 ");
		
	}

}
