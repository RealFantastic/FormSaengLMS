 <%@page import="kh.semi.member.model.vo.MemberVo"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
 <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/mgmain.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style>
#container {
	background-image: url('./resources/images/mglogin.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100vh;
	display:flex;
	justify-content: space-between;
	padding-top: 50px;
}

</style>
</head>
<body>
<% MemberVo vo = (MemberVo)session.getAttribute("ssMemberVo"); %>
	<div id="container">
            <div class="minilogo"><img src="<%= request.getContextPath() %>/resources/images/fromsaenglogo.png" alt="logo"></div>
            <div class="maincenter">
                <div class="logo"><img src="<%= request.getContextPath() %>/resources/images/logo.png" alt="폼생대학교"></div>
                      <form>
                        <h4><%=vo.getName()%>님 반갑습니다</h4>
                        <button type="button" id="lms" name="lms" class="btn btn-primary">LMS 바로가기</button>
                        <button type="button" id="notice" name="notice" class="btn btn-success">공지사항 관리</button>
                        <button type="button" id="enroll"  name="enroll" class="btn btn-success">수강신청 관리</button>
                        <button type="button" id="logout"  name="logout" class="btn btn-light">로그아웃</button>                   
                      </form>
            </div>
            <div></div>
    </div>
   <script>
	var msgVal = '${msg}';
 	if(msgVal != '' || msgVal != false){
 		alert(msgVal);
 	} // 로그인 성공 시 메시지
 	
   
   $("#lms").click(function(){
		location.href = "mgdlist"; // lms 바로가기
	});
   $("#notice").click(function(){
		location.href = "mgblist"; // 공지사항 관리
	});
   
   $("#enroll").click(function(){
		location.href = "mgSubjects"; // 수강신청
	});
   
   $("#logout").click(function(){
		location.href = "mglogout"; // 로그아웃
	});

   </script>
   <% session.removeAttribute("msg"); %>
</body>
</html>