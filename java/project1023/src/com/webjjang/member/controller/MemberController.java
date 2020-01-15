package com.webjjang.member.controller;

import java.util.List;
import java.util.Scanner;

import com.webjjang.member.dto.MemberDTO;
import com.webjjang.member.service.MemberDeleteService;
import com.webjjang.member.service.MemberListService;
import com.webjjang.member.service.MemberViewService;
import com.webjjang.member.service.MemberWriteService;
import com.webjjang.util.io.Input;
import com.webjjang.view.MemberView;

public class MemberController {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public void execute() {
		
		System.out.println("=====================");
		System.out.println("==   회  원  관  리    게  시  판  ==");
		System.out.println("=====================");
		
		while(true) {
			try {
				System.out.println();
				System.out.println("1.리스트 2.보기 3.등록");
				System.out.println("4.수정 5.삭제 0.이전메뉴");
				System.out.println("메뉴의 번호를 입력하세요.");
				String menu = scanner.nextLine();
				
				switch (menu) {
				case "1":
					System.out.println("회원관리 리스트 처리");
					
					MemberListService memberListService
					= new MemberListService();
					
					List<MemberDTO> list = memberListService.service();
					
					MemberView memberView = new MemberView();
					
					memberView.list(list);
					break;
				case "2":
					System.out.println("회원관리 보기 처리");
					System.out.println("회원 선택");
					
					String id =(scanner.nextLine());
					
					MemberViewService memberViewService
					= new MemberViewService();
					
					MemberDTO dto = memberViewService.service(id);
					
					MemberView memberView2 = new MemberView();
					
					memberView2.view(dto);
					break;
				case "3":
					System.out.println("회원관리 등록 처리");
					
					MemberWriteService memberWriteService
					= new MemberWriteService();
					
					memberWriteService.service(inputDTO());
					break;
				case "4":
					System.out.println("회원관리 수정 처리");
					
					MemberDTO memberDTO = getDTO("수정할 정보를 입력하세요.");
					
					changedata(memberDTO);
					System.out.println(memberDTO);
					break;
				case "5":
					System.out.println("회원관리 삭제 처리");
					
					new MemberDeleteService().service(Input.getStringWithMessage("삭제할 정보 입력"));
					break;
				case "0":
					System.out.println("이전 메뉴");
					return;
				default:
					System.out.println("잘못된 메뉴를 입력하셨습니다. \n다시 입력해 주세요.");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("게시판을 처리하는 중 오류가 발생되었습니다.");
				System.out.println("잠시 후에 다시 시도해 주세요.");
				System.out.println("계속 진행이 안되면 전산담당자(정태환)에게 연락해 주세요.");
			}
		}
	}
	
	public MemberDTO inputDTO() {
		MemberDTO dto = new MemberDTO();
		dto.setName(Input.getStringWithMessage("이름"));
		dto.setGender(Input.getStringWithMessage("성별"));
		dto.setBirth(Input.getStringWithMessage("생일"));
		dto.setTel(Input.getStringWithMessage("전화번호"));
		dto.setEmail(Input.getStringWithMessage("전자우편"));
		return dto;
	}
	
	public MemberDTO getDTO(String msg) throws Exception{
		
		String id = Input.getStringWithMessage(msg);
		
		MemberViewService memberViewService
		= new MemberViewService();
		MemberDTO dto = memberViewService.service(id);
		MemberView memberView = new MemberView();
		memberView.view(dto);
		return dto;
	}
	
	public void changedata(MemberDTO dto) {
		
		while(true) {
			System.out.println("변경 내용 선택-------------");
			System.out.println("1.이름, 2.성별, 3.생일, 4.전화번호, 5.전자우편, 0.수정 완료 ");
			String menu = Input.getStringWithMessage("수정 항목 선택");
			
			switch (menu) {
			case "1":
				dto.setName(Input.getStringWithMessage("이름"));
				break;
			case "2":
				dto.setGender(Input.getStringWithMessage("성별"));
				break;
			case "3":
				dto.setBirth(Input.getStringWithMessage("생일"));
				break;
			case "4":
				dto.setTel(Input.getStringWithMessage("전화번호"));
				break;
			case "5":
				dto.setEmail(Input.getStringWithMessage("전자우편"));
				break;
			case "0":
				return;

			default:
				System.out.println("잘못된 항목을 선택하셨습니다.");
				break;
			}
			
			new MemberView().view(dto);
		}
	}

}
