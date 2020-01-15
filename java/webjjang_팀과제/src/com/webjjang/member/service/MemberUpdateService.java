package com.webjjang.member.service;

import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.dto.MemberDTO;

public class MemberUpdateService {

	public void service(MemberDTO dto) throws Exception{
		
		System.out.println("MemberUpdateService.service()");
		try {
			MemberDAO dao = new MemberDAO();
			dao.update(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			throw new Exception("수정 중 오류가 발생했습니다.");
		}
		
	} 
}