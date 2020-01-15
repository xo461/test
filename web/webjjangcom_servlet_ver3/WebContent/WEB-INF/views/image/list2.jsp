
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//여기가 자바입니다.
	// DB에서 데이터 가져오기 : [controller] - service - dao : List<BoardDTO>
	// 	Service service = Beans.getService("boardListService");
	// 	request.setAttribute("list", Execute.service(service, 1));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 리스트</title>
<!-- ↓ bootstrap lib는 default_decorator 사이트 메쉬에 등록 되어 있어서 주석 처리함.  -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!-- <script -->
<!-- 	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>

<!-- <script lang="javascript"> 아래것과 동일함. -->
<!-- <script> 아래것과 동일함. -->

<script type="text/javascript">
	$(function() {
		// 하나의 글을 선택(tr tag를 클릭(선택))하면 글번호를 받아내서 글보기로 보낸다. 
		// #은 아이디, .은 테그 
		$(".dataRow").click(function() {
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no 
					+ "&cnt=1"
					+ "&page=${pageObject.page}"
					+ "&perPageNum=${pageObject.perPageNum}"
					// el 객체에서 empty -> null || "" 체크 -> 데이터가 넘어오지 않았다.
					// el 객체에서 문자열 연결을 "+" 로 사용 불가능 => "+=" 로 사용한다.
					${(!empty pageObject.word)?
							" + \"&key=" += pageObject.key += "&word="
							+= pageObject.word += "\"":""}
					;
		});

		// 페이지 네이션의 클릭 이벤트 처리 
		$(".pagination > li:not('.active')").click(
				function() {
					// 		alert("페이지이동 클릭 ");
					// 		.data("page")==> 속성 중에서 data-page 라는 속성 값을 가져온다.
					var page = $(this).data("page");
					alert(page + "-" + typeof page);
					// 가져온 글자 중에서 > 포함이 되어 있는 경우의 처리 
					// 			// 마지막 페이지로 이동처리 
					// 			if(text.indexOf (">>") > -1){
					// 				page = ${pageObject.totalPage};
					// 			}else if(text.indexOf (">") > -1){
					// 			page = ${pageObject.endPage + 1};
					// 			//시작 페이지로 이동 처리 
					// 			}else if(text.indexOf ("<<") > -1){
					// 				page = 1;
					// 			// 이전 그룹의 마지막 페이지로 이동 처리 
					// 			}else if(text.indexOf ("<") > -1){
					// 				page = ${pageObject.startPage -1};

					// 			}else {
					// 				page = parseInt(text);
					// 			};
					location = "list.do?page=" + page
							+ "&perPageNum=${pageObject.perPageNum}"
							+ "&key=${pageObject.key}"
							+ "&word=${pageObject.word}";
					// a tag의 페이지 이동을 취소 시킨다. 
					return false;
				});
		
		$("li.active").click(function() {
			return false;
		});
		// 한페이지에 나타날 글의 갯수 변경 이벤트 처리
		$("#perPageRow").on({
			"change":function(){
// 				alert("change");
				perPageNum = $("#perPageRow").val();
				location="list.do?page=1"
					+ "&perPageNum=" + perPageNum
					+ "&key=${pageObject.key}"
					+ "&word=${pageObject.word}";
			}
		});

	});
</script>

</head>

