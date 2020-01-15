package com.webjjang.main;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.board.bean.Beans;
import com.webjjang.util.io.ViewResolver;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Controller boardController = Beans.getController("boardController");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		System.out.println("FrontController.service()");
		String jsp = request.getServletPath();
		if(jsp.indexOf("/board")==0) {
			jsp = boardController.execute(request,jsp);
		}
		ViewResolver.forward(request, response, jsp);
		}catch (Exception e) {
			// TODO: handle exception
		throw new ServletException(e);
		}
		
		}
	}


