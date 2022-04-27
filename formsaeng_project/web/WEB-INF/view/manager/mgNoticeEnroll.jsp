<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/notice.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeEnroll</title>
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

	<div class="body_div">
		<div class="logoimg_enroll">
			<img src="./resources/images/fromsaenglogo.png" class="fromsaenglogo">
			<img src="./resources/images/logo.png" class="logo">
		</div>

		<!-- 폼태그는 가지고 갈 데이터 바로 앞에서 name이 꼭 필요함-->
		<form id="mgNoticeFrom"
			action="<%=request.getContextPath()%>/mgbinsert" method="post">
			<div class=title_search>
				<div class="title">공지사항 등록하기</div>
				<div class="button_enroll">
					<button type="submit" class="btn btn-primary" id="insertBtn">공지사항
						등록</button>
					<button type="button" id="nt_list_btn" class="btn btn-primary">공지사항 목록</button>
					<button type="reset" class="btn btn-primary">전체내용 삭제</button>
				</div>
			</div>

			<div class="mb-3 room">
				<div class="font4">제목</div>
				<div class="form-floating">
					<textarea class="form-control enroll_box" name="title"
						placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					<label for="floatingTextarea">제목을 입력하세요.</label>
				</div>
			</div>
			<div class="mb-3 room">
				<div class="font4">내용</div>
				<div class="form-floating">
					<textarea class="form-control enroll_box" name="content"
						placeholder="Leave a comment here" id="floatingTextarea2"
						style="height: 300px"></textarea>
					<label for="floatingTextarea2">내용을 입력하세요.</label>
				</div>
			</div>
		</form>
	</div>
		<script>
		/* 공지사항 목록 버튼 클릭 시 공지사항 리스트 페이지로 이동 */
		$("#nt_list_btn").click(function() {
			location.href = "mgblist";
		})
		</script>
</body>
</html>