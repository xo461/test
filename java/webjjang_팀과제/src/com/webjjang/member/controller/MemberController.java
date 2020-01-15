package com.webjjang.member.controller;

import java.util.List;

import com.webjjang.main.Controller;
//import com.webjjang.main.Main;
import com.webjjang.member.dto.MemberDTO;
import com.webjjang.member.service.MemberDeleteService;
import com.webjjang.member.service.MemberListService;
import com.webjjang.member.service.MemberUpdateService;
import com.webjjang.member.service.MemberViewService;
import com.webjjang.member.service.MemberWriteService;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.Output;
import com.webjjang.view.MemberView;

public class MemberController implements Controller{

	@Override
	public void execute() {
		
		Output.title("회 원 관 리");

		while (true) {
			try {
				System.out.println();
				System.out.println("1.리스트 2.보기 3.등록");
				System.out.println("4.수정 5.삭제 0.이전메뉴");
				String menu = Input.getStringWithMessage("메뉴의 번호를 입력하세요.");
				
				switch (menu) {
				case "1":
					System.out.println("회원 리스트 보기");
					MemberListService memberListService = new MemberListService();
					
					List<MemberDTO> list = memberListService.service();
					
					MemberView memberView = new MemberView();
					memberView.list(list);
					break;
				case "2":
					System.out.println("회원 정보 보기");
					
//					getDTO("회원 ID를 입력하세요.");
					new MemberView().view(new MemberViewService().service(Input.getStringWithMessage("회원 ID를 입력하세요.")));
					break;
				case "3":
					System.out.println("회원 정보 등록");
					
					MemberWriteService memberWriteService = new MemberWriteService();
					memberWriteService.service(inputDTO());
					break;
				case "4":
					System.out.println("회원 정보 수정");
					
//					if(Main.login == null)
//						throw new NotLoginException();
					MemberDTO memberDTO = getDTO("수정할 회원의 ID를 입력하세요.");
					
					changeData(memberDTO);
					System.out.println(memberDTO);
					
					MemberUpdateService memberUpdateService = new MemberUpdateService();
					memberUpdateService.service(memberDTO);
					break;
				case "5":
					System.out.println("회원 탈퇴");
					
					new MemberDeleteService().service(Input.getStringWithMessage("탈퇴할 회원 ID 입력"));
					break;
				case "0":
					System.out.println("이전 메뉴");
					return;

				default:
					System.out.printf("잘못된 메뉴를 입력하였습니다. %n다시 입력해 주세요.");
					break;
				}
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println(e.getMessage());
//				Main.login();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
				System.out.println(e.getMessage());
				System.out.println("회원정보를 처리하는 중 오류가 발생되었습니다.");
				System.out.println("잠시 후에 다시 시도해 주세요.");
				System.out.println("계속 진행이 안되면 전산담당자(정태환)에게 연락해 주세요.");
			}
			
		}
	}
	
	public MemberDTO inputDTO() {
		MemberDTO dto = new MemberDTO();
		dto.setId(Input.getStringWithMessage("id"));
		dto.setPw(Input.getStringWithMessage("pw"));
		dto.setName(Input.getStringWithMessage("이름"));
		dto.setBirth(Input.getStringWithMessage("생일"));
		dto.setGender(Input.getStringWithMessage("성별"));
		dto.setTel(Input.getStringWithMessage("전화번호"));
		dto.setEmail(Input.getStringWithMessage("email"));
		dto.setGrade(Input.getIntWithMessageOfSmart("등급"));
		return dto;
	}
	
	public MemberDTO getDTO(String msg) throws Exception{
		String id = Input.getStringWithMessage(msg);
		
		MemberViewService memberViewService = new MemberViewService();
		MemberDTO dto = memberViewService.service(id);
		MemberView memberView = new MemberView();
		memberView.view(dto);
		
		return dto;
	}
	
	public void changeData(MemberDTO dto) {
		while(true) {
			System.out.println("수정 내용 선택----------------");
			System.out.printf("1.이름%n2.생일%n3.성별%n4.전화번호%n5.email%n6.등급%n0.수정완료%n");
			String menu = Input.getStringWithMessage("수정 항목 선택");
			
			switch (menu) {
			case "1":
				dto.setName(Input.getStringWithMessage("이름"));
				break;
			case "2":
				dto.setBirth(Input.getStringWithMessage("생일"));
				break;
			case "3":
				dto.setGender(Input.getStringWithMessage("성별"));
				break;
			case "4":
				dto.setTel(Input.getStringWithMessage("전화번호"));
				break;
			case "5":
				dto.setEmail(Input.getStringWithMessage("email"));
				break;
			case "6":
				dto.setGrade(Input.getIntWithMessageOfSmart("등급"));
				break;
			case "0":
				return;

			default:
				System.out.println("잘못된 항목을 선택하였습니다.");
				break;
			}
			
			new MemberView().view(dto);
		}
	}
}
