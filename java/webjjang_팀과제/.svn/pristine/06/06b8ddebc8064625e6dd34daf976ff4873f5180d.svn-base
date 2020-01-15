package com.webjjang.notice.service;

import com.webjjang.notice.dao.NoticeDAO;

public class NoticeDeleteService {

	// 데이터 Controller <-> service - DAO
	// 입력받은 글번호(NoticeDTO)를 Controller 에서 받아서 처리한다.
	public void service(int no) throws Exception{
		// 데이터 처리부분에 해당된다.
		System.out.println("NoticeDeleteService.service()");
		
		// 공지사항 글삭제에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
		try {
			// 데이터Controller에서 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
			// NoticeController - NoticeWriteService - [NoticeDAO]
			NoticeDAO dao = new NoticeDAO();
			dao.delete(no);
		} catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예의메시지를 셋팅해서 다시 던지기를 할 수 있다.(사용자용)
			//개발자를 위한 오류 출력
			e.printStackTrace();
			throw new Exception("공지사항 삭제 중 오류가 발생되었습니다.");
		}
	}
	
}
