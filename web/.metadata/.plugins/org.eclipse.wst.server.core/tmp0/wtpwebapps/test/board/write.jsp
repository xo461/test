<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 이곳을 실행했다는 처리내용 출력
System.out.println("글쓰기 처리 ---write.jsp");
// 1. 데이터를 받는다.
// 2. dto 객체를 만든다.
// 3. service 객체를 호출해서 DB에 데이터를 넣는다.

// 글쓰기가 끝나면 자동으로 list로 이동한다.
response.sendRedirect("list.jsp");
%>
