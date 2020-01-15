<%@page import="com.webjjang.main.Service"%>
<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//여기가 자바입니다.
	// DB에서 데이터 가져오기 : [controller] - service - dao : List<BoardDTO>
	Service service = Beans.getService("noticeListService");
	request.setAttribute("list", Execute.service(service, 1));
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
		<h1>공지사항 리스트</h1>
		<table class="table">
			<!-- 테이블의 한줄 -->
			<!-- 항목의 제목 -->
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>공지시작일</th>
				<th>공지종료일</th>
				<th>최종수정일</th>
			</tr>
			<!-- 데이터표시줄 : 데이터가 있는 만큼 반복 처리한다. -->
			<C:forEach items="${list }" var="dto">
				<tr onclick="location='view.jsp?no=${dto.no}'" class="dataRow">
					<td>${dto.no }</td>
					<td>${dto.title }</td>
					<td>${dto.writeDate }</td>
					<td>${dto.startDate }</td>
					<td>${dto.endDate }</td>
					<td>${dto.updateDate }</td>
				</tr>
			</C:forEach>

			<!--  글쓰기 버튼  -->
			<tr>
				<td colspan="5"><a href="writeForm.jsp"><button>공지등록</button></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>











