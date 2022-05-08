<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/template.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/msg.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>Message</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/ef09f998fc.js" crossorigin="anonymous"></script>  
  </head>
<body>

  <header id="sideBar">
    <div class="side_container">
      <a href="./semitest.html" id="logo"><img src="<%= request.getContextPath() %>/resources/images/fromsaenglogo.png" alt="폼생대로고"></a>
      <a href="./semitest.html" id="uni_name"><img src="<%= request.getContextPath() %>/resources/images/name_logo.png" alt="폼생대학교"></a>
      <hr>
      <ul class="list_button">
        <li>
          <a href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-grid-3x2-gap-fill" viewBox="0 0 16 16">
              <path d="M1 4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V4zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V4zM1 9a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V9zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H7a1 1 0 0 1-1-1V9zm5 0a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V9z"/>
            </svg>
            Dashboard
          </a>
        </li>
        <li>
          <a href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
              <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
            </svg>
            Message
          </a>
        </li>
        <li>
          <a href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
              <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
            </svg>
            Subject
          </a>
        </li>
        <li>
          <a href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-alarm" viewBox="0 0 16 16">
              <path d="M8.5 5.5a.5.5 0 0 0-1 0v3.362l-1.429 2.38a.5.5 0 1 0 .858.515l1.5-2.5A.5.5 0 0 0 8.5 9V5.5z"/>
              <path d="M6.5 0a.5.5 0 0 0 0 1H7v1.07a7.001 7.001 0 0 0-3.273 12.474l-.602.602a.5.5 0 0 0 .707.708l.746-.746A6.97 6.97 0 0 0 8 16a6.97 6.97 0 0 0 3.422-.892l.746.746a.5.5 0 0 0 .707-.708l-.601-.602A7.001 7.001 0 0 0 9 2.07V1h.5a.5.5 0 0 0 0-1h-3zm1.038 3.018a6.093 6.093 0 0 1 .924 0 6 6 0 1 1-.924 0zM0 3.5c0 .753.333 1.429.86 1.887A8.035 8.035 0 0 1 4.387 1.86 2.5 2.5 0 0 0 0 3.5zM13.5 1c-.753 0-1.429.333-1.887.86a8.035 8.035 0 0 1 3.527 3.527A2.5 2.5 0 0 0 13.5 1z"/>
            </svg>
            Timetable
          </a>
        </li>
        <li>
          <a href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-calendar-week" viewBox="0 0 16 16">
              <path d="M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-5 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>
              <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
            </svg>
            Calendar
          </a>
        </li>
      </ul>
    </div>
  </header>
  <section id="template_content">
		<div class="template_container">

			<div class="template-title">
				<div class="msg_Write">
					<h1>Message</h1>
					
					<div class="btn-group msg_box" role="group" aria-label="Basic radio toggle button group">
					  <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" >
					  <label class="btn btn-outline-primary" for="btnradio1">　　받은 메시지　　</label>
					
					  <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off" checked>
					  <label class="btn btn-outline-primary" for="btnradio2">　　보낸 메시지　　</label>
					</div>

