package com.webjjang.member.service;

import com.webjjang.member.dao.MemberDAO;

public class MemberDeleteService {

	public void service(String id) throws Exception{
		
		System.out.println("MemberDeleteService.service()");
		try {
			MemberDAO dao = new MemberDAO();
			dao.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			throw new Exception("삭제 중 오류가 발생했습니다.");
		}
		
	} 
}
