package com.webjjang.image.controller;

import java.util.List;

import com.webjjang.image.dto.ImageDTO;
import com.webjjang.image.service.ImageDeleteService;
import com.webjjang.image.service.ImageListService;
import com.webjjang.image.service.ImageUpdateService;
import com.webjjang.image.service.ImageViewService;
import com.webjjang.image.service.ImageWriteService;
import com.webjjang.main.Controller;
import com.webjjang.main.Main;
import com.webjjang.util.io.Input;
import com.webjjang.util.io.Output;
import com.webjjang.view.ImageView;

public class ImageController implements Controller {
	// Main.scn.nextLine(); 이러한 형태로 외부에서 호출 가능.
	// public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	@Override
	public void execute() {
		while (true) {
			try {
				Output.title("이미지 게시판");
				Output.menu("1.리스트  2.보기  3.등록", "4.수정  5.삭제  0.이전메뉴");
				String menu = Input.getStringWithMessage("메뉴의 번호를 입력하세요");
				switch (menu) {
				case "1": 
					Output.title("이미지 리스트");
					ImageListService imageListService = new ImageListService();
					List<ImageDTO> list = imageListService.service();
					ImageView imageView = new ImageView();
					imageView.list(list);
					break;
				case "2":
					Output.title("이미지 보기");
					getDTO("보여줄 글 번호를 입력하세요");
					break;
				case "3":
					Output.title("이미지 글쓰기");
					if (Main.login == null) {
						System.out.println("Login이 필요한 서비스입니다. Login을 해주세요.");
						Main.login();
					}
					ImageWriteService imageWriteService = new ImageWriteService();
					imageWriteService.service(inputDTO());
					break;
				case "4":
					Output.title("이미지 수정");
					if (Main.login == null) {
						System.out.println("Login이 필요한 서비스입니다. Login을 해주세요.");
						Main.login();
					}
					ImageDTO imageDTO = getDTO("수정할 글 번호를 입력하세요");
					while(true) {
						int ch = IdNoCheck(imageDTO);
						if(ch==0) imageDTO = getDTO("수정할 글 번호를 입력하세요");
						else break;
					}
					changeData(imageDTO);
					System.out.println(imageDTO);
					ImageUpdateService imageUpdateService = new ImageUpdateService();
					imageUpdateService.service(imageDTO);
					break;
				case "5":
					Output.title("이미지 삭제");
					if (Main.login == null) {
						System.out.println("Login이 필요한 서비스입니다. Login을 해주세요.");
						Main.login();
					}
					ImageDTO DeleteImageDTO = getDTO("삭제할 글 번호를 입력하세요");
					while(true) {
						int ch = IdNoCheck(DeleteImageDTO);
						if(ch==0) DeleteImageDTO = getDTO("삭제할 글 번호를 입력하세요");
						else break;
					}
					new ImageDeleteService().service(DeleteImageDTO.getNo());
					break;
				case "0":
					System.out.println("이전메뉴로 돌아가기");
					return; 
				default:
					System.out.println("잘못된 메뉴값입니다. \n다시 입력하세요.");
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ImageDTO inputDTO() {
		ImageDTO dto = new ImageDTO();
		dto.setTitle(Input.getStringWithMessage("제목"));
		dto.setContent(Input.getStringWithMessage("내용"));
		dto.setFileName(Input.getStringWithMessage("첨부파일"));
		return dto;
	}

	public ImageDTO getDTO(String msg) throws Exception {
		int no = Input.getIntWithMessageOfSmart(msg);
		ImageViewService ImageViewService = new ImageViewService();
		ImageDTO dto = ImageViewService.service(no);
		ImageView imageView = new ImageView();
		imageView.view(dto);
		return dto;
	}

	public int IdNoCheck(ImageDTO dto) throws Exception{
		ImageUpdateService ImageUpdateService = new ImageUpdateService();
		if(ImageUpdateService.idCheck(dto) == false) {
			System.out.println("게시글 작성자가 다릅니다. 다시 번호를 확인해주세요.");
			return 0;
		}
		else return 1;
	}
	public void changeData(ImageDTO dto) {
		while (true) {
			// 변경할 데이터를 선택
			System.out.println("변경 내용 선택----------------");
			System.out.println("1. 제목, 2. 내용, 3. 첨부파일, 0. 수정 완료");
			String menu = Input.getStringWithMessage("수정 항목 선택하세요 : ");
			// 데이터를 입력 받는다.
			switch (menu) {
			case "1":
				dto.setTitle(Input.getStringWithMessage("제목 : "));
				break;
			case "2":
				dto.setContent(Input.getStringWithMessage("내용: "));
				break;
			case "3":
				dto.setFileName(Input.getStringWithMessage("첨부파일 : "));
				break;
			case "0":
				return;
			default:
				System.out.println("잘못된 항목을 선택하셨습니다.");
			}
			new ImageView().view(dto);
		}
	}
}
