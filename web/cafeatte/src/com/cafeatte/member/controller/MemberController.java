package com.cafeatte.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeatte.main.Controller;
import com.cafeatte.main.Execute;
import com.cafeatte.main.Service;
import com.cafeatte.member.dto.MemberDTO;
import com.cafeatte.util.page.PageObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.cafeatte.member.dto.LoginDTO;
import com.webjjang.util.ImageResizing;
import com.cafeatte.util.io.FileUtil;
import com.cafeatte.util.mail.SendEmailId;

public class MemberController implements Controller {

	private Service changePwService, findIdService, findPwService, 
	joinService, listService, loginService, signOutService, viewService,
	updateService, changeStateService, changeGradeService,
	findPwFormService;
	
	public MemberController(Service changePwService, Service findIdService, Service findPwService, Service joinService, 
			Service listService, Service loginService, Service signOutService, Service viewService, Service updateService,
			Service changeStateService, Service changeGradeService, Service findPwFormService) {
		this.changePwService = changePwService;
		this.findIdService = findIdService;
		this.findPwService = findPwService;
		this.joinService = joinService;
		this.listService = listService;
		this.loginService = loginService;
		this.signOutService = signOutService;
		this.viewService = viewService;
		this.updateService = updateService;
		this.changeStateService = changeStateService;
		this.changeGradeService = changeGradeService;
		this.findPwFormService = findPwFormService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		String jsp = "";
		HttpSession session = request.getSession();
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"), request.getParameter("perPageNum"));
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if(word != null) {
			pageObject.setKey(key);
			pageObject.setWord(word);
		}
		
		switch(uri) {
		case "/member/login.do":
			LoginDTO dto = new LoginDTO(request.getParameter("id"), request.getParameter("pw"));
			System.out.println(dto.getId() + dto.getPw());
			session.setAttribute("login", Execute.service(loginService, dto));
			if(((LoginDTO) session.getAttribute("login")).getState() != 1) {
				if(((LoginDTO) session.getAttribute("login")).getState() == 2) {
					return "member/dormancy";
				}
				session.invalidate();
				return "member/failState";
			}
			
			String nextURI = (String) session.getAttribute("nextURI");
			if(nextURI != null) {
				jsp = "redirect:"+nextURI;
				session.removeAttribute("nextURI");
			} else {
				jsp = "redirect:/main.do";
			}
			break;
					
		case "/member/logout.do":
			// 로그아웃 처리
			session.invalidate();
			jsp ="redirect:/main.do";
			break;

		case "/member/view.do":
			getDTOFromSessionToAttribute(request, session);
			jsp = "member/view";
			break;
		case "/member/updateForm.do":
			getDTOFromSessionToAttribute(request, session);
			jsp = "member/updateForm";
			break;
			
		case "/member/update.do":
			Execute.service(updateService, upDTO(request));
			session.setAttribute("login", Execute.service(loginService, (LoginDTO) session.getAttribute("login")));
			getDTOFromSessionToAttribute(request, session);
			jsp = "member/view";
			break;
		case "/member/loginForm.do":
			jsp = "member/loginForm";
			break;
			
		case "/member/joinForm.do":
			jsp = "member/joinForm";
			break;
			
		case "/member/join.do":
			Execute.service(joinService, joinDTO(request));
			jsp = "redirect:/main.do";
			break;
		case "/member/checkPwForm.do":
			jsp = "member/checkPwForm";
			break;	
			
		case "/member/checkPw.do":
			getDTOFromSessionToAttribute(request, session);
			jsp = "member/updateForm";
			break;	
			
		case "/member/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService, pageObject));
			jsp = "member/list";
			break;
		case "/member/adminView.do":
			request.setAttribute("dto", Execute.service(viewService, request.getParameter("id")));
			jsp = "member/adminView";
			break;
			
		case "/member/findIdPwForm.do":
			jsp = "member/findIdPwForm";
			break;
		case "/member/findId.do":
			String id = (String) Execute.service(findIdService, request.getParameter("email"));
			SendEmailId.gmailSend("카페어때 아이디 발송 이메일 입니다.", "고객님의 아이디는 " + id + "입니다. 보안을 위해 확인후 삭제해주세요.", request.getParameter("email"));
			jsp="member/sendEmail";
			break;
			
		case "/member/findPw.do":
			String findPw = (String) Execute.service(findPwService, request.getParameter("id"), request.getParameter("answer"));
			SendEmailId.gmailSend("카페어때 비밀번호 발송 이메일 입니다.", "고객님의 비밀번호는 " + findPw + "입니다. 보안을 위해 확인후 삭제해주세요.", (String) request.getParameter("pwEmail"));
			session.invalidate();
			jsp="member/sendEmail";
			break;
			
		case "/member/findPwForm.do":
			request.setAttribute("dto", Execute.service(findPwFormService, request.getParameter("id"), request.getParameter("email2")));
			jsp = "member/findPwForm";
			break;
			
		case "/member/changePwForm.do":
			jsp = "/member/changePwForm";
			break;
		case "/member/changePw.do":
			dto = new LoginDTO();
			dto = (LoginDTO) session.getAttribute("login");
//			System.out.println("changePw.do dto.getId() : " + dto.getId() + " pw : " + request.getParameter("pw"));
			Execute.service(changePwService, dto.getId(), request.getParameter("pw"));
			getDTOFromSessionToAttribute(request, session);
			jsp = "member/view";
			break;
			
		case "/member/changeState.do":
			Execute.service(changeStateService, request.getParameter("id"), Integer.parseInt(request.getParameter("stateSelect")));
			jsp = "redirect:/member/adminView.do?id="+request.getParameter("id");
			break;
		case "/member/changeGrade.do":
			System.out.println(request.getParameter("id") + Integer.parseInt(request.getParameter("gradeSelect")));
			Execute.service(changeGradeService, request.getParameter("id"), Integer.parseInt(request.getParameter("gradeSelect")));
			jsp = "redirect:/member/adminView.do?id="+request.getParameter("id");
			break;
			
		case "/member/signOutForm.do":
			jsp = "member/singOutForm";
			break;
			
		case "/member/signOut.do":
			Execute.service(signOutService, request.getParameter("id"));
			session.invalidate();
			jsp = "redirecht:/main.do";
			break;
		}
		return jsp;
	}
	
