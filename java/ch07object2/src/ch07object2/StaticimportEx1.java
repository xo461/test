package ch07object2;

import static java.lang.System.out;
import static java.lang.Math.random;

public class StaticimportEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println("test"); -> static import 사용 전.
		out.println("test");
				
		//System.out.println(Math.random()); -> static import 사용 전.
		System.out.println(random());
	}

}
