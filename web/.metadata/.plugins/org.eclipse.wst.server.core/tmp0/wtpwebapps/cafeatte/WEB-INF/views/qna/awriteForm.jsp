<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변 쓰기 폼</title>
<!-- jquery lib는 default_decorator.jsp에서 등록 되어 있음. -->
<script type="text/javascript" src="/js/regExUtil.js"></script>
<script type="text/javascript">
$(function () {

	
	$("#awriteForm").submit(function () {
		
//제목		
	if(!inputDataCheck(title_RegEx, "#title", title_err_msg))
		return false;

// 내용 
	if(!inputDataCheck(content_RegEx, "#content", content_err_msg))	
	return false; 
// 작성자 
	if(!inputDataCheck(id_RegEx, "#id", id_err_msg))	
	return false;

	});

});
</script>

</head>
<body>

<h1>질문 글 보기</h1>
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
	<th>작성자</th><td>${dto.id }</td>
</tr>

<tr>
	<th>작성일</th><td>${dto.writeDate }</td>
</tr>

</table>
<div class="container">
<h1>답변 쓰기</h1>
<!-- url 작성시 *.do : spring 3.1까지의 기본 url에 *.do pattern 기본으로 사용. -->
<!--  많은 데이터를 넘길때 form -->
<form action="answer.do"method="post" >
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
        <label for="title">답변 제목</label>
        <input type="text" class="form-control" id="title" 
        		name="title" title= "제목은 4~100글자 사이로 입력하셔야 합니다.">
    </div>
 
  
    <div class="form-group">
  		<label for="content">답변 내용</label>
  		<textarea class="form-control" rows="10" id="content"
  		name="content" ></textarea>
    </div>
    
  
        <button>등록</button>
        <button type="reset">다시입력</button>
        <button onclick = "history.back()">등록 취소하기</button>
  </form>
  </div>
</body>
</html>