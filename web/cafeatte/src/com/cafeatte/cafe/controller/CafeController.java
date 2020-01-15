package com.cafeatte.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeatte.cafe.dto.CafeDTO;
import com.cafeatte.main.Controller;
import com.cafeatte.main.Execute;
import com.cafeatte.main.Service;
import com.cafeatte.member.dto.LoginDTO;
import com.cafeatte.reply.dto.ReplyDTO;
import com.cafeatte.util.image.ImageResize;
import com.cafeatte.util.io.FileUtil;
import com.cafeatte.util.page.PageObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webjjang.util.ImageResizing;

public class CafeController implements Controller {
	private Service listService;
	private Service hTagSearchService;
	private Service hTagListService;
	private Service viewService;
	private Service hTagViewService;
	private Service writeService;
	private Service updateService;
	private Service hTagUpdateService;
	private Service deleteService;
	private Service hTagDeleteService;
	
	private Service replyListService;
	private Service replyWriteService;
	private Service replyUpdateService;
	private Service replyDeleteService;

	private Service favoriteService;
	
	public CafeController(Service listService, Service hTagSearchService, Service hTagListService, Service viewService, Service hTagViewService, Service writeService, Service updateService, Service hTagUpdateService, Service deleteService, 
			Service hTagDeleteService, Service replyListService, Service replyWriteService, Service replyUpdateService, Service replyDeleteService, Service favoriteService) {
		
		this.listService = listService;
		this.hTagSearchService = hTagSearchService;
		this.hTagListService = hTagListService;
		this.viewService = viewService;
		this.hTagViewService = hTagViewService;
		this.writeService = writeService;
		this.updateService = updateService;
		this.hTagUpdateService = hTagUpdateService;
		this.deleteService = deleteService;
		this.hTagDeleteService = hTagDeleteService;

		this.replyListService = replyListService;
		this.replyWriteService = replyWriteService;
		this.replyUpdateService = replyUpdateService;
		this.replyDeleteService = replyDeleteService;

		this.favoriteService = favoriteService;
	}
	
	LoginDTO IDdto = null;
	String id = "";
	int grade;
	String hTags="";
	int imgSize = 100*1024*1024;
	String path = "/upload/cafe/image/";
	String updateNo = "";
	String deleteFileName1 = null;
	String deleteFileName2 = null;
	String deleteFileName3 = null;
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CafeController.execute()");
		HttpSession session = request.getSession();
		String jsp = "";
		int no = 0;
		int cnt = 0;
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"), request.getParameter("perPageNum"));
		// 검색에 대한 데이터 셋팅
		String word = request.getParameter("word");
		if((LoginDTO)session.getAttribute("login")!=null) {
			
			IDdto = (LoginDTO)session.getAttribute("login");
			id = IDdto.getId();
		}
		
