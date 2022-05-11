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
				<a href="<%=request.getContextPath()%>/mg/main">
					<img src="<%=request.getContextPath()%>/resources/images/fromsaenglogo.png" class="fromsaenglogo"> 
				</a>
				<a href="<%=request.getContextPath()%>/mg/main">
					<img src="<%=request.getContextPath()%>/resources/images/name_logo.png"	class="logo">
				</a>
		</div>

		<!-- 폼태그는 가지고 갈 데이터 바로 앞에서 name이 꼭 필요함-->
		<form id="mgNoticeFrom"
			action="<%=request.getContextPath()%>/mg/notice/insert" method="post">
			<div class=title_search>
				<div class="title font5">공지사항 등록하기</div>
				<div class="button_enroll">
					<button type="submit" class="btn btn-primary" id="insertBtn">공지사항
						등록</button>
					<button type="button" id="nt_list_btn" class="btn btn-primary">공지사항 목록</button>
					<button type="reset" class="btn btn-primary">전체내용 삭제</button>
				</div>
			</div>


			<div class="mb-3 room">
				<div class="font4">제목</div>
					<input type="text" class="form-control title_box" id="formGroupExampleInput" name="title" placeholder="제목을 입력하세요." maxlength="50">
			</div>

			<div class="mb-3 room">
				<div class="form-group">
					<div class="font4">내용</div>
					<textarea class="form-control" name="content" rows="20" id="content" name="content" placeholder="내용을 입력하세요." maxlength="600"></textarea>
				</div>
			</div>
		</form>
	</div>
		<script>
		/* 공지사항 목록 버튼 클릭 시 발생하는 이벤트 =공지사항 리스트 페이지로 이동 */
		$("#nt_list_btn").click(function() {
			location.href = "<%=request.getContextPath()%>/mg/notice/list";
		})
		
		// 공지사항 등록 버튼을 클릭하면 발생하는 이벤트 = class"enroll_box"경우 제목과 내용 두군데라서 리스트 형식으로 나와서 안됨
		// id"floatingTextarea"(제목)"floatingTextarea2"(내용)은 각자 여서 가능함
		/* $("#insertBtn").click(function() {
			$("#floatingTextarea").val( $("#floatingTextarea").val().replace(/\r\n|\n/,"<br>") );
			//#floatingTextarea에 있는. 값을. 치환(이걸,이걸로)하여 #floatingTextarea에. 값으로 저장한다.
			$("#floatingTextarea2").val( $("#floatingTextarea2").val().replaceAll(/\r\n|\n/,"<br>") );
			
			//submit 하고 싶을때 작성한다.
			//여기에서는 버튼 스타일이 submit이 아니고 button여서 작성해줬다.
			$("#mgNoticeFrom").submit();
			//form id에. submit한다.
		}) */
	
		
		</script>
</body>
</html>