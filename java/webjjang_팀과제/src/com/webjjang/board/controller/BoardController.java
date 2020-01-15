package com.webjjang.board.controller;

import java.util.List;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.service.BoardDeleteService;
import com.webjjang.board.service.BoardListService;
import com.webjjang.board.service.BoardUpdateService;
import com.webjjang.board.service.BoardViewService;
import com.webjjang.board.service.BoardWriteService;
import com.webjjang.main.Controller;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.Output;
import com.webjjang.view.BoardView;

public class BoardController implements Controller {

	public void execute() {

		while (true) {
			try {
				Output.title("게 시 판");
				Output.menu("1.글목록    2.글보기    3.글쓰기",
				"4.글수정    5.글삭제    0.이전 메뉴");
				String menu = Input.getStringWithMessage("메뉴를 선택하세요");

				switch (menu) {
				case "1":
					System.out.println("1. 글목록 처리");
					BoardListService boardListService = new BoardListService();
					List<BoardDTO> list = boardListService.service();

					BoardView boardView = new BoardView();
					boardView.list(list);
					break;

				case "2":
					System.out.println("2. 글보기 처리");
					getDTO("볼 글 번호를 선택하세요", true);
					break;

				case "3":
					System.out.println("3. 글작성 처리");
					BoardWriteService boardWriteService = new BoardWriteService();
					BoardDTO writeDTO = new BoardDTO();
					writeDTO.setTitle(Input.getStringWithMessage("제목"));
					writeDTO.setContent(Input.getStringWithMessage("내용"));
					writeDTO.setWriter(Input.getStringWithMessage("글쓴이"));
					boardWriteService.service(writeDTO);
					break;

				case "4":
					System.out.println("4. 글수정 처리");
					BoardDTO updateDTO = getDTO("수정할 글 번호를 입력하세요.", false);
					updateData(updateDTO);

					BoardUpdateService boardUpdateService = new BoardUpdateService();
					boardUpdateService.service(updateDTO);

					break;
				case "5":
					System.out.println("5. 글삭제 처리");
					new BoardDeleteService().service(Input.getIntWithMessageOfSmart("삭제할 글 번호를 입력하세요."));
					break;
				case "0":
					System.out.println("6. 이전메뉴 처리");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
					break;
				}// End of switch
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("게시판 처리 도중 오류가 발생했습니다.");
				System.out.println("지속적으로 오류 발생시 담당자 '강동욱'에게 연락주세요.");
			} // end of while
				// end of try
		}
	}// end of BoardController.execute

	public BoardDTO getDTO(String msg, boolean inc) throws Exception {
		int no = Input.getIntWithMessageOfSmart(msg);

		BoardViewService boardViewService = new BoardViewService();
		BoardDTO dto = boardViewService.service(no, inc);

		BoardView boardView = new BoardView();
		boardView.view(dto);
		return dto;

	}

	public void updateData(BoardDTO dto) {
		while (true) {
			System.out.print("\n1. 제목 2. 내용 3. 글쓴이\n0. 수정 완료\n");
			String choice = Input.getStringWithMessage("수정항목을 선택하세요.");
			switch (choice) {
			case "1":
				dto.setTitle(Input.getStringWithMessage("제목"));
				break;

			case "2":
				dto.setContent(Input.getStringWithMessage("내용"));
				break;

			case "3":
				dto.setWriter(Input.getStringWithMessage("글쓴이"));
				break;

			case "0":
				return;

			default:
				System.out.println("잘못 누르셨습니다.");
				break;
			}
			new BoardView().view(dto);
		}
	}
}
