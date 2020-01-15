package com.cafeatte.magazine.service;

import com.cafeatte.magazine.dao.MagazineDAO;
import com.cafeatte.magazine.dto.MagazineDTO;
import com.cafeatte.main.Service;

public class MagazineUpdateService implements Service {
	
	private MagazineDAO dao;

	public MagazineUpdateService(MagazineDAO dao) {
		this.dao = dao;
	}
	// 데이터 Controller <->DAO
	// 글번호를 Controller 에서 받아서 처리한다.
	public Integer service(Object[] objs)throws Exception {
		// 데이터 처리 부분에 해당 된다. 
		System.out.println("MagazineUpdateService.service()");
		
		// 데이터 변환
		MagazineDTO dto = (MagazineDTO) objs[0];
		
		// 게시판 글수정에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다. 
		// - 예외가 발생이 되면 알맞은 메시지로 바꿔서 던진다.  
		try {
		
		// MagazineController - MagazineListService - [MagazineDAO]
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
