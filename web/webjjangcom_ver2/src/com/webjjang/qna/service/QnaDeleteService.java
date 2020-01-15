package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;

public class QnaDeleteService {

	public void service(int no) throws Exception{
		System.out.println("QnaDeleteService.service()");
		
		try {
			QnaDAO dao = new QnaDAO();
			dao.delete(no);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 글삭제 중 오류 발생 되었습니다.");
		}
	}
	
}
