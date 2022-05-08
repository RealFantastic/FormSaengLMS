<%@page import="kh.semi.member.model.vo.MemberVo"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/myPageM.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/MainTemplateHeader.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 마이페이지 수정</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<%MemberVo vo = (MemberVo)request.getAttribute("MyPageVo"); %>
<jsp:include page="/WEB-INF/view/professor/MainTemplateHeader.jsp"/>
<form> 
  <div class="d-flex">
    <label for="name" class="label col-1">이름</label>
    <div class="inputgroup col-2">
      <input type="text" readonly class="border-0" id="name" value=<%=vo.getName()%>>
    </div>
  </div><br>
    <div class="d-flex">
    <label for="id" class="label col-1">사번</label>
    <div class="inputgroup col-2">
      <input type="text" readonly class="border-0" id="id" value=<%=vo.getId()%>>
    </div>
  </div><br>
     <div class="d-flex">
	<label for="deptName" class="label col-1">학과</label>
    <div class="inputgroup col-2">
      <input type="text" readonly class="border-0" id="deptName" value=<%=vo.getDeptName()%>>
    </div>
  </div><br>
  
  <!-- 연락처 -->
  <div class="pnumgroup">
   <div class="d-flex">
  	<label for="pnum" class="label col-1">연락처</label>
    <div class="inputgroup col-2">
      <input type="text" readonly class="border-0 pnum" id="oldpnum" value=<%=vo.getPnum()%>> <button type=button id="modifyP" class="btn btn-secondary btn-sm pnum">수정</button>
    </div>
  </div><br>
  
<!-- Modal 새 연락처 -->
<div class="modal" id="newNum" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">연락처 변경하기</h5>
      </div>
      <div class="modal-body d-flex col-xs-1">
        <input type="text" id="pnum1" class="form-control"> <div class="pnumdiv">-</div>       
        <input type="text" id="pnum2" class="form-control"> <div class="pnumdiv">-</div>
        <input type="text" id="pnum3" class="form-control">
      </div>
      <div class="modal-footer">
        <button type="button" id="submitP" class="btn btn-primary submit">확인</button>
        <button type="button" class="btn btn-secondary close">취소</button>
      </div>
    </div>
  </div>
</div>
</div>

<script> // 연락처 변경
    $(function() {
    	
    $("#modifyP").on("click",function(){
       console.log("모달 안녕");
       $(".modal").eq(0).fadeIn(150);
       $(".close").on("click",closeModal);
    });
    
    function closeModal(){
       $(".modal").hide();
    }
    
   	 $("#submitP").on('click', function() {
   	
   	 var oldPnum = $("#oldpnum").val().trim();
   	 var newPnum = $("#pnum1").val().trim() + "-" + $("#pnum2").val().trim() +"-"+$("#pnum3").val().trim();
   	 
     var reg = /^[0-9]+$/;

     if (!reg.test($("#pnum1").val())) {
       alert("숫자를 입력해주세요");
       $("#pnum1").focus();
       return false;
     }
     if (!reg.test($("#pnum2").val())) {
         alert("숫자를 입력해주세요");
         $("#pnum2").focus();
         return false;
       }
     if (!reg.test($("#pnum3").val())) {
         alert("숫자를 입력해주세요");
         $("#pnum3").focus();
         return false;
       }
   	 
   	 var pnum = (newPnum==null | newPnum== "")? oldPnum:(newPnum);
   		 
   	 $.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
   	 type : "POST",
   	 url : "<%=request.getContextPath()%>/pf/mypagem.do",
   	 data : {
		pnum:pnum
   	 },
   	 success : function(result) {
   	 if(result == "성공"){
   		 console.log(result);
   		 console.log("성공");
   		alert("수정이 완료되었습니다");
    	location.reload();
   		
   	 } else if(result == "실패"){
   		alert("수정에 실패했습니다. 다시 시도해주세요");
   	 }
   	 } 
   	 });
   	 })
   });
