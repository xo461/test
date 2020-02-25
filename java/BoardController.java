package org.zerock.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.service.BoardService;

// 컨트롤러 역할 : 분개,메소드를 만들어 url이오면 메소드를 실행해라하고 명령.
// 컨트롤러 역할을 위해 어노테이션 등록
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 게시판 리스트
	// 디스페쳐서블렛에서 넘어 온것.↓
//	@RequestMapping("/list.do")
	@GetMapping("/list.do")
	// jsp '<c:forEach items="${list }'와 맞추기 위해,
	
	//	@RequestParam(defaultValue = "1") -> 페이지가 안넘어 올때, 기본값 1로 만드는것. 
	// 	-->매개 변수가 기본형 변수인경우 값이 안들어 오면 오류가 난다, 안들어오더라도 기본값을 셋팅할 수 있도록 지정 할 수 있다.
	
	// ↓처리된 데이터 형태와 표시하는 형태를 맞추기 위해 쓰는 Model
	public String list(@RequestParam(defaultValue = "1")int page, Model model) {

		// 처리한 결과 (boardService.list()) 를 model에 담는다.
		model.addAttribute("list", boardService.list());
		// viewResolve에서 "WEB-INF/views/" + "board/list" + ".jsp"
		// "redirect:~~" - redirect 실행, 없으면 - forward가 된다.
		return "board/list";
	}

	// 게시판 글쓰기 폼
//	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	@GetMapping("/write.do") // 위 RequestMapping과 같다 더 줄일수 있다. GET방식
	public String writeForm() {
		return "board/write";

	}

	// --------------------------------------------------------------
	// 게시판 글쓰기 처리
	// 처리 순서
	// Boardcontroller <-> Boardservice <-> Boardmapper.java <-> Boardmapper.xml
	//	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	@PostMapping("/write.do")
	// 데이터를 파라메터로 받는다.
	// spring (DispatcherServlet)이 넘어오는 데이터를BoardDTO를 생성하고 BoardDTO
	// 프로퍼티 이름과 같은 항이 있으면 바로 넣어주고 넘겨준다.
	public String write(BoardDTO dto) {
		// 넘어오는 데이터 확인
		System.out.println("BoardController.write().dto" + dto);

		// DB처리
		boardService.write(dto);

		// 자동으로 게시판 리스트
		// 같은 위치 여서 /board/ 쓰지 않아도 된다.
		return "redirect:list.do";

	}


	// ----------------------------------------------------------
	// 게시판 글보기 처리
	// 처리 순서
	// Boardcontroller <-> Boardservice <-> Boardmapper.java <-> Boardmapper.xml
//	@RequestMapping(value = "/view.do", method = RequestMethod.GET)
	@GetMapping("/view.do")
	// 데이터를 파라메터로 받는다.
	// spring (DispatcherServlet)이 넘어오는 데이터를BoardDTO를 생성하고 BoardDTO
	// 프로퍼티 이름과 같은 항이 있으면 바로 넣어주고 넘겨준다.
	// 기본형 변수 +String으로 선언된 변수는 반드시 파라메터로 넘어와야 한다. 안넘어오면 오류.
	// @RequestParam("no") : 넘어오는 파라메터 이름이 no인 데이터 가져오기 
	// --> 파라메터 이름과 매개변수명이 같은 경우 생략할 수 있다.  
	
	// 넘어 오는건 no뿐이다.
	// 넘오는 데이터는 no ↓처리된 데이터 형태와 표시하는 형태를 맞추기 위해 쓰는 Model
	public String view(@RequestParam("no") int no, Model model) {
		// 넘어오는 데이터 확인
		System.out.println("BoardController.view().dto" + no);

		// DB처리 -> model에 담는다.
		model.addAttribute("dto", boardService.view(no));

		// 자동으로 게시판 리스트로 이동

		return "board/view";
	}

	// -------------------------------------------------
	// 글수정은 글쓰기와 비슷하다, DB 에서 데이터를 가져오는것은 view에서 이미 짜놨다
	// 게시판 글수정 폼
//	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	@GetMapping("/update.do")
	public String updateForm(int no, Model model) {

		// DB처리 -> model에 담는다.
		model.addAttribute("dto", boardService.view(no));

		return "board/update";

	}

	// --------------------------------------------------------------
	// 게시판 글수정 처리
	// 처리 순서
	// Boardcontroller <-> Boardservice <-> Boardmapper.java <-> Boardmapper.xml
//	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@PostMapping("/update.do")
	// 데이터를 파라메터로 받는다.
	// spring (DispatcherServlet)이 넘어오는 데이터를BoardDTO를 생성하고 BoardDTO
	// 프로퍼티 이름과 같은 항이 있으면 바로 넣어주고 넘겨준다.
	public String update(BoardDTO dto) {
		// 넘어오는 데이터 확인
		System.out.println("BoardController.update().dto" + dto);

		// DB처리
		boardService.update(dto);

		// 자동으로 게시판 리스트
		// 같은 위치 여서 /board/ 쓰지 않아도 된다.
		// 넘어갈때는 view가고 no가 필요하다. no는 dto안에 있다.
		return "redirect:view.do?no=" + dto.getNo();

	}
	// --------------------------------------------------------------
	// 게시판 글삭제 처리
	// 처리 순서
	// Boardcontroller <-> Boardservice <-> Boardmapper.java <-> Boardmapper.xml
//	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	@GetMapping("/delete.do")
	// 데이터를 파라메터로 받는다.
	// spring (DispatcherServlet)이 넘어오는 데이터를BoardDTO를 생성하고 BoardDTO
	// 프로퍼티 이름과 같은 항이 있으면 바로 넣어주고 넘겨준다.
	public String delete(int no) {
		// 넘어오는 데이터 확인
		System.out.println("BoardController.delete().dto" + no);
		
		// DB처리
		boardService.delete(no);
		
		// 자동으로 게시판 리스트
		// 같은 위치 여서 /board/ 쓰지 않아도 된다.
		// 넘어갈때는 view가고 no가 필요하다. no는 dto안에 있다.
		return "redirect:list.do?page=1&perPageNo=10";
		
	}

}
