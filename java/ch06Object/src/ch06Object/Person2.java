package ch06Object;
/*
 * Person 클래스를 수정 했다. 
 * 생성을 하면 모든 String 변수들의 값이 null이므로 기본 값을 가지도록 처리 
 */

public class Person2 {
//  id번호, 이름,  생년월일, 성별, 연락처, 국적
	private String id, name, birth, gender, tel, nation;
	
	//초기화 블록(매개변수)없다. 값을 전달 못한다. -- 값 변경이 안되고 초기화 블록 안에 있는 값만 사용
	//static 초기화 블록(static{})- 호출하지 않아도 자동적으로 실행이 되므로 이름이 필요하지 않다. 
	//고정초기화 블록 - 클래스가 맨처음 찾게 되면 실행이 된다. -> 맨처음 new는 실행이 되는데 다음 부터는 실행이 안된다. 
	static{
		System.out.println("static 초기화 블록 실행 <= 한번만 실행됨");
	}
	
	// 초기화 블록 ({})- 호출하지 않아도 자동적으로 실행이 되므로 이름이 필요하지 않다. 
	// ↓ non static : new와 관련이 있다. 인스턴스 초기화 블록 -> new 마다 실행
	{
		System.out.println("초기화 블록 실행 ");
	}
	// 생성자 - 클래스 이름과 동일, 리턴 타입이 없다. 
	// 기본 생성자 - 생략 가능하다. 생략하고  생성자가 없으면  javac가 만들어 준다.
	public Person2() {
		// 부모 클래스를 먼저 생성을 하고 자신을 생성하게 된다. 생성이 되어 있어야 내 것으로 가져올 수 있다. 
		// 기본임으로 생략 가능하다. (부모 클래스의 기본 생성자 호출)
		super();
		System.out.println("person2()의 기본 생성자 실행 ");
		id = "1000011";
		name = "홍길동";
		birth = "2000-01-01";
		gender = "남자";
		tel = "111-111-1111";
		nation = "korea";
	} 
	
	// 생성자 - id번호, 이름, 국적
	public Person2 (String id, String name, String nation) {
		this(); // -> person2를 대신함. 생성자를 호출할려면 맨위에 한다. 
		System.out.println("Person2(id..) 생성자 실행");
		this.id = id;
		this.name = name;
		this.nation = nation;
	}
	
	// 데이터 받기 : getter - getId(), 데이터 넣기 : setter - serId(String id)
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	
	
	// 위에 올려 넣기. Object.toString()있고 Person.toString()
	// Person클래스 (자식클래스)가 Object(부모클래스)가 가지고 있는 모든 것을 상속 받으므로 
	// toString()가 이미 존재하게 된다. 그러나 본인만의 처리를 할 수 있는 toString()를 선언할 
	// 수 있는데 toString()를 호출을 하면 본인만의 처리 메서드인 Person.toString()가 
	// 호출 당한다. 아래에 부모클래스가 가지고 있던 toString() 올리고 그위 새로 작성한 
	// Person.toString()만 밖에서 볼 수 밖에 없다. 
	
	
	@Override
	public String toString() {
		System.out.println("Person2.toString() 실행 - 데이터 확인 ");
		return "Person [id=" + id + ", name=" + name + ", birth=" + birth + ", gender=" + gender + ", tel=" + tel
				+ ", nation=" + nation + "]";
	}
	

}
