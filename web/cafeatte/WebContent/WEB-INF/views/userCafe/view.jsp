<%@page import="com.cafeatte.member.dto.LoginDTO"%>
<%@page import="com.cafeatte.member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<title>UserCafe View</title>
<style type="text/css">
#userLike:hover {
	cursor: pointer;
}
#userLike{
	padding-right: 20px;
	color: black;
}
#title {
	font-size: 30px;
	text-align: center;
	padding-top: 100px;
	padding-bottom: 70px;
}

#info {
	font-size: 13px;
	text-align: left;
}

#info2 {
	text-align: right;
	font-size: 13px;
}

.infoDiv {
	padding-bottom: 0.1px;
}

#cafeimg {
	align-content: center;
	padding-bottom: 20px;
}

#content {
	text-align: center;
	font-size: 20px;
	padding-bottom: 20px;
	padding-top: 10px;
	font-family: inherit;
}

#buttons{
	padding-bottom: 50px;

}
</style>
<script type="text/javascript">
	$(function() {
		var check = 0; //좋아요 체크 안됨 0, 체크됨 1
		var no = '${param.no}';
		var id = "${login.id }";
		var LK=0;
		$("#deleteBtn").click(function() {
			if (!confirm("정말 삭제하시겠습니까?"))
				return false;
		});
		$(function(){
		LK="${result}";
		if (id==null){
				$("#userLike").attr("class", "far fa-heart");//빈하트
				$("#userLike").attr("style", "font-size:48px");//검정색		 		
		 	}
		 	else if (LK==0){ //로그인안했거나 좋아요한적없는상태
				$("#userLike").attr("class", "far fa-heart");//빈하트
				$("#userLike").attr("style", "font-size:48px");//검정색
				check=0;
			}else{//좋아요한적있는상태
				$("#userLike").attr("class", "fas fa-heart");//꽉찬하트
				$("#userLike").attr("style", "font-size:48px;color:red");//빨간색
				check=1;
			}});
			
		$("#userLike").click(function() {
			if (id == "") {
				alert("로그인이 필요한 서비스입니다.");
				location.href = "/member/loginForm.do";
			} else
				$("#userLike").load("/ajax/userLike.do", {
					no : no,
					id : id,
					vr : 1})
				if(check == 0){//좋아요안되어있었으니까
					check = 1;//좋아요클릭하고 
				$("#userLike").attr("class", "fas fa-heart");
				$("#userLike").attr("style", "font-size:48px;color:red");
				}else{//좋아요되어있었으니까
					check = 0;//좋아요취소
				$("#userLike").attr("class", "far fa-heart");
				$("#userLike").attr("style", "font-size:48px");
				};
		});
		
	});
</script>

</head>
<body>
	<div class="container">
		<div id="title">
			<span>${dto.title }</span>
		</div>
		<div class="container infoDiv">
			<div id="info" style="float: left;">
				<img alt="" src="${dto.photo}" style="width:40px;" class="img-circle" align="bottom">
				${dto.nickName } | ${dto.writeDate } | 글번호 ${dto.no } | 조회수
				${dto.hit }
			</div>
			<div id="info2" style="float: right;" >
				<!-- 좋아요기능 -->
				<i id="userLike">${dto.cntLike }</i>
			</div>
			
		</div>
		<hr>
		<div class="container">
			<div id="cafeimg" align="center">
				<img alt="" src="${dto.fileName }">
			</div>
			<div id="content">${dto.content }</div>

			<div id=buttons>
				<c:set var="logid" value="${login.id }"/>
				<c:set var="dtoid" value="${dto.id }"/>
				
				<!-- 자기 글일때만 글수정 보이기 -->
				<c:if test="${logid==dtoid}">
				<a href="updateForm.do?no=${dto.no }&cnt=0&page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}"><button>글수정</button></a>
				</c:if>
				
				<!-- 자기 글이거나 관리자일때만 글삭제 보이기 -->
				<c:if test="${logid==dtoid || logid==\"admin\"}">
				<a href="delete.do?no=${dto.no }&deleteFileName=${dto.fileName }&perPageNum=${param.perPageNum }" id="deleteBtn"><button>글삭제</button></a>
				</c:if>
				
				<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum }&key=${param.key }&word=${param.word}"><button>글목록</button></a>
				<a href="writeForm.do?perPageNum=${param.perPageNum }"><button>새글쓰기</button></a>
			</div>
		</div>

	</div>

</body>
</html>