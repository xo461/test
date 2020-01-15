package com.webjjang.board.service;

import java.util.List;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;
import com.webjjang.main.Service;

public class BoardListService implements Service{
	
	private BoardDAO dao;
	
	public BoardListService(BoardDAO dao) {
		this.dao = dao;
	}

	public List<BoardDTO> service(Object[] objs) throws Exception{
		// 데이터 처리부분에 해당된다.
		
		System.out.println("BoardListService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// BoardController - BoardListService - [BoardDAO]
		return dao.list();
	}
	
}
