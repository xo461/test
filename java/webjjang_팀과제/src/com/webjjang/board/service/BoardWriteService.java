package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;

public class BoardWriteService {

	public void service(BoardDTO dto) throws Exception {
		BoardDAO dao = new BoardDAO();
		dao.write(dto);
	}
}
