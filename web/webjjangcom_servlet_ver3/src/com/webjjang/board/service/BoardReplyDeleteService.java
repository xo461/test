package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;
import com.webjjang.main.Service;

public class BoardReplyDeleteService implements Service {
	
	private BoardDAO dao; 
	
	public BoardReplyDeleteService(BoardDAO dao) {
		this.dao = dao; 
	}

	// 데이터 Controller <->service <-> DAO
	// 입력 받은 글번호를 Controller 에서 받아서 삭제처리한다.
	@Override
	public Integer service(Object[] objs)throws Exception {
		// 데이터 변환
		// 데이터 처리 부분에 해당 된다. 
		int rno = (int)objs[0];
		System.out.println("BoardReplyDeleteService.service()");
			
		return dao.replyDelete(rno);
			
	}
	
}
