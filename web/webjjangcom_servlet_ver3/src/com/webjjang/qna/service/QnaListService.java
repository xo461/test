package com.webjjang.qna.service;

import java.util.List;

import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;
import com.webjjang.util.page.PageObject;

public class QnaListService implements Service {
	
	private QnaDAO dao;
	
	public QnaListService(QnaDAO dao) {
		this.dao = dao;
	}

	public List<QnaDTO> service(Object[] objs)throws Exception {
		// 데이터 처리 부분에 해당 된다. 
		PageObject pageObject = (PageObject) objs[0];
		
		System.out.println("QnaListService.list()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// BoardContrlloer - BoardListService - [BoardDAO]
		// 전체 데이터의 갯수를 구해서 pageObject에 넣는다. -> 전체 페이지가 자동으로 구해진다. 
		pageObject.setTotalRow(dao.getTotalRow());
		System.out.println("BoardListService.service().pageObject:"+pageObject);
		return dao.list(pageObject);
		// ↘ 
	}
	
}
