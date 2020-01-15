<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경하기</title>
</head>
<body>
	<form id="changePwForm" method="post" action="changePw.do">
		<div class="form-group">
			<label for="pw">새로운 비밀번호 : </label> <input type="password"
				class="form-control" id="pw" placeholder="Enter password"
				maxlength="20" required="required" pattern="^.{4,20}$"
				title="4-20이내의 글자 입력" name="pw" />
		</div>
		<!-- 			비밀번호 확인 입력 -->
		<div class="form-group">
			<label for="pw2">새로운 비밀번호확인 : </label> <input type="password"
				class="form-control" id="pw2" placeholder="비밀번호 확인" maxlength="20"
				required="required" pattern="^.{4,20}$" title="4-20이내의 글자 입력"
				name="pw2" />
		</div>
		<button class="btn btn-default" id="changeBtn">변경하기</button>
	</form>
	<div id="checkNewPw"></div>
	<script type="text/javascript">
$("#changePwForm").on("submit", function(){
	if($("#pw").val() != $("#pw2").val()){
		alert("비밀번호 확인이 일치하지 않습니다.");
		$("#pw").focus();
		return false;
	}
});

$(function(){
	// ajax load 메소드를 쓸 때 post로 넘길려면 json양식으로 서버에 데이터를 전송해야 한다.
	$("#changeBtn").on("click", function(event){
		event.preventDefault();
		var newPw = $("#pw").val();
		$("#checkNewPw").load("/ajax/checkNewPw.do", {pw: newPw}, function(data, status, jqXGR) {  // callback function 
			if(data.indexOf("없습니다.") != -1){
				$("#pw").focus(); 
				return false;
			} else {
				$("#changePwForm").submit();
			}
		});
	});
});
</script>
</body>

</html>