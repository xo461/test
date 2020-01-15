package com.webjjang.board.service;

import java.util.List;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;
import com.webjjang.main.Service;

public class BoardListService implements Service {

	 private BoardDAO dao;
	
	 //Beans를 통새서 생성 (DI적용 - dao를 넣어준다.)한 후 저장하고 잇따. 
	 public BoardListService(BoardDAO dao) {
		// TODO Auto-generated constructor stub
		 this.dao = dao;
	 }
	
	@Override
	public List<BoardDTO> service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		// 데이터 변환  - list는 넘어 오는 데이터가 없으므로 objs를 버린다.  
		
		return dao.list();
	}

}
