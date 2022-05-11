<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/template.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stAsgBoard.css">
<%@page import="kh.semi.lms.asg.model.vo.AsgListVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>과제게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/ef09f998fc.js" crossorigin="anonymous"></script>  
  </head>
<body>

<jsp:include page="/WEB-INF/view/student/stHeader.jsp"/>

  <section id="template_content">
    <div class="template_container">
      <div class="template-title">
        <h1>공지사항</h1>
        <hr>
      </div>
      <div class="content_container">
        <!-- 템플릿 -->
        	<!-- 과제 게시판 -->
				<div class="board_div">
					<form id="multiDelete">
						<br><br>
						<table class="table table-striped">
							<tr>
								<td>번호</td>
								<td>제목</td>
								<td>작성자</td>
								<td>작성일</td>
							</tr>
							<c:if test="${not empty boardVolist }">
								<c:forEach items="${boardVolist}" var="vo">
									<tr style="cursor: pointer;">
										<td class="bANo">${vo.bANo }</td>
										<td class="read_list">${vo.bATitle }</td>
										<td>${vo.bAWriter }</td>
										<td>${vo.bADate }</td>
									</tr>
								</c:forEach>
							</c:if>
						</table>
					</form>
						
						<!-- 페이징 박스 -->
						<div id="pagingBox">
							<ul class="pagination justify-content-center">
								<!-- startPage에서 -1일 때 -->
								<c:if test="${ startPage > 1 }">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/st/asgboard?pageNum=${startPage-1}">Previous</a></li>
								</c:if>
								<c:if test="${ startPage <= 1 }">
									<li class="page-item disabled"><a class="page-link"
										href="<%=request.getContextPath()%>/st/asgboard?pageNum=${startPage-1}">Previous</a></li>
								</c:if>
								<c:forEach step="1" begin="${startPage }" end="${ endPage}"
									var="idx">
									<c:if test="${idx eq currentPage }">
										<li class="page-item active"><a class="page-link"
											href="<%=request.getContextPath()%>/st/asgboard?pageNum=${idx }">${idx }
										</a></li>
									</c:if>
									<c:if test="${idx ne currentPage }">
										<li class="page-item"><a class="page-link"
											href="<%=request.getContextPath()%>/st/asgboard?pageNum=${idx }">${idx }
										</a></li>
									</c:if>
								</c:forEach>
								<!-- endPage에서 +1일 때 -->
								<c:if test="${endPage < pageCnt }">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/st/asgboard?pageNum=${endPage+1}">next</a></li>
								</c:if>
								<c:if test="${endPage >= pageCnt }">
									<li class="page-item disabled"><a class="page-link"
										href="<%=request.getContextPath()%>/st/asgboard?pageNum=${endPage+1}">next</a></li>
								</c:if>
							</ul>
						</div>
				</div>
				<!-- 목록 탭 -->
						<div class="list-tap">
							<ul class="list-group list-group-flush">
							<!-- TODO: 강의 목록 클릭시 강의탭 열기 -->
								<li class="list-group-item"><a href="">강의 자료실</a></li>
								<li class="list-group-item"><a href="<%=request.getContextPath()%>/st/asgboard"">과제 게시판</a></li>
								<li class="list-group-item"><a href="">사용자 및 그룹</a></li>
					   		</ul>
						</div>

	
      </div>
  </section>
  <script>
  
  //제목 클릭하여 상세페이지 이동
			$(".read_list").click(function() {
				console.log(this);
				console.log($(this).parents("tr").children(".bANo").text());
				console.log($(this).prev().text());
				// 배열 선언
				/* var trArr = new Array(); */

				// 현재 클릭된 행

				//var ta = document.getElementById("readList").previousSibling.previousSibling;
				//var tdVal = ta.innerText;
				
				//var tdVal = $(this).prev().text();
				var tdVal = $(this).parents("tr").children(".bANo").text();
				console.log("클릭된 행의 값은?"+tdVal);
				location.href = "<%=request.getContextPath()%>/st/asgboard/read?bANo=" + tdVal;
			});
  
	</script>
</body>
</html>