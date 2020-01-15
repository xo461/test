<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 폼</title>
<!-- jquery lib는 default_decorator.jsp에서 등록 되어 있음. -->
<script type="text/javascript" src="/js/regExUtil.js"></script>
<script type="text/javascript">
$(function () {
	//js 패턴 객체
// 	 title_RegEx = /^.{4,100}$/;
// 	 content_RegEx = /^.{5,1000}$/;
// 	 writer_RegEx =/^.{2,10}$/;
	
// 	// writeForm안에 데이터가 넘어 갈때(submit) 데이터 testing
	$("#writeForm").submit(function () {
// // 		alert("데이터가 넘어가기전 확인 함수.");
// 		//title 체크
// 		//앞뒤 공백 제거 trim()
// 		$("#title").val($("#title").val().trim());
// // 		alert("[" + $("#title").val()+"]");
// 		if(!title_RegEx.test($("#title").val())){
// 			//경고창을 띄운다.
// 			alert("제목은 4글자 이상 100글자 이내로 작성하셔야 합니다.");
// 			// 다시 제목을 입력 할 수 있도록 제목 입력란에 커서를 위치 시킨다. 
// 			$("#title").focus();
// 			return false;
// 		}
// 		//content 체크
// 		//앞뒤 공백 제거 trim()
// 		$("#content").val($("#content").val().trim());
// 		if(!content_RegEx.test($("#content").val())){
// 			//경고창을 띄운다.
// 			alert("제목은 4글자 이상 1000글자 이내로 작성하셔야 합니다.");
// 			// 다시 제목을 입력 할 수 있도록 제목 입력란에 커서를 위치 시킨다. 
// 			$("#content").focus();
// 			return false;
// 		}
// 		//writer 체크
// 		//앞뒤 공백 제거 trim()
// 		$("#writer").val($("#writer").val().trim());
// 		if(!writer_RegEx.test($("#writer").val())){
// 			//경고창을 띄운다.
// 			alert("작성자는 2글자 이상 10글자 이내로 작성하셔야 합니다.");
// 			// 다시 제목을 입력 할 수 있도록 제목 입력란에 커서를 위치 시킨다. 
// 			$("#writer").focus();
// 			return false;
// 		}
// 데이터 검사하는 regExUtil.js 파일 사용한 데이터 검사
// 제목 - 데이터가 유효하지않으면(!) 더이상 진행하지 않고 false를 리턴한다.
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
<form action="write.do"method="post" id="writeForm">
	<input type="hidden" name="page" value="${param.page }">
	<input type="hidden" name="perPageNum" value="${param.perPageNum }">
	<input type="hidden" name="key" value="${param.key }">
	<input type="hidden" name="word" value="${param.word }">
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
        <label for="writer">작성자</label>
<!--         입력한 데이터의 앞뒤 공백 문자 제거 (trim())
			 id, class : 화면 컨트롤을 위해서(빠른 선택),name : 넘어가는 데이터이름   -->
<!--         <input type="text" class="form-control" id="writer"  -->
<!--         	   name="writer" required="required" pattern="^.{2,10}$" -->
<!--         		title= "작성자은 4~10글자 사이로  입력하셔야 합니다."> -->
        <input type="text" class="form-control" id="writer" 
        	   name="writer" title= "작성자은 4~10글자 사이로  입력하셔야 합니다.">
    </div>

        <button type="submit"class="btn btn-default">게시판 등록하기</button>
        <button type="reset">다시입력</button>
        <button onclick = "history.back()">게시판 등록 취소하기</button>
  </form>
  </div>
</body>
</html>