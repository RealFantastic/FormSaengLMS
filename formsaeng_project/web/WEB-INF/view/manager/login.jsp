<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manager login</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css">
</head>
<style>
#plogin {
    margin-top: 50px;
    display: flex;
    justify-content: space-between;
}
.minilogo img {
    height: 70px;
    margin-left: 30px;
}
.logo img {
    height: 80px;
    margin-left: 10px;
}

#login {
    padding: 30px;
    background-color: rgb(228, 227, 232);
}
.form-group{
    margin-bottom: 10px;
}

.loginmenu {
    display: flex;
    justify-content: space-around;
}
.loginmenu input{
    width: 48%;
    margin-top: 15px;
    padding: 15px;
}


</style>
<body>
    <div id="plogin">
            <div class="minilogo"><img src="./resources/images/fromsaenglogo.png" alt="logo"></div>
            <div class="logincenter">
                <div class="logo"><img src="./resources/images/logo.png" alt="폼생대학교"></div>
                    <div id="login">
                            <form id="login-form" class="form" action="mglogin.do" method="post">
                                <h3>관리자 전용 로그인</h3>
                                <div class="form-group">
                                    <input type="text" name="id" id="id" placeholder="아이디를 입력해주세요" class="logininput">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="pwd" id="pwd" placeholder="비밀번호를 입력해주세요" class="logininput">
                                </div>
                                <div class="form-group">
                                    <input type="button" name="findid" class="findbtn" value="아이디 찾기" onclick="이동페이지">
                                    <input type="button" name="findpwd" class="findbtn"value="비밀번호 찾기" onclick="이동페이지">
                                    <input type="submit" name="submit" class="loginbtn" value="로그인">
                                </div>
                            </form>
                        </div>
                    <div class="loginmenu">
                        <input type="button" name="notice" value="공지사항" onclick="이동페이지">
                        <input type="button" name="enroll" value="수강신청" onclick="이동페이지">
                    </div>
                    </div>
            <div></div>
    </div>
</body>
</html>