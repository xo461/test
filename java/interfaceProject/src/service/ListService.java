package service;

import java.util.ArrayList;

import dto.DTO;
import main.Service;

public class ListService implements Service {

	@Override
	public Object service(Object... objs) {
		// TODO Auto-generated method stub
		System.out.println("ListService.service()");
		// 리스트 서비스에서는 데이터를 받기만 하고 버린다. 실제적으로는 호출하는 쪽에서 null을 넣어 준다.
		return new ArrayList<DTO>();
	}
}
