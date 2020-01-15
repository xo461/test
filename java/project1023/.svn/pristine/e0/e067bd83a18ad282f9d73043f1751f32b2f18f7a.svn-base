package com.webjjang.message.service;

import java.util.List;

import com.webjjang.message.dao.MessageDAO;
import com.webjjang.message.dto.MessageDTO;

public class MessageListService {

	public List<MessageDTO> service() throws Exception {

		System.out.println("MessageListService.service()");
		// 데이터 처리부분에 해당된다.
		// 데이터를 오라클에서 가져오기 위해 객체 생성하고 호출
		MessageDAO dao = new MessageDAO();
		return dao.list();
		// BoardController - BoardListService - [BoardDAO]
	}
}
