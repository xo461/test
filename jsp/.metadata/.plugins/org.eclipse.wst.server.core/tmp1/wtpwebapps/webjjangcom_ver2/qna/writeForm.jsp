<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문답변 질문하기</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<h1>질문하기</h1>
<!--  많은 데이터를 넘길때 form -->
<form action="write.jsp"method="post">
<!--  input, select,textarea : 입력 항목 만들기 : 생략 -->
	작성자 :<input id="id" name = "id" value="${login.id }" disabled><br/>
	제목 : <input id="title" name="title"><br/>
	내용 : <textarea id="content" rows="5" cols="100" name="content"></textarea>
	<br/> 
<!-- 	button tag의 기본  type은 submit이다. 그래서 생략가능  -->
	<button type="submit" class="btn btn-default" onclick="location='/qna/write.jsp'">질문하기 등록</button>
	<button type="reset">다시입력</button>
<!-- 	버튼 기능만 사용하고 다른 동작은 하지 않도록 하는 타입  : button -->
<!-- 	동작을 따로 정의 onclick(클릭할때 동작 ) / history.back():이전 페이지로 이동 -->
	<button type="button" onclick = "history.back()">취소</button>
	
</form>
</body>
</html>