<!-- 				메시지 보내기 모달창 -->
					<div>
					
					<form id="pfMessageFrom"action="<%=request.getContextPath()%>/pf/msgwrite" method="post">
					
						<button type="button" class="btn btn-primary msg_write_btn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">메시지 보내기</button>
						<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">메시지 보내기</h5>
										<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
											<div class="mb-3">
												<label for="recipient-name" class="col-form-label">받는 사람</label>
												<input type="text" class="form-control receive_pp" id="recipient-name" name="recevier">
												<button type="button" class="btn btn-primary" id="pp_select">찾기</button>
												<select id="select_select" name="sender_name"></select>
											</div>
											<div class="mb-3">
												<label for="message-text" class="col-form-label">제목</label>
												<textarea class="form-control modal_title" id="message-text" name="title"></textarea>
											</div>
											<div class="mb-3">
												<label for="message-text" class="col-form-label">내용</label>
												<textarea class="form-control modal_content" id="message-text" name="content"></textarea>
											</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
										<button type="submit" class="btn btn-primary" onclick="check()">전송</button>
									</div>
								</div>
							</div>
						</div>
					</form>
					</div>
				</div>

				<hr>

			</div>
			<div class="content_container">
				<!-- 템플릿 -->
				<div class="row">
					
	<!-- 			for문으로 돌려서... -->
					<div id="receive_box">
						<c:forEach var="msgreceive" items="${msgreceive}"> 
		<!-- 				받은메시지함 -->
						<div class="card border-success mb-3 msg_card receive_card">
							<div class="card-header bg-transparent border-success">
								${msgreceive.senderName}
							</div>
							<div class="card-body text-success">
								<h5 class="card-title">${msgreceive.msgTitle}</h5>
								<div class=scroll_content>
									<p class="card-text"> ${msgreceive.msgContent}</p>
								</div>
							</div>
							<div class="card-footer bg-transparent border-success">${msgreceive.msgDate}</div>
						</div>
						
						</c:forEach>
					</div>
					<div id="send_box">
						<c:forEach var ="msgsend" items="${msgsend}">
		<!-- 				보낸메시지함 -->
						<div class="card border-success mb-3 msg_card">
							<div class="card-header bg-transparent border-success">
								${msgsend.recevierName}
							</div>
							<div class="card-body text-success">
								<h5 class="card-title">${msgsend.msgTitle}</h5>
								<div class=scroll_content>
									<p class="card-text content_line"> ${msgsend.msgContent}</p>
								</div>
							</div>
							<div class="card-footer bg-transparent border-success">${msgsend.msgDate}</div>
						</div>
						
						</c:forEach>
					</div>
				</div>
			</div>
	</section>
	
	<script>
	
	$(function(){
		if($("#btnradio2").prop("checked")){
			console.log("안녕");
			showSendBox();
		}
		
		$("#btnradio1").on("click",function(){
			showReceiveBox();
		})
		$("#btnradio2").on("click",function(){
			showSendBox();
		})
		
		function showReceiveBox(){
			console.log("쇼리시브 함수");
			$("#send_box").hide();
			$("#receive_box").show();
		}
		function showSendBox(){
			console.log("쇼샌드박스함수");
			$("#receive_box").hide();
			$("#send_box").show();
		}
		
	});
	
	$(document).ready(function(){
		
		$("#pp_select").click(function(e){
			console.log("사람을 찾습니다.");
			var name= $("#recipient-name").val();
			
			$.ajax({
				url:"<%=request.getContextPath()%>/pf/recipient.ax",
				type:"get",
				dataType:"json",
				data:{"name":name},
				//제이슨 타입인데 (앞)키랑 (뒤)벨류 형식으로 만듬
				success:function(data){
					console.log("컨트롤러 가따옴");
					var html="<option value=''>받는사람</option>";
					for(var i=0; i<data.length; i++){
						html+="<option value="+data[i].id+" id='option_select'>"+data[i].name+data[i].id+"</option>";
					}
					$("#select_select").empty();
					//비워주는거
					$("#select_select").append(html);
					//값 밑에다가 (자식태그) 붙여준다.
				}
			})
		})
		/*$("#select_select").on('change',function(){
			var name=$("#recipient-name").val();
			console.log("recipient-name : "+name+id);
			
			var choice = $("#select_select").val();
			console.log(choice);
			
			//TODO : select 값 선택하면 input text에 출력되도록.
// 			$("#recipient-name").text($("#select_select").val());
// 			document.getElementbyId("recipient-name").innerText(choice);
		})*/
		$("#select_select").change(function(){
 				//input박스 value를 선택된 옵션에 text를 집어넣어준다.
				$("#recipient-name").val($("#select_select option:selected").text());
				//input박스 비활성화 
				$("#recipient-name").attr("disabled",true);
		});
	});

	function check(){
		console.log($("input[name='recevier']").val());
		
	}
	
	</script>
</body>
</html>