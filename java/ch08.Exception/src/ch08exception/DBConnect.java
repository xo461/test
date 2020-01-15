package ch08exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// DB 필요한 정보 
		String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
		String id = "c##java17";
		String pw = "java00";
		
		// 어떤 드라이버 (DB 실행 시키는 프로그램)인지 쓸 수 있도록 처리해야한다.
		// static으로 만들어진 프로그램을 자동 로딩 시킬 수 있다. 
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 오라클 연결 
		// 1. 드라이버 확인 
		// try(자원객체) -> 이런 형식으로 사용하면 try 안에 처리가 끝나면 자동으로 자원을 반환한다.close 필요 x
		try(Connection con = DriverManager.getConnection(url, id, pw);) {
			// 정상 처리 
			System.out.println("정상처리 시작 ");
			System.out.println("드라이버 확인 ");
			Class.forName(driver);
			
			// 2. DB와 연결 
			System.out.println("오라클 연결 시도 ");
//			Connection con = DriverManager.getConnection(url, id, pw);
			System.out.println("연결 결과:" + con);
			
			// 3. 실행할 쿼리문 작성 
			String sql 
			= " select no, title, writer, writeDate, hit "
					+ " from board ";
			
			// 4. 연결 객체에서 실행객체를 꺼내서 실행한다. 
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
			// 5. select -> 데이터 꺼내오기 -> ResultSet(DB table 구조)
//				  insert, update, delete -> 데이터 변경이 되었다. 안됐다. 1 / 0
			ResultSet rs = pstmt.executeQuery();
			
			
			//6. 가져온 데이터표시  / 저장 (DTO->List)
			if (rs!=null) {
				while(rs.next()) { // 다음 데이터 -> 없으면 false / 있으면 이동 true
					System.out.println(rs.getInt("no"));
					System.out.println(rs.getString("title"));
					System.out.println(rs.getString("writer"));
					System.out.println(rs.getString("writeDate"));
					System.out.println(rs.getString("hit"));
				}
				
			}
			
			// 7. 사용한 객체 닫기 - con, pstm, rs
			// con -> try(자원객체) 형식으로 사용 했으므로 자동 자원 반환이 이루어진다. 
//			con.close();
			pstmt.close();
			rs.close();
			System.out.println("정상처리 끝");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// 예외 처리 
			e.printStackTrace();
		}
	}

}


