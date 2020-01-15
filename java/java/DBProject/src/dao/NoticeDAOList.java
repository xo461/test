package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NoticeDAOList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// DB 연결 정보
		String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
		String id = "c##java00";
		String pw = "java00";
				
		// 드라이버
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			System.out.println("DB 시작");
			// 정상 처리
			// 1. 드라이버 확인
			Class.forName(driver);
			// 2. 연결
			Connection con = DriverManager.getConnection(url, id, pw);
			// 3. 쿼리작성
			String sql = " select no, title, "
					+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
					+ " to_char(endDate, 'yyyy-mm-dd') endDate, "
					+ " to_char(writeDate, 'yyyy-mm-dd') writeDate "
					+ " from notice ";
			System.out.println(sql);
			// 4. 실행객체
			PreparedStatement pstmt = con.prepareStatement(sql);
			// 5. 실행
			ResultSet rs =  pstmt.executeQuery();
			// 6. 저장, 표시
			if(rs != null) {
				while(rs.next()) {
					System.out.printf("%d - %s - %s - %s - %s %n",
						rs.getInt("no"),
						rs.getString("title"),
						rs.getString("startDate"),
						rs.getString("endDate"),
						rs.getString("writeDate")
						);
				}
			}
			// 7. 닫기
			con.close();
			pstmt.close();
			rs.close();
			System.out.println("DB 끝");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
