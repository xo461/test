package service;

import dto.DTO;
import main.Service;

public class ViewService implements Service {

	@Override
	public Object service(Object... objs) {
		// TODO Auto-generated method stub
		System.out.println("ViewService.service 실행");		// 뷰 서비스에서는 글번호, 조회수 1증가 데이터가 넘어온다.

		// 뷰 서비스에서는 글번호,조회수 1증가 데이터가 넘어온다.
//		Integer no = (Integer) objs[0];
//		Integer inc = (Integer) objs[1];
		return new DTO();
	}
}
