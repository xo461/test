package com.webjjang.message.service;

import com.webjjang.message.dao.MessageDAO;

public class MessageDeleteService {

	public void service(int no) throws Exception {
		System.out.println("MessageDeleteService.service()");
		MessageDAO dao = new MessageDAO();
		dao.delete(no);
	}
}
