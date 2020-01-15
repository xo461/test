package com.webjjang.message.service;

import com.webjjang.message.dao.MessageDAO;
import com.webjjang.message.dto.MessageDTO;

public class MessageSendService {

	public void service(MessageDTO dto) throws Exception {
		System.out.println("MessageSendService.service()");
		try {
			MessageDAO dao = new MessageDAO();
			dao.send(dto);
		} catch (Exception e) {
			throw new Exception ("메세지 보내기 중 오류가 발생되었습니다.");
		}
	}
}
