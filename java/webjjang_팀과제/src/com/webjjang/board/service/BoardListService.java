package com.webjjang.board.service;

import java.util.List;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardListService {

	public List<BoardDTO> service () throws Exception {
		System.out.println("BoardListService.List.service()");
		BoardDAO dao = new BoardDAO();
		return dao.list();
	}
	
}
