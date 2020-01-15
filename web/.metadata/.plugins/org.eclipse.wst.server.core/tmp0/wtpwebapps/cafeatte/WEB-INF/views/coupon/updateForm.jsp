<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap 라이브러리 등록 : CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<title>쿠폰 수정하기</title>
<script>
	$(function() {
		$("#endDate").datepicker({
			changeMonth : true,
			changeYear : true
		});
		$("#endDate").datepicker("option", "dateFormat", "yy-mm-dd");
	});
</script>
</head>

<body>
	<div class="container">
		<h2>쿠폰 수정하기</h2>
		<form action="update.do" method="post" id="updateForm" enctype="multipart/form-data">
		<input type="hidden" name="fileName" value="${dto.fileName }"/>
		<input type="hidden" name="cno" value="${dto.cno}"/>
			<div class="form-group">
				<label for="title">쿠폰 제목 : </label> <input type="text"
					class="form-control" id="title" placeholder="Enter title" maxlength="30"
					required="required" name="title" autocomplete="off" value="${dto.title }"/>
			</div>
			<div class="form-group">
				<label for="content">쿠폰 내용 : </label> 
				<textarea name="content" rows="20" cols="50">${dto.content }</textarea>
			</div>

			<div class="form-group">
				<label for="multiFile">이미지 첨부</label> 
				<input type="file" name="upPhoto" class="form-control" id="upPhoto"/><br/>
			</div>

			<div class="form-group">
				<label for="cafe_no">카페 번호</label> 
				<input type="text" name="cafe_no" class="form-control" id="cafe_no" value="${dto.cafe_no }"/><br/>
			</div>
			<div class="form-group">
				<label for="endDate">만료일</label> 
				<input type="text" name="endDate" class="form-control" id="endDate" value="${dto.endDate }" autocomplete="off"/><br/>
			</div>

			<button class="btn btn-default">수정하기</button>
			<button class="btn btn-default" id="cancleBtn">취소</button>
		</form>
	</div>
	<script type="text/javascript">
	function handleCancleBtn(){
		const cancleBtn = document.querySelector("#cancleBtn");
		cancleBtn.addEventListener("click", function(event) {
			event.preventDefault();
			location = "view.do";
		});		
	}
	
	function init(){
		handleCancleBtn();
	}
	init();
	</script>
</body>
</html>