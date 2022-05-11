 <%@page import="kh.semi.member.model.vo.MemberVo"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/slogin.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 로그인</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style>
#container {
	background-image: url('./resources/images/semi_main_page.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100vh;
}

</style>
<script>
$(function(){
		$("#findid").on("click",function(){
			console.log("함수야 안녕");
			$(".findid_modal").fadeIn(150);
			$(".btn_modal_close").on("click",closeModal);
			$(".findid_modal").on("click",closeModalWindow);
		});
		
		function closeModal(){
			$(".findid_modal").hide();
		}
		function closeModalWindow(){
			if(event.target == $(".findid_modal").get(0)){
				console.log('넌 어디냐');
				 $(".findid_modal").hide();
				 $(".findid_modal").off("click",closeModalWindow); 
			}
				
		}
});

</script>
</head>
<body>
<div id="container">
  <div id="slogin">
            <div class="minilogo"><a href="<%=request.getContextPath()%>"><img src="<%= request.getContextPath() %>/resources/images/fromsaenglogo.png" alt="logo"></a></div>
            <div class="logincenter">
                <div class="logo"><img src="<%= request.getContextPath() %>/resources/images/name_logo.png" alt="폼생대학교"></div>
                    <div id="login">
                         <form id="loginform" action="stlogin.do" method="post">
                             <h3>로그인</h3>
                             <div class="form-group">
                                 <input type="text" id="id" name="id" class="form-control" placeholder="아이디를 입력해주세요">
                             </div>
                             <div class="form-group">
                                 <input type="password" id="pwd" name="pwd" class="form-control" placeholder="비밀번호를 입력해주세요">
                             </div>
                             <div class="form-group">
                                 <button type="button" id="findid" name="findid" class="btn btn-light">학번 찾기</button>
                                 <button type="button" name="findpwd" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#findPwd" data-bs-whatever="@mdo">비밀번호 찾기</button>
                                 <input type="button" id="submit" name="submit" class="btn btn-primary" value="로그인">
                             </div>
                         </form>
                     </div>
                                     <!-- 아이디 찾기 모달창 -->
				<div class="findid_modal">
					<div class="modal_content">
						<div>
						<form id="frmEmail">
							<table>
									<tr>
										<td class="font-3">이름을 입력하세요</td>
										<td><input type="text" name="name" id="inputName"></td>
										<td></td>
									</tr>
									<tr>
										<td class="font-3">이메일을 입력하세요</td>
										<td><input type="email" name="email" id="inputEmail"></td>
										<td><button type="button" id="btnSendEmail">이메일 인증</button></td>
									</tr>
								</table>
							</form>	
						</div>
						<button class="btn_modal_close">닫기</button>
					</div>
				</div>
				<!-- 비밀번호 찾기 모달 -->
				<div class="modal fade" id="findPwd" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">비밀번호 찾기</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<div class="mb-3">
									<label for="user_name" class="col-form-label">이름</label>
									<input type="text" class="form-control" id="user_name" name="user_name">
								</div>
								<div class="mb-3">
									<label for="user_id" class="col-form-label">학번</label>
									<span id = "isRight"></span>
									<input type="text" class="form-control" id="user_id" name="user_id">
								</div>
								<div class="mb-3">
									<button type="button" class="btn btn-primary" id="checkMember">계정 확인하기</button>
								</div>
								<div class="mb-3" id="input_email">
									<label for="user_email" class="col-form-label">이메일 입력</label>
									<button type="button" class="btn btn-primary" id="send_mail">메일 전송</button>
									<input type="email" class="form-control" id="user_email" name="user_email">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">닫기</button>
							</div>
						</div>
					</div>
				</div>
            </div>
    </div>
   </div>
   <script> // ajax
   $(function() {
	   
	  	 $("#submit").click(function(){
		   var id = $("#id").val().trim();
		   var checkId = /^[S][0-9]{10}$/;
		   if(!checkId.test(id)){
			   alert("아이디는 S로 시작하는 10자리 숫자입니다");
			   $("#id").focus();		   
			   return false;
		   } else{
		 $.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
		 type : "POST",
		 url : "stlogin.do",
		 data : {
		 id : $("#id").val().trim(),
		 pwd : $("#pwd").val().trim(),
		 },
		 success : function(result) {
		 if(result == "성공"){
			 console.log(result);
			alert("반갑습니다");
	 		location.href = "<%=request.getContextPath()%>/st/main";

			
		 } else if(result == "실패"){
			alert("잘못된 아이디 또는 비밀번호입니다");
			$("#id").val("").focus();
			$("#pwd").val("");
		 }
		 }
		 });
			   
		   }
		   }); 
	  	 	 
	  	 //아이디 찾기
	  	$("#btnSendEmail").click(function(){
			var inputName = $("#inputName").val().trim();
			var inputEmail = $("#inputEmail").val().trim();
			if(inputName == "" || inputEmail=="" ){
				alert("이메일을 입력해주세요.");
				$("#inputEmail").focus();
				return;
			}
			$.ajax({
				url:"cemail",
				type:"post",
				data: {name: inputName, email:inputEmail },
				success:function(result){
					console.log(result);
					if(result == 0)  // 0: email, name과 일치하는 회원정보가 없음
						alert("name, email이 일치하는 회원정보가 없습니다. 다시 입력해주세요.");
					else if(result == 1)// 1: email 보내기 성공
						alert("email인증메일 전송되었습니다. 메일 확인해주세요");
					else // -1: email 보내기 실패
						alert("email인증메일 전송에 실패했습니다. 다시 시도해주세요");
				},
				error: function(){
					
				}
			});
		});
	  	 
	  	 
	   	   //비밀번호 찾기
	   	   $("#checkMember").click(function(){
	   		   var userName = $("#user_name").val();
	   		   var userId = $("#user_id").val();
	   		   console.log(userName);
	   		   console.log(userId);
	   		   if(userName != "" && userId !=""){
	   			   $.ajax({
	   				type : "POST",
	   			 	url : "checkSt.ajx",
	   			 	data : {
	   			 			name : userName,
	   			 			id : userId,
	   			 	},
	   			 	success : function(data){
	   			 		console.log("컨트롤러 갔다왔음.");
	   			 		console.log(data);
	   			 		if(data == 0){
	   			 			alert("입력하신 계정은 없는 계정 / 잘못된 이름 입니다.");
	   			 			$("#isRight").empty();
	   			 			$("#isRight").css('color',"red");
	   			 			$("#isRight").text("없는 계정입니다.");
	   			 			$("#user_name").focus();
	   			 			return;
	   			 		}else if(data == 1){
	   			 			$("#isRight").empty();
				 			$("#isRight").css('color',"green");
	   			 			$("#isRight").text("계정을 확인했습니다.");
	   			 			$("#input_email").show();
	   			 		}
	   			 		
	   			 	}
	   			 		
	   			   });
	   		   }
	   	   });
	   	   			//비밀번호 메일 전송
	   	   $("#send_mail").click(function(){
	   		   var userName = $("#user_name").val();
	 		   var userId = $("#user_id").val();
	   		   var address = $("#user_email").val();
	   		  if(address == "" || address == null){
	   			  alert("이메일을 입력해주세요.");
	   			  $("#user_email").focus();
	   			  return;
	   		  }else{
	   			  $.ajax({
	   				type : "POST",
	   			 	url : "<%= request.getContextPath()%>/sendEmail.ajx",
	   			 	data : {
		   			 		name : userName,
				 			id : userId,
	   			 			email : address
	   			 	},
	   			 	success : function(result){
	   			 		if(result ==-2){
	   			 			alert("이메일 정보가 일치하지 않습니다 다시 시도해주세요.");
	   			 			$("#user_email").focus();
	   			 		}else if(result == -1){
	   			 			alert("이메일 전송에 실패했습니다.");
	   			 			location.reload();
	   			 		}else if(result == 1){
	   			 			alert("이메일을 전송했습니다. 확인해주세요.");
	   			 			location.reload();
	   			 		}
	   			 	}
	   			 	
	   			  });
	   		  }
	   	   });
	});
   
   
   
   </script>
</body>
</html>