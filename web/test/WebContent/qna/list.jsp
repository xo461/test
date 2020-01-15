<%@page import="com.webjjang.qna.dto.QnaDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.webjjang.qna.service.QnaListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//여기가 자바입니다.
	// DB에서 데이터 가져오기 : [controller] - service - dao : List<BoardDTO>
	QnaListService service = new QnaListService();
	List<QnaDTO> list = service.service();
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>
</head>

<body>
	<div class="container">
		<h1>질문답변 리스트</h1>
		<table class="table">
			<!-- 테이블의 한줄 -->
			<!-- 항목의 제목 -->
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>아이디</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!-- 데이터표시줄 : 데이터가 있는 만큼 반복 처리한다. -->
			<C:forEach items="${list }" var="dto">
				<tr onclick="location='view.jsp'" class="dataRow">
					<td>${dto.no }</td>
					<td>${dto.title }</td>
					<td>${dto.id }</td>
					<td>${dto.name }</td>
					<td>${dto.writeDate }</td>
					<td>${dto.hit }</td>
				</tr>
			</C:forEach>

			<!--  글쓰기 버튼  -->
			<tr>
				<td colspan=6"><a href="writeForm.jsp"><button>글쓰기</button></a>
					<a href="updateForm.jsp"><button>글수정</button></a> <a
					href="delete.jsp"><button>글삭제</button></a></td>
			</tr>
		</table>
	</div>
</body>
</html>











