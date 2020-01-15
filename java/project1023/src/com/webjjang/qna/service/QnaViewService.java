package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaViewService {

	// 데이터 Controller <->DAO
	// 글번호를 Controller 에서 받아서 처리한다.
	public QnaDTO service(int no,int inc)throws Exception {
		// 데이터 처리 부분에 해당 된다. 
		
		System.out.println("QnaViewService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// QnaContrlloer - QnaListService - [QnaDAO]
		QnaDAO dao = new QnaDAO();
		// inc값이 1인 경우 조회수 1증가 시키는 처리 
		if (inc == 1)
			dao.increaseHit(no);
		return dao.view(no);
	}
	
}
