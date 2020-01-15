package com.cafeatte.main;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeatte.main.Controller;
import com.cafeatte.main.Execute;
import com.cafeatte.main.Service;
import com.cafeatte.member.dto.LoginDTO;
import com.cafeatte.member.dto.MemberDTO;
import com.cafeatte.util.io.ViewResolver;

public class AjaxController implements Controller {

	private Service memberIdCheckService;
	private Service memberCheckNewPwService;
	private Service memberPwCheckService;
	private Service memberViewService;
	private Service memberLoginService;
	private Service memberFindIdService;
	private Service memberFindPwFormService;
	private Service memberFindPwService;
	private Service favoriteService;
	private Service userLikeService;
	private Service userLikeCntService;

	public AjaxController() {}
	
	public AjaxController(Service memberIdCheckService, 
			Service memberCheckNewPwService,
			Service memberPwCheckService,
			Service memberViewService,
			Service memberLoginService,
			Service memberFindIdService,
			Service memberFindPwFormService,
			Service memberFindPwService,
			Service favoriteService,
			Service userLikeService,
			Service userLikeCntService){
		this.memberIdCheckService = memberIdCheckService;
		this.memberCheckNewPwService = memberCheckNewPwService;
		this.memberPwCheckService = memberPwCheckService;
		this.memberViewService = memberViewService;
		this.memberLoginService = memberLoginService;
		this.memberFindIdService = memberFindIdService;
		this.memberFindPwFormService = memberFindPwFormService;
		this.memberFindPwService = memberFindPwService;
		this.favoriteService = favoriteService;
		this.userLikeService = userLikeService;
		this.userLikeCntService = userLikeCntService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {

		// 서버에서 클라이언트 방향으로 데이터를 전송하기 위한 객체
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String idCheck = "";
		String checkNewPw = "";
		HttpSession session = request.getSession();
		String id = "";
		switch(uri) {
		case "/ajax/loginCheck.do":
			// 넘어오는 데이터를 받아서 LoginDTO를 생성한다.
			LoginDTO dto = new LoginDTO(request.getParameter("id"), request.getParameter("pw"));
			dto = (LoginDTO) Execute.service(memberLoginService, dto);
			
			if(dto == null) {
				out.print("<span style='color: red;'>아이디와 비밀번호가 틀립니다. 확인후 다시 시도해 주세요.</span>");
			}
			break;
		
		case "/ajax/idCheck.do":
			System.out.println("ajaxController.execute.ajax/idCheck.do");
			// 서비스를 갔다가 DB에서 확인한 결과로 클라이언트에 보낼 내용을 결정한다.
			idCheck = (String) Execute.service(memberIdCheckService, request.getParameter("id"));
			System.out.println("idCheck in execute ajaxcontroller" + idCheck);
			if(idCheck == null) {
				out.print("<span style='color:blue'>사용 가능한 아이디입니다.</span>");
			} else if(idCheck != null) {
				out.print("<span style='color:red'>이미 존재하는 아이디로 사용이 불가합니다.</span>");
			}
//			out.print("/ajax/idCheck.do 실행");
			break;
		case "/ajax/checkNewPw.do":
			System.out.println("ajaxController.execute.ajax/checkNewPw.do");
			LoginDTO dto1 = (LoginDTO) session.getAttribute("login");
			checkNewPw = (String) Execute.service(memberCheckNewPwService, dto1.getId(), request.getParameter("pw"));
			if(checkNewPw != null) {
				out.print("<span style='color:red'>현재와 동일한 비밀번호로 변경할 수 없습니다.</span>");
			}
			break;

		case "/ajax/checkPw.do":
			System.out.println("/ajax/checkPw.do");
			LoginDTO dto2 = (LoginDTO) session.getAttribute("login");
			String id2 = dto2.getId();
			String pw = request.getParameter("pw");
			int result = (int) Execute.service(memberPwCheckService, id2, pw);
			if(result == 0) {
				out.print("<span style='color: red;'>비밀번호가 틀립니다. 비밀번호를 확인해주세요.</span>");
			}
			break;
			
		case "/ajax/findId.do":
			id = (String) Execute.service(memberFindIdService, request.getParameter("email"));
			System.out.println("membeFindIdService id : "+ id);
			if(id==null) {
				out.print("<span style='color: red;'>해당 이메일로 등록된 아이디가 없습니다.</span>");
			}
			break;
		
		case "/ajax/findPwForm.do":
			MemberDTO mdto = (MemberDTO) Execute.service(memberFindPwFormService, request.getParameter("id"), request.getParameter("email2"));
			if(mdto == null) {
				out.print("<span style='color: red;'>이메일과 아이디를 확인해주세요.</span>");
			}
			break;
			
		case "/ajax/findPw.do":
			String findPw = (String) Execute.service(memberFindPwService, request.getParameter("id"), request.getParameter("answer"));
			if(findPw.equals("")) {
				out.print("<span style='color: red;'>비밀번호 찾기 답이 다릅니다.</span>");
			}
			break;
			
		case "/ajax/checkStar.do":
			System.out.println("ajaxController.execute.ajax/checkStar.do");
			int no = Integer.parseInt(request.getParameter("no"));
			id = request.getParameter("id");
			int vr = Integer.parseInt(request.getParameter("vr"));
			System.out.println(no);
			System.out.println(id);
			System.out.println(vr);
			Execute.service(favoriteService, no, id, vr);
			break;

		case "/ajax/userLike.do":
			System.out.println("ajaxController.execute.ajax/userLike.do");
			no = Integer.parseInt(request.getParameter("no"));
			System.out.println("no : "+no);
			id = request.getParameter("id");
			System.out.println("id : "+id);
			vr = Integer.parseInt(request.getParameter("vr"));//해당 사용자가 좋아요 클릭한적이 있는지 저장해놓은 값. vr=0이면 좋아요 한 적 없음, vr=1이면 좋아요한적있음.(좋아요 한적 있는지만 주는거고, 실제로 좋아요가 된건 아님)
			System.out.println("vr : "+vr);
			Execute.service(userLikeService, no, id, vr);
			request.setAttribute("dto", Execute.service(userLikeCntService, no));
			
			ViewResolver.forward(request, response, "userCafe/userLike");
			break;


		}
		// TODO Auto-generated method stub
		out.close();
		return null;
	}
	
	private void getDTOFromSessionToAttribute (HttpServletRequest request, HttpSession session) throws Exception{
		LoginDTO viewDTO = (LoginDTO) session.getAttribute("login");
		String id = viewDTO.getId();
		request.setAttribute("dto", Execute.service(memberViewService, id));
	}

}
