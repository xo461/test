package com.webjjang.member.service;

import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.dto.MemberDTO;

public class MemberUpdateService {

	public void service(MemberDTO dto) throws Exception{
		System.out.println("MemberViewService.service");
		
		try {
			MemberDAO dao = new MemberDAO();
			dao.update(dto);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
}
