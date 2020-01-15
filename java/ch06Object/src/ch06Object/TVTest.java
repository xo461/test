package ch06Object;

public class TVTest {

	static String email;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Main");
		// TV 필요하다. -> 객체로 생성해서 사용한다.
		// == 인스턴스화 시킨다. -> 인스턴스가 생긴다. => 자기 자신을 객체로 만들어서 주소를 제공 할때 
		TV tv1 = new TV();
		TV tv2 = new TV();
		System.out.println(tv1.toString() +"/"+ tv2);
		tv1.color = "black";
		System.out.println(tv1.color);
	
		// tv1 객체의 기능 사용해보자.
		// 전원 조작
		tv1.powerOnOff();
		System.out.println(tv1);
		
		// 채널올리기 
		tv1.channelUp();
		System.out.println(tv1);
		
		// 채널내리기
		tv1.channelDown();
		System.out.println(tv1);
		
		// 채널 변경
		tv1.channelchange(11);
		System.out.println(tv1);
		
		// 모든 클래스는 기본적으로 object를 상속받는다.
		// Object(부모클래스) - TV(자식 클래스 :Object가 가지고 있는 것을 상속(내꺼)받는다.)
		// 중요 : 관계가 생겼다. -> 캐스팅(형변환)이 가능하다.
		// TV -> Object로 만드는데 문제가 없다.
		// Object -> TV로 만들때는 문제가 있다. Object 타입에 TV객체를 저장해 놓은 경우만 가능
		Object obj = new TV(); // 작 -> 큰 : 자동 캐스팅 
		System.out.println(obj.toString());
		((TV)obj).channelUp();
		System.out.println(obj);
		// Object 안에 넣은 것이 String -> Object[String]
		obj = new String("test");
		((TV)obj).channelUp();
		System.out.println(obj);

		
		
//		String name;
//		System.out.println(name);
//		System.out.println(email);
	} // end of main

}// end of TVTest class

//클래스 선언 
class  TV{
	// TV 정보를 저장하는 변수  - TV클래스의 구성원 (member 변수) 
	// - 메서드 안에 들어가 있지 않다. 전역변수 : 지역이 따로 정해져 있지않고 어디서든 쓸 수 있다. 
	// new 할때 생성이 되고 처리할때는 이미 존재하게 되어져 있다. 초기화가 반드시 되어야 한다.(자동) 
	String color; // 색상 , 기본값으로 null 
	boolean power; // 전원상태(on/off) > 꺼져있는지 켜져 있는지를 저장하는 상태를 저장하는 변수 // 기본값으로 false 
	int channel; // 채널 > 현재 시청중인 채널의 정보를 저장하는 변수  // 기본 값으로 0
	
	/// 생성자 - 생성할때 호출해서 사용하는 특별한 메서드 
	public TV() {}
	
	
	void print(){
		System.out.println(color);
		String menu = null; // 매서드 안에 있는 변수는 사용하려면 반드시 초기화를 수동으로 시켜줘야한다. 
		System.out.println(menu);
	}// end of print()
	
	// 전원 켜기 끄기 : true -> false = on / false -> true(not:!) = off 
	void powerOnOff() {
		power = !power; // ! : not
	}
	// 채널 올리기
	void channelUp() {
		++channel;
	}
	// 채널 내리기
	void channelDown() {
		--channel;
	}
	// 채널 선택 -> 번호를 입력하면 받아야 한다. -> 변수 선언 : 위치 (변수) 
	void channelchange(int channel) {
		// this -> 자신의 객체를 의미한다. -> 생성해서 변수로 저장 -> 변수의 주소가 this 
		this.channel = channel;
	}
	// object를 출력하고자 할때 자동적으로 호출 당해서 처리한 후 결과를 출력하게 해주는 메서드 
	public String toString() {
		// getClass() -> 메서드 호출  object class에서 상속 받았다. 내꺼다. 
		// getName() -> package...className
		// getSimpleName() -> className :: TV
		return getClass().getSimpleName() + "[" +
		"color=" + color + ",power=" + power + ", channel = " + channel + "]";
	}
}// end of TV class






















































