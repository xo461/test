package com.webjjang.qna.service;

import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaUpdateService implements Service {

	private QnaDAO dao;
	
	public QnaUpdateService(QnaDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Integer service(Object[] objs) throws Exception{
		// 데이터 변환
		QnaDTO dto = (QnaDTO) objs[0];
		System.out.println("QnaUpdateService.service()");
		
		try {
			return dao.update(dto);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
//			throw new Exception("질문답변 글수정 중 오류 발생 되었습니다.");
			throw e;
		}
	}
	
}
