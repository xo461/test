package com.webjjang.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.util.db.DBUtil;

public class BoardDAO {

	// 객체에서 사용할 DB 정보 -> list(), view()... 다른 메서드에서 다 필요로 하기 때문에 전역 변수로 선언.

	// service.BoardService -> dao.BoardDAO
	// 1. 게시판리스트 데이터 가져오기
	// 데이터 가져오기가 실패하면 출력하러갈 수가 없다. 그런 경우 예외처리를 반드시 해야 함
	// 여기서는 예외처리 하지 않고 throw 시킴
	public List<BoardDTO> list() throws Exception {

		System.out.println("BoardDAO.list()");

		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴 타입과 같아야 함
		List<BoardDTO> list = null;

		// 데이터 가져오는 처리문
		// 1. 드라이버 확인
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		String sql = " SELECT no, title, writer, TO_CHAR(writeDate, 'yy-mm-dd') writeDate, hit FROM board ORDER BY no DESC ";
		System.out.println("BoardDAO.list().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		if (rs != null) {
			while (rs.next()) { // rs.next() -> 다음 데이터로 넘어가면서 데이터가 있으면 true, 없으면 false를 리턴
				// 최종적으로 저장할 list가 null 이면 생성해서 사용가능하도록 해준다.
				// ArrayList는 list의 일종으로 배열을 사용한다. (연속된 주소)
				if (list == null)
					list = new ArrayList<BoardDTO>();
				// 게시판 하나의 데이터를 담는 객체 생성 -> BoardDTO
				BoardDTO dto = new BoardDTO();
				// 데이터를 dto에 담는다. rs에서 꺼내어 dto 에 담는다.
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setHit(rs.getInt("hit"));
				// 리스트 데이터가 여러개이므로 데이터를 담은 dto를 list 에 추가시킨다.
				list.add(dto);
			} // end of while

		} // end of if
			// 7. 닫기
		DBUtil.close(con, pstmt, rs);

		System.out.println("BoardDAO.list().list : " + list);
		return list;
		// end of list()
	}

	// service.BoardService -> dao.BoardDAO
	// 2. 게시판 글보기 데이터 가져오기 -> 한 개의 데이터 -> 글 번호에 따라서 결정 (전달 받는다.)
	// 데이터 가져오기가 실패하면 출력하러갈 수가 없다. 그런 경우 예외처리를 반드시 해야 함
	// 여기서는 예외처리 하지 않고 throw 시킴
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public BoardDTO view(int no) throws Exception {

		System.out.println("BoardDAO.view().no : " + no);

		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴 타입과 같아야 함
		BoardDTO dto = null;

		// 데이터 가져오는 처리문
		// 1. 드라이버 확인
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당함.
		String sql = " SELECT no, title, content, writer, TO_CHAR(writeDate, 'yy-mm-dd') writeDate, hit FROM board WHERE no = ? ";
		System.out.println("BoardDAO.list().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, 대체할 값)
		pstmt.setInt(1, no);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		if (rs != null && rs.next()) { // rs.next() -> 다음 데이터로 넘어가면서 데이터가 있으면 true, 없으면 false를 리턴
			// 게시판 하나의 데이터를 담는 객체 생성 -> BoardDTO
			dto = new BoardDTO();
			// 데이터를 dto에 담는다. rs에서 꺼내어 dto 에 담는다.
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setWriter(rs.getString("writer"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setHit(rs.getInt("hit"));
			// 리스트 데이터가 여러개이므로 데이터를 담은 dto를 list 에 추가시킨다.

		} // end of if(rs != null && rs.next())
			// 7. 닫기
		DBUtil.close(con, pstmt, rs);

		System.out.println("BoardDAO.list().dto: " + dto);
		return dto;
		// end of view()
	}

	// service.BoardWriteService -> dao.BoardDAO
	// 3. 게시판 글쓰기 데이터 가져오기 -> 한 개의 전달받아 DB에 저장
	// 여기서는 예외처리 하지 않고 throw 시킴
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public void write(BoardDTO dto) throws Exception {

		System.out.println("BoardDAO.write().dto : " + dto);

		// 데이터 저장하는 처리문
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당함.
		String sql = " INSERT INTO board(no, title, content, writer) VALUES (board_seq.nextval, ?, ?, ?) ";
		System.out.println("BoardDAO.write().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, 대체할 값)
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());
		// 5. 실행
		// SLECET -> executeQuery()
		// INSERT, UPDATE, DELETE -> excuteUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글 쓰기 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
	}
	// end of write()

	// service.BoardUpdateService -> dao.BoardDAO
	// 4. 게시판 글수정 데이터 가져오기 -> 한 개의 전달받아 DB에 저장
	// 여기서는 예외처리 하지 않고 throw 시킴
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public void update(BoardDTO dto) throws Exception {

		// 확인해야할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.update().dto : " + dto);

		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당함.
		String sql = " UPDATE board SET title = ?, content = ?, writer = ?  WHERE no=  ?";
		System.out.println("BoardDAO.update().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, 대체할 값)
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());
		pstmt.setInt(4, dto.getNo());
		// 5. 실행
		// SLECET -> executeQuery()
		// INSERT, UPDATE, DELETE -> excuteUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글 수정 성공");
		// 7. 닫기
		DBUtil.close(con, pstmt);
	}
	
	// service.BoardDeleteService -> dao.BoardDAO
	// 5. 게시판 글삭제 번호 가져오기 -> 글번호를 전달받아 DB에 저장
	// 여기서는 예외처리 하지 않고 throw 시킴
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public void delete(int no) throws Exception {
		
		// 확인해야할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.delete().no : " + no);
		
		// 데이터 저장하는 처리문
		// 1. 드라이버 확인
		// 2. 연결객체
		Connection con = DBUtil.getConnection();
		// 3. 실행할 쿼리문 작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당함.
		String sql = " DELETE FROM board WHERE no = ? ";
		System.out.println("BoardDAO.delete().sql : " + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, 대체할 값)
		pstmt.setInt(1, no);
		// 5. 실행
		// SLECET -> executeQuery()
		// INSERT, UPDATE, DELETE -> excuteUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글 삭제 성공");
		
		// 7. 닫기
		DBUtil.close(con, pstmt);
	}
	// end of delete()

} // end of BoardDAO class
