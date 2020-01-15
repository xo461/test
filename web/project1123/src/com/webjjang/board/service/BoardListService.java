package com.webjjang.board.service;

import java.util.List;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;
import com.webjjang.main.Service;

public class BoardListService implements Service {

	private BoardDAO dao;
	
	public BoardListService(BoardDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<BoardDTO> service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.list();
	}

}
