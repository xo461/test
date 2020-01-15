package com.webjjang.message.service;

import com.webjjang.message.dao.MessageDAO;
import com.webjjang.message.dto.MessageDTO;

public class MessageUpdateService {

	public void service(MessageDTO dto) throws Exception {
		// TODO Auto-generated method stub
		MessageDAO messageDAO = new MessageDAO();
		messageDAO.update(dto);
		
	}

}
