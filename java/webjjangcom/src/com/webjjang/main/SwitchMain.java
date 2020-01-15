/*
 * 처음시작하는 main 부분 : PL이 작성해 넣어 둔다.
 * 각각의 모듈 컨트롤러에서 사용할 메서드를 정의해 놓은 인터페이스를 만든다.
 * 각각의 모듈 컨트롤러를 작성할 때에 반드시 인터페이스를 상속받아서 만들어야 한다고 강제한다.
 */
package com.webjjang.main;

import com.webjjang.bean.Beans;

//import java.util.Scanner;

import com.webjjang.board.controller.BoardController;
import com.webjjang.member.dto.LoginDTO;
import com.webjjang.member.service.LoginService;
import com.webjjang.qna.controller.QnaController;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.Output;

public class SwitchMain {

	// Main.scanner.nextLine();
//	public static Scanner scanner = new Scanner(System.in);
//	↓ 변경
//	String menu 
//	= Input.getStringWithMessage("메뉴의 번호를 입력하세요.");
	// 로그인 정보를 사용하는 객체 따로 작성하는게 좋다. 
	// 로그인 정보를 저장하는  객체 -> 초기 값은 로그인 안된 상태(null)
	public static LoginDTO login = null;
	
	//Controller 변수선언
	private static Controller noticeController 
	= Beans.getController("noticeController");
	private static Controller boardController 
	= Beans.getController("boardController");
	private static Controller imageController 
	= Beans.getController("imageController");
	private static Controller qnaController 
	= Beans.getController("qnaController");
	private static Controller messageController 
	= Beans.getController("messageController");
	private static Controller memberController 
	= Beans.getController("memberController");
	
	public static void main(String[] args) 
			throws ClassNotFoundException {
		// TODO Auto-generated method stub
		// 필요한 객체 생성하도록 Beans 초기화 블록을 실행
		Class.forName("com.webjjang.bean.Beans");
		
		// 환영 메세지 
		System.out.println("☆☆☆☆☆ 안 녕 하 세 요 !!!(switchmain)☆☆☆☆☆ ");
		// 메인을 무한 반복 처리 - 0 을 입력하면 종료시킨다.
		while(true) {
			// 메인 제목 출력
			Output.title("webjjang 메인");
			
//			// 로그인 정보 출력
			Output.loginInfor();
//			
//			System.out.println("======= [로 그 인 정 보] =======");
//			if(login == null)
//				System.out.println("=====로그인이 되지않았습니다!!! 로그인 하슈!=====");
//			else
//				System.out.println("환영합니다. " + login.getName()
//				+ "님은 " + login.getGradeName() + "권한으로 로그인 하셨습니다.");
//			System.out.println("========================================");
			
			// 메인메뉴 출력
			Output.menu("1.공지사항  2.게시판 3.이미지",
					"4.질문답변  5.메세지 6.회원관리",
					"7."+ ((login == null)?"로그인 ":"로그아웃") + "    "+"0.종료");

//			System.out.println("1.공지사항  2.게시판 3.이미지");
//			System.out.println("4.질문답변  5.메세지 6.회원관리");
//			System.out.print("7."
//			+ ((login == null)?"로그인 ":"로그아웃") + "    ");
//			System.out.println("0.종료");
			
			// 메인메뉴 번호 선택 -> web : url로 정한다. -> 클릭
//			System.out.println("메뉴의 번호를 입력하세요.");
//			String menu = scanner.nextLine();
			String menu 
			= Input.getStringWithMessage("메뉴의 번호를 입력하세요.");
			// 메인메뉴 처리
			switch (menu) {
			case "1":
				System.out.println("공지사항 처리");
				// 객체 생성 - main memory에 올린다. : new
//				NoticeController noticeController
//				= new NoticeController();
				// 생성한 객체의 처리문이 들어 있는 메서드를 호출해서 처리하도록 시킨다.
				noticeController.execute();
				// switch 문을 빠져 나간다.
				// break : switch, for, while문을 빠져 나갈때 사용한다.
				// break가 없는 경우는 case에 맞는 값이라서 case 아래로 처리하기 위해 들어오면
				// 그 아래로 case와 상관없이 처리문을 처리하게된다.
				break;
			case "2":
				System.out.println("게시판 처리");
				// 객체 생성 - 메서드 호출
				BoardController boardController = new BoardController();
				boardController.execute();
				break;
			case "3":
				System.out.println("이미지 처리");
				break;
			case "4":
				System.out.println("질문답변 처리");
				QnaController qnaController = new QnaController();
				qnaController.execute();
				break;
			case "5":
				System.out.println("메세지 처리");
				break;
			case "6":
				System.out.println("회원관리 처리");
				break;
			case "7":
				System.out.println("로그인/로그아웃 처리");
				if(login != null) {
					// 로그인 상태  -> 로그아웃 처리 - login = null ;			
					login = null;
					System.out.println("** 로그아웃 되었습니다. **");
				} else {
					login();
				}
//				     아래에 있는 로그인 처리하는 메서드 호출 밑에 처리 문을 간단히 만듬 ↑ 
//					
				// 로그아웃 상태 -> 로그인 처리  - id, pw 받아서 DB에서 가져온 데이터 넣기
//					LoginDTO dto = new LoginDTO();
//					dto.setId(Input.getStringWithMessage("ID:"));
//					dto.setPw(Input.getStringWithMessage("PW:"));
//					// controller - service - DAO
//					LoginService loginService = new LoginService();
//					
//					try {
//						login = loginService.service(dto);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						System.out.println(e.getMessage());
//					}
//									
				
				break;
			case "0":
				System.out.println("프로그램을 종료합니다.");
				// 시스템 종료 - 0:정상종료 - 종료명령으로 종료가 이뤄졌다.
				System.exit(0);

			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다. \n다시 입력해 주세요.");
				break;
			}// end of switch
		}// end of while(true)
	}// end of main()
	
	// 로그인 처리를 하는 메서드
	public static void login() { 
		LoginDTO dto = new LoginDTO();
		dto.setId(Input.getStringWithMessage("ID:"));
		dto.setPw(Input.getStringWithMessage("PW:"));
		// controller - service - DAO
		LoginService loginService = new LoginService();
		
		try {
			login = loginService.service(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}// end of login()
					
	// 서비스를 실행하는 메서드 작성
	// service(실행 객체, 넘겨질파라메터) -> 넘겨질 파라메터는 알맞게 캐스팅해서 사용하는 것으로 한다. 
	public static Object service(Service service, Object...objs) 
			throws Exception {
		System.out.println("SwitchMain.service():서비스 실행");
		return service.service(objs);
	}
	
}// end of SwitchMain class

















