package com.webjjang.qna.service.Service;


import com.webjjang.qna.dao.QnaDAO.QnaDAO;
import com.webjjang.qna.dto.QnaDTO.QnaDTO;

public class QnaWriteService {

	public void service(QnaDTO dto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaWriteService.service()");
		
		try {
			QnaDAO dao = new QnaDAO();
			dao.write(dto);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("!!!!!질문 답변 질문하기 중 오류 발생 !!!!!!");
		}
				
	}

}
