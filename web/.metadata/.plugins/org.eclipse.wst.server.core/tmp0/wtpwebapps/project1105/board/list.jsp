<%@page import="com.webjjang.board.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.webjjang.board.service.BoardListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//DB 데이터 가져오기 
	BoardListService service = new BoardListService();
	List<BoardDTO> list = service.service();
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
		<h1>게시판 리스트</h1>
		<table class="table">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<C:forEach items="${list }" var="dto">
				<tr onclick="location='view.jsp'" class="dataRow">
					<td>${dto.no }</td>
					<td>${dto.title }</td>
					<td>${dto.writer }</td>
					<td>${dto.writeDate }</td>
					<td>${dto.hit }</td>
				</tr>
			</C:forEach>
			<tr>

				<td colspan="4"><a href="writeForm.jsp"><button type="button" class="btn btn-primary">글쓰기</button></a>
					<a href="updateForm.jsp"><button type="button" class="btn btn-primary">글수정</button></a> <a
					href="delete.jsp"><button type="button" class="btn btn-primary">글삭제</button></a></td>
			
			</tr>
		
		</table>
	</div>
</body>
</html>


