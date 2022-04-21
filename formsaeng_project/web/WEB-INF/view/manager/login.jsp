 <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
 <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/mlogin.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manager login</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<div id="container">
    <div id="mlogin">
            <div class="minilogo"><img src="./resources/images/fromsaenglogo.png" alt="logo"></div>
            <div class="logincenter">
                <div class="logo"><img src="./resources/images/logo.png" alt="폼생대학교"></div>
                    <div id="login">
                            <form id="login-form" class="form" action="mglogin.do" method="post">
                                <h3>관리자 전용 로그인</h3>
                                <div class="form-group">
                                    <input type="text" name="id" class="form-control" placeholder="아이디를 입력해주세요">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="pwd" class="form-control" placeholder="비밀번호를 입력해주세요">
                                </div>
                                <div class="form-group">
                                    <input type="button" name="findid" class="btn btn-light" value="아이디 찾기" onclick="이동페이지">
                                    <input type="button" name="findpwd" class="btn btn-light"value="비밀번호 찾기" onclick="이동페이지">
                                    <input type="submit" name="submit" class="btn btn-primary" value="로그인">
                                </div>
                            </form>
                        </div>
                    <div class="loginmenu">
                        <input type="button" name="notice" class="btn btn-success"  value="공지사항" onclick="이동페이지">
                        <input type="button" name="enroll" class="btn btn-success"  value="수강신청" onclick="이동페이지">
                    </div>
                    </div>
            <div></div>
    </div>
   </div>
</body>
</html>