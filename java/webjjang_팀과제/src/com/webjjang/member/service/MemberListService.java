package com.webjjang.member.service;

import java.util.List;

import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.dto.MemberDTO;

public class MemberListService {

	public List<MemberDTO> service() throws Exception{
		System.out.println("MemberListService.service()");
		
		MemberDAO dao = new MemberDAO();
		return dao.list();
	}
}
