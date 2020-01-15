package ch07object2;

public class FighterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fighter f1 = new Fighter(100); //
		Fightable f2 = new Fighter(200); // ↑위에 코드 보다 이것을 많이 사용한다.
		
		if (f1 instanceof Unit)
			System.out.println("f는 Unit클래스의 자손입니다.");
		
		if (f1 instanceof Fightable) 
			System.out.println("f1는 Fightable 인터페이스를 구현했습니다.");
		
		if (f2 instanceof Movable) 
			System.out.println("f2는 Movable 인터페이스를 구현했습니다.");
		
		if (f1 instanceof Attackable) 
			System.out.println("f는 Attackable 인터페이스를 구현했습니다.");
		
		if (f1 instanceof Object) 
			System.out.println("f는 Object 클래스의 자손입니다.");
		
		f1.move(10, 20);
			System.out.println(f1);
	}

}
		//공격 Unit - 공격Unit -> Unit - HP, x, y : 상속 
		class Fighter extends Unit implements Fightable {
			
			public Fighter(int hp) {
				currentHP = hp;
			}
			public void move (int x, int y) {
				System.out.println("공격 유닛 이동 ");
			
			}
			
			public void attack (Unit u) {
				System.out.println("공격 유닛 공격");
			
			
			}
			@Override
			public String toString() {
				return "Fighter [currentHP=" + currentHP + ", x=" + x +", y=";
			}
		}
		
		// Unit
		class Unit {
			int currentHP; // 유닛의 체력
			int x;         // 유닛의 위치(x좌표)
			int y;         // 유닛의 위치(y좌표)
		}
		// 인터페이스 설계\
		// 싸움이 가능한 unit -> 이동가능, 공격가능
		// 인터페이스는 다중상속이 가능 <-> 클래스는 다중상속이 불가능
		// unit이 이동을 한다. -> x, y 좌표
		// unit이 공격을 한다. -> 대상 unit
		interface Fightable extends Movable, Attackable{}
		interface Movable {void move (int x, int y); }
		interface Attackable { void attack (Unit u); }
		
		
		
		
		
		
		
		
		
