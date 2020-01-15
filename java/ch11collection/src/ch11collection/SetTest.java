/*
 * 컬렉션 - 여러개의 데이터를 담는 객체
 * List -  데이터의 나열 : 중복을 허용 
 * Set - 데이터의 묶음 : 중복을 허용하지 않는다. 
 */
package ch11collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
		Set<String> set = new HashSet<String>();
		set.add("이영환");
		set.add("정태환");
		set.add("김동현");
		set.add("이영환");
		System.out.println(set); // 중복을 허용하지 않는다. 순서도 제각각이다. 
		System.out.println(set.size());
		// 데이터 순서대로 출력 
		Iterator<String> iter = set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());

		// 로또 프로그램 작성 - 랜덤 숫자를 발생시킨다.(1~45) : 6개의 숫자 - 중복이 되면 안된다. 
		
		Set set2 = new HashSet();
		
		for(int i = 0; set2.size() < 6; i++ ) {
			int num = (int)(Math.random()*45) + 1;
			set2.add(new Integer(num));
		}
		List list = new LinkedList(set2);
		Collections.sort(list);
		System.out.println(list);
	}

}










