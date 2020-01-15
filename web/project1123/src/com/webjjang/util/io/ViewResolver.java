package com.webjjang.util.io;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {

	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SURFIX = ".jsp";
	
	private static String getJsp(String jsp) {
		return PREFIX + jsp + SURFIX;
	}

	public static void forward(HttpServletRequest request, 
			HttpServletResponse response, String jsp) throws ServletException, IOException {
		if(jsp.indexOf("redirect:") != 0) {
			request.getRequestDispatcher(getJsp(jsp)).forward(request, response);
			return;
		} 
		jsp = jsp.substring("redirect:".length());
		response.sendRedirect(jsp);
	}
}
