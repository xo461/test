package com.webjjang.util.io;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
 
	// 접두어 선언
	private static final String PREFIX = "/WEB-INF/views/";
	
	// 접미어 선언
	private static final String SURFIX = ".jsp";
	
	//forward 시킬 jsp를 완성해 주는 메서드 
	private static String getJsp(String jsp) {
		return PREFIX + jsp + SURFIX;
	}
	
	public static void forward(HttpServletRequest request, 
			HttpServletResponse response, String jsp) throws ServletException, IOException {
		if(jsp != null && jsp.indexOf("redirect:") != 0) {
			request.getRequestDispatcher(getJsp(jsp)).forward(request, response);
			return;
		}
		//redirect:제거 
		jsp = jsp.substring("redirect:".length());
	response.sendRedirect(jsp);
	}
	
}
