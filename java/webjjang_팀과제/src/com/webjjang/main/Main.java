package com.webjjang.main;

import com.webjjang.board.controller.BoardController;
import com.webjjang.image.controller.ImageController;
import com.webjjang.member.controller.MemberController;
import com.webjjang.member.dto.LoginDTO;
import com.webjjang.member.service.LoginService;
import com.webjjang.message.controller.MessageController;
import com.webjjang.notice.controller.NoticeController;
import com.webjjang.qna.dao.QnaController.QnaController;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.Output;

public class Main {

	public static LoginDTO login = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			
			Output.title("우주최강 DogFoot 메인^^");
			
			Output.printLine(45);
			System.out.println("  1.공지사항   2.게시판   3.이미지");
			System.out.println("  4.질문답변   5.메세지   6.회원관리");
			System.out.println("  7."+((login == null) ? "로그인 " : "로그아웃 ")+"    0.종료");
			Output.printLine(45);
			
			System.out.println();
			String menu = Input.getStringWithMessage("   원하시는 메뉴의 번호를 입력하세요");
			
			switch (menu) {
			case "1":
				System.out.println("공지사항 처리");
				new NoticeController().execute();
				break;
			case "2":
				System.out.println("게시판 처리");
				BoardController boardController = new BoardController();
				boardController.execute();
				break;
			case "3":
				System.out.println("이미지 처리");
				ImageController imageController = new ImageController();
				imageController.execute();
				break;
			case "4":
				System.out.println("질문답변 처리");
				QnaController qnaController = new QnaController();
				qnaController.execute();
				break;
			case "5":
				System.out.println("메시지 처리");
				MessageController messageController = new MessageController();
				messageController.execute();
				
				break;
			case "6":
				System.out.println("회원관리 처리");
				new MemberController().execute();				
				break;
			case "7":
				Output.title("로그인  / 로그아웃");
				if (login != null) {
					// 로그인 상태 -> 로그아웃 처리-> login=null;
					login = null;
					System.out.println("*******로그아웃 되었습니다.*******");
				} else {
					login();
				}				
				break;
			case "0":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;

			default:
				System.out.printf("잘못된 메뉴를 입력하셨습니다. %n다시 입력해 주세요.");
				break;
			}
		}
	}
	
// 로그인처리 메서드
	public static void login() {
		// 로그아웃 상태 -> 로그인처리->id, pw 받아서 DB에서 가져온 데이터 넣기//service, dao 필요하다.
		LoginDTO dto = new LoginDTO();
		dto.setId(Input.getStringWithMessage("ID를 입력하세요"));
		dto.setPw(Input.getStringWithMessage("Password를 입력하세요"));
		// controller - service - DAO
		LoginService loginService = new LoginService();
		try {
			login = loginService.service(dto);
			System.out.println();
			System.out.println("성공적으로 로그인되었습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}