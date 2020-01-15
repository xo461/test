<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="tl" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>

<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>

<script type="text/javascript">
$(function() {
	$(".dataRow").click(function() {
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no
				+ "&cnt=1"
				+ "&page=${pageObject.page}"
				+ "&perPageNum=${pageObject.perPageNum}"
				${(!empty pageObject.word)?" + \"&key=" += pageObject.key += "&word="
					+= pageObject.word += "\"":""};
	});
	
	$(".pagination > li:not('.active')").click(
			function() {
				var page = $(this).data("page");
				alert(page + "-" + typeof page);
				
				location = "list.do?page=" + page
				+ "&perPageNum=${pageObject.perPageNum}"
				+ "&key=${pageObject.key}"
				+ "&word=${pageObject.word}";
				
				return false;
			});
	$("li.active").click(function() {
		return false;
	});
	
	$("#perPageRow").on({
		"change": function() {
			alert("change");
			perPageNum = $("perPageRow").val();
			location="list.do?page=1"
					+ "&perPageNum=" + perPageNum
					+ "&key=${pageObject.key}"
					+ "&word=${pageObject.word}";
		}
	});
});
</script>
</head>
<body>
	<div class="container">
		<h1>공지 사항</h1>
		<div class="row">
		<div id="searchDiv">
		<form action="list.do" class="form-inline">
		<input name="page" value="1" type="hidden"/>
		<div class="form-group">
		<select class="form-control" id="key" name="key">	
		<option value="t" ${(param.key == "t")?"selected='selected'":"" }>제목</option>
		<option value="c" ${(param.key == "c")?"selected='selected'":"" }>내용</option>
		<option value="tc" ${(param.key == "tc")?"selected='selected'":"" }>전체</option>
		</select>
</div>
<div class="input-group">
			<input type="text" class="form-control" placeholder="Search" name="word" value="${param.word }">
			<div class="input-group-btn">
				<button class="btn btn-default" type="submit">
					<i class="glyphicon glyphicon-search"></i>
				</button>
			</div>
		</div>
		<div class="input-group">
			<span class="input-group-addon">글개수/페이지</span>
			<select class="form-control" id="perPageRow">
				<option ${(pageObject.perPageNum == 10)?"selected'selected'":"" }>10</option>
				<option ${(pageObject.perPageNum == 15)?"selected'selected'":"" }>15</option>
				<option ${(pageObject.perPageNum == 20)?"selected'selected'":"" }>20</option>
				<option ${(pageObject.perPageNum == 25)?"selected'selected'":"" }>25</option>
			</select>
		</div>
		</form>
		</div>
		</div>
		<table class="table">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>공지시작일</th>
				<th>공지종료일</th>
				<th>최종수정일</th>
			</tr>
			<c:forEach items="${list }" var="dto">
	<tr class="dataRow">
		<td class="no">${dto.no }</td>
		<td>${dto.title }</td>
		<td>${dto.writeDate }</td>
		<td>${dto.startDate }</td>
		<td>${dto.endDate }</td>
		<td>${dto.updateDate }</td>
</tr>
</c:forEach>

<tr>
				<td colspan="5">
					<tl:pageNav  page="${pageObject.page }"
					 startPage="${pageObject.startPage }" endPage="${pageObject.endPage }" 
					 totalPage="${pageObject.totalPage }" />
				</td>
			</tr>
<tr>
	<td colspan="5">
				<c:if test="${login.grade==9 }">
		<a href="writeForm.do?perPageNum=${pageObject.perPageNum }"><button>공지등록</button></a>
				</c:if>
		<a href="list.do?page=1&perPageNum=${pageObject.perPageNum }"><button>전체목록</button></a>
		</td>
</tr>
</table>
</div>

</body>
</html>