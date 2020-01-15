package com.webjjang.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.main.Main;
import com.webjjang.message.dto.MessageDTO;
import com.webjjang.util.db.DBUtil;

public class MessageDAO {

	public List<MessageDTO> list(int no) throws Exception {
		System.out.println("MessageDAO.list()");

		List<MessageDTO> list = null;
		String sql = "";
		Connection con = DBUtil.getConnection();
		if (no == 1) // 1은 수신함
			sql = " SELECT no, content, sender, TO_CHAR(sendDate, 'yy-mm-dd') sendDate, accepter, "
					+ " TO_CHAR(acceptDate, 'yy-mm-dd') acceptDate FROM message WHERE accepter = ? ORDER BY no DESC ";
		else if (no == 2) // 2은 발신함
			sql = " SELECT no, content, sender, TO_CHAR(sendDate, 'yy-mm-dd') sendDate, accepter, "
					+ " TO_CHAR(acceptDate, 'yy-mm-dd') acceptDate FROM message WHERE sender = ? ORDER BY no DESC ";
		else if (no == 3) // 3은 전체
			sql = " SELECT no, content, sender, TO_CHAR(sendDate, 'yy-mm-dd') sendDate, accepter, "
					+ " TO_CHAR(acceptDate, 'yy-mm-dd') acceptDate FROM message WHERE sender = ? OR accepter = ? ORDER BY no DESC ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, Main.login.getId());
		if (no == 3)
			pstmt.setString(2, Main.login.getId());
		ResultSet rs = pstmt.executeQuery();

		if (rs != null) {

			while (rs.next()) {
				if (list == null) {
					list = new ArrayList<MessageDTO>();
				} // end of (list == null)
				MessageDTO dto = new MessageDTO();
				dto.setNo(rs.getInt("no"));
				dto.setContent(rs.getString("content"));
				dto.setSender(rs.getString("sender"));
				dto.setSendDate(rs.getString("sendDate"));
				dto.setAccepter(rs.getString("accepter"));
				dto.setAcceptDate(rs.getString("acceptDate"));

				list.add(dto);
			} // end of while
		} // end of if(list != null)
		DBUtil.close(con, pstmt, rs);

		return list;
	} // end of List<MessageDTO> list()

	public MessageDTO view(int no, boolean accepted) throws Exception {
		// TODO Auto-generated method stub

		MessageDTO dto = null;

		Connection con = DBUtil.getConnection();
		String sql = " SELECT no, content, sender, TO_CHAR(sendDate, 'yy-mm-dd') sendDate, accepter, "
				+ " TO_CHAR(acceptDate, 'yy-mm-dd') acceptDate FROM message WHERE no = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);

		ResultSet rs = pstmt.executeQuery();
		if (rs != null && rs.next()) {
			dto = new MessageDTO();

			dto.setNo(rs.getInt("no"));
			dto.setContent(rs.getString("content"));
			dto.setSender(rs.getString("sender"));
			dto.setSendDate(rs.getString("sendDate"));
			dto.setAccepter(rs.getString("accepter"));
			dto.setAcceptDate(rs.getString("acceptDate"));
		} // end of if

		if(dto == null) {
			throw new Exception("쪽지 보기 처리 중 에러가 발생했습니다. 쪽지 번호를 확인해주세요.");
		}
		if (accepted == false && dto.getAcceptDate() == null) {
				if(dto.getAccepter().equals(Main.login.getId()))
					updateAcceptDate(no);
		}
		System.out.println("MessageDAO.view.dto" + dto);
		DBUtil.close(con, pstmt, rs);
		return dto;
	} // end of MessageDAO.view()

	private void updateAcceptDate(int no) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = " UPDATE message SET acceptDate = SYSDATE WHERE no = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeQuery();

	}

	public void send(MessageDTO dto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageDAO.send().dto" + dto);

		Connection con = DBUtil.getConnection();
		String sql = " INSERT INTO message (no, content, sender, accepter) VALUES (message_seq.NEXTVAL, ?, ?, ?) ";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, dto.getContent());
		pstmt.setString(2, Main.login.getId());
		pstmt.setString(3, dto.getAccepter());

		pstmt.executeUpdate();
		System.out.println("쪽지 보내기가 완료되었습니다.");

		DBUtil.close(con, pstmt);

	}

	public void update(MessageDTO dto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageDAO.update().dto" + dto);

		Connection con = DBUtil.getConnection();
		String sql = " UPDATE message SET content = ? WHERE no = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println(sql);
		pstmt.setString(1, dto.getContent());
		pstmt.setInt(2, dto.getNo());

		pstmt.executeUpdate();
		System.out.println("메세지 수정 작업이 완료되었습니다.");

		DBUtil.close(con, pstmt);
	}

//
	public void delete(int no) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageDAO.delete().dto" + no);

		Connection con = DBUtil.getConnection();
		String sql = " DELETE FROM message WHERE no = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println(sql);
		pstmt.setInt(1, no);

		if(pstmt.executeUpdate()==0)
			throw new Exception("메세지 삭제 작업 중 오류가 발생했습니다. 메세지 번호를 확인하세요.");
		System.out.println("메시지 삭제 작업이 완료되었습니다.");

		DBUtil.close(con, pstmt);
	}
} // end of MessageDAO class
