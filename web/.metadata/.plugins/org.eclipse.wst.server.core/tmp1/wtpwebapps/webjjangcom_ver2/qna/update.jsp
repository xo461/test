<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.qna.dto.QnaDTO"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 실행할 서비스를 받아온다.
Service service = Beans.getService("qnaUpdateService");

//이곳을 실행했다는 처리내용 출력
System.out.println("글 수정 처리 --- update.jsp");
// 한글처리 

request.setCharacterEncoding("utf-8");

//1. 데이터를 받는다.
int no = Integer.parseInt(request.getParameter("no"));
String title = request.getParameter("title");
String content = request.getParameter("content");

//2. dto객체를 만들고 데이터를 셋팅한다.
QnaDTO dto = new QnaDTO();
dto.setNo(no);
dto.setTitle(title);
dto.setContent(content);

//3. service객체를 호출해서 DB에 데이터를 수정한다. 
Execute.service(service, dto);

// 글수정이 끝나면 자동으로 view로 이동한다. 
response.sendRedirect("view.jsp?no="+dto.getNo()+"&cnt=0");
%>
