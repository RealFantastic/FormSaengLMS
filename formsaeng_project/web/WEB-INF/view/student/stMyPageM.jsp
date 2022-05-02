<%@page import="kh.semi.member.model.vo.MemberVo"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/stMyPage.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 마이페이지 수정</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<%MemberVo vo = (MemberVo)request.getAttribute("MyPageVo"); %>
<header>
<div class="font5">마이페이지 수정하기</div>
<div class="font3">
<button type="button" id="lms" name="lms" class="btn btn-success">LMS 바로가기</button>
<button type="button" id="stmain" name="stmain" class="btn btn-success">메인페이지</button>
</div>
</header>
<form> 
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="name" value=<%=vo.getName()%>>
    </div>
  </div>
    <div class="form-group row">
    <label for="id" class="col-sm-2 col-form-label">학번</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="id" value=<%=vo.getId()%>>
    </div>
  </div>
     <div class="form-group row">
	<label for="deptName" class="col-sm-2 col-form-label">학과</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="deptName" value=<%=vo.getDeptName()%>>
    </div>
  </div>
  <!-- 연락처 -->
  <div class="pnumgroup">
   <div class="form-group row">
  	<label for="pnum" class="col-sm-2 col-form-label">연락처</label>
    <div class="col-sm-10">
      <input type="text" class="form-control-plaintext" id="oldpnum" value=<%=vo.getPnum()%>>
    </div>
  </div>
  <div class="newNum">
     <div class="form-group row">
  	<label for="pnum" class="col-sm-2 col-form-label">새 연락처</label>
    <div class="col-sm-10">
  <input type="text" id="pnum1"> - <input type="text" id="pnum2"> - <input type="text" id="pnum3">
      </div>
  </div>
  </div>

</div>
<!-- 주소 -->
		<div class="addressgroup">
			<!-- 기존 주소 -->
			<div class="form-group row">
				<label for="address" class="col-sm-2 col-form-label">주소</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="oldaddress" value="<%=vo.getAddress()%>">
				</div>
			</div>
			<!-- 새 주소 -->
			<div class="form-group row">
				<label for="address" class="col-sm-2 col-form-label">새 주소</label>
				<div class="col-sm-10">
					<input type="text" id="sample3_postcode" placeholder="우편번호">
					<input type="button" onclick="sample3_execDaumPostcode()"
						value="우편번호 찾기"><br> <input type="text"
						id="sample3_address" placeholder="주소"><br> <input
						type="text" id="sample3_detailAddress" placeholder="상세주소">
					<input type="text" id="sample3_extraAddress" placeholder="참고항목">

					<div id="wrap"
						style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
						<img src="//t1.daumcdn.net/postcode/resource/images/close.png"
							id="btnFoldWrap"
							style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1"
							onclick="foldDaumPostcode()" alt="접기 버튼">
					</div>
				</div>
			</div>
		</div>
<!-- 이메일 -->
<div class="emailgroup">
		<div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="oldemail" value=<%=vo.getEmail()%>>
    </div>
  </div>
  	<div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">새 이메일</label>
    <div class="col-sm-10">
      <input type="text" class="form-control-plaintext" id="email"><input type="text" class="form-control-plaintext" value="@gmail.com">
    </div>
  </div>
 </div> 
  
  
  
<div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword" placeholder="">
    </div>
  </div>
</form>

<script> // 주소 API
    // 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function sample3_execDaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample3_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample3_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample3_postcode').value = data.zonecode;
                document.getElementById("sample3_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample3_detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
</script>
<button type="button" id="modify">수정완료</button>
<script>
// 유효성 검사

/* var pwd = $("#pwd").val().trim();
var repwd = $("#repwd").val().trim();
  if ( $("#pwd").val() == "") {
    alert("비밀번호를 입력하세요.");
    pwd.focus();
    return false;
  };

  //비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식
  var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;

  if (!pwdCheck.test(pwd.value)) {
    alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
    pwd.focus();
    return false;
  };

  if (pwd !== repwd) {
    alert("비밀번호가 일치하지 않습니다..");
    repwd.focus();
    return false;
  };

  var reg = /^[0-9]+/g; //숫자만 입력하는 정규식

  if (!reg.test(mobile.value)) {
    alert("전화번호는 숫자만 입력할 수 있습니다.");
    mobile.focus();
    return false;
  }

  if (email_id.value == "") {
    alert("이메일 주소를 입력하세요.");
    email_id.focus();
    return false;
  } */

  //입력 값 전송
  document.join_form.submit(); //유효성 검사의 포인트   
}

$(function() {
	
	 $("#modify").on('click', function() {
	
	 $.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
	 type : "POST",
	 url : "stmypagem.do",
	 data : {
	 pnum1 :  $("#pnum1").val().trim(),
	 pnum2 :  $("#pnum2").val().trim(),
	 pnum3 :  $("#pnum3").val().trim(),
	 address : $("#sample3_address").val(),
	 detailAddress : $("#sample3_detailAddress").val(),
	 extraAddress : $("#sample3_extraAddress").val(),
	 email : $("#email").val().trim(),
	 },
	 success : function(result) {
	 if(result == "성공"){
		 console.log(result);
		alert("수정이 완료되었습니다"); //  alert 안 뜸
 		location.href = "stmypage"; // 페이지 변화 없어
		
	 } else if(result == "실패"){
		alert("수정에 실패했습니다. 다시 시도해");
	 }
	 }
	 });
	 })
});


$("#lms").click(function(){
	location.href = "stdlist"; // lms 바로가기
});
	
$("#stmain").click(function(){
	location.href = "stmain"; // 메인페이지
});


</script>
</body>
</html>
