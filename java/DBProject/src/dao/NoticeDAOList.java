package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeDAOList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
		String id = "c##java17";
		String pw = "java00";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
  
		try {
			System.out.println("정상처리 시작 ");
			System.out.println("드라이버 확인 ");
			Class.forName(driver);
			
			System.out.println("오라클 연결 시도 ");
			Connection con = DriverManager.getConnection(url, id, pw);
			System.out.println("연결 결과:" + con);
			
			String sql
			= " select no, title, content, "
					+ "to_char(startDate,'yyyy-mm-dd') startDate, "
					+ "to_char(endDate, 'yyyy-mm-dd')endDate,"
					+ "to_char(writeDate, 'yyyy-mm-dd')writeDate,"
					+ "updateDate from notice ";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
		
			if(rs!=null) {
				while(rs.next()) {
					System.out.printf(" %d - %s - %s -%s -%s -%s %n",rs.getInt("no"),rs.getString("title"),rs.getString("content"),rs.getString("startDate"),rs.getString("endDate"),rs.getString("writeDate"),rs.getString("updateDate"));
					
					
					
					
					
//					System.out.println(rs.getInt("no"));
//					System.out.println(rs.getString("title"));
//					System.out.println(rs.getString("content"));
//					System.out.println(rs.getString("startDate"));
//					System.out.println(rs.getString("endDate"));
//					System.out.println(rs.getString("writeDate"));
//					System.out.println(rs.getString("updateDate"));
//			
					}
				}
			
			con.close();
			pstmt.close();
			rs.close();
			System.out.println("정상처리 끝");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			
	
	}

}
