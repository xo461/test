package com.webjjang.view;

import java.util.List;

import com.webjjang.image.dto.ImageDTO;
import com.webjjang.util.io.Output;

public class ImageView {
	//list 화면에 출력
	public void list(List<ImageDTO> list) {
		//타이틀 출력
		Output.list("이 미 지   리 스 트");
		System.out.println("| 번호  |  제목  |  작성자  |  작성일  |");
		//list에 여러개의 데이터가 들어있으므로 각각의 데이터에 대해서 출력한다. ->forEach
		for(ImageDTO dto : list) {
			System.out.printf("|  %2d  |  %s  |  %s  |  %s  |%n",
					dto.getNo(), dto.getTitle(), dto.getId(), dto.getWriteDate());
		}
		System.out.println("\n");
	}
	public void view(ImageDTO dto) {
		//타이틀 출력
		Output.list("이 미 지  보 기");
		System.out.println("글번호 : " + dto.getNo());
		System.out.println("제목 : " + dto.getTitle());
		System.out.println("내용 : " + dto.getContent());
		System.out.println("작성자 : " + dto.getId());
		System.out.println("작성일 : " + dto.getWriteDate());
		System.out.println("첨부파일 : " + dto.getFileName());
		System.out.println();
	}

}
