package ch07object2;

public class BoardDAOTest {

	static BoardDAO boardDAO = null; // null. list 사용하려면 생성을 반드시 해야한다. 
	static String dbms = "oracle";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dbms = args[0];
		if(args[0] == null);
		else if(args[0].equals("oracle"))
			boardDAO = new OracleBoardDAO();
		else if(args[0].equals("mysql"))
			boardDAO = new MySQLBoardDAO();

	
		//리스트처리 
		boardDAO.list();
		// boardDAO 객체 변수의 클래스 이름을 출력
		System.out.println(boardDAO.getClass().getName());
		System.out.println(boardDAO instanceof OracleBoardDAO);
		System.out.println(boardDAO instanceof MySQLBoardDAO);
		System.out.println(boardDAO instanceof BoardDAO);
	}

}
