package com.webjjang.message.controller;

import java.util.List;
import java.util.Scanner;

import com.webjjang.message.dto.MessageDTO;
import com.webjjang.message.service.MessageDeleteService;
import com.webjjang.message.service.MessageListService;
import com.webjjang.message.service.MessageSendService;
import com.webjjang.message.service.MessageUpdateService;
import com.webjjang.message.service.MessageViewService;
import com.webjjang.util.io.Input;
import com.webjjang.view.MessageView;

public class MessageController {

	// Main.scanner.nextLine();
	public static Scanner scanner = new Scanner(System.in);
	public static String menu;

	// public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	public void execute() {
		// TODO Auto-generated method stub

		while (true) {
			try {
				System.out.println("=========================================");
				System.out.printf("1. 쪽지함%n2. 보기%n3. 메세지 보내기%n4. 수정%n5. 삭제%n0. 이전 메뉴%n");
				System.out.println("메뉴의 번호를 입력하세요.");
				menu = scanner.nextLine();
				switch (menu) {
				case "1":
					System.out.println("메세지 리스트 처리");
					MessageListService messageListService = new MessageListService();
					// 데이터 가져오기 -> 메서드 호출
					List<MessageDTO> list = messageListService.service();
					MessageView messageView = new MessageView();
					messageView.list(list);
					// 가져온 데이터를 출력(객체 생성 -> 메서드 호출)
					break;
				case "2":
					System.out.println("메시지 글보기처리");
					// list를 먼저 실행하고 있는 글 번호를 선택한다.
					getDTO("볼 메세지 번호를 입력하세요.");
					break;

				case "3":
					System.out.println("메세지 보내기 처리");
					MessageSendService messageSendService = new MessageSendService();
					messageSendService.service(inputDTO());
					break;
				case "4":
					System.out.println("메세지 수정 처리");
					MessageDTO messageDTO = getDTO("수정할 메세지 번호를 입력하세요.");
					if(messageDTO.getAcceptDate() != null) {
						System.out.println("상대방이 이미 읽은 메세지는 수정할 수 없습니다.");
						break;
					}
					changeData(messageDTO);
					System.out.println(messageDTO);
					MessageUpdateService messageUpdateService = new MessageUpdateService();
					messageUpdateService.service(messageDTO);
					
					break;
				case "5":
					System.out.println("메세지 삭제 처리");
					MessageDTO messageDTO1 = getDTO("삭제할 메세지 번호를 입력하세요.");
					if(messageDTO1.getAcceptDate() != null) {
						System.out.println("상대방이 이미 읽은 메세지는 삭제할 수 없습니다.");
						break;
					}
					new MessageDeleteService().service(messageDTO1.getNo());
					break;
				case "0": {
					System.out.println("이전 메뉴로 돌아갑니다.");
					// 호출한 곳으로 돌아가라는 명령어 : return : SwitchMain.main
					return;
				}
				default:
					System.out.println("잘못된 메뉴를 입력하셨습니다. \n다시 입력해 주세요.");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				// 사용자를 위한 코드
				System.out.println("메시지를 처리하는 중 오류가 발생되었습니다.");
				System.out.println("잠시 후에 다시 시도해 주세요.");
				System.out.println("계속 진행이 안되면 전산담당자(정태환)에게 연락해 주세요");
			}

		}

	}
	
	public MessageDTO inputUpdateDTO() {
		MessageDTO dto = new MessageDTO();
		dto.setContent(Input.getStringWithMessage("내용 : "));

		return dto;
	}
	
	public MessageDTO inputDTO() {
		MessageDTO dto = new MessageDTO();
		dto.setContent(Input.getStringWithMessage("내용 : "));
		dto.setAccepter(Input.getStringWithMessage("받는이 : "));
		dto.setSender(Input.getStringWithMessage("보낸이 : "));

		return dto;
	}
	public MessageDTO getDTO(String msg) throws Exception{
		int no = Input.getIntWithMessageOfSmart(msg);
		// 데이터 가져오기
		MessageViewService messageViewService = new MessageViewService();
		MessageDTO dto = messageViewService.service(no);
		// 생성하고 호출
		MessageView messageView2 = new MessageView();
		messageView2.view(dto);
		
		return dto;
	}
	
	public void changeData(MessageDTO dto) {
			// 변경할 데이터를 선택
			// 데이터 입력받는다.
			System.out.println("변경할 내용 입력");

			dto.setContent(Input.getStringWithMessage("내용"));

			new MessageView().view(dto);
	}
}