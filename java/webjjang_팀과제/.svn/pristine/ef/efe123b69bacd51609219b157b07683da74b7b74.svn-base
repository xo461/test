package com.webjjang.notice.controller;

import java.util.List;
import com.webjjang.main.Controller;
import com.webjjang.main.Main;
import com.webjjang.notice.dto.NoticeDTO;
import com.webjjang.notice.service.NoticeDeleteService;
import com.webjjang.notice.service.NoticeListService;
import com.webjjang.notice.service.NoticeUpdateService;
import com.webjjang.notice.service.NoticeViewService;
import com.webjjang.notice.service.NoticeWriteService;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.Output;
import com.webjjang.view.NoticeView;

public class NoticeController implements Controller {

	// Main.scanner.nextLine();
	//public static Scanner scanner = new Scanner(System.in);
	
	
	// public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	public void execute() {
		
		Output.title("공 지 사 항");
		
		// 공지사항 처리를 무한 반복 - 0 을 입력하면 이전 메뉴로 간다.(main)
		while(true) {
			try {
			// 공지사항 메뉴 출력
			System.out.println();
			Output.menu(
			"1.공지사항 리스트    2.공지사항 보기    3.공지사항 쓰기",
			"4.공지사항 수정       5.공지사항 삭제    0.이전메뉴");
			System.out.println();
			// 공지사항 메뉴 번호 선택
			String menu = Input.getStringWithMessage("  메뉴의 번호를 입력하세요.");
			// 메인메뉴 처리
			switch (menu) {
			
			case "1":
								
				System.out.println("공지사항  리스트 처리");
				// switch 문을 빠져 나간다.
				// break : switch, for, while문을 빠져 나갈때 사용한다.
				// break가 없는 경우는 case에 맞는 값이라서 case 아래로 처리하기 위해 들어오면
				// 그 아래로 case와 상관없이 처리문을 처리하게된다.
				//객체생성 - main 메모리에 올린다 (new)
				NoticeListService noticeListService = new NoticeListService();
				List<NoticeDTO> list = noticeListService.service();
				
				//가져온 데이터를 출력(객체 생성 -> 메서드 호출)
				NoticeView noticeView = new NoticeView();
				noticeView.list(list);
				
				break;
			case "2":
				System.out.println("공지사항 보기 처리");
				//list를 먼저 실행하고 있는 글 번호를 선택한다.
				
				new NoticeView().view(new NoticeViewService().
						service(Input.getIntWithMessageOfSmart(
								"보여줄 글 번호를 입력하세요"), 1));
				break;
			case "3":
				System.out.println("공지사항 쓰기 처리");
				if (Main.login == null) 
				{	System.out.println("로그인이 필요한 서비스입니다. 로그인을 해주세요.");
					Main.login();					
				}
				if (Main.login.getGrade() != 9) { 
					System.out.println("일반회원은 공지사항 글쓰기 권한이 없습니다.");
					break;
				}
				else {
//				
				// 사용자에게 데이터를 받는다. -> dto 객체로 만든다.
				// 제목, 내용, 시작일, 마감일
				NoticeDTO inDto = inputDTO();
//				String id = SwitchMain.login.getId();
//				inDto.setId(id);
//				// controller -> [service] -> dao
				NoticeWriteService noticeWriteService = new NoticeWriteService();
				noticeWriteService.service(inDto);
				break;}
			case "4":
				System.out.println("공지사항 수정 처리");
				// 수정할 글번호를 받는다 -> 글을 가져온다. (viewService) 표시
				// - > 가져온 dto의 데이터를 항목별로 수정한다.
				// -> 수정처리를 한다. (service -> dao)
//				// 로그인되어있지 않으면 예외발생
//				if (SwitchMain.login == null)
//					throw new NotLoginException();
				if (Main.login == null) 
				{	System.out.println("로그인이 필요한 서비스입니다. 로그인을 해주세요.");
					Main.login();					
				}
				if (Main.login.getGrade() != 9) { 
					System.out.println("일반회원은 공지사항 수정 권한이 없습니다.");
					break;
				}
				else {
				NoticeDTO updateDTO = getDTO("수정할 글번호를 입력하세요.");
				updateData(updateDTO);
				System.out.println(updateDTO);
				
				NoticeUpdateService noticeUpdateService = 
						new NoticeUpdateService();
				noticeUpdateService.service(updateDTO);
				
				break;
				}
				
			case "5":
				if (Main.login == null) 
				{	System.out.println("로그인이 필요한 서비스입니다. 로그인을 해주세요.");
					Main.login();					
				}
				if (Main.login.getGrade() != 9) { 
					System.out.println("일반회원은 공지사항 삭제 권한이 없습니다.");
					break;
				}
				else {
				System.out.println("공지사항 삭제 처리");
				new NoticeDeleteService().service(Input.getIntWithMessageOfSmart("삭제할 글번호 입력"));
				break;
				}
			case "0":
				// 호출한 곳으로 돌아가라는 명령어 : return :SwitchMain.main() 호출
				return; 

			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
				break;
			}
		}catch (Exception e) {
			// TODO: handle exception
			// 개발자를 위한 코드
			e.printStackTrace();
			// 사용자를 위한 코드
			System.out.println("공지사항을 처리하는 중 오류가 발생되었습니다.");
			System.out.println("잠시후에 다시 시도해주세요");
			System.out.println("계속 진행이 안되면 전산담당자(정태환)에게 연락해주세요.");
		}
}
}
	
	// 게시판의 내용을 입력받는 메서드 -> dto생성 -> 제목, 내용 , 작성자 입력 리턴한다.
	public NoticeDTO inputDTO() {
		NoticeDTO dto = new NoticeDTO();
		dto.setTitle(Input.getStringWithMessage("1. 공지 제목 "));
		dto.setContent(Input.getStringWithMessage("2. 공지 내용 "));
		dto.setStartDate(Input.getStringWithMessage("3. 공지 시작일(YYYY-MM-DD) "));
		dto.setEndDate(Input.getStringWithMessage("4. 공지 마감일(YYYY-MM-DD) "));
		return dto;
	}

	
	public NoticeDTO getDTO(String msg) throws Exception{
		
		int no = Input.getIntWithMessageOfSmart(msg);
		NoticeViewService noticeViewService = new NoticeViewService();
		NoticeDTO dto = noticeViewService.service(no, 0);
		NoticeView noticeView = new NoticeView();
		noticeView.view(dto);
		return dto;
	}
	
	
	public void updateData(NoticeDTO dto) {
		// 입력데이터가 0이 될때까지 무한반복
		while (true) {
			System.out.println("---------------변경 내용 선택-------------");
			System.out.println("1.제목,  2.내용,  3.시작일,  4.마감일,  0.수정 완료");
			String menu =Input.getStringWithMessage("수정항목을 선택하세요.");
			
			// 수정할 데이터를 입력받는다.
			switch (menu) {
			case "1":
				dto.setTitle(Input.getStringWithMessage("1. 공지 제목: "));
				break;
			case "2":
				dto.setContent(Input.getStringWithMessage("2. 공지 내용: "));
				break;
			case "3":
				dto.setStartDate(Input.getStringWithMessage("3. 공지 시작일(YYYY-MM-DD): "));
				break;
			case "4":
				dto.setEndDate(Input.getStringWithMessage("4. 공지 마감일(YYYY-MM-DD): "));				
				break;
			case "0":
				return;
				
			default:
				System.out.println("잘못된 항목을 선택하셨습니다.");
				break;
			}		
			new NoticeView().view(dto);
		}
	}
}