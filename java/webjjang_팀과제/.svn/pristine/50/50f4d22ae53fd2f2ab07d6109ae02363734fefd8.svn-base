package com.webjjang.qna.service.Service;


import com.webjjang.qna.dao.QnaDAO.QnaDAO;
import com.webjjang.qna.dto.QnaDTO.QnaDTO;

public class QnaDeleteService {

	public void service(int no) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaDeleteService.service()");
		
		try {
			QnaDAO dao = new QnaDAO();
			dao.delete(no);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("!!!!!질문 답변 삭제하기 중 오류 발생 !!!!!!");
		}
				
	}

}
