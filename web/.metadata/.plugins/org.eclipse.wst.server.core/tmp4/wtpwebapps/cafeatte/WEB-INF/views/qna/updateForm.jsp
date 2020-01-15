<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문답변 글수정 폼</title>
<script type="text/javascript" src="/js/regExUtil.js"></script>
<style type="text/css">
.attachFile {
	display: none;
}
</style>

<script type="text/javascript">

	
	$("#writeForm").submit(function () {
		if(!inputDataCheck(title_RegEx, "#title", title_err_msg))
			return false;
	// 내용 
		if(!inputDataCheck(content_RegEx, "#content", content_err_msg))	
		return false; 
	// 작성자 
		if(!inputDataCheck(id_RegEx, "#id", id_err_msg))	
		return false;

		});
  


</script>
</head>
<body>
	<h1>질문답변 글수정</h1>
	<!--  많은 데이터를 넘길때 form -->
	<form action="update.do" method="post" id="writeForm">
		<input type="hidden" name="page" value="${param.page }"> 
		<input type="hidden" name="perPageNum" value="${param.perPageNum }">
		<input type="hidden" name="key" value="${param.key }"> 
		<input type="hidden" name="word" value="${param.word }">
		<input type="hidden" id="no" name="no" value="${dto.no }">
		<input type="hidden" id="refNo" name="refNo" value="${dto.refNo }">
		<input type="hidden" id="ordNo" name="ordNo" value="${dto.ordNo }">
		<input type="hidden" id="levNo" name="levNo" value="${dto.levNo }">
		<input type="hidden" id="parentNo" name="parentNo" value="${dto.parentNo }">
		<!--  input, select,textarea : 입력 항목 만들기 : 생략 -->
		<div class="form-group">
			<label for="title">번호(수정불가)</label> <input type="text"
				class="form-control" id="no" name="no" value="${dto.no }"
				readonly="readonly" />
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" id="title" name="title"
				title="제목은 4~100글자 사이로 입력하셔야 합니다." value="${dto.title }">
		</div>
		
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" rows="5" id="content" name="content">${dto.content }</textarea>
		</div>

		<button>수정</button>
		<button type="reset">다시입력</button>
		<button onclick="history.back()">취소</button>

	</form>
</body>
</html>
