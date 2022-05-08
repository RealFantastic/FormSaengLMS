<%@page import="kh.semi.member.model.vo.MemberVo"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/stMyPage.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/MainTemplateHeader.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 마이페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<%MemberVo vo = (MemberVo)request.getAttribute("MyPageVo"); %>
<div class="container justify-content-center">
<jsp:include page="/WEB-INF/view/student/MainTemplateHeader.jsp"/>
<form> 
  <div class="d-flex row">
    <label for="name" class="label col-1">이름</label>
    <div class="inputgroup col-6">
      <input type="text" readonly id="name" class="border-0" value=<%=vo.getName()%>>
    </div>
  </div><br>
    <div class="d-flex row">
    <label for="id" class="label col-1">학번</label>
    <div class="inputgroup col-6">
      <input type="text" readonly  id="id" class="border-0" value=<%=vo.getId()%>>
    </div>
  </div><br>
     <div class="d-flex row">
	<label for="deptName" class="label col-1">학과</label>
    <div class="inputgroup col-6">
      <input type="text" readonly  id="deptName" class="border-0" value=<%=vo.getDeptName()%>>
    </div>
  </div><br>
   <div class="d-flex row">
  	<label for="pnum" class="label col-1">연락처</label>
    <div class="inputgroup col-6">
      <input type="text" readonly  id="pnum" class="border-0" value=<%=vo.getPnum()%>>
    </div>
  </div><br>
     <div class="d-flex row">
    <label for="address" class="label col-1">주소</label>
    <div class="inputgroup col-7">
      <input type="text" readonly  id="address" class="border-0 col-7" value="<%=vo.getAddress()%>">
    </div>
  </div><br>
  <div class="d-flex row">
    <label for="email" class="label col-1">이메일</label>
    <div class="inputgroup col-7">
      <input type="text" readonly  id="email" class="border-0 col-7" value=<%=vo.getEmail()%>> 
    </div>
  </div>
</form>

<!-- Button trigger modal -->
<button type="button" id="myModal" class="btn btn-primary">
  수정하기
</button>
</div>
<!-- Modal -->
<div class="modal" id="exampleModal" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">비밀번호 확인</h5>
      </div>
      <div class="modal-body">
        <input type="password" id="pwdcheck" class="form-control" name="pwdcheck" placeholder="비밀번호를 입력하세요">
      </div>
      <div class="modal-footer">
        <button type="button" id="submit" class="btn btn-primary submit">확인</button>
        <button type="button" class="btn btn-secondary close">취소</button>
      </div>
    </div>
  </div>
</div>

<script>

$("#lms").click(function(){
	location.href = "<%=request.getContextPath()%>/st/dlist"; // lms 바로가기
});
	
$("#stmain").click(function(){
	location.href = "<%=request.getContextPath()%>/st/main"; // 메인페이지
});


// 모달
$(function(){
    $("#myModal").on("click",function(){
       console.log("모달 안녕");
       $(".modal").fadeIn(150);
       $(".close").on("click",closeModal);
       $(".modal").on("click",closeModalWindow);
    });
    
    function closeModal(){
       $(".modal").hide();
    }
    function closeModalWindow(){
       if(event.target == $(".modal").get(0)){
          console.log('모');
           $(".modal").hide();
           $(".modal").off("click",closeModalWindow); 
       }
          
    }
}); 

$("#myPage").hide();
// 정보 수정하기
 $(function() {
	
	 $("#submit").on('click', function() {
		 
	 $.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
	 type : "POST",
	 url : "<%=request.getContextPath()%>/stpwdcheck.do",
	 data : {
	 pwdcheck : $("#pwdcheck").val().trim(),
	 },
	 success : function(result) {
	 if(result == "성공"){
		 console.log(result);
		alert("비밀번호가 확인되었습니다"); 
		$(".modal").hide();
		$("#pwdcheck").val(""); // 비번 삭제해주기
		location.href = "<%=request.getContextPath()%>/st/mypagem";
<%-- location.replace('<%=request.getContextPath()%>/st/mypagem') ; --%>
	 } else if(result == "실패"){
		alert("비밀번호가 일치하지 않습니다. 다시 시도해");
		$("#pwdcheck").focus();
	 }
	 }
	 });
	 })
}); 

</script>
</body>
</html>
