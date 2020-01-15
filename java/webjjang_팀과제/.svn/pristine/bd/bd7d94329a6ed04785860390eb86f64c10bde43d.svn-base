package com.webjjang.qna.service.Service;


import com.webjjang.qna.dao.QnaDAO.QnaDAO;
import com.webjjang.qna.dto.QnaDTO.QnaDTO;

public class QnaViewService {

	public QnaDTO service(int no, int inc) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaViewService.service()");
		
		QnaDAO dao = new QnaDAO();
	
		// 조회수 증가
		if(inc == 1)
			dao.increaseHit(no);
		
		return dao.view(no);
	}

}
