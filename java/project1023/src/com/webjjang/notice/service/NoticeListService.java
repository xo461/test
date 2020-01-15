package com.webjjang.notice.service;
import java.util.List;

import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.dto.NoticeDTO;

public class NoticeListService {


		public List<NoticeDTO> service() throws Exception{

			System.out.println("NoticeListService.service()");
			//������ ó�� �κп� �ش�ȴ�. 
			//�����͸� ����Ŭ���� �������� ���� ��ü ���� ȣ��.
			NoticeDAO dao = new NoticeDAO();
			return dao.list();
			//BoardController - BoardListService - [BoardDAO]

}



}
