package com.webjjang.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;

public class MainController implements Controller {

	//공지사항 리스트 서비스
	private Service noticeListService;
	
	//이미지 리스트 서비스 
	private Service imageListService;
	
	
	//생성자를 이용한 DI 적용 
	public MainController(Service noticeListService, Service imageListService) {
		super();
		this.noticeListService = noticeListService;
		this.imageListService = imageListService;
	}

	@Override
	public String execute(HttpServletRequest request, 
			HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub

		// 공지사항 데이터 가져오기 . 1페이지, 7- perPageNum
		PageObject pageObject = new PageObject(1,7);
		request.setAttribute("noticeList", Execute.service(noticeListService, pageObject));
		
		// 이미지 게시판 데이터 가져오기. 1페이지 8- perPageNum
		pageObject = new PageObject(1,8);
		request.setAttribute("imageList", Execute.service(imageListService, pageObject));
		
		return "main/main";
	}

}
