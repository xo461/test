package com.webjjang.notice.service;

import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.dto.NoticeDTO;

public class NoticeViewService {
	//������ controller <->DAO
	//�۹�ȣ�� controller���� �޾Ƽ� ó���Ѵ�.
	public NoticeDTO service(int no) throws Exception{
		//
		System.out.println("NoticeViewService.service()");
		//������ ó�� �κп� �ش�ȴ�. 
		//�����͸� ����Ŭ���� �������� ���� ��ü ���� ȣ��.
		NoticeDAO dao = new NoticeDAO();
		return dao.view(no);
}
}

