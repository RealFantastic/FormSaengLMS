<%@page import="kh.semi.lms.calendar.vo.CalendarVo"%>
<%@page import="java.util.ArrayList"%>
<link href="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/core/main.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/daygrid/main.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/core/main.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/daygrid/main.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/interaction/main.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/core/main.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/daygrid/main.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/fullcalendar-4.4.0/packages/interaction/main.min.js"></script>
<script src="https://unpkg.com/popper.js/dist/umd/popper.min.js"></script>
<script src="https://unpkg.com/tooltip.js/dist/umd/tooltip.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/template.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/calendar.css">


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- FullCalendar -->
<script>
// 달력띄움
	document.addEventListener('DOMContentLoaded', function() {
		var calendarList = '${calVoList}';
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			plugins : [ 'interaction', 'dayGrid' ],
			dateClick: function(info) {
				debugger
				$("#calendar_start_date, #calendar_end_date").val(info.dateStr);
				
				$('#calendarModal').modal('show');
				
			},

// 달력모달 상세보기
			eventClick: function(info) {
// 				debugger
				$("#del_calendar_content").val(info.event.title);
				
				var startyear=info.event.start.getFullYear();
				var startmonth=Number(info.event.start.getMonth()+1) < 10 ? "0"+Number(info.event.start.getMonth()+1) : Number(info.event.start.getMonth()+1) ;//삼항연산자 10보다 작으면 0을 붙여주고 아니면 그대로사용 
				var startday=info.event.start.getDate() <10 ? "0"+info.event.start.getDate() : info.event.start.getDate();
				
				$("#del_calendar_start_date").val(startyear+"-"+startmonth+"-"+startday);
			
				if(info.event.end==null){
					$("#del_calendar_end_date").val(startyear+"-"+startmonth+"-"+startday);
				}else{
					var endyear=info.event.end.getFullYear();
					var endmonth=Number(info.event.end.getMonth()+1) <10 ? "0"+Number(info.event.end.getMonth()+1) : Number(info.event.end.getMonth()+1);
					var endday=info.event.end.getDate() <10? "0"+info.event.end.getDate() : info.event.end.getDate();
					$("#del_calendar_end_date").val(endyear+"-"+endmonth+"-"+endday);
					
				}
				$("#del_calendar_id").val(info.event.id);
				
				$('#delcalendarModal').modal('show');
			
			},


// 달력 일정추가 건 보기
			events : [ 
				<%ArrayList<CalendarVo> calendarList = (ArrayList<CalendarVo>)request.getAttribute("calVoList");%>
				<%if (calendarList != null) {%>
					<%for (CalendarVo vo : calendarList) {%>
					{
						id : <%=vo.getAcademicNo()%>,
						title : "<%=vo.getAcademicName()%>",
						start : new Date ("<%=vo.getStartDate()%>"+" 00:00:00"),
						end : new Date ("<%=vo.getEndDate()%>"+ " 23:59:59"),
						color : '#' + Math.round(Math.random() * 0xffffff).toString(16),
					},
					<%}
 				}%> 
			]

			
		
		});
		
		calendar.render();
		
	});
	

</script>


<title>Academic Calendar</title>



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
<%-- [[ ${calVoList }]] --%>
<jsp:include page="/WEB-INF/view/professor/pfHeader.jsp"/>

	<section id="template_content">
		<div class="template_container">
			<div class="template-title">
				<h1>학사일정</h1>
				
				<hr>
			</div>
			<div class="content_container">

				<!-- 템플릿 -->
				<div class="row">
					<div id="calendar" class="cal"></div>

					<!-- modal 일정추가 -->
					<div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
								</div>
								<form id="mgCalendar" action="<%=request.getContextPath()%>/mg/calendar/enroll" method="post">
									<div class="modal-body">
										<div class="form-group">
											<label for="taskId" class="col-form-label">일정 내용</label> 
											<input type="text" class="form-control" id="calendar_content" name="calendar_content"> 
											<label for="taskId" class="col-form-label">시작 날짜</label> 
											<input type="date" class="form-control" id="calendar_start_date" name="calendar_start_date"> 
											<label for="taskId" class="col-form-label">종료 날짜</label> 
											<input type="date" class="form-control" id="calendar_end_date" name="calendar_end_date">
										</div>
									</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-warning" id="addCalendar">완료</button>
									<button type="button" class="btn btn-secondary modalclose" data-dismiss="modal" id="sprintSettingModalClose">취소</button>
								</div>
									</form>
							</div>
						</div>
					</div>
					
					
					<!-- modal 일정삭제 -->
					<div class="modal fade" id="delcalendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">일정상세보기.</h5>
								</div>
									<div class="modal-body">
										<div class="form-group">
											<label for="taskId" class="col-form-label">일정 내용</label> 
											<input type="text" class="form-control" id="del_calendar_content" name="calendar_content"> 
											<label for="taskId" class="col-form-label">시작 날짜</label> 
											<input type="date" class="form-control" id="del_calendar_start_date" name="calendar_start_date"> 
											<label for="taskId" class="col-form-label">종료 날짜</label> 
											<input type="date" class="form-control" id="del_calendar_end_date" name="calendar_end_date">
										</div>
									</div>
								<div class="modal-footer">
									<input type="hidden" id="del_calendar_id" name="del_calendar_id"> 
									<button type="button" class="btn btn-warning" id="delCalendar">삭제</button>
									<button type="button" class="btn btn-secondary delmodalclose" data-dismiss="modal" id="delsprintSettingModalClose">취소</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	<script type="text/javascript">
// 	모달 취소버튼 클릭 시
// 	$(".modalclose").on("click", function(){
// 		$('#calendarModal').modal('hide');
// 	});
	
// 	$(".delmodalclose").on("click", function(){
// 		$('#delcalendarModal').modal('hide');
// 	});
	
	
// 일정삭제TODO
// 	$("#delCalendar").click(function(){
// // 		.event.remove();
// 		console.log(this);
// 		console.log($(this));
// 		console.log($(this).prev().val());
// 		var delIdVal = $(this).prev().val();
		
// 		console.log(data);
// 		$.ajax({
// 			type: "post",
<%-- 				url: "<%=request.getContextPath()%>/mg/cal/delete.ax", --%>
// 			//contentType: "application/json; charset=utf-8",
// 			//dataType: "json",
// 			data: {delId: delIdVal },
// 			success: function (result) {
// 				if(result ==0){
// 					alert("일정삭제를 실패했습니다.");
// 				}else{
// 					alert("일정삭제가 완료되었습니다.");
// 					location.reload();
// 				}
// 		},
// 		});
	
	
// 	})
	</script>
		
	</section>

</body>
</html>