</script>

<!-- 주소 -->
<div class="addressgroup">
			<!-- 기존 주소 -->
			<div class="d-flex">
				<label for="address" class="label col-1">주소</label>
				<div class="inputgroup col-7">
					<input type="text" readonly class="border-0"
						id="oldaddress" value="<%=vo.getAddress()%>"> <button type=button id="modifyA" class="btn btn-secondary btn-sm">수정</button>
				</div>
			</div><br>

<!-- Modal 새 주소 -->
<div class="modal" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">주소 변경하기</h5>
      </div>
      <div class="modal-body">
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
      <div class="modal-footer">
        <button type="button" id="submitA" class="btn btn-primary submit">확인</button>
        <button type="button" class="btn btn-secondary close">취소</button>
      </div>
    </div>
  </div>
</div>
</div>
<script> // 주소 변경
    $(function() {
    $("#modifyA").on("click",function(){
       console.log("모달 안녕");
       $(".modal").eq(1).fadeIn(150);
       $(".close").on("click",closeModal);
    });
    
    function closeModal(){
       $(".modal").hide();
    }

   	 $("#submitA").on('click', function() {
   	
   	var oldAddress = $("#oldaddress").val().trim();
   	var newAddress =  $("#sample3_address").val() +" "+$("#sample3_detailAddress").val()+" "+$("#sample3_extraAddress").val();
   	var address = (newAddress==null | newAddress== "")? oldAddress:(newAddress);
   	
 	  if ($("#sample3_address").val() == "" |$("#sample3_detailAddress").val() =="" ) {
 	    alert("주소를 입력해주세요.");
 	   $("#sample3_address").focus();
 	    return false;
 	  } 
 	  
   	 $.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
   	 type : "POST",
   	 url : "<%=request.getContextPath()%>/pf/mypagem.do",
   	 data : {
   	 address : address
   	 },
   	 success : function(resulta) {
   	 if(resulta == "성공"){
   		 console.log(resulta);
   		alert("수정이 완료되었습니다"); 
   		location.reload(); 
   		
   	 } else if(resulta == "실패"){
   		alert("수정에 실패했습니다. 다시 시도해주세요");
   	 }
   	 } 
   	 });
   	 })
   });
</script>
<!-- 이메일 -->
<div class="emailgroup">
		<div class="d-flex row">
    <label for="email" class="label col-1">이메일</label>
    <div class="inputgroup col-3">
      <input type="text" readonly class="border-0" id="oldemail" value=<%=vo.getEmail()%>><button type=button id="modifyE" class="btn btn-secondary btn-sm">수정</button>
    </div>
  </div><br>
  
  <!-- Modal 새 이메일 -->
<div class="modal" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">이메일 변경하기</h5>
      </div>
      <div class="modal-body">
        <input type="text" class="form-control-plaintext" id="newemail"><input type="text" readonly class="form-control-plaintext" value="@gmail.com">
      </div>
      <div class="modal-footer">
        <button type="button" id="submitE" class="btn btn-primary submit">확인</button>
        <button type="button" class="btn btn-secondary close">취소</button>
      </div>
    </div>
  </div>
