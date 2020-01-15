package com.webjjang.member.service;

import com.webjjang.member.dao.LoginDAO;
import com.webjjang.member.dto.LoginDTO;

public class LoginService {

	public LoginDTO service(LoginDTO dto) throws Exception{
		System.out.println("LoginService.service()");
		
		LoginDAO dao = new LoginDAO();
		dao.increaseConDate(dto);
		return dao.login(dto);
	}
}
