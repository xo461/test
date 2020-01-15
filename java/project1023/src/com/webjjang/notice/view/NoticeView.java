package com.webjjang.notice.view;

import java.util.List;

import com.webjjang.notice.dto.NoticeDTO;

public class NoticeView {

	
	//list ȭ�鿡 ���
	public void list(List<NoticeDTO> list) {
		
		System.out.println("***********");
		System.out.println("** NOTICE LIST **");
		System.out.println("************");
		System.out.println(" |NO|TITLE|CONTENT|STARTDATE|ENDDATE|WRITEDATE|UPDATEDATE| ");
		
		//list�� �������� �����Ͱ� ��������Ƿ� ������ �����Ϳ� ���ؼ� ����Ѵ�
		// -> forEach
		
		for(NoticeDTO dto : list){
			System.out.printf("|%d|%s|%s|%s|%s|%s|%s]", 
					dto.getTitle(), dto.getStartDate(),
					dto.getEndDate(),
					dto.getWriteDate(), dto.getUpdateDate());
			
		}

}
	
	public void view(NoticeDTO dto) {
		System.out.println("*******************");
		System.out.println("*****  NOTICE VIEW ******");
		System.out.println("*******************");
		System.out.println("�۹�ȣ:"+dto.getNo());
		System.out.println("����:"+dto.getTitle());
		System.out.println("����:"+dto.getContent());
		System.out.println("������:"+dto.getStartDate());
		System.out.println("������:"+dto.getEndDate());
		System.out.println("�ۼ���:"+dto.getWriteDate());
		System.out.println("������:"+dto.getUpdateDate());
		System.out.println();
	
	
	
	}
	}

