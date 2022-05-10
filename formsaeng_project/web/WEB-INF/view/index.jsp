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
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
            <div class="univlogo">
                <a href="https://www.naver.com"><img src="<%= request.getContextPath() %>/resources/images/name_logo.png" alt="폼생대학교"></a>
            </div>
        </header>
        <section id="first">
            <div class="login_container">
                <div class="login_wrapper">
                    <div class="welcome">
                        안녕하세요 폼생대 LMS 입니다.
                    </div>
                    <div class="loginlink">
                        <button id="std_login" class="move_button">학생 로그인</button>
                        <button id="pf_login" class="move_button">교수자 로그인</button>
                        <button id="mgr_login" class="move_button">관리자 로그인</button>
                    </div><br>
                    <div>
                    <button id="notice" class="move_button">공지사항</button>
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