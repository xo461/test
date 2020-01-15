<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 열람</title>
<style>
.left {
	width: 50%;
	float: left;
	box-sizing: border-box;
}

.right {
	width: 50%;
	float: right;
	box-sizing: border-box;
}

.mainDiv {
	padding: 50px;
}

tr {
	font-size: 20px;
}

.showing {
	display: block;
}

.select {
	display: none;
}

body {
	font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
		Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}

 button { 
 	all: unset; 
 	background-color: steelblue; 
 	color: white; 
 	padding: 5px 20px; 
 	border-radius: 5px; 
 	cursor: pointer; 
 }
.modal {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.modal__overlay {
	background-color: rgba(0, 0, 0, 0.6);
	width: 100%;
	height: 100%;
	position: absolute;
}

.modal__content {
	background-color: white;
	padding: 50px 100px;
	text-align: center;
	position: relative;
	border-radius: 10px;
	width: 50%;
	height: 50%;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px
		rgba(0, 0, 0, 0.23);
}

h1 {
	margin: 0;
}

.hidden {
	display: none;
}
</style>
</head>
<body>
	<div class="mainDiv">
		<div class="left">
			<img src="${dto.photo }" class="img-circle" width="60%">
			<p>프로필 사진</p>
		</div>
		<div class="right">
			<table class="table">
				<tr>
					<td>아이디</td>
					<td>${dto.id }</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>${dto.nickName }</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>${dto.addr }</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>${dto.email }</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>${dto.tel }</td>
				</tr>
				<tr>
					<td>상태</td>
					<td>${dto.stateName }</td>
					<td>
						<form class="changeStateForm" id="changeStateForm" method="post" action="changeState.do">
							<input type="hidden" value="${dto.id }" name="id"/>
						</form>
							<button class="btn btn-default" id="changeState">변경하기</button>
							<select class="form-control select" name="stateSelect" id="stateSelect"
								onchange="changeStateSelected()" form="changeStateForm">
								<option value='1'>정상</option>
								<option value='2'>휴면</option>
								<option value='4'>강퇴</option>
							</select>
					</td>
				</tr>
				<tr>
					<td>등급</td>
					<td>${dto.gradeName }</td>
					<td>
						<form class="changeGradeForm" id="changeGradeForm" method="post" action="changeGrade.do">
						<input type="hidden" value="${dto.id }" name="id"/>
						</form>
							<button class="btn btn-default"  id="changeGrade">변경하기</button>
							<select class="form-control select" name="gradeSelect" id="gradeSelect"
								onchange="changeGradeSelected()" form="changeGradeForm">
								<option value='1'>회원</option>
								<option value='5'>에디터</option>
								<option value='9'>관리자</option>
							</select>
					</td>
				</tr>
			</table>
			<button class="btn btn-default" id="toList">목록으로</button>
		</div>
	</div>
	<div class="modal hidden">
        <div class="modal__overlay"></div>
        <div class="modal__content">
            <h1>변경하시겠습니까?</h1>
            <div class="changeDiv"></div>
            <button class="modalAccept">변경하기</button>
            <button class="modalClose">취소</button>
        </div>
    </div>
	<script type="text/javascript">

		const changeState = document.querySelector("#changeState");
		const stateSelect = document.querySelector("#stateSelect");
		const changeGrade = document.querySelector("#changeGrade");
		const gradeSelect = document.querySelector("#gradeSelect");
		const modal = document.querySelector(".modal");
        const overlay = modal.querySelector(".modal__overlay");
        const modalClose = modal.querySelector(".modalClose");
        const modalAccept = modal.querySelector(".modalAccept");
        const changeDiv = modal.querySelector(".changeDiv");
        const toList = document.querySelector("#toList");
        var modalFormSelector = 0;
        
        toList.addEventListener("click", function(){
        	location.href = "list.do";
        });
        
        modalClose.addEventListener("click", closeModal);
        modalAccept.addEventListener("click", acceptModal);
        function acceptModal(){
			if(modalFormSelector == 1){
				var form = document.querySelector(".changeStateForm");
				form.submit();
			} else if(modalFormSelector == 2) {
				var form = document.querySelector(".changeGradeForm");
				form.submit();
			}
        	// 매개변수로 전달 받기.
        	closeModal();
        }
        
        function closeModal(){
        	modal.classList.add("hidden");
        }
        
		function changeStateSelected() {
			const stateSelected = stateSelect.options[stateSelect.selectedIndex].value;
			changeDiv.innerHTML = "<h2>" + "${dto.stateName}" + " ->" + stateSelect.options[stateSelect.selectedIndex].innerText + "</h2>";
			modal.classList.remove("hidden");
			modalFormSelector = 1;
		}
		function changeGradeSelected() {
			const gradeSelected = gradeSelect.options[gradeSelect.selectedIndex].value;
			changeDiv.innerHTML = "<h2>" + "${dto.gradeName}" + " ->" + gradeSelect.options[gradeSelect.selectedIndex].innerText + "</h2>";
			modal.classList.remove("hidden");
			modalFormSelector = 2;
		}

		changeState.addEventListener("click", function(event) {
			event.preventDefault();
			if (stateSelect.classList.contains('showing')) {
				stateSelect.classList.remove("showing");
				stateSelect.classList.add("select");
			} else {
				stateSelect.classList.remove("select");
				stateSelect.classList.add("showing");
			}
		});

		changeGrade.addEventListener("click", function(event) {
			event.preventDefault();
			if (gradeSelect.classList.contains('showing')) {
				gradeSelect.classList.remove("showing");
				gradeSelect.classList.add("select");
			} else {
				gradeSelect.classList.remove("select");
				gradeSelect.classList.add("showing");
			}
		});
		
	</script>
</body>
</html>