	private MemberDTO joinDTO(HttpServletRequest request) throws Exception {
		String uploadPath = request.getServletContext().getRealPath("upload/member/profile/images");
		String path = "/upload/member/profile/images/";
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		String fileName = path + multi.getFilesystemName("photo");
		if(fileName != null && !fileName.equals("") && !fileName.equals(path + "null")) {
			ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("photo"), "s_", 100);
		}
		MemberDTO dto = new MemberDTO();
		
		dto.setId(multi.getParameter("id"));
		dto.setPw(multi.getParameter("pw"));
		dto.setNickName(multi.getParameter("nickName"));
		String[] tel = multi.getParameterValues("tel");
		String colTel = tel[0] + "-" + tel[1] + "-" + tel[2];
		dto.setTel(colTel);
		dto.setAddr(multi.getParameter("addr"));
		dto.setEmail(multi.getParameter("email"));
		dto.setQuestion(multi.getParameter("question"));
		dto.setAnswer(multi.getParameter("answer"));
		if(fileName != null && !fileName.equals("") && !fileName.equals(path + "null")) {
			dto.setPhoto(fileName);
		} else {
			dto.setPhoto(path + "default.jpg");
		}
		
		return dto;
	}
	
	private MemberDTO upDTO(HttpServletRequest request) throws Exception {
		MemberDTO dto = new MemberDTO();
		String uploadPath = request.getServletContext().getRealPath("upload/member/profile/images");
		String path = "/upload/member/profile/images/";
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		String fileName = path + multi.getFilesystemName("upPhoto");
		if(multi.getParameter("photo").indexOf("default") == -1) {
			if(fileName != null && !fileName.equals("") && !fileName.equals(path + "null")) {
				ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("upPhoto"), "s_", 100);
				FileUtil.deleteFile(FileUtil.realPath(request, multi.getParameter("photo")));
				String smallPhoto = multi.getParameter("photo");
				int pos = smallPhoto.lastIndexOf("/");
				smallPhoto = smallPhoto.substring(0, pos + 1) + "s_" + smallPhoto.substring(pos + 1);
				FileUtil.deleteFile(FileUtil.realPath(request, smallPhoto));
			}
		} else {
			if(fileName != null && !fileName.equals("") && !fileName.equals(path + "null")) {
				ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("upPhoto"), "s_", 100);
			}
		}
		
		System.out.println("upDTO" + multi.getOriginalFileName("upPhoto"));
		dto.setId(multi.getParameter("id"));
		dto.setAddr(multi.getParameter("addr"));
		dto.setEmail(multi.getParameter("email"));
		dto.setTel(multi.getParameter("tel"));
		if(fileName != null && !fileName.equals("") && !fileName.equals(path + "null")) {
			dto.setPhoto(fileName);
		} else {
			dto.setPhoto(multi.getParameter("photo"));
		}
		System.out.println(dto);
		return dto;
	}
	
	private void getDTOFromSessionToAttribute (HttpServletRequest request, HttpSession session) throws Exception{
		LoginDTO viewDTO = (LoginDTO) session.getAttribute("login");
		String id = viewDTO.getId();
		request.setAttribute("dto", Execute.service(viewService, id));
	}
	
//	private MemberDTO getDTOFromId(String id) throws Exception {
//		return (MemberDTO) Execute.service(viewService, id);
//	}
	
}
