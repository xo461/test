<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>

<body>
	<div class="container">
		<h2>아이디 찾기</h2>
		<form action="findId.do" method="post">
				<div class="form-group">
					<label for="email">이메일 : </label> <input type="text"
						class="form-control" id="email" placeholder="Enter email"
						maxlength="20" required="required" pattern="^.{4,20}$"
						title="4-20이내의 글자 입력" name="email" />
				</div>
			<button type="submit" class="btn btn-default">아이디 찾기</button>
			</form>
			<hr/>
			<hr/>
			<form action="findPwForm.do" method="post">
				<div class="form-group">
				<label for="ID">아이디 : </label> <input type="text"
					class="form-control" id="id" placeholder="Enter ID" maxlength="20"
					required="required" pattern="^[A-Za-z][A-za-z0-9]{3,19}$"
					title="4-20영숫자, 맨 앞자는 영문자" name="id" />
				</div>
				<div class="form-group">
					<label for="email2">이메일 : </label> <input type="text"
						class="form-control" id="email2" placeholder="Enter email"
						maxlength="20" required="required" pattern="^.{4,20}$"
						title="4-20이내의 글자 입력" name="email2" />
				</div>
			<button type="submit" class="btn btn-default">비밀번호 찾기</button>
		</form>
		<hr/>
	</div>
</body>
</html>