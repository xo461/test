package com.webjjang.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice.dto.NoticeDTO;
import com.webjjang.util.db.DBUtil;

public class NoticeDAO {

	// 1. 공지사항 리스트 데이터 가져오기
	// service.NoticeListService -> dao.NoticeDAO
	// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	public List<NoticeDTO> list() throws Exception {

		System.out.println("NoticeDAO.list()");

		List<NoticeDTO> list = null;
		// ��ü���� ����� DB ���� -> list(), view()... �ٸ� �޼��忡�� �� �ʿ�� �ϱ� ������
		// ���������� �����Ѵ�.

//		Class.forName(driver);
		Connection con = DBUtil.getConnection();

		String sql = " select no, title, content, " + " to_char(startDate, 'yyyy-mm-dd') startDate, "
				+ " to_char(endDate,'yyyy-mm-dd') endDate, " + " to_char(writeDate,'yyyy-mm-dd') writeDate, "
				+ " to_char(updateDate, 'yyyy-mm-dd') updateDate, " + " hit " + " from notice order by no desc ";

		System.out.println("NoticeDAO.list().sql : " + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		if (rs != null) {
			while (rs.next()) {
				// ���������� ������ list�� null�� ��쿡�� �����ؼ� ��밡���ϵ��� ���ش�.
				if (list == null)
					list = new ArrayList<NoticeDTO>();

				// �Խ��� �ϳ��� �����͸� ��� ��ü ����
				NoticeDTO dto = new NoticeDTO();
				// �����ʹ��
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setUpdateDate(rs.getString("updateDate"));
				dto.setHit(rs.getInt("hit"));

				list.add(dto);

			} // end of while
		} // end of if

		DBUtil.close(con, pstmt, rs);

		System.out.println("NoticeDAO.list().list :" + list);
		return list;
		// end of list

	}

