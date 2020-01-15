package com.webjjang.image.service;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.main.Service;

public class ImageViewService implements Service{

	private ImageDAO dao;
	
	// 사용해야할 dao 객체를 초기화 -> 밖에 생성할 때 넣어준다. 
	public ImageViewService(ImageDAO dao) {
		this.dao = dao;
	}

	@Override
	// 데이터 Controller <-> DAO
	// 글번호를 Controller 에서 받아서 처리한다.
		// TODO Auto-generated constructor stub
		// 데이터 처리부분에 해당된다.
	public ImageDTO service(Object[] objs) throws Exception {
	
		// 데이터 변환
		int no = (int)objs[0];
//		int cnt = (int)objs[1];
		// 데이터 처리부분 
		System.out.println("ImageViewService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서  Beans에서 생성한 객체 호출한다.
		// ImageController - ImageViewService - [ImageDAO]
//		if(cnt == 1) 
//			dao.increaseHit(no);// 1증가 시키는 처리문.
		
		return dao.view(no);
	}
	
}
