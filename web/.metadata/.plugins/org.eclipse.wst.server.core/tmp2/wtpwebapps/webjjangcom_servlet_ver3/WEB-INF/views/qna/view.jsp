<%@page import="com.webjjang.main.Service"%>
<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

Service service = Beans.getService("qnaViewService");
 

// 여기가 자바 부분입니다. 
// 글번호를 받는다. 
// 글번호와 조회수 1증가여부를 받는다. 글번호와 조회수
int no = Integer.parseInt(request.getParameter("no"));   
int cnt = Integer.parseInt(request.getParameter("cnt"));   
// Execute.service(글번호, 조회수 1증가)
request.setAttribute("dto", Execute.service(service, no, 1));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 답변 보기 </title>
<!-- Bootstrap 라이브러리 -->
</head>
<body>
<h1>질문답변 보기</h1>
<table class="table" >
<tr>
	<th>글번호</th><td>${dto.no }</td>
</tr>
<tr>	
	<th>제목</th><td>${dto.title }</td>
</tr>
<tr>
	<th>내용</th><td><pre>${dto.content }</pre></td>
</tr>
<tr>
	<th>이름[아이디]</th><td>${dto.name }[${dto.id }]</td>
</tr>
<tr>
	<th>조회수</th><td>${dto.hit }</td>
</tr>
<tr>
	<td colspan="2">	
		<a href ="answerForm.jsp"><button>답변하기</button></a>
		<a href ="updateForm.jsp?no=${dto.no }"><button>수정</button></a>
		<a href ="delete.jsp?no=${dto.no }"><button>삭제</button></a>
		<a href ="list.jsp"><button>목록</button></a>
	</td>
</tr>
</table>
</body>
</html>