</div>
</div>
<script> // 이메일 변경
    $(function() {
    $("#modifyE").on("click",function(){
       console.log("모달 안녕");
       $(".modal").eq(2).fadeIn(150);
       $(".close").on("click",closeModal);
    });
    
    function closeModal(){
       $(".modal").hide();
    }

   	 $("#submitE").on('click', function() {
   	 
   	 var oldEmail = $("#oldemail").val().trim();
   	 var newEmail = $("#newemail").val().trim();
   	 
   	var reg = /^[a-z0-9]+$/;
  	 
   	  if (!reg.test(newEmail)) {
   	    alert("잘못된 이메일 형식입니다.");
   	   $("#newemail").focus();
   	    return false;
   	  } 
   	  
   	 var email = (newEmail==null | newEmail== "")? oldEmail:(newEmail+"@gmail.com");
   	 
   	 
   	 $.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
   	 type : "POST",
   	 url : "<%=request.getContextPath()%>/pf/mypagem.do",
   	 data : {
   	 email : email
   	 },
   	 success : function(resulte) {
   	 if(resulte == "성공"){
   		 console.log(resulte);
   		alert("수정이 완료되었습니다"); //  alert 안 뜸
   		location.reload();
   		
   	 } else if(resulte == "실패"){
   		alert("수정에 실패했습니다. 다시 시도해주세요");
   	 }
   	 } 
   	 });
   	 })
   });
</script> 
<!-- 비밀번호 -->
<div class="d-flex row">
    <label for="inputPassword" class="label col-1">비밀번호 변경</label>
    <div class="col-3">
      <input type="password" class="form-control" id="oldpwd" placeholder="현재 비밀번호를 입력해주세요">
      <div class="alert" id="alert1" style="color:red; display:none;">비밀번호가 틀렸습니다</div>
      <input type="password" class="form-control" id="newpwd" placeholder="새 비밀번호를 입력해주세요">
      <div class="alert" id="alert2" style="color:red; display:none;;">비밀번호를 입력해주세요</div>
      <input type="password" class="form-control" id="repwd" placeholder="새 비밀번호를 다시 한번 확인해주세요">
      <div class="alert" id="alert3" style="color:red; display:none;;">비밀번호가 서로 일치하지 않습니다</div>
      <button type=button id="modifyPwd" class="font3 btn btn-secondary btn-sm">수정</button>
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
<script>
// 유효성 검사
    $(function() {
    	

   	 $("#modifyPwd").on('click', function() {
   		 
   	 var oldpwd = $("#oldpwd").val().trim();
   	 var newpwd = $("#newpwd").val().trim();
   	 var repwd = $("#repwd").val().trim();
   	 
   	 
   		 $.ajax({ // 비밀번호 확인 ajax
   			 type : "POST",
   			 url : "<%=request.getContextPath()%>/pfpwdcheck.do",
   			async: true,
   			 data : {
   				pwdcheck : oldpwd,
   			 },
   			 success : function(result) {
   			 if(result == "성공"){
   				 console.log("비번 일치");
				   	 if ( newpwd == "") {
				   		$("#alert1").hide(); // 비번 틀림 경고 삭제해주기
				   		$("#alert2").show();
				   		$("#newpwd").focus();
				   	  } else if ( newpwd != repwd){
				   		$("#alert1").hide(); // 비번 틀림 경고 삭제해주기
				   		$("#alert3").show();
				   		$("#repwd").focus();
				   	  }else{
				   		  
   		 $.ajax({ // 비밀번호 일치시 비밀번호 변경 ajax
   			 type : "POST",
   			 url : "<%=request.getContextPath()%>/pf/modifypwd.do",
   			async: true,
   			 data : {
   				newpwd : newpwd,
   			 },
   			 success : function(result) {
   			 if(result == "성공"){
   				 console.log(result);
   				 alert("비밀번호가 수정되었습니다");
   				 location.reload();
   			 } else if(result == "실패"){
   				 console.log(result);
   			 }
   			 }
   	   	 }) 
   				
				   	  }
   			 } else if(result == "실패"){
   				 console.log(result);
   				$("#alert1").show();
   				$("#oldpwd").val("").focus(); // 비번 지워주기
   				
   			 }
   			 }
   	   	 }) 
   			 });
   	 });

$("#move_lms").click(function(){
	location.href = "<%=request.getContextPath()%>/pf/dashboard"; // lms 바로가기
});
	
$("#myPage").click(function(){
	location.href = "<%=request.getContextPath()%>/pf/mypage"; // 마이페이지
});


</script>
</body>
</html>
