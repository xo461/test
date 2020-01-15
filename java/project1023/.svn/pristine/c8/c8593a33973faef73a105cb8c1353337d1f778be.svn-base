package com.webjjang.notice.view;

import java.util.List;

import com.webjjang.notice.dto.NoticeDTO;

public class NoticeView {

	
	//list 화면에 출력
	public void list(List<NoticeDTO> list) {
		
		System.out.println("***********");
		System.out.println("** NOTICE LIST **");
		System.out.println("************");
		System.out.println(" |NO|TITLE|CONTENT|STARTDATE|ENDDATE|WRITEDATE|UPDATEDATE| ");
		
		//list에 여러개의 데이터가 들어있으므로 각각의 데이터에 대해서 출력한다
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
		System.out.println("글번호:"+dto.getNo());
		System.out.println("제목:"+dto.getTitle());
		System.out.println("내용:"+dto.getContent());
		System.out.println("시작일:"+dto.getStartDate());
		System.out.println("마감일:"+dto.getEndDate());
		System.out.println("작성일:"+dto.getWriteDate());
		System.out.println("업뎃일:"+dto.getUpdateDate());
		System.out.println();
	
	
	
	}
	}

