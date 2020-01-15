package com.cafeatte.cafe.service;

import com.cafeatte.cafe.dao.CafeDAO;
import com.cafeatte.main.Service;

public class FavoriteService implements Service {
	private CafeDAO dao;
	public FavoriteService(CafeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Integer service(Object[] objs) throws Exception {
		System.out.println("FavoriteService.service()");
		int no = (int) objs[0];
		String id = (String) objs[1];
		int vr = (int) objs[2];
		int result = dao.favoriteCheck(no, id);
		if( vr == 1 ) {
			if(result == 0 ) {
				dao.favoriteUpdate(no, id);
			}else {
				dao.favoriteDelete(no, id);
			}
			result = 1;
		}
		return result;
	}
}
