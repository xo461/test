package com.webjjang.image.service;

import java.util.List;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.dto.ImageDTO;

public class ImageListService {
	public List<ImageDTO> service() throws Exception{
		System.out.println("ImageListService.service()");
		ImageDAO dao = new ImageDAO();
		return dao.list();
	}
}
