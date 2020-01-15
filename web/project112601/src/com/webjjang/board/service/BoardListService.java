package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.main.Service;

public class BoardListService implements Service {

	private BoardDAO dao;
	
	public BoardListService(BoardDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardListService");
		return dao.list();
	}

}
