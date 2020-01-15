<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매거진 쓰기 폼</title>
<!-- jquery lib는 default_decorator.jsp에서 등록 되어 있음. -->
<script type="text/javascript" src="/js/regExUtil.js"></script>
<script type="text/javascript">
$(function () {

	
	$("#writeForm").submit(function () {
		alert($("#fileName").val());
	if(!inputDataCheck(title_RegEx, "#title", title_err_msg))
		return false;

// 내용 
	if(!inputDataCheck(content_RegEx, "#content", content_err_msg))	
	return false; 
// 작성자 
	if(!inputDataCheck(writer_RegEx, "#writer", writer_err_msg))	
	return false;

	});

});
</script>

</head>
<body>
<div class="container">
<h1>글쓰기</h1>
<!-- url 작성시 *.do : spring 3.1까지의 기본 url에 *.do pattern 기본으로 사용. -->
<!--  많은 데이터를 넘길때 form -->
<form action="write.do"method="post" id="writeForm" 
enctype="multipart/form-data">
	<input name="perPageNum" value="${param.perPageNum }" type="hidden">

<!--  input, select,textarea : 입력 항목 만들기 : 생략 -->
    <div class="form-group">
        <label for="title">제목</label>
<!--         입력한 데이터의 앞뒤 공백 문자 제거 (trim())
			 id, class : 화면 컨트롤을 위해서(빠른 선택),name : 넘어가는 데이터이름   -->
<!--         <input type="text" class="form-control" id="title"  -->
<!--         		placeholder="제목을 입력하세요" name="title" -->
<!--         		required="required" pattern="^.{4,100}$" -->
        <input type="text" class="form-control" id="title" 
        		name="title" title= "제목은 4~100글자 사이로 입력하셔야 합니다.">
    </div>
    
    <div class="form-group">
  		<label for="content">내용</label>
<!--   		<textarea class="form-control" rows="10" id="content" -->
<!--   		name="content" required="required" ></textarea> -->
  		<textarea class="form-control" rows="10" id="content"
  		name="content" ></textarea>
    </div>
    
    <div class="form-group">
        <label for="fileName">첨부파일</label>
        <input type="file" class="form-control" id="fileName" 
        	   name="fileName" required="required">
    </div>

        <button>등록</button>
        <button type="reset">다시입력</button>
        <button onclick = "history.back()">등록 취소하기</button>
  </form>
  </div>
</body>
</html>