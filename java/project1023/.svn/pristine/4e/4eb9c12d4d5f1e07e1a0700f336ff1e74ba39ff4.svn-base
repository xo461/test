package com.webjjang.member.service;

import java.util.List;

import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.dto.MemberDTO;

public class MemberListService {

	public List<MemberDTO> service() throws Exception {
		// 데이터 처리부분에 해당된다.
		
		System.out.println("MemberListService.setvice()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// BoardController - BoardListService - [BoardDAO]
		MemberDAO dao = new MemberDAO();
		return dao.list();
	}
}