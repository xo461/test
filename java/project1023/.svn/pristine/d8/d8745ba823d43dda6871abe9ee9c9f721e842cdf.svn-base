package com.webjjang.image.controller;

import java.util.List;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.image.service.ImageDeleteService;
import com.webjjang.image.service.ImageListService;
import com.webjjang.image.service.ImageUpdateService;
import com.webjjang.image.service.ImageViewService;
import com.webjjang.image.service.ImageWriteService;
import com.webjjang.main.Controller;
import com.webjjang.util.io.Input;
import com.webjjang.view.ImageView;

public class ImageController implements Controller{
	//Main.scn.nextLine(); 이러한 형태로 외부에서 호출 가능.
	//public 공공의 - main 패키지의 Main 클래스에서 사용한다.
	@Override
	public void execute() {

		try {
			//공지사항 처리를 무한 반복 - 0을 입력하면 이전 메뉴로 돌아간다(main)
			while(true) {
				//공지사항 메뉴 출력
				System.out.println("===================================");
				System.out.println("===이           미           지            게           시          판===");
				System.out.println("===================================");
				System.out.printf("%s.리스트 %s.보기  %s.등록%n", "1", "2", "3");
				System.out.printf("%s.수정  %s.삭제  %s.이전메뉴%n", "4", "5", "0");
				String menu = Input.getStringWithMessage("메뉴의 번호를 입력하세요");
				//switch 문을 빠져 나간다.
				//break : switch, for, while 문을 빠져 나갈때 사용한다.
				//break가 없는 경우는 case에 맞는 값이라서 case 아래로 처리하기 위해 들어오면
				//case와 상관 없이 처리문을 처리하게 된다.
				switch (menu) {
				case "1": //case 값 : 값에는 문자, 문자열, 정수는 가능하나 변수, 실수는 불가능하다.
					System.out.println("이미지 리스트 처리");
					//객체 생성 : ImageController -> [ImageListService] -> ImageDAO
					ImageListService imageListService = new ImageListService();
					List<ImageDTO> list = imageListService.service();
					ImageView imageView = new ImageView();
					imageView.list(list);
					break;
				case "2":
					System.out.println("이미지 보기 처리");
					getDTO("보여줄 글 번호를 입력하세요");
					break;
				case "3":
					System.out.println("이미지 글 쓰기 처리");
					ImageWriteService imageWriteService = new ImageWriteService();
					imageWriteService.service(inputDTO());
					break;
				case "4":
					System.out.println("이미지 수정 처리");
					ImageDTO imageDTO = getDTO("수정할 글 번호를 입력하세요");
					changeData(imageDTO);
					System.out.println(imageDTO);
					ImageUpdateService imageUpdateService = new ImageUpdateService();
					imageUpdateService.service(imageDTO);
					break;
				case "5":
					System.out.println("이미지 삭제 처리");
					new ImageDeleteService().service(Input.getIntWithMessageOfSmart("삭제할 글 번호 입력 : "));
					break;
				case "0":
					System.out.println("이전메뉴로 돌아가기");
					//scn.close();
					return; //호출한 곳으로 돌아가라는 명령어 : return : SwitchMain.main()호출
				default:
					System.out.println("잘못된 메뉴값입니다. \n다시 입력하세요.");
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ImageDTO inputDTO() {
		ImageDTO dto = new ImageDTO();
		dto.setTitle(Input.getStringWithMessage("제목"));
		dto.setContent(Input.getStringWithMessage("내용"));
		dto.setId(Input.getStringWithMessage("작성자"));
		dto.setFileName(Input.getStringWithMessage("첨부파일"));
		return dto;
	}
	
	public ImageDTO getDTO(String msg) throws Exception{
		int no = Input.getIntWithMessageOfSmart(msg);
		ImageViewService ImageViewService = new ImageViewService();
		ImageDTO dto = ImageViewService.service(no);
		ImageView imageView = new ImageView();
		imageView.view(dto);
		return dto;
	}
	
	public void changeData(ImageDTO dto) {
		while(true) {
			//변경할 데이터를 선택
			System.out.println("변경 내용 선택----------------");
			System.out.println("1. 제목, 2. 내용, 3. 작성자, 4. 첨부파일, 0. 수정 완료");
			String menu = Input.getStringWithMessage("수정 항목 선택하세요 : ");
			//데이터를 입력 받는다.			
			switch(menu) {
			case "1" :
				dto.setTitle(Input.getStringWithMessage("제목 : "));
				break;
			case "2" :
				dto.setContent(Input.getStringWithMessage("내용: "));
				break;
			case "3" :
				dto.setId(Input.getStringWithMessage("작성자 : "));
				break;
			case "4" :
				dto.setFileName(Input.getStringWithMessage("첨부파일 : "));
				break;
			case "0" :
				return;
			default :
				System.out.println("잘못된 항목을 선택하셨습니다.");
			}
			
			//데이터가 수정이 되었으면 출력해서 확인할 수 있도록 제공한다.
			new ImageView().view(dto);
		}
	}
	
	
}
