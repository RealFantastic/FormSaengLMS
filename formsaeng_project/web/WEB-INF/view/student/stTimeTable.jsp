<link href="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/core/main.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/daygrid/main.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/core/main.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/daygrid/main.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/interaction/main.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/core/main.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/daygrid/main.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/interaction/main.min.js"></script>
<!-- <link href='node_modules/@fullcalendar/core/main.css' rel='stylesheet' /> -->
<!-- <link href='node_modules/@fullcalendar/timegrid/main.css' rel='stylesheet' /> -->
<link href="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/timegrid/main.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/timegrid/main.js"></script>
<!-- <script src='fullcalendar/resource-common/main.js'></script> -->
<!-- <script src='fullcalendar/resource-daygrid/main.js'></script> -->
<!-- <script src='fullcalendar/resource-timegrid/main.js'></script> -->

<script src="https://unpkg.com/popper.js/dist/umd/popper.min.js"></script>
<script src="https://unpkg.com/tooltip.js/dist/umd/tooltip.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/template.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/calendar.css">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- FullCalendar -->
<script>
	//시간표 띄움
	document.addEventListener('DOMContentLoaded', function() {
	var calendar=document.getElementById('timetable');
	var calendar = new FullCalendar.Calendar(calendar, {
		 plugins: [ 'timeGrid' ],
		 defaultView: 'timeGridWeek'
	});
	calendar.render();
});
	
</script>


<title>강의 시간표</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link
	href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css"
	rel="stylesheet">
<!-- 폰트어썸 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/ef09f998fc.js"
	crossorigin="anonymous"></script>
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

</head>

<body>
	<header id="sideBar">
		<div class="side_container">
			<a href="./semitest.html" id="logo"><img
				src="<%=request.getContextPath()%>/resources/images/fromsaenglogo.png"
				alt="폼생대로고"></a> <a href="./semitest.html" id="uni_name"><img
				src="<%=request.getContextPath()%>/resources/images/name_logo.png"
				alt="폼생대학교"></a>
			<hr>
			<ul class="list_button">
				<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
							width="22" height="22" fill="currentColor"
							class="bi bi-grid-3x2-gap-fill" viewBox="0 0 16 16">
              <path
								d="M1 4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V4zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V4zM1 9a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V9zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V9zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V9z" />
            </svg> Dashboard
				</a></li>
				<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
							width="22" height="22" fill="currentColor" class="bi bi-envelope"
							viewBox="0 0 16 16">
              <path
								d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z" />
            </svg> Message
				</a></li>
				<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
							width="22" height="22" fill="currentColor" class="bi bi-book"
							viewBox="0 0 16 16">
              <path
								d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z" />
            </svg> Subject
				</a></li>
				<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
							width="22" height="22" fill="currentColor" class="bi bi-alarm"
							viewBox="0 0 16 16">
              <path
								d="M8.5 5.5a.5.5 0 0 0-1 0v3.362l-1.429 2.38a.5.5 0 1 0 .858.515l1.5-2.5A.5.5 0 0 0 8.5 9V5.5z" />
              <path
								d="M6.5 0a.5.5 0 0 0 0 1H7v1.07a7.001 7.001 0 0 0-3.273 12.474l-.602.602a.5.5 0 0 0 .707.708l.746-.746A6.97 6.97 0 0 0 8 16a6.97 6.97 0 0 0 3.422-.892l.746.746a.5.5 0 0 0 .707-.708l-.601-.602A7.001 7.001 0 0 0 9 2.07V1h.5a.5.5 0 0 0 0-1h-3zm1.038 3.018a6.093 6.093 0 0 1 .924 0 6 6 0 1 1-.924 0zM0 3.5c0 .753.333 1.429.86 1.887A8.035 8.035 0 0 1 4.387 1.86 2.5 2.5 0 0 0 0 3.5zM13.5 1c-.753 0-1.429.333-1.887.86a8.035 8.035 0 0 1 3.527 3.527A2.5 2.5 0 0 0 13.5 1z" />
            </svg> Timetable
				</a></li>
				<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
							width="22" height="22" fill="currentColor"
							class="bi bi-calendar-week" viewBox="0 0 16 16">
              <path
								d="M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-5 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z" />
              <path
								d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
            </svg> Calendar
				</a></li>
			</ul>
		</div>

	</header>

	<section id="template_content">
		<div class="template_container">
			<div class="template-title">
				<h1>강의시간표</h1>
				
				<hr>
			</div>
			<div class="content_container">

				<!-- 템플릿 -->
				<div class="row">
					<!-- <button type="button" id="cal_add_btn" class="btn btn-primary">학사일정 등록</button> -->
					<div id="timetable" class="time"></div>

					<div class="modal fade bs-example-modal-sm" tabindex="-1"
						role="dialog" aria-labelledby="mySmallModalLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">...</div>
						</div>
					</div>

					<!-- modal 추가 -->
					<div class="modal fade" id="calendarModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="taskId" class="col-form-label">일정 내용</label> <input
											type="text" class="form-control" id="calendar_content"
											name="calendar_content"> <label for="taskId"
											class="col-form-label">시작 날짜</label> <input type="date"
											class="form-control" id="calendar_start_date"
											name="calendar_start_date"> <label for="taskId"
											class="col-form-label">종료 날짜</label> <input type="date"
											class="form-control" id="calendar_end_date"
											name="calendar_end_date">
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-warning" id="addCalendar">추가</button>
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal" id="sprintSettingModalClose">취소</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>