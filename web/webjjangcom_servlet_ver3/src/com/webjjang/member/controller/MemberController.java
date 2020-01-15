package com.webjjang.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;



public class MemberController implements Controller {

	private Service listService; // 회원리스트
	private Service viewService; // 내정보 보기
//	private Service writeService; // 회원가입
//	private Service updateService; // 내정보 수정
	private Service deleteService; // 회원탈퇴

	// 생성자를 이용해서 service DI(Dependent 적용 --> Beans에서 생성 후 넣어 준다. 
	public MemberController(Service listService,Service viewService,
			Service writeService,Service updateService,Service deleteService) {
		// TODO Auto-generated constructor stub
		this.listService = listService;
		this.viewService = viewService;
//		this.writeService = writeService;
//		this.updateService = updateService;
		this.deleteService = deleteService;
	}
	
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, String uri) 
			throws Exception {
		// TODO Auto-generated method stub
		
		// 공통으로 사용되는 변수 (초기값셋팅)
		String jsp = "";
//		String strPage = "";
//		int page = 0;
//		String strPerPageNum = "";
//		int perPageNum = 0;
//		PageObject pageObject = null;
		PageObject pageObject =PageObject.getInstance(request.getParameter("page"), 
				request.getParameter("perPageNum"));
		
		
		//jsp에서 자바 부분을 여기에 넣는다. 
		switch(uri) {
		case "/member/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService,pageObject));
			
			// jsp 파일 정하기
			jsp = "member/list";
			//FrontController에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
// ========================페이지 오브 젝트 메서드 작성함 ===========================//
			
			 //strPage = request.getParameter("page");
			 			//			// 처음 회원으로 들어 오거나 페이지 데이터가 넘어오지 않으면 1페이지로 간주한다. : 기본 생성자 사용 
//			if(strPage == null || strPage.equals("")) {
//				pageObject = new PageObject(); // page : 1, perPageNum : 10 
//			}else {
//				page = Integer.parseInt(strPage);
//				// 넘어오는 한페이지당 데이터의 갯수를 받는다. 
//				strPerPageNum = request.getParameter("perPageNum");
//				// 한페이지당 데이터의 갯수가 넘어오지 않는 경우 처리 :10으로 셋팅한다.  
//				if(strPerPageNum == null || strPerPageNum.equals("")) {
//					strPerPageNum = "10";
//				}
//				perPageNum = Integer.parseInt(strPerPageNum);
//				pageObject = new PageObject(page, perPageNum);
//			}
//			System.out.println("MemberController.execute().pageObject:" + pageObject);

			
		
		case "/member/view.do":	
			//request에 실행한 결과 값을 저장 -> jsp에서 꺼내 쓴다. 
			int no = Integer.parseInt(request.getParameter("no"));   
			int cnt = Integer.parseInt(request.getParameter("cnt"));   
			request.setAttribute("dto", Execute.service(viewService, no, cnt));
				
			jsp = "member/view";
			
			//FrontController에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
			//회원 가입
		case "/member/joinForm.do":	
			// joinForm.jsp로 바로 이동 시킨다.
			// 자동으로 리스트로 이동시켜야 한다.
			jsp = "member/joinForm";
			break;
			
		case "/member/delete.do":	
			//request에 실행한 결과 값을 저장 -> jsp에서 꺼내 쓴다.   
			Execute.service(deleteService, Integer.parseInt(request.getParameter("no")));
			// 자동으로 리스트로 이동시켜야 한다. 
			jsp = "redirect:list.do";
			
			//FrontController에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
		
				
		default:
			break;
		}
		System.out.println("MemberController.execute().jsp"+jsp);
		return jsp;
	}


}