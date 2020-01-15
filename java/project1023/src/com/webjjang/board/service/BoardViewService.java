package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardViewService {

	// 데이터 Controller <-> DAO
	// 글 번호를 Controller에서 받아서 처리한다.
	public BoardDTO service(int no) throws Exception {

		System.out.println("BoardViewService.service()");
		// 데이터 처리부분에 해당된다.
		// 데이터를 오라클에서 가져오기 위해 객체 생성하고 호출
		BoardDAO dao = new BoardDAO();
		return dao.view(no);
		// BoardController - BoardListService - [BoardDAO]
	}
}