	// 2. 공지사항 게시판 글보기 데이터 가져오기 - 한개 데이터 -
	// 글번호에 따라서 결정(전달 받는다.)
	// 글보기를 하면 조회수 1 증
	// service.NoticeViewService -> dao.NoticeDAO
	// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// NoticeController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// NoticeController -> Service -> DAO
	public NoticeDTO view(int no) throws Exception {

		System.out.println("NoticeDAO.view().no : " + no);

		NoticeDTO dto = null;
		// ��ü���� ����� DB ���� -> list(), view()... �ٸ� �޼��忡�� �� �ʿ�� �ϱ� ������
		// ���������� �����Ѵ�.

//������ �������� ó����
		// ?�� ���� ��ü��Ű�� ��ü���ڿ� �ش��
		Connection con = DBUtil.getConnection();

		String sql = " select no, title, content, " + " to_char(startDate, 'yyyy-mm-dd') startDate, "
				+ " to_char(endDate,'yyyy-mm-dd') endDate, " + " to_char(writeDate,'yyyy-mm-dd') writeDate, "
				+ " to_char(updateDate, 'yyyy-mm-dd') updateDate, " + " hit " + " from notice where no = ? ";
		System.out.println("NoticeDAO.list().sql : " + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);

//?�� ��ġ, ?�� ��ü�ؾ� �� ��
		pstmt.setInt(1, no);

		ResultSet rs = pstmt.executeQuery();

		if (rs != null && rs.next()) {
			// ���������� ������ list�� null�� ��쿡�� �����ؼ� ��밡���ϵ��� ���ش�.

			// �Խ��� �ϳ��� �����͸� ��� ��ü ����
			dto = new NoticeDTO();
			// �����ʹ��
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("Content"));
			dto.setStartDate(rs.getString("StartDate"));
			dto.setEndDate(rs.getString("EndDate"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setUpdateDate(rs.getString("UpdateDate"));
			dto.setHit(rs.getInt("hit"));

		} // end of while

		DBUtil.close(con, pstmt, rs);

		System.out.println("NoticeDAO.list().dto :" + dto);

		return dto;
	} // end of view()

	
	
	
	
	
	// 2-1. NoticeController.main() 2. 글보기를 한 경우 조회수를 1 증가시킨다.
	// service.NoticeViewService -> dao.NoticeDAO
	// 답변데이터를 넣기 전에 실행해야 한다!!!
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// NoticeController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// NoticeController -> Service -> DAO
	public void increaseHit(int no) throws Exception {

		// 확인해야 할 데이터 - 관련글번호, 순서번호
		System.out.println("NoticeDAO.update().no:" + no);

		// 데이터 저장 처리문
		// 1. 드라이버 확인
//			Class.forName(driver);
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();

		// 아래와같은방법으로 사용 가능
		// con.setAutoCommit(false); //기본은 true임
//		con.commit();
//		con.rollback();
//		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " update notice set hit = hit +1 " + " where no = ? ";
		System.out.println("NoticeDAO.update().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no);

		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		if (result > 0)
			System.out.println("조회수 1 증가 성공");
		// 순서번호가 3번까지만 있다. 4번을 답변하고자 한다. -> 같거나 큰 데이터가 없으므로 수정되지 않음.
		// 조회수는 반드시 1증가해야함
		else {
			System.out.println("조회수 1 증가 실패");
			throw new Exception("조회수 1 증가 처리 중 오류");
		}
		// 7. 닫기
//			con.close();
//			pstmt.close();
		DBUtil.close(con, pstmt);
	} // end of increaseHit()

	
	
	
	
	
	// 3. 공지사항 게시판 글쓰기 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
	// service.NoticeWriteService -> dao.NoticeDAO
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// NoticeController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// NoticeController -> Service -> DAO
	public void write(NoticeDTO dto) throws Exception {

		System.out.println("NoticeDAO.write().dto : " + dto);

//������ �������� ó����
		// ?�� ���� ��ü��Ű�� ��ü���ڿ� �ش��
		Connection con = DBUtil.getConnection();

		String sql = " insert into notice(no, title, content, startDate, endDate) " 
		+ " values(notice_seq.nextval, ?, ?, ?, ? ) ";
		System.out.println("NoticeDAO.write().sql : " + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);

//?�� ��ġ, ?�� ��ü�ؾ� �� ��
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getStartDate());
		pstmt.setString(4, dto.getEndDate());

//5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		pstmt.executeUpdate();

		// 6. 표시 / 저장
		System.out.println("공지사항이 등록되었습니다.");

		// 7. 닫기
		DBUtil.close(con, pstmt);

	}// end of write()

	
	
	
	
	
	
	
	// 5. 공지사항 글수정 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
	// service.NoticeWriteService -> dao.NoticeDAO
	// 여기기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// NoticeController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// NoticeController -> Service -> DAO
	public void update(NoticeDTO dto) throws Exception {

		// 확인해야 할 데이터 - 번호, 제목, 내용
		System.out.println("NoticeDAO.update().dto:" + dto);

		// 데이터 저장 처리문
		// 1. 드라이버 확인
//				Class.forName(driver);
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " update notice set title = ?, " + " content = ?, startDate = ?, endDate = ? " + " where no = ? ";
		System.out.println("NoticeDAO.update().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getStartDate());
		pstmt.setString(4, dto.getEndDate());
		pstmt.setInt(5, dto.getNo());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		if (result > 0)
			System.out.println("*** 공지사항이 성공적으로 수정되었습니다.");
		else
			System.out.println("공지사항 수정이 되지 않았습니다. - 글번호를 확인하세요");

		// 7. 닫기
		DBUtil.close(con, pstmt);
	} // end of update()

	// 6. 글삭제 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
	// service.NoticeWriteService -> dao.NoticeDAO
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// NoticeController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// NoticeController -> Service -> DAO
	public void delete(int no) throws Exception {

		// 확인해야 할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("NoticeDAO.delete().no:" + no);

		// 데이터 저장 처리문
		// 1. 드라이버 확인
//				Class.forName(driver);
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " delete from notice where no = ? ";
		System.out.println("NoticeDAO.delete().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no);

		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();

		// 6. 표시 / 저장
		if (result > 0)
			System.out.println("공지사항이 삭제되었습니다.");
		else
			System.out.println("공지사항 삭제가 되지 않았습니다. - 글번호를 확인해주세요.");

//				// 7. 닫기
//				con.close();
//				pstmt.close();
		DBUtil.close(con, pstmt);
	} // end of delete()

}
