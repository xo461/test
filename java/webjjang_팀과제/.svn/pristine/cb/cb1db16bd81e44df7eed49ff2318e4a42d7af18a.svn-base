package com.webjjang.view;

import java.util.List;

import com.webjjang.message.dto.MessageDTO;
import com.webjjang.util.io.Output;

public class MessageView {

	public void list(List<MessageDTO> list) {
		Output.printTitleLine();
		Output.list("메 시 지  리 스 트");
		Output.printTitleLine();
		System.out.println("|  번 호  |  보낸이  |  보낸날짜  |  받는이  |   받은날짜   |");
		for (MessageDTO dto : list) {
			System.out.printf("|%3d   | %s | %s | %s | %s |%n", dto.getNo(), dto.getSender(),
					dto.getSendDate(), dto.getAccepter(), dto.getAcceptDate());
			System.out.printf("%.10s", dto.getContent());
			if(dto.getContent().length()>11)
				System.out.println("...");
			else
				System.out.println();
		} // end of for
		

	} // end of list

	public void view(MessageDTO dto) {
		Output.printLine(100);
		System.out.printf("%s%n", dto.getContent());
		Output.printLine(100);		

	} // end of view
}
