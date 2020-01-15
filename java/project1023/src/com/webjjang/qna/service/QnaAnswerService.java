package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaAnswerService {

	public void service(QnaDTO dto) throws Exception{
		System.out.println("QnaAnswerService.service()");
		
		try {
			QnaDAO dao = new QnaDAO();
			// 관련글 번호 가 같으면서 순서번호가 들어온 순서번호 보다 크거나 같으면 +1해줘야한다. 
			dao.increaseOrdNo(dto);
			// 답변데이터 처리 
			dao.answer(dto);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 답변 중 오류 발생 되었습니다.");
		}
	}
	
}
