package ch07object2;

public class BoardDAOTest {
	
	static BoardDAO boardDAO = null; // null.list()사용하려면 생성을 반드시 해야한다.
	static String dbms = "oarcle";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dbms = args[0];
		if(dbms == null);
		else if(dbms.equals("oracle"))
			boardDAO = new OracleBoardDAO();
		else if(dbms.equals("mysql"))
			boardDAO = new MySQLBoardDAO();
		
		// 리스트 처리
		boardDAO.list();
		// boardDAO 객체 변수의 클래스 이름을 출력
		System.out.println(boardDAO.getClass().getName());
		System.out.println(boardDAO instanceof OracleBoardDAO);
		System.out.println(boardDAO instanceof MySQLBoardDAO);
		System.out.println(boardDAO instanceof BoardDAO);
	}

}
