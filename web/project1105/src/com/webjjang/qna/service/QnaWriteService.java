/*
 * 질문하기 처리 
 * - 답변하기 처리 : QnaAnswerService
 */


package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaWriteService {

	public void service(QnaDTO dto) throws Exception{
		System.out.println("QnaWriteService.service()");
		
		try {
			QnaDAO dao = new QnaDAO();
			dao.write(dto);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 글쓰기 중 오류 발생 되었습니다.");
		}
	}
	
}