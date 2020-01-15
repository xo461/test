package com.webjjang.image.service;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.main.Service;

public class ImageDeleteService implements Service {
	
	private ImageDAO dao; 
	
	public ImageDeleteService(ImageDAO dao) {
		this.dao = dao; 
	}

	// 데이터 Controller <->service <-> DAO
	// 입력 받은 글번호를 Controller 에서 받아서 삭제처리한다.
	@Override
	public Integer service(Object[] objs)throws Exception {
		// 데이터 변환
		// 데이터 처리 부분에 해당 된다. 
		int no = (int)objs[0];
		System.out.println("ImageDeleteService.service()");
			
		return dao.delete(no);
			
	}
	
}
