package com.webjjang.member.service;

import com.webjjang.member.dao.MemberDAO;

public class MemberDeleteService {

	public void service(String id) throws Exception{
		
		System.out.println("MemberViewService.service");
		
		try {
			MemberDAO dao = new MemberDAO();
			dao.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			throw new Exception("회원관리 등록 중 오류가 발생되었습니다.");
		}
	}
}
