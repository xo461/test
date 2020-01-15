package ch04condition;

public class FlowEx23While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		for(;i <= 5;) 
			System.out.println(i++);
			
		// 조건에 따라서 반복 처리 
		System.out.println("while문을 이용한 출력 ===============");
		i = 1;
		while(i <= 5)
			System.out.println(i++);
			
		i = 1;
		for(;;) { // 무한 반복 = while(true) 
			if(!(i<=5)) // 반복처리 결정 조건  -> 반복문을 빠져나가는 조건 
				break;  
			System.out.println(i); // 실제적인 처리문 
			i++; // 증감값
		}
		System.out.println("while문 반복문2===============");
		i = 1;
		while(true) {
			if(!(i<=5)) // 반복처리 결정 조건 -> 반복문을 빠져나가는 조건 
				break;  
			System.out.println(i); 
			i++; // 증감값
		}
	}
}
