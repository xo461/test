package ch06Object;

public class PersonTest {

	public static void main(String[] args) {
		System.out.println("PersonTest.main() start");
		// TODO Auto-generated method stub
		// 사람의 대한 처리 -> 사람(Person)객체가 필요하다.
		// new Person () -> 기본 생성자 호출 : 생성자가 없으면 javac가 자동적으로 만들어 준다. 
		Person person = new Person();
		System.out.println(person);
		
		Person2 person2 = new Person2();
		System.out.println(person2);
		System.out.println("Person2 생성 -> Person22 전");
		// 사람을 등록할 때는 반드시 id번호, 이름, 국적은 반드시 입력해야 한다.
		Person2 person22 = new Person2("1000022", "test", "korea");
		System.out.println("Person2 생성 -> Person22 후");
		System.out.println(person22);
	
		// 사람 객체의 데이터 변경과 사용
		// person22 연락처를 변경해 보자.
		person22.setTel("010-2222-2222");
		// person22의 이름과 연락처 출력
		System.out.println(person22.getName() + "님의 연락처가" 
		+ person22.getTel()+ "로 변경되었습니다.");
			
		System.out.println("PersonTest.main() end");
	
	}
	
}
