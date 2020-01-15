
public class Lunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		String [] Lunch = {"김치찌개", "뼈해장국", "보쌈정식", "중식당","태운 칼국수", "칼국수", "구로역","백반","동태찌개","부대찌개"};
		
		int menu = (int) (Math.random()*10)+1;
		
		System.out.println("오늘에 매뉴는 : " +Lunch[menu]);
		
	}
}
