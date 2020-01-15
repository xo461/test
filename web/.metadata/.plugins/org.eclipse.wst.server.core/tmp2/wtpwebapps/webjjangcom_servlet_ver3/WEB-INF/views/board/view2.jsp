<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<% 
// Service service = Beans.getService("boardViewService");
 

// 여기가 자바 부분입니다. 
// 글번호를 받는다. 
// 글번호와 조회수 1증가여부를 받는다. 글번호와 조회수
// int no = Integer.parseInt(request.getParameter("no"));   
// int cnt = Integer.parseInt(request.getParameter("cnt"));   
// // Execute.service(글번호, 조회수 1증가)
// request.setAttribute("dto", Execute.service(service, no, cnt));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 보기 </title>

<style type="text/css">
	.updateDiv{display: none;}
</style>

<script type="text/javascript">
$(function() {
	// 삭제 버튼 이벤트 처리
	$("#deleteBtn").click(function () {
		if(!confirm("정말 삭제 하시겠습니까?"))
		return false; // a tag의 href를 취소 시킨다. -> location.href를 변경하는 태그 a
	});
	
	$(".updateBtns").click(function () {
		$(".updateDiv").hide();
		$(this).parent().next().show();
	});
});
</script>

<!-- Bootstrap 라이브러리 -->
</head>
<body>
<h1>게시판 보기</h1>
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
	<th>작성자</th><td>${dto.writer }</td>
</tr>
<tr>
	<th>작성일</th><td>${dto.writeDate }</td>
</tr>
<tr>
	<th>조회수</th><td>${dto.hit }</td>
</tr>
<tr>
	<td colspan="2">	
		<a href ="updateForm.do?no=${dto.no }&page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}"><button>수정</button></a>
		<a href ="delete.do?no=${dto.no }" id="deleteBtn"><button>삭제</button></a>
		<a href ="list.do?page=${param.page }&perPageNum=${param.perPageNum }&key=${param.key }&word=${param.word}"><button>목록</button></a>
	</td>
</tr>
<tr>
	<td colspan="2">
		<h3>댓글</h3>
		<hr/>
		<!-- 댓글 쓰기 폼 -->
		<div>
		
		<form action="replyWrite.do" method="post">
			<input name="no" type="hidden" value="${dto.no }" />
			<input name="page" type="hidden" value="${param.page }" />
			<input name="perPageNum" type="hidden" value="${param.perPageNum }" />
		    <div class="form-group">
		      <label for="content">내용</label>
		      <textarea class="form-control" rows="2" id="content"
		       name="content"></textarea>
		    </div>
		    <div class="form-group">
			  <label for="writer">작성자</label>
			  <input type="text" class="form-control" id="writer" name="writer">
			</div>
			<button>달기</button>
		 
		  </form>
		</div>
		<!-- 댓글 리스트 -->
		<div>
		<div id="replyList"></div>
			<c:if test="${empty replyList }">댓글이 존재하지 않습니다.</c:if>
			<c:if test="${!empty replyList }">
				<ul class="list-group">
					<c:forEach var = "dto" items="${replyList }">
					  <li class="list-group-item" data-rno="${dto.rno }">
					  	<h4>${dto.writer }(${dto.writeDate })</h4>
					  	${dto.content }
					  	<span class="badge btn-group" style="background: white">
						   
						   <button type="button" 
						   class="btn btn-primary updateBtns">수정</button>
						   <button type="button" class="btn btn-warning">삭제</button>
					  		
					  	</span>
					  	<div class="updateDiv">
					  		<form action="boardReplyUpdate.do" method="post">
					  			<input name="rno" value="${dto.rno }" type="hidden"/>
					  			<textarea rows="2" class="form-control" 
					  			name="content">${dto.content }</textarea>
					  			<button>수정</button>
					  		</form>
					  	</div>
					  </li>
					</c:forEach>
				</ul>
			</c:if>
		</div>

</table>
</body>
</html>