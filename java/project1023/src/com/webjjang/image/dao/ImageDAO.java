package com.webjjang.image.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.image.dto.ImageDTO;

public class ImageDAO {
	//객체에서 사용할 DB 정보 -> List(), view()... 등등 다른 메서드에서 다 필요로 하기 때문에
	//전역변수로 선언한다.
	String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
	String id = "c##java13";
	String pw = "java13";
	
	//오라클 드라이버
	String driver = "oracle.jdbc.driver.OracleDriver";

	//service.BoardService->dao.BoardDAO
	//1. 이미지 리스트 데이터 가져오기
	//데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야하므로
	//여기서는 예외처리를 하지 않고 throw한다.
	
	public List<ImageDTO> list() throws Exception{
		System.out.println("ImageDAO.service()");
		List<ImageDTO> list = null;
		
		//데이터 가져오는 처리문
		//1. 드라이버 확인
		Class.forName(driver);
		
		//2. 연결객체
		Connection con = DriverManager.getConnection(url, id, pw);
		
		//3. 실행할 쿼리문 작성
		String sql =
		" select * from ( select rownum rnum, no, title, content, id, writeDate, fileName from ("
		+ " select no, title, content, id, to_char(writeDate, 'yyyy-mm-dd') writeDate, fileName from image order by no desc )"
		+ " ) where rnum between 1 and 10 ";
	 
		System.out.println("ImageDAO.list().sql"+sql);
		//4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		//5. 실행
		ResultSet rs = pstmt.executeQuery();
		//6. 표시/저장
		if(rs!=null) {
			while(rs.next()) {
				if(list == null) list = new ArrayList<ImageDTO>();
				
				ImageDTO dto = new ImageDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setWriteDate(rs.getString("writeDate"));
				
				list.add(dto);
			}
		}
		//7. 닫기
		con.close();
		pstmt.close();
		rs.close();
		
		System.out.println("ImageDAO.list().list : " + list);
		return list;
	}
	
	public ImageDTO view(int no) throws Exception{
		System.out.println("ImageDAO.view().no : " + no);
		ImageDTO dto = null;
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, pw);
		String sql = 
		" select no, title, content, id, to_char(writeDate, 'yyyy-mm-dd') writeDate, fileName from image where no = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		//pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no); //첫번째 물음표에 no 값으로 대체해라

		ResultSet rs = pstmt.executeQuery();
		
		if(rs!=null && rs.next()) {
			dto = new ImageDTO();
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setId(rs.getString("id"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setFileName(rs.getString("fileName"));
		}
		con.close();
		pstmt.close();
		rs.close();
		
		System.out.println("ImageDAO.view().dto : " + dto);
		
		return dto;
	}

	//글 작성하여 저장하는 것이므로 데이터 반환할 것이 없기 때문에 void
	public void write(ImageDTO dto) throws Exception{
		System.out.println("ImageDAO.write().dto : " + dto);
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, pw);
		String sql = 
		" insert into image( no, title, content, id, fileName) values(image_seq.nextval, ?, ?, ?, ?) ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		//pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setString(1, dto.getTitle()); 
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getId());
		pstmt.setString(4, dto.getFileName());

		//pstmt.executeUpdate()는 잘 되면 1 오류나면 0으로 반환하는 int형이기 때문에 ResultSet이 필요 없다.
		pstmt.executeUpdate();
		System.out.println("이미지 글 쓰기 성공");
		//단일 데이터 입력 후 저장이므로 데이터가 비었는지, 다음 데이터가 있는지 확인할 필요 없다.
		
		con.close();
		pstmt.close();
	}
	
	//글 작성하여 저장하는 것이므로 데이터 반환할 것이 없기 때문에 void
		public void update(ImageDTO dto) throws Exception{
			System.out.println("ImageDAO.update().dto : " + dto);
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, id, pw);
			String sql = 
			" update image set title = ?, content = ?, id = ?, fileName =? where no = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			//pstmt.setInt(?의 위치, ?를 대체해야할 값)
			pstmt.setString(1, dto.getTitle()); 
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getFileName());
			pstmt.setInt(5, dto.getNo());

			//pstmt.executeUpdate()는 잘 되면 1 오류나면 0으로 반환하는 int형이기 때문에 ResultSet이 필요 없다.
			pstmt.executeUpdate();
			//단일 데이터 입력 후 저장이므로 데이터가 비었는지, 다음 데이터가 있는지 확인할 필요 없다.
			
			con.close();
			pstmt.close();
		}

		public void delete(int no) throws Exception{
			//확인해야할 데이터 - 번호,제목, 내용, 작성자
			System.out.println("ImageDAO.delete().no : "+ no); //현재 위치에 들어와있음을 알리기 위해 출력
			//가져온 결과가 저장되어지는 변수 - 리턴해야 하므로 리턴타입과 같아야 한다.
			
			//데이터 가져오는 처리문
			//1. 드라이버 확인
			Class.forName(driver);
			
			//2. 연결객체
			Connection con = DriverManager.getConnection(url, id, pw);
			
			//3. 실행할 쿼리문 작성
			//쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당
			String sql =
					" delete from image where no = ? ";
			
			System.out.println("ImageDAO.delete().sql"+sql);
			
			//4. 실행객체 가져오기 / 데이터 셋팅
			PreparedStatement pstmt = con.prepareStatement(sql);
			//pstmt.setInt(?의 위치, ?를 대체해야할 값)
			pstmt.setInt(1, no);
			
			//5. 실행
			// select -> excuteQuery()
			// insert, update, delete -> excuteUpdate()
			pstmt.executeUpdate();
			
			//6. 표시/저장
			System.out.println("이미지 글 삭제 성공");
			
			//7. 닫기
			con.close();
			pstmt.close();
		}
}
