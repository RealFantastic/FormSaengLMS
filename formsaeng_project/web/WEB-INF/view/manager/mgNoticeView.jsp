<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/notice.css">
<%@page import="kh.semi.notice.model.vo.NoticeVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeView</title>
<!--부트스트랩-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<!-- J쿼리 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<!-- 글자 -->
<link
	href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css"
	rel="stylesheet">
</head>

<body>
	<form id="boardFrm" action="<%=request.getContextPath()%>/board/insert"
		method="post"></form>

	<div class="body_div">
		<header class="logo_button">
			<div class="logoimg">
				<img src="./resources/images/fromsaenglogo.png"
					class="fromsaenglogo"> <img src="./resources/images/logo.png"
					class="logo">
			</div>

			<div class="button">
				<button type="button" class="btn btn-success">마이페이지</button>
				<button type="button" class="btn btn-success">LMS바로가기</button>
			</div>
		</header>
		<div class=title_search>
			<div class="title">공지사항</div>
			<div class="dropdown notice_search">
				<div class=drop_search>
					<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
						id="dropdownMenuLink" data-bs-toggle="dropdown"
						aria-expanded="false"> 전체 </a>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item" href="#">제목</a></li>
						<li><a class="dropdown-item" href="#">내용</a></li>
					</ul>
				</div class=drop_search>
				<div>
					<input class="form-control notice_input" list="datalistOptions"
						id="exampleDataList" placeholder="공지사항 검색">
				</div>
				<div class=drop_search>
					<button type="button" class="btn btn-secondary">검색</button>
				</div>
			</div>
		</div>
		<div class="table_div">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>
							<input type="checkbox">
						</th>
						<th scope="col">NO</th>
						<th scope="col">제목</th>
						<th scope="col">내용</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일자</th>
					</tr>
				</thead>
				<tbody>
					<%--<tr onclick="detailview(' no ')" data-속성(넣고싶은 이름) ex(data-boardno = '+<%=noticeList.get(0).getBoardNoticeTitle() %>')> --%>
					<c:forEach var="notice" items="${boardVolist}">
						<tr Class="nt_detail_list">
							<td><input type="checkbox"></td>
							<th scope="row" class="nno">${notice.boardNoticeNo }</th>
							<td>${notice.boardNoticeTitle }</td>
							<td>${notice.boardNoticeContent }</td>
							<td>${notice.boardNoticeWriter }</td>
							<td>${notice.boardNoticeDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true"
						class="Page_order">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link Page_order" href="#">1</a></li>
				<li class="page-item"><a class="page-link Page_order" href="#">2</a></li>
				<li class="page-item"><a class="page-link Page_order" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true" class="Page_order">&raquo;</span>
				</a></li>
			</ul>
		</nav>
		<div class="add_delete">
			<button type="button" id="nt_add_btn" class="btn btn-secondary">공지사항 추가</button>
			<button type="button" class="btn btn-secondary">공지사항 삭제</button>
		</div>
	</div>

	<script>
		/* 공지사항 추가 버튼 클릭 시 공지사항 등록하기 페이지로 이동 */
		$("#nt_add_btn").click(function() {
			location.href = "mgbinsert";
		})
		
		/* 공지사항 1건 클릭 시 공지사항 상세 페이지로 이동 */
		/* 강사님 도움 */
		$(".nt_detail_list").click(function() {
			console.log(this);
			console.log($(this));
			console.log($(this).children(".nno"));
			console.log($(this).children(".nno").text());
			var noticeNo = $(this).children(".nno").text();
		location.href = "mgbdetail?nno="+noticeNo;
		})
	</script>
</body>
</html>