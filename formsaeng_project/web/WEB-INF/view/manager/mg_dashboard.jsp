<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/mgDashBoard.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>매니저 대시보드</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/ef09f998fc.js" crossorigin="anonymous"></script>  
  </head>
<body>
	<jsp:include page="/WEB-INF/view/manager/mgHeader.jsp"/>
  <section id="template_content">
    <div class="template_container">
    	<div class="template-title">
	        <h1>이용안내</h1>
	        <hr>
      	</div>
      	<div class="content_container">
      		<div id="info" class="col-12">
	      		<div id = "info_title" class="col-8">
      				<h1 class="font5"> 관리자 이용안내에 오신 것을 환영합니다.</h1>
	        		<img src = "<%=request.getContextPath() %>/resources/images/cute_face.png" class="img-fluid" alt="이용안내1">
	        		<p class="font3">
		        		관리자분들이 폼생대 LMS를 이용해 과목의 학습 내용을 구성하고, 다채로운 학습 활동 운영을 지원하고 상호작용하며, 평가와 성적 관리하는
		        		다양한 활동을 편리하고 효율적으로 운영할 수 있도록 도와드릴 가이드를 확인하실 수 있습니다.
		        	</p>
		        	<hr>
	        	</div>
	        	<div id="info_content" class="col-8">
	        		<h2 class="sub_title1">메세지함 이용 방법</h2>
	        		<img src = "<%=request.getContextPath() %>/resources/images/info_message.PNG" class="img-fluid" alt="메세지함사진">
	        		<p class="font3 explain_use">상단 중앙 버튼 : 보낸 메세지 / 받은 메세지 확인 가능</p><br>
	        		<p class="font3 explain_use">상단 우측 버튼 : 메세지 보내기</p>
	        	</div>
      		</div>
      	</div>
    </div>
  </section>
</body>
</html>