package com.webjjang.view;

import java.util.List;
import com.webjjang.notice.dto.NoticeDTO;

public class NoticeView {
	//list ȭ�鿡 ���
	public void list(List<NoticeDTO> list) {
		//타이틀 출력
		System.out.println("***************************");
		System.out.println("******* 공 지 사 항   리  스  트  ******");
		System.out.println("***************************");
		System.out.println("| 글번호  | 제목  | 내용  | 시작일  | 마감일  | 작성일  | 수정일  |");
		
		
//		 "NoticeDTO [no=" + no + ", title=" + title + ", content=" + content + ", startDate=" + startDate
	//		+ ", endDate=" + endDate + ", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
		//list에 여러개의 데이터가 들어있으므로 각각의 데이터에 대해서 출력한다. ->forEach
		for(NoticeDTO dto : list) {
			System.out.printf("|  %2d  |  %s  |  %s  |  %s  |  %s  |  %s  |  %s  |%n",
					dto.getNo(), dto.getTitle(), dto.getContent(), dto.getStartDate(), dto.getEndDate(), dto.getWriteDate(), dto.getUpdateDate());
		}
		System.out.println("\n");
	}
	public void view(NoticeDTO dto) {
		//타이틀 출력
		System.out.println("***************************");
		System.out.println("******* 공  지  사  항   보  기 *******");
		System.out.println("***************************");
		System.out.println("글번호 : " + dto.getNo());
		System.out.println("제목 : " + dto.getTitle());
		System.out.println("내용 : " + dto.getContent());
		System.out.println("시작일 : " + dto.getStartDate());
		System.out.println("마감일 : " + dto.getEndDate());
		System.out.println("작성일 : " + dto.getWriteDate());
		System.out.println("수정일 : " + dto.getUpdateDate());
		System.out.println();
	}

}