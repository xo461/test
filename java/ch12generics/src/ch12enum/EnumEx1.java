package ch12enum;

//방향 데이터 정의 - 4가지만 사용한다. 
enum Direction{EAST, SOUTH, WEST, NORTH}// 타입임임으로 {EAST, SOUTH, WEST, NORTH}이것들 외에 쓸수 없다.

public class EnumEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Direction d1 = Direction.EAST;
		System.out.println(d1);
		if(d1.toString().equals("EAST")) //d1은 현재 Direction 타입이다!
			System.out.println("같다.");
//		d1 = "Test";
		System.out.println("d1.name(): " + d1.name());
		System.out.println("ordnal:"+ d1.ordinal()); // ordinal 순서 번호
		System.out.println(Direction.valueOf("EAST")); // 문자열로 나온게 아님.
		// enum 데이터의 문자열을 알고 있을 때 처리하기
		String dstr = "WEST";
		d1 = Direction.valueOf(dstr);	
		System.out.println(d1);
		Direction[] arrDir = Direction.values();
		for(Direction d : arrDir)
			System.out.println(d);
	}

}
