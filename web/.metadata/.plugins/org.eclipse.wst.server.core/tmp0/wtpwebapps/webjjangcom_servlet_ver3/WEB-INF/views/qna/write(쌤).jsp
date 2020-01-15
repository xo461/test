<%@page import="com.webjjang.member.dto.LoginDTO"%>
<%@page import="java.util.Set"%>
<%@page import="com.webjjang.qna.dto.QnaDTO"%>
<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 질문답변의 질문하기 처리 - Beans객체에 등록이 되어 있는지 확인한다. 
//- service가 Service인터페이스를 상속받고 있어야 한다. 
Service service = Beans.getService("qnaWriteService");

 
// 이곳을 실행했다는 처리내용 출력
System.out.println("질문하기 처리 ---qna/write.jsp");

// 한글 처리 -> 서버의 ISO-18~~~코드를 사용하므로 utf-8과는 다르다. 한글이 깨진다.
request.setCharacterEncoding("utf-8");

// 1. 데이터를 받는다.
// id는 로그인한 후 처리해야 하므로 session에서 부터 꺼내는 것으로 한다. 
String id = ((LoginDTO) session.getAttribute("login")).getId();
String title = request.getParameter("title");
String content = request.getParameter("content");

// 2. dto 객체를 만든다. 데이터 셋팅 
QnaDTO dto = new QnaDTO();
dto.setId(id);
dto.setTitle(title);
dto.setContent(content);

// 3. service 객체를 호출해서 DB에 데이터를 넣는다.
Execute.service(service, dto);

// 글쓰기가 끝나면 자동으로 list로 이동한다.
response.sendRedirect("list.jsp");
%>
