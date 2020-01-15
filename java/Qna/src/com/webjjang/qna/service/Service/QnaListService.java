package com.webjjang.qna.service.Service;

import java.util.List;

import com.webjjang.qna.dao.QnaDAO.QnaDAO;
import com.webjjang.qna.dto.QnaDTO.QnaDTO;

public class QnaListService {

	public List<QnaDTO> service()throws Exception{
		System.out.println("QnaListService.list()");
		
		QnaDAO dao = new QnaDAO();	
		return dao.list();
	}
	
}
