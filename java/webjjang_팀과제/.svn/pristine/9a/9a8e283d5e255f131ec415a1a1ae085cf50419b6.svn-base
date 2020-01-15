package com.webjjang.message.service;

import com.webjjang.message.dao.MessageDAO;
import com.webjjang.message.dto.MessageDTO;

public class MessageSendService {

	public void service(MessageDTO dto) throws Exception {
		MessageDAO dao = new MessageDAO();
		dao.send(dto);
	}
}