<body>
	<div class="container">
		<h1>이미지 리스트</h1>
		<div id="searchDiv">
			<form action="list.do" class="form-inline">
				<input name="page" value="1" type="hidden"/>
				<input name="perPageNum" value="${pageObject.perPageNum }" type="hidden"/>
				<div class="form-group">
					 <select class="form-control" id="key" name="key">
						<option value="t" ${(param.key == "t")?"selected='selected'":""}>제목</option>
						<option value="c" ${(param.key == "c")?"selected='selected'":""}>내용</option>
						<option value="w" ${(param.key == "w")?"selected='selected'":""}>작성자</option>
						<option value="tc" ${(param.key == "tc")?"selected='selected'":""}>제목/내용</option>
						<option value="tw" ${(param.key == "tw")?"selected='selected'":""}>제목/작성자</option>
						<option value="cw" ${(param.key == "cw")?"selected='selected'":""}>내용/작성자</option>
						<option value="tcw" ${(param.key == "tcw")?"selected='selected'":""}>전체</option>
						
					</select>
				</div>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="word" value="${param.word }">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
				<div class="input-group right">
						<span class="input-group-addon">Rows/Page</span>
					  <select class="form-control" id="perPageRow">
					    <option ${(pageObject.perPageNum == 10)?"selected='selected'":"" }>10</option>
					    <option ${(pageObject.perPageNum == 15)?"selected='selected'":"" }>15</option>
					    <option ${(pageObject.perPageNum == 20)?"selected='selected'":"" }>20</option>
					    <option ${(pageObject.perPageNum == 25)?"selected='selected'":"" }>25</option>
					  </select>
				</div>
			</form>
		</div>
		
		<!-- 이미지 갤러리 리스트 작성  -->
		<div class="row">
		<!-- 데이터가 있는 만큼 반복문 처리 시작   -->
		    <c:forEach items="${list }" var="dto">
		    <!-- col시작 : no,title,id,writeDate,fileName -->
		    <div class="col-md-4 dataRow">
		      <div class="thumbnail">
		          <img src="${dto.fileName }" alt="Lights" style="width:100%">
		          <div class="caption">
		            <p><span class="no">${dto.no }</span>.${dto.title }</p>
					<p>${dto.id }(${dto.writeDate })
					</p>		          
		          </div>
		        </a>
		      </div>
		    </div>
		 	<!-- col의 끝 -->
		 	</c:forEach>
		<!-- 데이터가 있는 만큼 반복문 처리 끝  -->
		 </div>
		<!-- row 끝 -->
		
		<!-- 페이지 네비게이션 -->
		<div>
		
			<ul class="pagination">
				<li data-page=1><a href="#">&lt;&lt;</a></li>
				<c:if test="${pageObject.startPage > 1 }">
					<li data-page=${pageObject.startPage -1 }><a href="#">&lt;</a>
					</li>
				</c:if>
				<c:forEach begin="${pageObject.startPage }"
					end="${pageObject.endPage }" var="cnt">
					<li ${(pageObject.page == cnt)?"class=\"active\"":"" }
						data-page=${cnt }><a>${cnt}</a></li>
				</c:forEach>
				<c:if test="${pageObject.endPage < pageObject.totalPage }">
					<li data-page=${pageObject.endPage + 1}><a href="#">&gt;</a>
					</li>
				</c:if>
				<li data-page=${pageObject.totalPage }><a href="#">&gt;&gt;</a>
				</li>
			</ul>
		
		</div>
		<div>
		<!-- 버튼처리  -->
			<tr>
				<td colspan="5">
					<a href="writeForm.do"><button>글쓰기</button></a>
					<a href="list.do?page=1&perPageNum=${pageObject.perPageNum }"><button>전체목록</button></a>
				</td>
			</tr>
		</div>
		<table class="table">
			<!-- 테이블의 한줄 -->
			<!-- 항목의 제목 -->
			<tr>
				<th>글번호</th>
				<th>이미지</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				
			</tr>
			<!-- 데이터표시줄 : 데이터가 있는 만큼 반복 처리한다. -->
			<c:forEach items="${list }" var="dto">
				<tr class="dataRow">
					<td class="no">${dto.no }</td>
					<td><img src="${dto.fileName }"/></td>
					<td>${dto.title }</td>
					<td>${dto.id }</td>
					<td>${dto.writeDate }</td>
				</tr>
			</c:forEach>
			<!-- 페이지를 이동시키는 페이지네이션  -->
			<tr>
				<td colspan="5">
					<ul class="pagination">
						<li data-page=1><a href="#">&lt;&lt;</a></li>
						<c:if test="${pageObject.startPage > 1 }">
							<li data-page=${pageObject.startPage -1 }><a href="#">&lt;</a>
							</li>
						</c:if>
						<c:forEach begin="${pageObject.startPage }"
							end="${pageObject.endPage }" var="cnt">
							<li ${(pageObject.page == cnt)?"class=\"active\"":"" }
								data-page=${cnt }><a>${cnt}</a></li>
						</c:forEach>
						<c:if test="${pageObject.endPage < pageObject.totalPage }">
							<li data-page=${pageObject.endPage + 1}><a href="#">&gt;</a>
							</li>
						</c:if>
						<li data-page=${pageObject.totalPage }><a href="#">&gt;&gt;</a>
						</li>
					</ul>
				</td>

			</tr>

			<!-- 글쓰기 버튼 -->
			<tr>
				<td colspan="5">
					<a href="writeForm.do"><button>글쓰기</button></a>
					<a href="list.do?page=1&perPageNum=${pageObject.perPageNum }"><button>전체목록</button></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>











