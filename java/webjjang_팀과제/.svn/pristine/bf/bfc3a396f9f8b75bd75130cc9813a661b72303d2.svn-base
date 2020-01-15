package com.webjjang.qna.dao.QnaView;

import java.util.List;

import com.webjjang.qna.dto.QnaDTO.QnaDTO;

public class QnaView {
	
	
	public void list(List<QnaDTO>list) {
		
		System.out.println("===============================================");
		System.out.println("====================질 문 답 변 리 스 트================");
		System.out.println("===============================================");
		System.out.println("| 번  호  | 제   목  | 작  성  자(id) | 작  성  일  | 조  회  수  |");
		
		for(QnaDTO dto : list){
			String indent = "";
			for (int i = 0; i < dto.getLevNo(); i++)
				indent +="   ";
			System.out.printf("|  %d  |  %s  |  %s  |  %s  |  %d  | %n",
					dto.getNo(),indent + dto.getTitle(),
					dto.getName() + " ( " + dto.getId() + " ) ",
					dto.getWriteDate(),dto.getHit());
		}
		System.out.println();
	}
	public void view(QnaDTO dto) {
		// 타이틀 출력
		System.out.println("*****************");
		System.out.println("**** 질문답변 리스트  ****");
		System.out.println("*****************");
		System.out.println("글번호 :" + dto.getNo());
		System.out.println("제목 :" + dto.getTitle());
		System.out.println("내용 :" + dto.getContent());
		System.out.println("작성자 :" + dto.getName()+"("+dto.getId()+")");
		System.out.println("작성일 :" + dto.getWriteDate());
		System.out.println("조회수 :" + dto.getHit());
		// 사용자에게 보여주지는 않지만 답변글 작성 시 꼭 필요하다.
		System.out.println("관련글번호 :" + dto.getRefNo());
		System.out.println("순서번호:" + dto.getOrdNo());
		System.out.println("들여쓰기:" + dto.getLevNo());
		System.out.println("부모글번호:" + dto.getParentNo());
		System.out.println();
		}
	}

