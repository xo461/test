package service;

import dto.DTO;
import main.Service;

public class DeleteService implements Service {

	@Override
	public Object service(Object... objs) {
		// TODO Auto-generated method stub
		System.out.println("DeleteService.service()");

		// 뷰 서비스에서는 글번호,조회수 1증가 데이터가 넘어온다.
//		Integer  no = (Integer)objs[0];
		return null;
	}
}
