package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;
import com.webjjang.main.Service;

public class BoardViewService implements Service{

	private BoardDAO dao;
	// 사용해야할 dao 객체를 초기화 -> 밖에 생성할 때 넣어준다. 
	public BoardViewService(BoardDAO dao) {
		this.dao = dao;
	}

	// 데이터 Controller <-> DAO
	// 글번호를 Controller 에서 받아서 처리한다.
		// TODO Auto-generated constructor stub
		// 데이터 처리부분에 해당된다.
	public BoardDTO service(Object[] objs) throws Exception {
		
		int no = (int)objs[0];
		System.out.println("BoardViewService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// BoardController - BoardViewService - [BoardDAO]
		return dao.view(no);
	}
	
}
