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

<jsp:include page="/WEB-INF/view/professor/pfHeader.jsp"/>

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
												<textarea class="form-control modal_title" id="message-text" name="title" maxlength="50"></textarea>
											</div>
											<div class="mb-3">
												<label for="message-text" class="col-form-label">내용</label>
												<textarea class="form-control modal_content" id="message-text" name="content" maxlength="300"></textarea>
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