		if (word != null) {
			pageObject.setWord(word);
		}
		System.out.println("login id : " + id);
		switch(uri) {
		case "/cafe/list.do":
			System.out.println("CafeController.execute().list");
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("hTags", Execute.service(hTagListService, pageObject));
			request.setAttribute("searchTags", Execute.service(hTagSearchService, pageObject)); //상단에 넣을 상위 태그 1~6개 String 출력
			request.setAttribute("list", Execute.service(listService, pageObject));				
			jsp="cafe/list";
			break;
		case "/cafe/view.do":
			System.out.println("CafeController.execute().view");
			no = Integer.parseInt(request.getParameter("no"));
			cnt = Integer.parseInt(request.getParameter("cnt"));
			request.setAttribute("hTags", Execute.service(hTagViewService, no));
			if(id != "") {
				request.setAttribute("favorite", Execute.service(favoriteService, no, id, 0));
			}else {
				request.setAttribute("favorite", 0);
			}
			request.setAttribute("replyList", Execute.service(replyListService, no));
			request.setAttribute("dto", Execute.service(viewService, no, cnt));
			jsp="cafe/view";
			break;
		case "/cafe/writeForm.do":
			System.out.println("CafeController.execute().writeForm");
			jsp = "cafe/writeForm";
			break;
		case "/cafe/write.do":
			System.out.println("CafeController.execute().write");
			Execute.service(writeService, getMultiCafeDTO(request), hTags);
			jsp="redirect:list.do?page=1&perPageNum=" + request.getParameter("perPageNum");
			break;
		case "/cafe/updateForm.do":
			System.out.println("CafeController.execute().updateForm");
			System.out.println("id : " + id);
			no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("dto", Execute.service(viewService,
					no, cnt));
			request.setAttribute("hTags", Execute.service(hTagViewService,
					no));
			jsp = "cafe/updateForm";
			break;
		case "/cafe/update.do":
			System.out.println("CafeController.execute().update");
			CafeDTO dto = getMultiCafeDTO(request);
			System.out.println("CafeController.execute().update : dto " + dto);
			Execute.service(updateService, dto, id);
			if(!dto.getFileName1().equals(deleteFileName1)) {
				if(deleteFileName1 != null) {
					FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName1));
				}
			}//if(fileName1 change) end
			if(!dto.getFileName2().equals(deleteFileName2)) {
				if(deleteFileName2 != null) {
					FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName2));
				}
			}//if(fileName2 change) end
			if(!dto.getFileName3().equals(deleteFileName3)) {
				if(deleteFileName3 != null) {
					FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName3));
				}
			}//if(fileName3 change) end
			Execute.service(hTagDeleteService, dto.getNo());
			System.out.println("업데이트 중 : hTags = " + hTags);
			Execute.service(hTagUpdateService, dto.getNo(), hTags);
			jsp="redirect:view.do?no=" + updateNo + "&cnt=0" + "&page=" + pageObject.getPage() + "&perPageNum=" + pageObject.getPerPageNum();
			break;
		case "/cafe/delete.do":
			System.out.println("CafeController.execute().delete");
			no = Integer.parseInt(request.getParameter("no"));
			System.out.println("delete: id: "+id);
			Execute.service(deleteService, no, id);
			FileUtil.deleteFile(FileUtil.realPath(request, request.getParameter("deleteFile1")));
			FileUtil.deleteFile(FileUtil.realPath(request, request.getParameter("deleteFile2")));
			FileUtil.deleteFile(FileUtil.realPath(request, request.getParameter("deleteFile3")));
			jsp="redirect:list.do?page=1&perPageNum=" + request.getParameter("perPageNum");
			break;
		case "/cafe/replyWrite.do":
			// 데이터를 받아 dto를 만든 후 서비스에 전달해서 DB에 글쓰기를 한다.
			System.out.println("CafeController.execute().replyWrite");
			System.out.println("replyWrite: id: "+id);
			Execute.service(replyWriteService, new ReplyDTO(Integer.parseInt(request.getParameter("no")),
					request.getParameter("content"), id));
			// 자동으로 글보기로 이동시켜야 한다.
			jsp = "redirect:view.do?no=" + request.getParameter("no") + "&cnt=0" + "&page="
					+ request.getParameter("page") + "&perPageNum=" + request.getParameter("perPageNum");
			break;
		case "/cafe/replyUpdate.do":
			System.out.println("replyUpdte: id: "+id);
			Execute.service(replyUpdateService, Integer.parseInt(request.getParameter("replyNo")),request.getParameter("content"), id);
			// 자동으로 글보기로 이동시켜야 한다.
			jsp = "redirect:view.do?no=" + request.getParameter("no") + "&cnt=0" + "&page="
					+ request.getParameter("page") + "&perPageNum=" + request.getParameter("perPageNum");
			break;
		case "/cafe/replyDelete.do":
			System.out.println("replyDelete: id: "+id);
			Execute.service(replyDeleteService, Integer.parseInt(request.getParameter("replyNo")), id); // 삭제니까 결과를 담을 필요 없다.
			jsp = "redirect:view.do?no=" + request.getParameter("no") + "&cnt=0" + "&page="
					+ request.getParameter("page") + "&perPageNum=" + request.getParameter("perPageNum");
			break;
		default:
			break;
		}//switch end
		
		System.out.println("CafeController.execute().jsp : " + jsp);
		return jsp;
	}
	private CafeDTO getCafeDTO(String id, String title, String addr, String tel, String parking, 
			String open, String holiday, String menu, String fileName1, String fileName2, String fileName3){
		CafeDTO dto = new CafeDTO();
		dto.setId(id);
		dto.setTitle(title);
		dto.setAddr(addr);
		dto.setTel(tel);
		dto.setParking(parking);
		dto.setOpen(open);
		dto.setHoliday(holiday);
		dto.setMenu(menu);
		if(fileName1 != null && !fileName1.equals("") 
				&& !fileName1.equals(path+"L_null"))
			dto.setFileName1(fileName1);
		if(fileName2 != null && !fileName2.equals("") 
				&& !fileName2.equals(path+"T_null"))
			dto.setFileName2(fileName2);
		if(fileName3 != null && !fileName3.equals("") 
				&& !fileName3.equals(path+"E_null"))
			dto.setFileName3(fileName3);
		
		return dto;	
	}//getCafeDTO(all request dto) end
	
	private CafeDTO getUpdateCafeDTO(int no, String id, String title, String addr, String tel, String parking, 
			String open, String holiday, String menu, String fileName1, String fileName2, String fileName3){
		if(fileName1.equals(path+"L_null")) {
			fileName1 = deleteFileName1;
		}
		if(fileName2.equals(path+"T_null")) {
			fileName2 = deleteFileName2;
		}
		if(fileName3.equals(path+"E_null")) {
			fileName3 = deleteFileName3;
		}
		CafeDTO dto = getCafeDTO(id, title, addr, tel, parking, open, holiday, menu, fileName1, fileName2, fileName3);
		dto.setNo(no);
		return dto;	
	}//getCafeDTO(all request dto) end
	
	private CafeDTO getMultiCafeDTO(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CafeController.getCafeDTO()");
		//File Upload Path
		String uploadPath=request.getServletContext().getRealPath(path);
		System.out.println("이미지 파일 업로드 위치(uploadPath) : " + uploadPath);
		//File Request
		MultipartRequest multi = new MultipartRequest(request, uploadPath, imgSize, "utf-8", new DefaultFileRenamePolicy());
		//DB Save
		String fileName1 = path + "L_" + multi.getFilesystemName("fileName1");
		String fileName2 = path + "T_" + multi.getFilesystemName("fileName2");
		String fileName3 = path + "E_" + multi.getFilesystemName("fileName3");
//		String fileName1 = path + multi.getFilesystemName("fileName1");
//		String fileName2 = path + multi.getFilesystemName("fileName2");
//		String fileName3 = path + multi.getFilesystemName("fileName3");
		System.out.println("CafeController.getCafeDTO().fileName1 : " + fileName1);
		System.out.println("CafeController.getCafeDTO().fileName2 : " + fileName2);
		System.out.println("CafeController.getCafeDTO().fileName3 : " + fileName3);
		
		//ImageResize.imageResize(realPath, 이미지 파일 명, 앞첨자, 너비, 높이); 비율 무시
		//ImageResizing.imageResizing(realPath, 이미지 파일 명, 앞첨자, 너비, 높이); 비율 맞춰서
		if(fileName1 != null && !fileName1.contentEquals("") && !fileName1.equals(path+"L_null")) {
			ImageResize.imageResize(uploadPath, multi.getFilesystemName("fileName1"), "L_", 200, 200);
		}//if(fileName1) end
		if(fileName2 != null && !fileName2.contentEquals("") && !fileName2.equals(path+"T_null")) {
			ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("fileName2"), "T_", 500);
				}//if(fileName2) end
		if(fileName3 != null && !fileName3.contentEquals("") && !fileName3.equals(path+"E_null")) {
			ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("fileName3"), "E_", 300);
		}//if(fileName3) end
		
		updateNo = multi.getParameter("no");
		hTags = multi.getParameter("hTag");
		System.out.println("hTags ======= " + hTags);
		System.out.println("updateNo : " + updateNo);
		if(updateNo != null && !updateNo.equals("")) {
			deleteFileName1 = multi.getParameter("deleteFile1");
			deleteFileName2 = multi.getParameter("deleteFile2");
			deleteFileName3 = multi.getParameter("deleteFile3");
			System.out.println("CafeController.getMultiCafeDTO.deleteFileName1: "+ deleteFileName1);
			System.out.println("CafeController.getMultiCafeDTO.deleteFileName2: "+ deleteFileName2);
			System.out.println("CafeController.getMultiCafeDTO.deleteFileName3: "+ deleteFileName3);
			System.out.println("CafeController.getMultiCafeDTO.fileName1: "+ fileName1);
			System.out.println("CafeController.getMultiCafeDTO.fileName2: "+ fileName2);
			System.out.println("CafeController.getMultiCafeDTO.fileName3: "+ fileName3);
			return getUpdateCafeDTO(Integer.parseInt(updateNo), multi.getParameter("id"),
					multi.getParameter("title"), multi.getParameter("addr"),
					multi.getParameter("tel"), multi.getParameter("parking"), multi.getParameter("open"),
					multi.getParameter("holiday"), multi.getParameter("menu"), fileName1, fileName2, fileName3);
		}//if(String updateNo not null and "" -> update content/fileName) end

		return getCafeDTO( multi.getParameter("id"), multi.getParameter("title"), multi.getParameter("addr"),
				multi.getParameter("tel"), multi.getParameter("parking"), multi.getParameter("open"),
				multi.getParameter("holiday"), multi.getParameter("menu"), fileName1, fileName2, fileName3);
	}//getCafeDTO end
}
