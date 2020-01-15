package com.webjjang.board.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.dto.BoardReplyDTO;
import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;



public class BoardController implements Controller {

	private Service listService; 
	private Service viewService; 
	private Service writeService; 
	private Service updateService; 
	private Service deleteService;
	
	private Service replyListService; 
	private Service replyWriteService;
	private Service replyUpdateService; 
	private Service replyDeleteService; 

	// 생성자를 이용해서 service DI(Dependent 적용 --> Beans에서 생성 후 넣어 준다. 
	public BoardController(Service listService,
			Service viewService,
			Service writeService,
			Service updateService,
			Service deleteService,
			
			Service replyListService,
			Service replyWriteService, 
			Service replyUpdateService,
			Service replyDeleteService
			) {
		
		
		// TODO Auto-generated constructor stub
		this.listService = listService;
		this.viewService = viewService;
		this.writeService = writeService;
		this.updateService = updateService;
		this.deleteService = deleteService;
		
		//댓글 서비스 
		this.replyListService = replyListService;
		this.replyWriteService = replyWriteService;
		this.replyUpdateService = replyUpdateService;
		this.replyDeleteService = replyDeleteService;
	}
	


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, String uri) 
			throws Exception {
		// TODO Auto-generated method stub
		
		// 공통으로 사용되는 변수 (초기값셋팅)
		String jsp = "";
		PageObject pageObject =PageObject.getInstance(request.getParameter("page"), 
				request.getParameter("perPageNum"));
		// 검색에 대한 데이터 셋팅
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if(word != null) {
			pageObject.setKey(key);
			pageObject.setWord(word);
		}	
	
		
		//jsp에서 자바 부분을 여기에 넣는다. 
		switch(uri) {
		case "/board/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService,pageObject));
			
			// jsp 파일 정하기
			jsp = "board/list";
			//FrontController에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
// ========================페이지 오브 젝트 메서드 작성함 ===========================//
			
			 //strPage = request.getParameter("page");
			 			//			// 처음 게시판으로 들어 오거나 페이지 데이터가 넘어오지 않으면 1페이지로 간주한다. : 기본 생성자 사용 
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
//			System.out.println("BoardController.execute().pageObject:" + pageObject);

			
		//게시판 글보기 + 댓글 리스트 보기 추가 (별도의 데이터를 받아와서 request에 넣는다.
		case "/board/view.do":	
			//request에 실행한 결과 값을 저장 -> jsp에서 꺼내 쓴다. 
			int no = Integer.parseInt(request.getParameter("no"));   
			int cnt = Integer.parseInt(request.getParameter("cnt"));   
			//게시판 글보기 데이터 가져오기 
			
			request.setAttribute("dto", Execute.service(viewService, no, cnt));
			
			//댓글 리스트 데이터 가져오기 
			request.setAttribute("replyList", 
					Execute.service(replyListService, no, cnt));
			
			
			jsp = "board/view";
			
			//FrontController에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
		//게시판 글 쓰기 폼
		case "/board/writeForm.do":	
			// writeForm.jsp로 바로 이동 시킨다.
			// 자동으로 리스트로 이동시켜야 한다.
			jsp = "board/writeForm";
			break;
		// 게시판 글 처리 
		case "/board/write.do":	
			// 데이터를 받아 dto를 만든 후 서비스에 전달해서 DB에 글쓰기를 한다.
			Execute.service(writeService, 
					getDTO(request.getParameter("title"),
							request.getParameter("content"),
							request.getParameter("writer")));
			// 자동으로 리스트로 이동시켜야 한다.
			jsp ="redirect:list.do?page=1&perPageNum="
					+request.getParameter("perPageNum");
			break;
		
		case "/board/updateForm.do":
			// 글번호를 받는다.
			no = Integer.parseInt(request.getParameter("no"));   
			request.setAttribute("dto", Execute.service(viewService, no, 0));
			// 자동으로 리스트로 이동시켜야 한다.
			jsp = "board/updateForm";
			break;

		case "/board/update.do":
			// 글번호를 받는다.
			no = Integer.parseInt(request.getParameter("no"));   
			Execute.service(updateService, 
					getDTO(no,
							request.getParameter("title"),
							request.getParameter("content"),
							request.getParameter("writer")));
			// 자동으로 리스트로 이동시켜야 한다.
			jsp = "redirect:view.do?no=" + no
					+ "&cnt=0"
					+ "&page="+pageObject.getPage()
					+ "&perPageNum=" + pageObject.getPerPageNum()
					+ ((pageObject.getWord() != null && !pageObject.getWord().equals(""))
						?"&key="+ pageObject.getKey() 
						+ "&word=" 
						// 서버의 한글 코드가 ISO-8859-1를 사용하므로 맞지 않으므로
						// 데이터를 꺼내서 붙이면 코드 변환 문제를 해결해야 한다. 
						// 검색어가 한글인 경우 엔코딩해서 넘긴다.
						+ URLEncoder.encode(pageObject.getWord(),"utf-8"):"");
			System.out.println("BoardController.execute().jsp:" + jsp);
			break;
			
			// 게시판 글삭제
		case "/board/delete.do":	
			//request에 실행한 결과 값을 저장 -> jsp에서 꺼내 쓴다.   
			Execute.service(deleteService, Integer.parseInt(request.getParameter("no")));
			// 자동으로 리스트로 이동시켜야 한다. 
			jsp = "redirect:list.do";
			
			//FrontController에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
			
			// 게시판 댓글 쓰기 처리
		case "/board/replyWrite.do":
			// 데이터를 받아 dto를 만든 후 서비스에 전달해서 DB에 글쓰기를 한다.
			
			Execute.service(replyWriteService, 
					new BoardReplyDTO
					(Integer.parseInt(request.getParameter("no")),
					request.getParameter("content"),
					request.getParameter("writer")));
			// 자동으로 글보기로 이동시켜야 한다.
			jsp ="redirect:view.do?no="+request.getParameter("no")+
					"&cnt=0"
					+ "&page=" + request.getParameter("page")
					+ "&perPageNum=" + request.getParameter("perPageNum");
			break;

	
		default:
			break;
		}
		System.out.println("BoardController.execute().jsp"+jsp);
		return jsp;
	}


	private BoardDTO getDTO(String title, String content, String writer) {
		// TODO Auto-generated method stub
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriter(writer);
		return dto;
	}
	private BoardDTO getDTO(int no, String title, String content, String writer) {
		// TODO Auto-generated method stub
		BoardDTO dto = getDTO(title, content, writer);
		dto.setNo(no);
		return dto;
	}


}
