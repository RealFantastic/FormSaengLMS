  <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/plogin.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 로그인</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style>
#container {
	background-image: url('./resources/images/pflogin.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100vh;
}

</style>
</head>
<body>
<div id="container">
    <div id="plogin">
            <div class="minilogo"><img src="<%= request.getContextPath() %>/resources/images/fromsaenglogo.png" alt="logo"></div>
            <div class="logincenter">
                <div class="logo"><img src="<%= request.getContextPath() %>/resources/images/logo.png" alt="폼생대학교"></div>
                    <div id="login">
                        <form id="login-form" class="form" action="pflogin.do" method="post">
                            <h3>교수 전용 로그인</h3>
                            <div class="form-group">
                                <input type="text" name="id" class="form-control" placeholder="아이디를 입력해주세요">
                            </div>
                            <div class="form-group">
                                <input type="password" name="pwd" class="form-control" placeholder="비밀번호를 입력해주세요">
                            </div>
                            <div class="form-group">
                                <button type="button" name="findid" id="findid" class="btn btn-light">아이디 찾기</button>
                                <button type="button" name="findpwd" id="findpwd" class="btn btn-light">비밀번호 찾기</button>
                                <input type="submit" name="submit" class="btn btn-primary" value="로그인">
                            </div>
                        </form>
                    </div>
                    <div class="loginmenu">
                        <input type="button" id="notice" name="notice" class="btn btn-success"  value="공지사항">
                    </div>
				<div class="findid_modal">
					<div class="modal_content">
						<button class="btn_modal_close">닫기</button>
						<div>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry. Lorem Ipsum has been the industry's
							standard dummy text ever since the 1500s, when an unknown printer
							took a galley of type and scrambled it to make a type specimen
							book.</div>
						<div>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry. Lorem Ipsum has been the industry's
							standard dummy text ever since the 1500s, when an unknown printer
							took a galley of type and scrambled it to make a type specimen
							book.</div>
						<div>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry. Lorem Ipsum has been the industry's
							standard dummy text ever since the 1500s, when an unknown printer
							took a galley of type and scrambled it to make a type specimen
							book.</div>
					</div>
				</div>
			</div>
            <div></div>
    </div>
   	</div>
	<script>
		$("#notice").click(function() {
			location.href = "";
		});
		//모달창 구현 JavaScript
   		window.onload = pageLoadedHandler;
   		function pageLoadedHandler(){
   			//버튼에 이벤트 등록
   			document.querySelector("#findid").addEventListener("click",openFindIdModalHandler);
   			document.querySelector(".btn_modal_close").addEventListener("click",closeFindIdModalHandler);
   			
   			//모달창 DOM을 담은 변수
   			const findIdBox = document.querySelector(".findid_modal");
   			
   			//모달창 아무데나 눌러도 닫히도록
   			findIdBox.onclick = closeModalWindowHandler;
   			
   			//모달창 열기 함수
   			function openFindIdModalHandler(){
   				console.log("아이디 찾기 버튼 클릭됨");
   				findIdBox.style.display = "block";
   			}
   			
   			//모달창 닫기 함수
   			function closeFindIdModalHandler(){
   				console.log("닫기버튼 클릭됨");
   				findIdBox.style.display = "none";
   			}
   			
   			//모달창 닫기(아무곳이나 눌러도) 함수
   			function closeModalWindowHandler(){
   				console.log("모달영역 바깥 클릭됨");
   				//모달창 하위의 실제 입력해야되는 칸 클릭할때 안닫히도록함.
   				if(event.target == document.getElementsByClassName("findid_modal")[0]){
	   				findIdBox.style.display = "none";
   				}
   			}
   		}
		
	</script>


</body>
</html>