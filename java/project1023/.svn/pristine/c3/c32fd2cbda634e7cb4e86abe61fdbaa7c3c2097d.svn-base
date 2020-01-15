package com.webjjang.member.service;

import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.dto.MemberDTO;

public class MemberWriteService {

	public void service(MemberDTO dto) throws Exception{
		System.out.println("MemberViewService.service");
		
		try {
			MemberDAO dao = new MemberDAO();
			dao.write(dto);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("회원관리 등록 중 오류가 발생되었습니다.");
		}
	}
}
