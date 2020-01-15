package com.webjjang.main;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AjaxController implements Controller {
	

	private Service memberIdCheckService; // 회원 아이디 자동 체크 시 사용 
	
	public void setMemberIdCheckService(Service memberIdCheckService) {
		this.memberIdCheckService = memberIdCheckService;
	}

	// setter를 이용해서 service DI 적용 --> Beans에서 생성 후 넣어 준다. 
	public AjaxController() {}
	
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, String uri) 
			throws Exception {
		// TODO Auto-generated method stub
		
		//서버에서 클라이언트 방향으로 데이터를 전송하기 위한 객체 꺼내기
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//jsp에서 자바 부분을 여기에 넣는다. 
		switch(uri) {
		case "/ajax/idCheck.do":
			System.out.println("AjaxController.execute() - idCheck");
			//서비스를 갔다가 DB에서 확인 할 결과로 클라이언트에 보낼 내용을 결정한다. 
			String id = (String) memberIdCheckService.service(new Object[] {request.getParameter("id")});
			if(id == null)
				out.print("<span style = 'color:blue'>사용가능한 아이디</span>");
			else
				out.print("<span style = 'color:red'>중복된 아이디</span>");
				
			break;
				
		default:
			break;
		}
		return null;
	}


}
