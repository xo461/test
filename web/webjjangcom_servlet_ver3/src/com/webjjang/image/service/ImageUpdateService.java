package com.webjjang.image.service;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.main.Service;

public class ImageUpdateService implements Service {
	
	private ImageDAO dao;

	public ImageUpdateService(ImageDAO dao) {
		this.dao = dao;
	}
	// 데이터 Controller <->DAO
	// 글번호를 Controller 에서 받아서 처리한다.
	public Integer service(Object[] objs)throws Exception {
		// 데이터 처리 부분에 해당 된다. 
		System.out.println("ImageUpdateService.service()");
		
		// 데이터 변환
		ImageDTO dto = (ImageDTO) objs[0];
		
		// 게시판 글수정에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다. 
		// - 예외가 발생이 되면 알맞은 메시지로 바꿔서 던진다.  
		try {
		// 데이터 controller를 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
		// ImageController - ImageListService - [ImageDAO]
		return dao.update(dto);
		}catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예의 메시지를 셋팅해서 다시 던지기를 할 수 있다. 
			// ↓ 사용자를 위한 예외처리
//			throw new Exception("게시판 글쓰기 중 오류가 발생되었습니다.");
			// ↓ 개발자를 위한 예외처리 
			throw e;
		}
		
	}
	
}
