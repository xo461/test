package com.webjjang.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice.dto.NoticeDTO;
import com.webjjang.util.io.DBUtil;

public class NoticeDAO {
	
	// servico.NoticeviewService -> dao.NoticeDAO
	//1. 공지사항 리스트 데이터 가져오기
	// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로 
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다. 
    public List<NoticeDTO> list() throws Exception{
    	
    	System.out.println("NoticeDAO.list()");
		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴 타입과 같아야 한다. 
    	List<NoticeDTO> list = null;
    	
    	// 데이터 가져오는 처리문
    	// 1.드라이버 확인, 2.연결 객체
    	Connection con = DBUtil.getConnection();
    	// 3.실행한 쿼리문작성
    	String sql = " select no, title, "
    			+ "to_char(startDate,'yyyy-mm-dd') startDate, "
    			+ "to_char(endDate,'yyyy-mm-dd') endDate, "
    			+ "to_char(writeDate,'yyyy-mm-dd') writeDate, "
    			+ "to_char(updateDate,'yyyy-mm-dd') updateDate "
    			+ " from notice order by no desc ";
    	System.out.println("NoticeDAO.list().sql:" + sql);
    	// 4.실행객체 가져오기 / 데이터 셋팅
    	PreparedStatement pstmt = con.prepareStatement(sql);
    	// 5.실행
    	ResultSet rs = pstmt.executeQuery();
    	// 6.표시 /저장
    	if(rs != null) {
    		// rs.next(): 다음 데이처로 넘어가면서 데이처가 있으면 true, 없으면 false를 리턴 한다. 
    		while(rs.next()) {
    			// 최종적으로 저장할 list가 null이면 생성해서 사용가능 하도록 해준다. 
    			// ArrayList는 list의 일종으로 배열을 사용한다. (연속된주소)
    			if(list == null)list = new ArrayList<NoticeDTO>();
    			// 공지사항 하나의 데이터를 담는 객체 생성  - NoticeDTO
    			NoticeDTO dto = new NoticeDTO();
    			// 데이처를 담는다. rs에서 꺼내서  dto에
    			dto.setNo(rs.getInt("no"));
    			dto.setTitle(rs.getString("title"));
    			dto.setStartDate(rs.getString("startDate"));
    			dto.setEndDate(rs.getString("endDate"));
    			dto.setWriteDate(rs.getString("writeDate"));
    			dto.setUpdateDate(rs.getString("updateDate"));
    			// 리스트 데이터가 여러개 이므로 데이터를 담은 dto를 list에 추가 시킨다. 
    			list.add(dto);
    		}// end of while(rs.next())
    	}// end of if(rs == null)
    	
    	// 7.닫기
    	DBUtil.close(con, pstmt, rs);
    	
    	System.out.println("NoticeDAO.list().list:"+list);
    	   	
    	return list;
	}// end of list()
    
    
    // servico.NoticeService -> dao.NoticeDAO
    //2. 공지사항 글보기 데이터 가져오기 - 한개 데이터 - 글번호에 따라서 결정 (전달 받는다.)
    // 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로 
    // 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
    // NoticeController : 실행내용 결정  - 데이터 수집 / 표시 
    // NoticeController -> Service -> DAO
    public NoticeDTO view(int no) throws Exception{
    	
    	System.out.println("NoticeDAO.view().no:" + no);
    	
    	// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴 타입과 같아야 한다. 
    	NoticeDTO dto = null;
    	
    	// 데이터 가져오는 처리문
    	// 1.드라이버 확인
    	
    	// 2.연결 객체
    	Connection con = DBUtil.getConnection();
    	// 3.실행한 쿼리문작성
    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
    	String sql = " select no, title, content, "
    			+ "to_char(startDate,'yyyy-mm-dd') startDate, "
    			+ "to_char(endDate,'yyyy-mm-dd') endDate, "
    			+ "to_char(writeDate,'yyyy-mm-dd') writeDate, "
    			+ "to_char(updateDate,'yyyy-mm-dd') updateDate "
    			+ " from notice where no = ? ";
    	System.out.println("NoticeDAO.view().sql:" + sql);
    	// 4.실행객체 가져오기 / 데이터 셋팅
    	PreparedStatement pstmt = con.prepareStatement(sql);
    	// pstmt.setInt(?의 위치,?를 대체 해야할 값)
    	pstmt.setInt(1, no);
    	// 5.실행
    	ResultSet rs = pstmt.executeQuery();
    	// 6.표시 /저장
    	if(rs != null && rs.next()) {
    		// rs.next(): 다음 데이처로 넘어가면서 데이처가 있으면 true, 없으면 false를 리턴 한다. 
    			// 공지사항 하나의 데이터를 담는 객체 생성  - NoticeDTO
    			dto = new NoticeDTO();
    			// 데이처를 담는다. rs에서 꺼내서  dto에
    			dto.setNo(rs.getInt("no"));
    			dto.setTitle(rs.getString("title"));
    			dto.setContent(rs.getString("content"));
    			dto.setStartDate(rs.getString("startDate"));
    			dto.setEndDate(rs.getString("endDate"));
    			dto.setWriteDate(rs.getString("writeDate"));
    			dto.setUpdateDate(rs.getString("updateDate"));
    			
    	}// end of if(rs != null&& rs.next())
   	
    	
    	// 7.닫기
    	DBUtil.close(con, pstmt, rs);
    	
    	System.out.println("NoticeDAO.view().dto:"+dto);
    	
    	return dto;
    } // end of view()
    // servico.NoticeWriteService -> dao.NoticeDAO
    //3. 공지사항 글쓰기 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
    // 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
    // NoticeController : 실행내용 결정  - 데이터 수집 / 표시 
    // NoticeController -> Service -> DAO
    public void write (NoticeDTO dto) throws Exception{
    
    	System.out.println("NoticeDAO.write().dto:" + dto);
    	
    	
    	// 데이터  저장 처리문
    	// 1.드라이버 확인
    	
    	// 2.연결 객체
    	Connection con = DBUtil.getConnection();
    	// 3.실행한 쿼리문작성
    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
    	String sql = " insert into notice(no, title, content,"
    			+ " startDate,endDate) "
				+ " values(notice_seq.nextval, ?, ?, ?, ?) ";
		System.out.println("NoticeDAO.write().sql:"+sql);
    	// 4.실행객체 가져오기 / 데이터 셋팅
    	PreparedStatement pstmt = con.prepareStatement(sql);
    	// pstmt.setInt(?의 위치,?를 대체 해야할 값)
    	pstmt.setString(1, dto.getTitle());
    	pstmt.setString(2, dto.getContent());
    	pstmt.setString(3, dto.getStartDate());
    	pstmt.setString(4, dto.getEndDate());
    	// 5.실행
    	// select -> executeQuery();
    	// insert, update, delete -> executeUpdate
    	int result = pstmt.executeUpdate();
    	// 6.표시 /저장
    	System.out.println("공지 등록 성공 ");
    			
    	// 7.닫기
    	DBUtil.close(con, pstmt);
    } // end of write()
    // servico.NoticeUpdateService -> dao.NoticeDAO
    //4. 공지사항 글수정 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 수정처리
    // 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
    // NoticeController : 실행내용 결정  - 데이터 수집 / 표시 
    // NoticeController -> Service -> DAO
    public int update(NoticeDTO dto) throws Exception{
    	
    	// 확인해야할 데이터 - 번호, 제목, 내용, 작성자 
    	System.out.println("NoticeDAO.update().dto:" + dto);
    	
    	
    	// 데이터 저장 처리문
    	// 1.드라이버 확인

    	// 2.연결 객체
    	Connection con = DBUtil.getConnection();
    	// 3.실행한 쿼리문작성
    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
    	String sql = "update notice set title = ?, content = ?, updateDate = sysdate "
    			+ " where no = ?";
    	System.out.println("NoticeDAO.update().sql:"+sql);
    	// 4.실행객체 가져오기 / 데이터 셋팅
    	PreparedStatement pstmt = con.prepareStatement(sql);
    	// pstmt.setInt(?의 위치,?를 대체 해야할 값)
    	pstmt.setString(1, dto.getTitle());
    	pstmt.setString(2, dto.getContent());
    	pstmt.setInt(3, dto.getNo());
    	// 5.실행
    	// select -> executeQuery();
    	// insert, update, delete -> executeUpdate
    	int result = pstmt.executeUpdate();
    	// 6.표시 /저장
    	System.out.println("글수정 성공 ");
    	
    	// 7.닫기
    	DBUtil.close(con, pstmt);
    
    	return result;
    } // end of update()
    
    
    // servico.NoticeDeleteService -> dao.NoticeDAO
    //5. 공지사항 글삭제 데이터 가져오기 - 글번호 전달 받아서 DB에 삭제처리
    // 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
    // NoticeController : 실행내용 결정  - 데이터 수집 / 표시 
    // NoticeController -> Service -> DAO
    public int delete(int no) throws Exception{
    	
    	// 확인해야할 데이터 - 번호
    	System.out.println("NoticeDAO.delete().no:" + no);
    	
    	// 1.드라이버 확인
    	
    	// 2.연결 객체
    	Connection con = DBUtil.getConnection();
    	// 3.실행한 쿼리문작성
    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
    	String sql = " delete from notice "
    			+ " where no = ? ";
    	System.out.println("NoticeDAO.delete().sql:"+sql);
    	// 4.실행객체 가져오기 / 데이터 셋팅
    	PreparedStatement pstmt = con.prepareStatement(sql);
    	// pstmt.setInt(?의 위치,?를 대체 해야할 값)
    	pstmt.setInt(1, no);
    	
    	// 5.실행
    	// select -> executeQuery();
//    	ResultSet rs = pstmt.executeQuery();
//    	if(rs != null && rs.next()) {
//    		dto = new NoticeDTO();
//    	}
    	// insert, update, delete -> executeUpdate
    	int result = pstmt.executeUpdate();
    	// 6.표시 /저장
    	System.out.println("글삭제 성공 ");
    	
    	// 7.닫기
    	DBUtil.close(con, pstmt);
		return result;
    } // end of delete()


	
}
	










