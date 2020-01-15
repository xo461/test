package com.webjjang.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.message.controller.MessageController;
import com.webjjang.message.dto.MessageDTO;
import com.webjjang.util.db.DBUtil;

public class MessageDAO {

	// 오라클 드라이버

	public List<MessageDTO> list() throws Exception {
		List<MessageDTO> list = null;

		// 데이터 가져오는 처리문
		// 1. 드라이버 확인
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		String sql = " SELECT no, content, sender, TO_CHAR(sendDate, 'yy-mm-dd') sendDate, accepter, TO_CHAR(acceptDate, 'yy-mm-dd') acceptDate  FROM message ORDER BY no DESC ";
		System.out.println("MessageDAO.list().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				if (list == null)
					list = new ArrayList<MessageDTO>();
				MessageDTO dto = new MessageDTO();
				dto.setNo(rs.getInt("no"));
				dto.setContent(rs.getString("content"));
				dto.setSender(rs.getString("sender"));
				dto.setSendDate(rs.getString("sendDate"));
				dto.setAccepter(rs.getString("accepter"));
				dto.setAcceptDate(rs.getString("acceptDate"));
				list.add(dto);
			}
			DBUtil.close(con, pstmt, rs);
		}
		System.out.println("MessageDAO.list().list : " + list);
		return list;
	}

	public MessageDTO view(int no) throws Exception {

		System.out.println("MessageDAO.view().no : " + no);

		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴 타입과 같아야 함
		MessageDTO dto = null;

		// 데이터 가져오는 처리문
		// 1. 드라이버 확인
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당함.]
		if(Integer.parseInt(MessageController.menu) == 2)
			updateAcceptDate(no);
		String sql = " SELECT no, content, sender, TO_CHAR(sendDate, 'yy-mm-dd') sendDate, accepter, TO_CHAR(acceptDate, 'yy-mm-dd') acceptDate  FROM message WHERE no = ? ";
		System.out.println("MessageDAO.list().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, 대체할 값)
		pstmt.setInt(1, no);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		
		System.out.println(rs);
		// 6. 표시 / 저장
		if (rs != null && rs.next()) { // rs.next() -> 다음 데이터로 넘어가면서 데이터가 있으면 true, 없으면 false를 리턴
			// 게시판 하나의 데이터를 담는 객체 생성 -> BoardDTO
			dto = new MessageDTO();
			// 데이터를 dto에 담는다. rs에서 꺼내어 dto 에 담는다.
			dto.setNo(rs.getInt("no"));
			dto.setContent(rs.getString("content"));
			dto.setSender(rs.getString("sender"));
			dto.setSendDate(rs.getString("sendDate"));
			dto.setAccepter(rs.getString("accepter"));
			dto.setAcceptDate(rs.getString("acceptDate"));

		} // end of if(rs != null && rs.next())
			// 7. 닫기
		DBUtil.close(con, pstmt, rs);

		System.out.println("BoardDAO.list().dto: " + dto);
		return dto;
		// end of view()
	}

	public void send(MessageDTO dto) throws Exception {

		System.out.println("MessageDAO.send().dto : " + dto);

		// 데이터 저장하는 처리문
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당함.
		String sql = " INSERT INTO message(no, content, sender, accepter) VALUES (message_seq.nextval, ?, ?, ?) ";
		System.out.println("Message.send().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, 대체할 값)

		pstmt.setString(1, dto.getContent());
		pstmt.setString(2, dto.getSender());
		pstmt.setString(3, dto.getAccepter());
		// 5. 실행
		// SLECET -> executeQuery()
		// INSERT, UPDATE, DELETE -> excuteUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("메세지 보내기 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
	}

	public void update(MessageDTO dto) throws Exception {
		System.out.println("MessageDAO.update().dto : " + dto);
		// 1. 드라이버 확인
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당함.
		String sql = " UPDATE message SET content = ? WHERE no=  ? ";
		System.out.println("BoardDAO.update().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, 대체할 값)
		pstmt.setString(1, dto.getContent());
		pstmt.setInt(2, dto.getNo());
		// 5. 실행
		// SLECET -> executeQuery()
		// INSERT, UPDATE, DELETE -> excuteUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글 수정 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
	}
	
	public void updateAcceptDate(int no) throws Exception {
		String sql = " UPDATE message SET acceptDate = SYSDATE WHERE no = ? ";
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
		DBUtil.close(con, pstmt);
	}

	public void delete(int no) throws SQLException {
		// TODO Auto-generated method stub
		// 확인해야할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.delete().no : " + no);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당함.
		String sql = " DELETE FROM message WHERE no = ? ";
		System.out.println("MessageDAO.delete().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, 대체할 값)
		pstmt.setInt(1, no);
		// 5. 실행
		// SLECET -> executeQuery()
		// INSERT, UPDATE, DELETE -> excuteUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("메모 삭제 성공");
		
		// 7. 닫기
		DBUtil.close(con, pstmt);
	// end of delete()
		
	}
}
