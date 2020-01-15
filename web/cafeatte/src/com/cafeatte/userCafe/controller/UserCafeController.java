package com.cafeatte.userCafe.controller;

import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cafeatte.main.Controller;
import com.cafeatte.main.Execute;
import com.cafeatte.main.Service;
import com.cafeatte.member.dto.LoginDTO;
import com.cafeatte.userCafe.dto.UserCafeDTO;
import com.cafeatte.userCafe.service.UserLikeService;
import com.cafeatte.util.io.FileUtil;
import com.cafeatte.util.page.PageObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webjjang.util.ImageResizing;

//서비스로 보낸다.

public class UserCafeController implements Controller {

	// 변수타입은 인터페이스 Service (다 상속받고있다.)
	private Service listService;
	private Service viewService;
	private Service writeService;
	private Service updateService;
	private Service deleteService;
	private Service userLikeService;

	// 생성자...
	public UserCafeController(Service listService, Service viewService, Service writeService, Service updateService,
			Service deleteService, Service userLikeService) {
		this.listService = listService;
		this.viewService = viewService;
		this.writeService = writeService;
		this.updateService = updateService;
		this.deleteService = deleteService;
		this.userLikeService = userLikeService;
	}

	//첨부파일용 변수 
	int size = 100*1024*1024;
	String path = "/upload/userCafe/image/";
	String noStr = "";//글번호 (기존no랑 이름 다르게 선언)
	String perPageNumStr = ""; //(기존 perPageNum과 이름 다르게 선언)
	String deleteFileName = null;//지울파일

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {

		System.out.println("userCafeController.execute().시작");

		//세션에서 정보 받음(id 받기 위함)
		HttpSession session = request.getSession();
		LoginDTO iddto = (LoginDTO) session.getAttribute("login");
		System.out.println("LoginDTO : "+iddto);
		// 공통변수
		String jsp = "";
		int no = 0;
		int cnt = 0;
		PageObject pageobject = PageObject.getInstance(request.getParameter("page"),
				request.getParameter("perPageNum"));
		// 검색했으면 pageobject의 key, word에 넣어준다.
		String key = request.getParameter("key");
		System.out.println("Key : "+key);
		String word = request.getParameter("word");
		System.out.println("word : "+word);
		if (word != null) {
			pageobject.setKey(key);
			pageobject.setWord(word);
		}

		switch (uri) {
		case "/userCafe/list.do":// list.do요청이 들어오면
			System.out.println("userCafeController.execute().list");
			request.setAttribute("pageObject", pageobject);
			// listservice를 실행해서 "list"라는 이름으로 request에 담겠다. 그리고 리스트로 보낸다.
			request.setAttribute("list", Execute.service(listService, pageobject));
			jsp = "userCafe/list";
			break;

		case "/userCafe/view.do":
			System.out.println("userCafeController.execute().view");
			// view요청들어오면 글번호, cnt(list.jsp에서 글 클릭하면 cnt=1이 되게 셋팅해놓음) 받아서 viewservice실행시켜서
			// "view"이름에 담는다. 뷰로 보낸다.
			//
				no = Integer.parseInt(request.getParameter("no"));
				cnt = Integer.parseInt(request.getParameter("cnt"));
				String id = "";
				if(iddto == null) {//null일때 판별하면 numberformatexception오류난다...
					id = "";
				} else {
					id = iddto.getId();
				}
				try {
					
					if(id!="") {//로그인되어있으면
						System.out.println("로그인되어있음"+no+id);
						request.setAttribute("result", Execute.service(userLikeService, no, id, 0));//마지막 0은 vr. 그냥 view만 볼때는 vr=0으로 넘김(좋아요 클릭 안한상태)
						System.out.println(request.getAttribute("result"));
						//check=0이나1로 리턴 (0이면 좋아요한적없음, 1이면 있음)
					}else {
						System.out.println("로그인안되어있음"+no+id);
						request.setAttribute("result", 0);
					}//로그인안되어있으면
				} catch (Exception e) {
					// TODO: handle exception
				}
				request.setAttribute("dto", Execute.service(viewService, no, cnt));
	
			jsp = "userCafe/view";
			break;

		// ???
		case "/userCafe/writeForm.do":
			System.out.println("userCafeController.execute().writeForm");
			System.out.println("id:"+iddto.getId());
			jsp = "/userCafe/writeForm";
			break;

		case "/userCafe/write.do":
			// write요청 들어오면 글쓴뒤 리스트로 리다이렉트시킨다.
			System.out.println("userCafeController.execute().write");
			Execute.service(writeService, getMultiDTO(request, iddto.getId()));
			jsp = "redirect:list.do?page=1&perPageNum=" + perPageNumStr;
			break;

		case "/userCafe/updateForm.do":
			System.out.println("userCafeController.execute().updateForm");
			System.out.println("id:"+iddto.getId());
			no=Integer.parseInt(request.getParameter("no"));
			//view에있는 내용을 복사해와서 수정할수있게함...
			request.setAttribute("dto", Execute.service(viewService, no, cnt));
			jsp = "userCafe/updateForm";
			break;
			
		case "/userCafe/update.do":
			System.out.println("userCafeController.execute().update");
			UserCafeDTO dto = getMultiDTO(request, iddto.getId());
			Execute.service(updateService, dto, iddto.getId());
			//전달된 이미지 있으면 원래것 지운다.
			if(!dto.getFileName().equals(deleteFileName))
				FileUtil.deleteFile2(FileUtil.realPath(request, deleteFileName));
			jsp = "redirect:view.do?no=" + noStr + "&cnt=0" + "&page=" + pageobject.getPage() + "&perPageNum="
					+ pageobject.getPerPageNum()
					+ ((pageobject.getWord() != null && !pageobject.getWord().equals("")) ? "&key="
					+ pageobject.getKey() + "&word=" + URLEncoder.encode(pageobject.getWord(), "utf-8") : "");
			System.out.println("UserCafeController.execute().update.jsp:" + jsp);
			break;

		case "/userCafe/delete.do":
			System.out.println("userCafeController.execute().delete");
			System.out.println("id:"+iddto.getId());
			System.out.println("no:"+Integer.parseInt(request.getParameter("no")));
			int result2=(int) Execute.service(deleteService, Integer.parseInt(request.getParameter("no")), iddto.getId());
			//서버에 올린 파일 지우기
			System.out.println("result2:"+result2);
			if (result2 == 1) {
			FileUtil.deleteFile2(FileUtil.realPath(request, request.getParameter("deleteFileName")));
			System.out.println("글 삭제 및 파일 삭제 성공");
			jsp = "redirect:list.do?" + "page=1" + "&perPageNum=" + request.getParameter("perPageNum");
			}
			else {
			System.out.println("글 및 파일 삭제 되지 않음");
			jsp = "redirect:view.do?no=" +request.getParameter("no")+ "&page=1&perPageNum=" + request.getParameter("perPageNum");
			}
			break;

		default:
			break;
		}

		System.out.println("UserCafeController.execute().끝.jsp:" + jsp);
		return jsp;
	}// execute() end

