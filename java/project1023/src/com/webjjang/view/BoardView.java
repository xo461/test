package com.webjjang.view;

import java.util.List;

import com.webjjang.board.dto.BoardDTO;

public class BoardView {

	// list 화면에 출력
	public void list(List<BoardDTO> list) {
		// 타이틀 출력
		System.out.println("===================================");
		System.out.println("===일                반                게                시              판===");
		System.out.println("===================================");

		// list 에 여러개의 데이터가 들어있으므로 각각의 데이터에 대해서 출력 -> forEach
		for (BoardDTO dto : list) {
			System.out.printf("번호  : %d%n제목 : %s%n작성자 : %s%n작성일 : %s%n조회수 : %d%n%n", dto.getNo(), dto.getTitle(),
					dto.getWriter(), dto.getWriteDate(), dto.getHit());
		}
	}

	public void view(BoardDTO dto) {
		System.out.println("===================================");
		System.out.printf("%d | %s 작성자 : %s 작성일 : %s 조회수 : %d %n", dto.getNo(), dto.getTitle(), dto.getWriter(),
				dto.getWriteDate(), dto.getHit());
		System.out.println("===================================");
		System.out.printf("%s%n", dto.getContent());
		System.out.println("-----------------------------------------------------------------");
	}
}
