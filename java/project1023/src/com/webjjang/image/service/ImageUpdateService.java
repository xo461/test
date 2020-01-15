package com.webjjang.image.service;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.dto.ImageDTO;

public class ImageUpdateService {
	//글쓰기는 반환할 것이 없으므로 void
	//글 저장하기 전에 오류를 확인 하는 것이므로, 작성된 ImagDTO를 받아온다
	public void service(ImageDTO dto) throws Exception{
		System.out.println("ImageUpdateService.service()");
		
		//받아온 ImageDTO에서 오류가 났을 경우 예외처리를 해야한다
		//예외가 발생되면 메세지로 던지기!
		try {
			ImageDAO dao = new ImageDAO();
			dao.update(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//상세한 내용의 예외 메세지를 셋팅해서 다시 던지기를 할 수 있다.
			throw new Exception("이미지 업데이트 중 오류가 발생되었습니다.");
		}
	}

}
