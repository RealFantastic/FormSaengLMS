<%@page import="kh.semi.notice.model.vo.NoticeVo"%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/notice.css">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeDetail</title>
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
<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
</head>

<body>
	<!-- 폼태그는 가지고 갈 데이터(값) 바로 앞에서 name이 꼭 필요함-->
	<form id="mgNoticeFrom" action="mgbupdate" method="post">
		<div class="body_div">
			<div class="logoimg_enroll">
				<img src="<%=request.getContextPath()%>/resources/images/fromsaenglogo.png" class="fromsaenglogo">
				<img src="<%=request.getContextPath()%>/resources/images/name_logo.png" class="logo">
			</div>

			<div class=title_search>
				<div class="title font5">공지사항 상세보기</div>
				<div class="button_enroll">
					<button type="button" class="btn btn-primary" id="updateBtn">공지사항 수정</button>
					<button type="button" id="nt_list_btn" class="btn btn-primary">공지사항 목록</button>
				</div>
			</div>

			<div class="mb-3 room">
				<%NoticeVo list = (NoticeVo) request.getAttribute("ssnoticeVo");%>
				<!-- MgNoticeDetailServlet에 저장된 ssnoticevo 를 가져옴 -->

				<input type="hidden" id="nno" value="<%=list.getBoardNoticeNo()%>">
				<!-- hidden:숨겨놓은창 -->

				<div class="font4">제목</div>
				<div class="form-floating">
					<div class="notice_detail_title" name="title">
						<%=request.getAttribute("detailtitle")%>
					</div>
				</div>
			</div>
			<div class="mb-3 room">
				<div class="font4">내용</div>
				<div>
					<div class="notice_detail_content" name="content">
						<pre class="font2"><%=request.getAttribute("detailcontent")%></pre>
					</div>
				</div>
			</div>
	</form>

	</div>



	<script>
		/* 공지사항 목록 버튼 클릭 시 공지사항 리스트 페이지로 이동 */
		$("#nt_list_btn").click(function() {
			location.href = "<%=request.getContextPath()%>/mg/notice/list";
		})
		/* 공지사항 수정 버튼 클릭 시 공지사항 수정 페이지로 이동 */
		$("#updateBtn").click(function() {
			var nno = $("#nno").val(); /* var nno에 input id=nno에 값(val)을 가져옴 */
			console.log(nno);
			location.href = "<%=request.getContextPath()%>/mg/notice/update?nno=" + nno; // mgbupdate로 갈때 위 var nno를 같이 데리고 감
		})
	</script>
</body>
</html>