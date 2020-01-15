package com.webjjang.qna.service.Service;


import com.webjjang.qna.dao.QnaDAO.QnaDAO;
import com.webjjang.qna.dto.QnaDTO.QnaDTO;

public class QnaUpdateService {

	public void service(QnaDTO dto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaUpdateService.service()");
		
		try {
			QnaDAO dao = new QnaDAO();
			dao.update(dto);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("!!!!!질문 답변 글수정 하기 중 오류 발생 !!!!!!");
		}
				
	}

}
