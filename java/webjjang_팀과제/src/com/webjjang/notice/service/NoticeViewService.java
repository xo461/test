package com.webjjang.notice.service;

import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.dto.NoticeDTO;

public class NoticeViewService {
	//������ controller <->DAO
	//�۹�ȣ�� controller���� �޾Ƽ� ó���Ѵ�.
	public NoticeDTO service(int no, int inc) throws Exception{
		//
		System.out.println("NoticeViewService.service()");
		//������ ó�� �κп� �ش�ȴ�. 
		//�����͸� ����Ŭ���� �������� ���� ��ü ���� ȣ��.
		NoticeDAO dao = new NoticeDAO();
		if(inc == 1)
			dao.increaseHit(no);
		return dao.view(no);
}
}

