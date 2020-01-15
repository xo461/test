package com.webjjang.view;

import java.util.List;

import com.webjjang.member.dto.MemberDTO;
import com.webjjang.util.io.Output;

public class MemberView {

	public void list(List<MemberDTO> list) {
		Output.list("회 원 관 리   리 스 트");
		System.out.println("|  id  |  이름  |  생일  |  성별  |  전화번호  |  eamil  |  작성일  |  상태  |  등급  |");
		
		for(MemberDTO dto : list) {
			System.out.printf("|  %s  |  %s  |  %s  |  %s  |  %s  | "
					+ " %s  |  %s  |  %s  |  %d  |  %n",
					dto.getId(), dto.getName(), dto.getBirth(), dto.getGender(), 
					dto.getTel(), dto.getEmail(), dto.getRegdate(), dto.getStatus(), dto.getGrade());
		}
		System.out.println();
	}
	
	public void view(MemberDTO dto) {
		Output.list("회 원 관 리   보 기");
		System.out.println("id :" + dto.getId());
		System.out.println("이름 :" + dto.getName());
		System.out.println("생일 :" + dto.getBirth());
		System.out.println("성별 :" + dto.getGender());
		System.out.println("전화번호 :" + dto.getTel());
		System.out.println("email :" + dto.getEmail());
		System.out.println("상태 :" + dto.getStatus());
		System.out.println("등급 :" + dto.getGrade());
		System.out.println("작성일:" + dto.getRegdate());
		System.out.println("최근 접속일:" + dto.getCondate());
		System.out.println();
	}
}
