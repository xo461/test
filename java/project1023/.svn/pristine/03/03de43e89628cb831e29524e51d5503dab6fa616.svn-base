package com.webjjang.message.service;

import com.webjjang.message.dao.MessageDAO;

public class MessageDeleteService {

	// 데이터 Controller <-> Service <-> DAO
	// 입력받은 쪽지 번호를 Controller에서 받아서 DB에서 삭제처리한다.
	public void service(int no) throws Exception {

		// 데이터 처리부분에 해당된다.
		System.out.println("MessageDeleteService.service()");

		// 게시판 글삭제에서 오류가 나고 있다는 처리를 할 때 예외처리를 해준다. -> 알맞은 메시지로 바꿔서 던진다.
		try {

			// 데이터를 컨트롤러에서 오라클에 저장하기 위해 객체 생성하고 호출
			// MessageController - MessageWriteService - [MessageDAO]
			MessageDAO dao = new MessageDAO();
			dao.delete(no);
		} catch (Exception e) {
			// 개발자를 위한 오류 출력
			e.printStackTrace();
			// 상세한 내용의 예외 메시지를 세팅해서 다시 던지기를 할 수 있다.
			throw new Exception("게시판 글삭제 중 오류가 발생되었습니다.");
		}
	}
}
