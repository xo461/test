package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardDeleteService {

	// 데이터 Controller <->service <-> DAO
	// 입력 받은 글번호를 Controller 에서 받아서 삭제처리한다.
	public void service(int no)throws Exception {
		// 데이터 처리 부분에 해당 된다. 
		
		System.out.println("BoardDeleteService.service()");
		
		// 게시판 글삭제에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다. 
		// - 예외가 발생이 되면 알맞은 메시지로 바꿔서 던진다.  
		try {
		// 데이터 controller를 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
		// BoardController - BoardListService - [BoardDAO]
		BoardDAO dao = new BoardDAO();
		dao.delete(no);
		}catch (Exception e) {
			// TODO: handle exception
			// 개발자를 위한 오류 출력 ↓
			e.printStackTrace();
			// 상세한 내용의 예의 메시지를 셋팅해서 다시 던지기를 할 수 있다. 
			throw new Exception("게시판 글수정 중 오류가 발생되었습니다.");
		}
		
	}
	
}
