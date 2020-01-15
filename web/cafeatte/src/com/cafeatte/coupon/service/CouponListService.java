package com.cafeatte.coupon.service;

import com.cafeatte.coupon.dao.CouponDAO;
import com.cafeatte.main.Service;

public class CouponListService implements Service {

	private CouponDAO dao;
	
	public CouponListService(CouponDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		return dao.list((String) objs[0]);
	}

}
