package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaUpdateService {

	public void service(QnaDTO dto) throws Exception{
		System.out.println("QnaUpdateService.service()");
		
		try {
			QnaDAO dao = new QnaDAO();
			dao.update(dto);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 글수정 중 오류 발생 되었습니다.");
		}
	}
	
}
