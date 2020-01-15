
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
<title>매거진 리스트</title>
<style type="text/css">


.dataRow:hover {
	background: #eee;
	cursor: pointer;
}

.dataRow2:hover {
	background: #eee;
	cursor: pointer;

}
.img-rounded{
width:270px;
height: 270px;
}
.thumbnail{
width: 175px;
height: 175px;
}


</style>
 
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
							+= pageObject.word += "\"":""};
		});
		
	$(function() {
		// 하나의 글을 선택(tr tag를 클릭(선택))하면 글번호를 받아내서 글보기로 보낸다. 
		// #은 아이디, .은 테그 
		$(".dataRow2").click(function() {
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no 
					+ "&cnt=1"
				
		});

		// 페이지 네이션의 클릭 이벤트 처리 
		$(".pagination > li:not('.active')").click(
				function() {
					
					var page = $(this).data("page");
					alert(page + "-" + typeof page);
				
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
	});

</script>

</head>

<body>

  <div >
<h2> 추천 매거진 리스트 </h2>
	
		<!-- 매거진  메인 리스트 작성  -->
		<span class="row">
		<!-- 데이터가 있는 만큼 반복문 처리 시작   -->
		    <c:forEach items="${mlist }" var="dto">
		    <!-- col시작 : no,title,id,writeDate,fileName -->
		    <div class="col-md-4" align="center">
		      <div class="dataRow2" style="max-width: 300px" align="center">
		        <div align="left"> 조회수 : ${dto.hit }</div>
		          <img src="${dto.fileName }" class="img-rounded" alt="Lights" > 
		          <div class="caption">
		          <p><span class="no" style="display: none;">${dto.no }</span></p>
		            <b>${dto.title }</b> <br> 
		            ${dto.subTitle }
					<p>(${dto.startDate })(${dto.endDate })</p>
					  	        
		          </div>
		    
		      </div>
		    </div>
		 	<!-- col의 끝 -->
		 	</c:forEach>
		<!-- 데이터가 있는 만큼 반복문 처리 끝  -->
		 </span>
	</div>	
	
	
	<div>
		<hr><hr>
		<h2>매거진 리스트 </h2>
		<span class="row" align="center">
		<!-- 데이터가 있는 만큼 반복문 처리 시작   -->
		    <c:forEach items="${list }" var="dto">
		    <!-- col시작 : no,title,id,writeDate,fileName -->
		    <div class="col-md-2 dataRow" align="center">
		      <div align="center">
		          <img src="${dto.fileName }" class="thumbnail" alt="Lights" width=100% >
		          <div class="caption">
		            <p><span class="no" style="display: none;">${dto.no }</span></p>
		           <b>${dto.title }</b><br>
		            ${dto.subTitle }
					<p style="display: none;">${dto.id }(${dto.writeDate })
					</p>		          
		          </div>
		    
		      </div>
		    </div>
		 	<!-- col의 끝 -->
		 	</c:forEach>
		<!-- 데이터가 있는 만큼 반복문 처리 끝  -->
		 </span>
		<!-- row 끝 -->
		
		<div>
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
					    <option ${(pageObject.perPageNum == 12)?"selected='selected'":"" }>12</option>
					    <option ${(pageObject.perPageNum == 15)?"selected='selected'":"" }>15</option>
					    <option ${(pageObject.perPageNum == 20)?"selected='selected'":"" }>20</option>
					    <option ${(pageObject.perPageNum == 25)?"selected='selected'":"" }>25</option>
					  </select>
				</div>
			</form>
		</div>
	</div>
</div>		
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
		
		<!-- 버튼처리  -->
		<div>

			<tr>
				<td colspan="5">
					<a href="writeForm.do"><button>글쓰기</button></a>
					<a href="list.do?page=1&perPageNum=${pageObject.perPageNum }"><button>전체목록</button></a>
				</td>
			</tr>	
		</div>
		
</body>
</html>










