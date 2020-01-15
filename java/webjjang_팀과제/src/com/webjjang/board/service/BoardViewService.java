package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardViewService {

	public BoardDTO service(int no, boolean inc) throws Exception {
		System.out.println("BoardViewService.service()");
		
		BoardDAO dao = new BoardDAO();
		return dao.view(no, inc);
	}
}
