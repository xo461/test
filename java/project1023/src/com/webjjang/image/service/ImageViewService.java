package com.webjjang.image.service;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.dto.ImageDTO;

public class ImageViewService {
	public ImageDTO service(int no) throws Exception{
		System.out.println("ImageViewService.service()");
		ImageDAO dao = new ImageDAO();
		return dao.view(no);
	}

}
