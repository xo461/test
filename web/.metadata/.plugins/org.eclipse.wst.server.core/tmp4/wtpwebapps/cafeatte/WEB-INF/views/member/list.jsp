<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tl" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	$(function() {
// 		하나의 글을 선택 (tr tag를 클릭)하면 글 번호를 받아내서 글보기로 보낸다.
		$(".dataRow").click(function() {
			var id = $(this).find(".id").text();
			if (${(!empty pageObject.word)}){
				location = "adminView.do?id=" + id + "&cnt=1&page=${pageObject.page}&perPageNum=${pageObject.perPageNum }&key=${pageObject.key}&word=${pageObject.word }";
			}
			else{
				location = "adminView.do?id=" + id + "&cnt=1&page=${pageObject.page}&perPageNum=${pageObject.perPageNum }";
			}
		});
		// 페이지네이션의 클릭 이벤트 처리
		$(".pagination > li:not('.active')").click(
				function() {
					var page = $(this).data("page");
// 					alert(page + "-" + typeof page);
// 					alert("${pageObject.word }");
					if (${(!empty pageObject.word)}){
						location = "list.do?page="+ page + "&perPageNum=${pageObject.perPageNum }&key=${pageObject.key}&word=${pageObject.word }";
// 						alert(location);						
					}
					else{
						location = "list.do?page=" + page + "&perPageNum=${pageObject.perPageNum }";
					}
					// a tag의 페이지 이동을 취소
					return false;
				});

		$("li.active").click(function() {
			return false;
		});
		$("#perPageRow").on({
			"change":function(){
// 				alert("change");
				perPageNum = $("#perPageRow").val();
				location="list.do?page=1"
					+ "&perPageNum=" + perPageNum
					+ "&key=${pageObject.key}"
					+ "&word=${pageObject.word}";
			}
		});
		
		$("#searchSubmit").on({
			"submit":function(){
				location="list.do?page=1"
				+ "&perPageNum=${pageObject.perPageNum}"
				+ "&key=${pageObject.key}"
				+ "&word=${pageObject.word}";
			}
		});
	});
</script>

<style type="text/css">
/* 	li{ */
/* 		cursor: pointer; */
/* 	} */
</style>

<title>회원 리스트</title>
</head>
<body>
	<div class="container">
		<h1>회원 리스트</h1>
		<div id="searchDiv">
			<form class="form-inline" action="list.do">
			<input name="page" id="page" value="1" type="hidden"/>
				<div class="form-group"> 
					<select class="form-control" id="key" name="key">
						<option value="i" ${(param.key == "i")?"selected='selected'" : "" }>아이디</option>
						<option value="n" ${(param.key == "n")?"selected='selected'" : "" }>닉네임</option>
						<option value="in" ${(param.key == "in")?"selected='selected'" : "" }>아이디/닉네임</option>
					</select>
				</div>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search" name="word" value="${param.word }">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit" id="searchSubmit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
				<div class="input-group right">
						<span class="input-group-addon">Rows/Page</span>
					  <select class="form-control" id="perPageRow">
					    <option ${(pageObject.perPageNum == 10)?"selected='selected'":"" }>10</option>
					    <option ${(pageObject.perPageNum == 15)?"selected='selected'":"" }>15</option>
					    <option ${(pageObject.perPageNum == 20)?"selected='selected'":"" }>20</option>
					    <option ${(pageObject.perPageNum == 25)?"selected='selected'":"" }>25</option>
					  </select>
					</div>
			</form>
		</div>
		<table class="table">
			<tr>
				<th width="80">아이디</th>
				<th>닉네임</th>
				<th>주소</th>
				<th>이메일</th>
				<th>등급</th>
				<th>상태</th>
				<th>프로필사진</th>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr class="dataRow">
					<td class="id">${dto.id }</td>
					<td>${dto.nickName }</td>
					<td>${dto.addr }</td>
					<td>${dto.email }</td>
					<td>${dto.gradeName }</td>
					<td>${dto.stateName }</td>
					<td><img src="${dto.photo }"/></td>
				</tr>
			</c:forEach>
			<!-- 페이지를 이동시키는 페이지네이션 -->
			<tr>
				<td colspan="5">
					<tl:pageNav page="${pageObject.page }" startPage="${pageObject.startPage }" endPage="${pageObject.endPage }" totalPage="${pageObject.totalPage }"/>
				</td>
			</tr>
			<tr>
				<td><a href="http://localhost/main/index.jsp"><button
							type="button" class="btn btn-success">메인으로</button></a></td>
			</tr>
		</table>
	</div>
</body>
</html>