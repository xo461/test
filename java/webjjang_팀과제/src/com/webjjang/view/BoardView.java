package com.webjjang.view;

import java.util.List;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.util.io.Output;

public class BoardView {

	public void list(List<BoardDTO> list) {
		Output.list("게 시 판  리 스 트");
		System.out.println("|  번 호  |  제목   |  작성자  |  작성일  |  조회수  |");
		for (BoardDTO dto : list) {
			System.out.printf("|   %2d   | %s | %s | %s | %d |%n", dto.getNo(), dto.getTitle(),
					dto.getWriter(), dto.getWriteDate(), dto.getHit());
		} // end of for
		

	} // end of list

	public void view(BoardDTO dto) {
		Output.printLine(100);
		System.out.printf("제목 : %s | 작성자 : %s | 작성일 : %s | 조회수 : %d%n", dto.getTitle(),
				dto.getWriter(), dto.getWriteDate(), dto.getHit());
		Output.printLine(100);
		System.out.println(dto.getContent());
		
		Output.printLine();

	} // end of view
}
