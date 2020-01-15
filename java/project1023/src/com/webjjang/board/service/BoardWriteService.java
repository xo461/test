package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardWriteService {

	// 데이터 Controller <-> DAO
	// 입력받은 글 정보(BoardDTO)를 Controller에서 받아서 처리한다.
	public void service(BoardDTO dto) throws Exception {

		// 데이터 처리부분에 해당된다.
		System.out.println("BoardWriteService.service()");

		// 게시판 글쓰기에서 오류가 나고 있다는 처리를 할 때 예외처리를 해준다. -> 알맞은 메시지로 바꿔서 던진다.
		try {

			// 데이터를 컨트롤러에서 오라클에 저장하기 위해 객체 생성하고 호출
			// BoardController - BoardWriteService - [BoardDAO]
			BoardDAO dao = new BoardDAO();
			dao.write(dto);
			
		} catch (Exception e) {
			// 상세한 내용의 예외 메시지를 세팅해서 다시 던지기를 할 수 있다.
			throw new Exception("게시판 글쓰기 중 오류가 발생되었습니다.");
		}
	}
}
