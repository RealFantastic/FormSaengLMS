 <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
 <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/mlogin.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style>
#container {
	background-image: url('<%=request.getContextPath()%>/resources/images/mglogin.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100vh;
}

</style>
</head>
<body>
<div id="container">
    <div id="mlogin">
            <div class="minilogo"><a href="<%=request.getContextPath()%>"><img src="<%= request.getContextPath() %>/resources/images/fromsaenglogo.png" alt="logo"></a></div>
            <div class="logincenter">
                <div class="logo"><img src="<%= request.getContextPath() %>/resources/images/logo.png" alt="폼생대학교"></div>
                    <div id="login">
                            <form id="login-form" class="form" action="mglogin.do" method="post">
                                <h3>관리자 전용 로그인</h3>
                                <div class="form-group">
                                    <input type="text" id="id" name="id" class="form-control" placeholder="아이디를 입력해주세요">
                                </div>
                                <div class="form-group">
                                    <input type="password" id="pwd" name="pwd" class="form-control" placeholder="비밀번호를 입력해주세요">
                                </div>
                                <div class="form-group">
                                    <input type="button" id="submit" name="submit" class="btn btn-primary" value="로그인">
                                </div>
                            </form>
                        </div>
                    </div>
            <div></div>
		</div>
   </div>

   	   <script> // ajax
   $(function() {

   $("#submit").click(function(){
   var id = $("#id").val().trim();
   var checkId = /^[M][0-9]{10}$/;
   if(!checkId.test(id)){
	   alert("아이디는 M으로 시작하는 10자리 숫자입니다");
	   $("#id").focus();
	   return false;
   } else{
		 $.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
		 type : "POST",
		 url : "mglogin.do",
		 data : {
		 id : $("#id").val().trim(),
		 pwd : $("#pwd").val().trim(),
		 },
		 success : function(result) {
		 if(result == "성공"){
			 console.log(result);
			alert("반갑습니다");
	 		location.href = "<%=request.getContextPath()%>/mg/main"; // 메인으로 이동
			
		 } else if(result == "실패"){
			alert("잘못된 사번 또는 비밀번호입니다");
			$("#id").val("").focus();
			$("#pwd").val("");
		 }
		 }
		 });
	   
   } 
   });
	});
   </script>
</body>
</html>