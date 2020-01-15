package com.cafeatte.magazine.service;

import java.util.List;

import com.cafeatte.magazine.dao.MagazineDAO;
import com.cafeatte.magazine.dto.MagazineDTO;
import com.cafeatte.main.Service;
import com.cafeatte.util.page.PageObject;

public class MagazinemListService implements Service{
	
	private MagazineDAO dao;
	
	public MagazinemListService(MagazineDAO dao) {
		this.dao = dao;
	}
@Override
	public List<MagazineDTO> service(Object[] objs) throws Exception{
		// 데이터 처리부분에 해당된다.
		PageObject pageObject = (PageObject) objs[0];
		
		// 데이터 처리 부문에 해당된다.
		System.out.println("Magazine_m_ListService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성된 객체를 호출한다.
		// MagazineController - MagazineListService - [MagazineDAO]
		// 전체 데이터의 갯수를 구해서 pageObject에 넣는다. -> 전체 페이지가 자동으로 구해진다. 
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		System.out.println("Magazine_m_ListService.service().pageObject:"+pageObject);
		return dao.mlist(pageObject);
	}
	
}
