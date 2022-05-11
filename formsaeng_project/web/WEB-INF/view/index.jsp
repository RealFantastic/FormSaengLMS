<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/index.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
        #root{
            background-image: url(./resources/images/semi_main_page.jpg) ;
            background-size: cover;
            background-repeat: no-repeat;
            height: 100vh;
        }
        
    </style>
</head>
<body>
    <div id="root">
        <header>
        <div class="minilogo">
        <img src="<%= request.getContextPath() %>/resources/images/fromsaenglogo.png" alt="폼생대학교">
        </div>
        </header>
        <section id="first">
            <div class="login_container">
				<div class="login_wrapper">
					<div class="welcome" style="margin-bottom: 30px;">
						<div class="univlogo">
							<a href="https://www.naver.com"><img src="<%=request.getContextPath()%>/resources/images/name_logo.png" alt="폼생대학교"></a>
						</div>
					</div>
					<div class="loginlink">
						<button id="std_login" class="btn btn-success move_button btn-lg">STUDENT<br>LOGIN</button>
						<button id="pf_login" class="btn btn-success move_button btn-lg">PROFESSOR<br>LOGIN</button>
						<button id="mgr_login" class="btn btn-success move_button btn-lg">MANAGER<br>LOGIN</button>
					</div>
					<br>
					<div>
						<button id="notice" class="btn btn-secondary move_button btn-lg">공지사항</button>
					</div>
				</div>
			</div>
        </section>
    </div>
    <script>
      $(function(){
            $('#std_login').click(function(){
                console.log("학생 로그인 이동");
                location.href = "stlogin";
            });
            $('#pf_login').click(function(){
                console.log("교수 로그인 이동");
                location.href = "pflogin";
            });
            $('#mgr_login').click(function(){
                console.log("관리자 로그인 이동");
                location.href = "mglogin";
            });
            $('#notice').click(function(){
                console.log("공지사항 이동");
                location.href = "<%=request.getContextPath()%>/notice/list";
            });
      });
    </script>
</body>
</html>