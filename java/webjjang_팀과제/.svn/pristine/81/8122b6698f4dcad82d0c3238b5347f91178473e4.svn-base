package com.webjjang.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.util.db.DBUtil;

public class BoardDAO {

	public List<BoardDTO> list() throws Exception {
		System.out.println("BoardDAO.list()");

		List<BoardDTO> list = null;
		Connection con = DBUtil.getConnection();
		String sql = " SELECT no, title, writer, TO_CHAR(writeDate, 'yy-mm-dd') writeDate, hit FROM board ORDER BY no DESC ";

		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		if (rs != null) {

			while (rs.next()) {
				if (list == null) {
					list = new ArrayList<BoardDTO>();
				} // end of (list == null)
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setHit(rs.getInt("hit"));

				list.add(dto);
			} // end of while
		} // end of if(list != null)
		DBUtil.close(con, pstmt, rs);

		return list;
	} // end of List<BoardDTO> list()

	public BoardDTO view(int no, boolean inc) throws Exception {
		// TODO Auto-generated method stub

		BoardDTO dto = null;
		Connection con = DBUtil.getConnection();
		if(inc == true)
			increaseHit(no);
		String sql = " SELECT no, title, content, writer, TO_CHAR(writeDate, 'yy-mm-dd') writeDate, hit FROM board WHERE no = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);

		ResultSet rs = pstmt.executeQuery();
		System.out.println(rs);
		if (rs != null && rs.next()) {
			dto = new BoardDTO();
			
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setWriter(rs.getString("writer"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setHit(rs.getInt("hit"));
		} // end of if
		if(dto == null) {
			throw new Exception("글 읽기 처리 중 에러가 발생했습니다. 글 번호를 확인해주세요.");
		}
		System.out.println("BoardDAO.view.dto" + dto);
		DBUtil.close(con, pstmt, rs);
		return dto;
	} // end of BoardDAO.view()

	private void increaseHit(int no) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = " UPDATE board SET hit = hit + 1 WHERE no = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
		System.out.println("조회수 증가 작업 완료");
		
	} // end of increaseHit

	public void write(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDAO.write().dto" + dto);

		Connection con = DBUtil.getConnection();
		String sql = " INSERT INTO board (no, title, content, writer) VALUES (board_seq.NEXTVAL, ?, ?, ?) ";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());

		pstmt.executeUpdate();
		System.out.println("글 쓰기 작업이 완료되었습니다.");

		DBUtil.close(con, pstmt);

	}

	public void update(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDAO.update().dto" + dto);

		Connection con = DBUtil.getConnection();
		String sql = " UPDATE board SET title = ?, content = ?, writer = ? WHERE no = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());
		pstmt.setInt(4, dto.getNo());

		pstmt.executeUpdate();
		
		System.out.println("글 수정 작업이 완료되었습니다.");

		DBUtil.close(con, pstmt);
	}

	public void delete(int no) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDAO.delete().dto" + no);

		Connection con = DBUtil.getConnection();
		String sql = " DELETE FROM board WHERE no = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println(sql);
		pstmt.setInt(1, no);

		if(pstmt.executeUpdate() == 0)
			throw new Exception("글 삭제 도중 오류가 발생했습니다.");
		System.out.println("글 삭제 작업이 완료되었습니다.");

		DBUtil.close(con, pstmt);
	}
} // end of BoardDAO class
