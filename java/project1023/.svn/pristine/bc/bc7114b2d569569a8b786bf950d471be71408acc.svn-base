package com.webjjang.notice.controller;

import java.util.List;
import java.util.Scanner;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.service.BoardWriteService;
import com.webjjang.main.Controller;
import com.webjjang.notice.dto.NoticeDTO;
import com.webjjang.notice.service.NoticeListService;
import com.webjjang.notice.service.NoticeViewService;
import com.webjjang.notice.service.NoticeWriteService;
import com.webjjang.util.io.Input;
import com.webjjang.view.NoticeView;


public class NoticeController implements Controller{


	//같은 Main 안에 들어와있는 함수. Main 안에서만 사용 가능
	public static Scanner scanner = new Scanner(System.in);
	public void execute() {
		// TODO Auto-generated method stub

		//메인 무한반복처리 - 0을 입력하면 종료시킨다.
		while(true) {
			try {
		
		// 메인메뉴 출력
		System.out.println("===================================");
		System.out.println("===   공            지               사               항              ===");
		System.out.println("===================================");
		System.out.printf("%s.리스트  %s.보기  %s.쓰기%n", "1", "2", "3");
		System.out.printf("%s.수정  %s.삭제  %s.이전메뉴%n", "4", "5", "0");
		
		// 메인메뉴 번호선택
		System.out.println("메뉴의 번호를 입력하세요.");
		String menu = scanner.nextLine();
		
		// 메인메뉴 처리
		switch (menu) {
		case "1":
			System.out.println("공지사항 리스트 처리.");			
			//객체생성 - main 메모리에 올린다 (new)
			NoticeListService noticeListService = new NoticeListService();
			List<NoticeDTO> list = noticeListService.service();
			
			//가져온 데이터를 출력(객체 생성 -> 메서드 호출)
			NoticeView noticeView = new NoticeView();
			noticeView.list(list);
			break;
		case "2":
			System.out.println("공지사항 글보기처리");
			//list를 먼저 실행하고 있는 글 번호를 선택한다.
			System.out.println("보여줄 글 번호를 입력하세요");
			int no = Integer.parseInt(scanner.nextLine());
			//데이터 가져오기
			NoticeViewService noticeViewService = new NoticeViewService();
			NoticeDTO dto = noticeViewService.service(no);
			//생성하고 호출
			NoticeView noticeView2 = new NoticeView();
			noticeView2.view(dto);	
			break;
		case "3":
			System.out.println("공지사항 글쓰기처리");
			// 사용자에게 데이터를 받는다. -> dto 객체로 만든다.
			// 제목, 내용, 작성자
//			BoardDTO inDto = inputDTO();
			// controller -> [service] -> dao
			NoticeWriteService noticeWriteService
			= new NoticeWriteService();
//			boardWriteService.service(inDto);
			noticeWriteService.service(inputDTO());
			break;
					
			
		case "4":
			System.out.println("공지사항 글수정처리");
			break;
		case "5":
			System.out.println("공지사항 글삭제처리");
			break;
		case "0":
			System.out.println("이전메뉴로 돌아가기");
			//0 입력시 시스템 종료
			return;
			
		//0~6 이외의 값 입력시 : 
		default:
			System.out.println("잘못된 메뉴값입니다. \\n다시 입력하세요.");	
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
		dto.setTitle(Input.getStringWithMessage("제목"));
		dto.setContent(Input.getStringWithMessage("내용"));
		return dto;
	}


	}
