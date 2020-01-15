package com.webjjang.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.board.service.BoardListService;
import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;

public class BoardController implements Controller {

	private Service boardListService;
	
	public BoardController(Service boardListService) {
		// TODO Auto-generated constructor stub
		this.boardListService = boardListService;
	}
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		String jsp = "";
			switch (uri) {
			case "/board/list.do":
				request.setAttribute("list", Execute.service(boardListService, 1));
				break;

			default:
				break;
			}
			return jsp;
	}

}
