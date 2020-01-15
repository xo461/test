package com.cafeatte.member.service;

import com.cafeatte.main.Service;
import com.cafeatte.member.dao.MemberDAO;

public class MemberPwCheckService implements Service {

	private MemberDAO dao;
	
	public MemberPwCheckService (MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		return dao.pwCheckService((String) objs[0], (String) objs[1]);
	}

}
