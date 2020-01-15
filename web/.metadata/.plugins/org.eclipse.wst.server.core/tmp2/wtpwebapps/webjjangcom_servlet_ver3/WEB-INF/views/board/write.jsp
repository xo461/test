<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@page import="com.webjjang.board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Service service = Beans.getService("boardWriteService");
// 이곳을 실행했다는 처리내용 출력
System.out.println("글쓰기 처리 ---write.jsp");

request.setCharacterEncoding("utf-8");
// 1. 데이터를 받는다.
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");
// 2. dto 객체를 만든다.
BoardDTO dto = new BoardDTO();
dto.setTitle(title);
dto.setWriter(writer);
dto.setContent(content);
// 3. service 객체를 호출해서 DB에 데이터를 넣는다.
Execute.service(service, dto);
// 글쓰기가 끝나면 자동으로 list로 이동한다.
response.sendRedirect("list.jsp");
%>
