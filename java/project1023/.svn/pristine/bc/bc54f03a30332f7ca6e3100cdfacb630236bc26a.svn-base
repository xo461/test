package com.webjjang.view;

import java.util.List;

import com.webjjang.member.dto.MemberDTO;

public class MemberView {

	public void list(List<MemberDTO> list) {
		System.out.println("**************");
		System.out.println("** 회원관리 리스트  **");
		System.out.println("**************");
		System.out.println("|  id  |  pw  |  이름  |  성별  |  생일  |"
				+"  전화번호  |  |  email  |  등록일  |  condate  |  상태  |  등급  |");
		for(MemberDTO dto : list) {
			System.out.printf("|  %s  |  %s  |  %s  |  %s  |  %s  |"
					+"  %s  |  %s  |  %s  |  %s  |  %s  |  %d  |  %n",
					dto.getId(),dto.getPw(),dto.getName(),dto.getGender(),dto.getBirth(),dto.getTel(),
					dto.getEmail(),dto.getRegdate(),dto.getCondate(),dto.getStatus(),dto.getGrade());
		}
		System.out.println();
	}
	public void view(MemberDTO dto) {
		System.out.println("**************");
		System.out.println("** 회원관리 리스트  **");
		System.out.println("**************");
		System.out.println("id:"+dto.getId());
		System.out.println("pw:"+dto.getPw());
		System.out.println("이름:"+dto.getName());
		System.out.println("생일:"+dto.getBirth());
		System.out.println("성별:"+dto.getGender());
		System.out.println("전화번호:"+dto.getTel());
		System.out.println("전자우편:"+dto.getEmail());
		System.out.println("등록일:"+dto.getRegdate());
		System.out.println("condate:"+dto.getCondate());
		System.out.println("상태:"+dto.getStatus());
		System.out.println("등급:"+dto.getGrade());
		System.out.println();
	}
}
