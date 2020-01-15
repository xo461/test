package ch07object2;

public class FighterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fighter f1 = new Fighter(100); //
		Fightable f2 = new Fighter(200); // 위에 코드 보다 이것을 많이 사용한다.
		if (f1 instanceof Fightable)
			System.out.println("f1은 Fightable을 상속");
		if (f2 instanceof Movable)
			System.out.println("f2은 Movable을 상속");
		f1.move(10, 20);
		f1.attack((Unit)f2);
		System.out.println(f1);
		System.out.println(f2);
	}

}

// 공격 Unit - 공격 Unit -> Unit - HP, x, y : 상속
class Fighter extends Unit  implements Fightable{

	public Fighter(int hp) {
		// TODO Auto-generated constructor stub
		currentHP = hp;
	}
	
	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("공격 유닛 이동");
		this.x = x;
		this.y = y;
	}

	@Override
	public void attack(Unit u) {
		// TODO Auto-generated method stub
		System.out.println("공격 유닛 공격");
		u.currentHP -= 10;
	}

	@Override
	public String toString() {
		return "Fighter [currentHP=" + currentHP + ", x=" + x + ", y=" + y + "]";
	}
	
}

// Unit
class Unit{
	int currentHP; // 현재 체력
	int x; // x 좌표
	int y; // y 좌표
}

// 인터페이스 설계
// 싸움이 가능한 unit -> 이동가능, 공격가능
// 인터페이스는 다중 상속이 가능 <-> 클래스는 다중 상속이 불가능
interface Fightable extends Movable, Attackable{}
// unit이 이동을 한다.-> x, y 좌표
interface Movable { abstract void move(int x, int y);}
// unit이 공격을 한다.-> 대상 unit
interface Attackable { void attack(Unit u);}