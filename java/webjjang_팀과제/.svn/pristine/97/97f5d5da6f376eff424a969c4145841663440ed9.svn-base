package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;

public class BoardDeleteService {

	public void service(int no) throws Exception {
		System.out.println("BoardDeleteService.delete()");
		try {
			BoardDAO dao = new BoardDAO();
			dao.delete(no);			
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception("게시판 글 삭제 중 오류가 발생했습니다.");
		}
	}
}
