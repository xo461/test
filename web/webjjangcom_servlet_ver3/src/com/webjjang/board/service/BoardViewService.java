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

	@Override
	// 데이터 Controller <-> DAO
	// 글번호를 Controller 에서 받아서 처리한다.
		// TODO Auto-generated constructor stub
		// 데이터 처리부분에 해당된다.
	public BoardDTO service(Object[] objs) throws Exception {
	
		// 데이터 변환
		int no = (int)objs[0];
		int cnt = (int)objs[1];
		// 데이터 처리부분 
		System.out.println("BoardViewService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서  Beans에서 생성한 객체 호출한다.
		// BoardController - BoardViewService - [BoardDAO]
		if(cnt == 1) 
			dao.increaseHit(no);// 1증가 시키는 처리문.
		
		return dao.view(no);
	}
	
}
