package com.webjjang.view;

import java.util.List;

import com.webjjang.message.dto.MessageDTO;

public class MessageView {

	// list 화면에 출력
	public void list(List<MessageDTO> list) {
		// 타이틀 출력
		System.out.println("==============");
		System.out.println("====메세지 리스트====");
		System.out.println("==============");
		System.out.println("|   번호   |   보낸이   |  보낸날짜   |  받는이   |   받은 날짜   |");

		// list 에 여러개의 데이터가 들어있으므로 각각의 데이터에 대해서 출력 -> forEach
		for (MessageDTO dto : list) {
			System.out.printf("|   %d   |   %s   |   %s   |   %s   |   %s   |%n", dto.getNo(), dto.getSender(),
					dto.getSendDate(), dto.getAccepter(), dto.getAcceptDate());
		}
	}

	public void view(MessageDTO dto) {
		System.out.println("========================");
		System.out.printf("|   번호   |   내용%n");
		System.out.printf("|  %d    |   %s%n 받은 날 : %s   |%n", dto.getNo(), dto.getContent(), dto.getAcceptDate());
	}
}
