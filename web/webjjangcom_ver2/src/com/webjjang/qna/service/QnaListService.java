package com.webjjang.qna.service;

import java.util.List;

import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaListService implements Service {
	
	private QnaDAO dao;
	
	public QnaListService(QnaDAO dao) {
		this.dao = dao;
	}

	public List<QnaDTO> service(Object[] objs)throws Exception {
		// 데이터 처리 부분에 해당 된다. 
		
		System.out.println("QnaListService.list()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// BoardContrlloer - BoardListService - [BoardDAO]
		return dao.list();
		// ↘ 
	}
	
}
