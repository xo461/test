package com.webjjang.qna.controller;

import java.util.List;
import java.util.Scanner;

import com.webjjang.exception.NotLoginException;
import com.webjjang.main.Controller;
import com.webjjang.main.SwitchMain;
import com.webjjang.qna.dto.QnaDTO;
import com.webjjang.qna.service.QnaAnswerService;
import com.webjjang.qna.service.QnaDeleteService;
import com.webjjang.qna.service.QnaListService;
import com.webjjang.qna.service.QnaUpdateService;
import com.webjjang.qna.service.QnaViewService;
import com.webjjang.qna.service.QnaWriteService;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.Output;
import com.webjjang.view.QnaView;

public class QnaController implements Controller{

	// Main.scanner.nextLine();
	public static Scanner scanner = new Scanner(System.in);

	@Override
	// public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	public void execute() {
	
		System.out.println("===================================");
		System.out.println("===========   질  문  답 변        ===========");
		System.out.println("===================================");
		
		// 질문답변 처리를 무한 반복 처리 - 0을 입력하면 이전 메뉴로 간다.(main)
		while (true) {
			try {
			// 질문답변 메뉴 출력
			Output.menu("1.리스트  2.보기  3.질문하기 4.답변하기","5.수정  6.삭제  0.이전메뉴");
//			System.out.println();
//			System.out.println("1.리스트  2.보기  3.질문하기 4.답변하기");
//			System.out.println("5.수정  6.삭제  0.이전메뉴");
//			System.out.println("메뉴의 번호를 입력하세요.");
//			String menu = scanner.nextLine();
			// 질문답변 번호 선택
			String menu 
			= Input.getStringWithMessage("메뉴번호를 입력하세요 ");
			// 메인메뉴 처리
			switch (menu) {
			case "1":
				System.out.println("질문답변 리스트 처리");
				// 객체 생성 : QnaController -> [QnaListService]
				//                         -> QnaDAO
				QnaListService qnaListService
				= new QnaListService();
				
				// 데이터 가져오기 -> 메서드 호출
				List<QnaDTO> list = qnaListService.service();
				// 가져온 데이터를 출력(객체생성 -> 메서드 호출)
				QnaView qnaView = new QnaView();
				qnaView.list(list);
				break;
			case "2":
				System.out.println("질문답변 글보기 처리");
				// Controller.main() -> view : hit = hit + 1 -> DAO 메서드 이용 
				// 조회수 1증가 시킨다 : 1을 넘긴다. 
				// list를 먼저 실행하시고 있는 글번호를 선택한다. 
				System.out.println("보여줄 글 번호를 입력하세요");
				new QnaView().view(new QnaViewService().service
					(Input.getIntWithMessageOfSmart("보여줄 글 번호를 입력하세요"),1));
//				int no = Integer.parseInt(scanner.nextLine());
//				// 데이터 가져오기 
//				// 생성하고 호출
//				QnaViewService qnaviewService
//				=new QnaViewService();
//				qnaviewService.service(no);
//				QnaDTO dto = qnaviewService.service(no);
				// 데이터 출력
				// 생성 하고 호출한다.
				break;
			case "3":
				System.out.println("질문답변 질문하기 처리");
				
				// 로그인이 필요한 처리이므로 로그인이 되어 있지 않으면 예외발생
				 
				if(SwitchMain.login == null)
					throw new NotLoginException();
				
				QnaDTO inDto = inputDTO();
				
//				String id = "test"; // 강제 로그인
				String id = SwitchMain.login.getId(); // 로그인
				inDto.setId(id);
				
				QnaWriteService qnaWriteService 
				= new QnaWriteService();
				
				qnaWriteService.service(inDto);
				break;
			
			case "4":
				System.out.println("질문답변 답변하기 처리");
				
				// 로그인이 필요한 처리이므로 로그인이 되어 있지 않으면 예외발생
				 
				if(SwitchMain.login == null)
					throw new NotLoginException();
				
				// 답변할 글번호 받기
				QnaDTO sourceDTO = getDTO("답변할 글번호를 입력하세요.");
				// 사용자에게 답변 데이터를 받는다. -> dto객체로 만든다. 
				// 제목, 내용
				QnaDTO inDTO = inputDTO();
				// 답변하는 사람의 아이디 셋팅
				String answerId = "admin";
				inDTO.setId(answerId);
				// 사용해야할 번호를 셋팅하는 처리 
				inDTO.setOperateNo(sourceDTO);
				
				
				QnaAnswerService qnaAnswerService 
				= new QnaAnswerService();	
				qnaAnswerService.service(inDTO);
				
				break;
			
			case "5":
				System.out.println("질문답변 수정 처리");
				
				// 로그인이 필요한 처리이므로 로그인이 되어 있지 않으면 예외발생
				 
				if(SwitchMain.login == null)
					throw new NotLoginException();
				
				QnaDTO qnaDTO = getDTO("수정할 글번호 입력하세요");
				changeDate(qnaDTO);
				System.out.println(qnaDTO);
				
				QnaUpdateService qnaUpdateService
				= new QnaUpdateService();
				qnaUpdateService.service(qnaDTO);
				break;
			
			case "6":
				System.out.println("질문답변 글삭제 처리");
				
				// 로그인이 필요한 처리이므로 로그인이 되어 있지 않으면 예외발생
				 
				if(SwitchMain.login == null)
					throw new NotLoginException();
				
				// 삭제할 글번호 받기
				// 글번호에 맞는 DB에 데이터를 삭제 - delete
				new QnaDeleteService()
				.service(Input.getIntWithMessageOfSmart("삭제할 글번호 입력"));
				break;
			
			case "0":
				System.out.println("이전 메뉴");
				// 호출한 곳으로 돌아가라는 명령어 return : SwitchMain.main()호출 
				return;

			default:
				System.out.println("잘못 된 메뉴를 입력하셨습니다. \n다시 입력해 주세요");
				break;
			}//end of switch
		}catch (NotLoginException e) {
			System.out.println(e.getMessage());
			// 로그인 처리 
			SwitchMain.login();
			// 로그인 정보 출력
			Output.loginInfor();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// 사용자를 위한 코드 
			System.out.println("질문답변을 처리하는 중 오류가 발생되었습니다. ");
			System.out.println("잠시 후에 다시 시도해 주세요. ");
			System.out.println("계속 진행이 안되면 전산담당자(정태환)에게 연락해 주세요");
			}
		}

	}


	private QnaDTO getDTO(String msg)throws Exception {
		// TODO Auto-generated method stub
		int no = Input.getIntWithMessageOfSmart(msg);
		
		QnaViewService qnaViewService 
		= new QnaViewService();
		
		QnaDTO dto = qnaViewService.service(no,0);
		
		QnaView qnaView = new QnaView();
		qnaView.view(dto);
		
		return dto;
	}

	private QnaDTO inputDTO() {
		// TODO Auto-generated method stub
		QnaDTO dto = new QnaDTO();
		dto.setTitle(Input.getStringWithMessage("제목"));
		dto.setContent(Input.getStringWithMessage("내용"));
		return dto;
	}

	public void changeDate(QnaDTO dto) {
		// 입력 데이터 가 0 이 될 때까지 무한 반복
		while(true){
			// 변경할 데이터를 선택
			System.out.println("변경내용 선택 -------");
			System.out.println("1.제목 , 2.내용 , 0.수정 완료");
			String menu = Input.getStringWithMessage("수정항목 선택");
			
			// 수정할 데이터 입력 받는다. 
			switch (menu) {
			case "1":
				dto.setTitle(Input.getStringWithMessage("제목"));
				break;
			case "2":
				dto.setContent(Input.getStringWithMessage("내용"));
				break;
			case "0":
				return;

			default:
				System.out.println("잘못된 항목을 선택 하셨습니다.");
				break;
				}
			// 데이터가 수정이 되었으면 출력해서 확인 할 수 있도록 제공한다. 
			new QnaView().view(dto);
		}
	}
}

