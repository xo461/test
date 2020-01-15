package ch11collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList arrList = new ArrayList();
		arrList.add(1004);
		arrList.add("김혜수");
		arrList.add(new Date());
		arrList.add(1004);
		arrList.add("김혜수");
		arrList.add(new Date());
		System.out.println(arrList);
		System.out.println("arrList 데이터 갯수 :" + arrList.size());
//		arrList.clear();
//		System.out.println(arrList);
		// 데이터를 하나씩 출력하자.
		for(Object obj : arrList)
			System.out.println(obj);
		Iterator iter = arrList.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		// 배열을 이용해서 데이터 저장 : ArrayList -> 데이터를 저장하는 변수 가지고 있다. 
		// 안에 있는 기본 타입이 Object -> 밖에서 선언한 타입으로 사용하도록 변수 타입을 변경 할 수 
		// 있다. : 제네릭스 : 안에 있는 변수를 String 으로 변경 -> ArrList<String> 
		ArrayList<String> arrList2 = new ArrayList<>();
//		arrList2.add(1004);
		List<String> list = arrList2;
		
		
	}

}

































