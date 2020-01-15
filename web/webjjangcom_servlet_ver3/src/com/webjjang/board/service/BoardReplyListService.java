package com.webjjang.board.service;

import java.util.List;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardReplyDTO;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;

public class BoardReplyListService implements Service{

	private BoardDAO dao;
	public BoardReplyListService(BoardDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
@Override
	public List<BoardReplyDTO> service(Object[] objs) throws Exception{
		// 데이터 변환
		int no = (Integer) objs[0];
	// 데이터 처리부분에 해당된다.
		System.out.println("BoardReplyListService.service() : " + objs[0]);
		
		// 데이터를 오라클에서 가져오기 위해서 생성된 객체를 호출한다.
		// BoardController - BoardListService - [BoardDAO]
		// 전체 데이터의 갯ㅅ수를 구해서 pageObject에 넣는다.-> 전체 페이지가 자동으로 구해진다.
//		pageObject.setTotalRow(dao.getTotalRow(pageObject));
//		System.out.println("BoardReplyListService().pageObject :" +pageObject);
		return dao.replyList(no);
	}
	
}