	// write용 method
	// ()파라메터를 받아서 userCafeDTO타입의 getDTO 메소드 실행.
	// {}처리문 : 사용자가입력한(title, fileName, content) 내용 dto에 받아서 리턴함...
	private UserCafeDTO getWriteDTO(String id, String title, String content, String fileName) {
		System.out.println("UserCafeController.getWriteDTO()");
		UserCafeDTO dto = new UserCafeDTO();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		if(fileName!=null && !fileName.equals("") && !fileName.equals(path+"s_null"))
				dto.setFileName(fileName);
		return dto;
	}

	// update용 method
	private UserCafeDTO getUpdateDTO(int no, String id, String title, String content, String fileName) {
		System.out.println("UserCafeController.getUpdateDTO()");
		if(fileName.equals(path+"s_null")) fileName=deleteFileName;//파일을 새로 안올렸을때 파일은 그대로유지
		UserCafeDTO dto = getWriteDTO(id, title, content, fileName);
		//메소드이름 같은데 파라메터 다르면 - overload. 위에 글쓰기용 dto에 있는 title 등 받아오고  거기에 없는 no는 밑에 추가해서 셋팅해줌.
		dto.setNo(no);
		return dto;
	}

	private UserCafeDTO getMultiDTO(HttpServletRequest request, String id) throws Exception{
		System.out.println("UserCafeController.getMultiDTO()");
		
		//파일업로드되는 서버의 절대위치 (하드디스크위치) 설정
		String uploadPath = FileUtil.realPath(request, path);
		System.out.println("이미지업로드 위치 uploadpath:"+uploadPath);
		MultipartRequest multi = new MultipartRequest(
				request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		//db에 저장할 정보 : 위치+서버의파일명
		String fileName = path + "s_" + multi.getFilesystemName("fileName");//getFilesystemName:fileName키워드에담긴 파일명이름가져옴(updateForm에서 새로올린파일)
		System.out.println("UserCafeController.execute().fileName:"+fileName);
		
		//리사이즈된파일복사
		if(fileName !=null && !fileName.equals("") && !fileName.equals(path + "s_null"))
			ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("fileName"), "s_", 350);

		//한페이지에 표시할 데이터개수
		perPageNumStr = multi.getParameter("perPageNum");		
		noStr = multi.getParameter("no");
		System.out.println("noStr:"+noStr);
		//글번호가 들어오면 - 글수정
		if(noStr!=null &&!noStr.equals("")) {
			deleteFileName = multi.getParameter("deleteFile");//기존에올린파일...
			System.out.println("deleteFileName:"+deleteFileName);
			return getUpdateDTO(Integer.parseInt(noStr), id, multi.getParameter("title"), multi.getParameter("content"), fileName);
		}
		//글번호가 들어오지 않으면 - 글쓰기
		return getWriteDTO(id, multi.getParameter("title"), multi.getParameter("content"), fileName);
	}
}
