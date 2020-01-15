package ch07object2.dto2;

import ch07object2.dto.Data;

public class Data2 {

	public void print() {
		// Data 생성 -> 다른 패키지에 있는 클래스를 생성
		Data data = new Data();
		data.pubInt = 100;
//		data.proInt = 100; // 같은 패키지에서는 new로 사용할수 있으나 다른 패키지에서는 불가능
//		data.defInt = 100; // 같은 패키지에서는 new로 사용할수 있으나 다른 패키지에서는 불가능
//		data.priInt = 100; // private은 같은 클래스에서만 사용 가능합니다.
	}
}
