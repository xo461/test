<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
<!-- jquery lib는 default_decorator.jsp에서 등록 되어 있음. -->
<script type="text/javascript" src="/js/regExUtil.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<h1>글쓰기</h1>
<!--  많은 데이터를 넘길때 form -->


<form action="write.jsp"method="post">
<!--  input, select,textarea : 입력 항목 만들기 : 생략 -->
	제목 : <input name = "title"><br/>
	내용 : <textarea rows="5" cols="100" name="content"></textarea>
	<br/> 
	공지시작일 : <input name = "startDate"><br/>
	공지시작일 : <input name = "endDate"><br/>



<!-- 	button tag의 기본  type은 submit이다. 그래서 생략가능  -->
	<button>공지사항 등록</button>
	<button type="reset">다시입력</button>
<!-- 	버튼 기능만 사용하고 다른 동작은 하지 않도록 하는 타입  : button -->
<!-- 	동작을 따로 정의 onclick(클릭할때 동작 ) / history.back():이전 페이지로 이동 -->
	<button type="button" onclick = "history.back()">취소</button>
	
</form>
</body>
</html>