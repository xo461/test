package com.webjjang.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	public void execute(HttpServletRequest request, 
			HttpServletResponse response, String uri) throws Exception;
	
}
