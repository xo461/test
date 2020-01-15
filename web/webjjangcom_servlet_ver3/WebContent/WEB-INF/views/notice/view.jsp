<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지보기</title>
</head>
<body>
<h1>공지보기</h1>
<table class="table">
	<tbody>
		<tr>
			<th class="col-md-3">제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th class="col-md-3">제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th class="col-md-3">내용</th>
			<td><pre>${dto.content }</pre></td>
		</tr>
		<tr>
			<th class="col-md-3">공지기간</th>
			<td>${dto.startDate }~${dto.endDate }</td>
		</tr>
		<tr>
			<th class="col-md-3">등록일</th>
			<td>${dto.updateDate }</td>
		</tr>
		<tr>
			<td>
				<a href="updateForm.do?no=${param.no }"><button>수정</button></a>
				<a href="delete.do?no=${param.no }"><button>삭제</button></a>
				<a href="list.do"><button>목록</button></a>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>