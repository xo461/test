package com.webjjang.image.service;

import com.webjjang.image.dao.ImageDAO;

public class ImageDeleteService {
	public void service(int no) throws Exception {
		System.out.println("ImageDeletervice.service()");
		try {
			ImageDAO dao = new ImageDAO();
			dao.delete(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("이미지 글 삭제 중 오류가 발생되었습니다.");
		}
	}
}
