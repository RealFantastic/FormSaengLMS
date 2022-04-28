<%@page import="kh.semi.member.model.vo.MemberVo"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/stMyPage.css">
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
<header>
<div class="font5">마이페이지</div>
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
   <div class="form-group row">
  	<label for="pnum" class="col-sm-2 col-form-label">연락처</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="pnum" value=<%=vo.getPnum()%>>
    </div>
  </div>
     <div class="form-group row">
    <label for="address" class="col-sm-2 col-form-label">주소</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="address" value=<%=vo.getAddress()%>> <!-- 띄어쓰기 뒤에 안 나옴 -->
    </div>
  </div>
  <div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="email" value=<%=vo.getEmail()%>> 
    </div>
  </div>
<!--   <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword" placeholder="">
    </div>
  </div> -->
</form>
<script>

$("#lms").click(function(){
	location.href = "stdlist"; // lms 바로가기
});
	
$("#stmain").click(function(){
	location.href = "stmain"; // 메인페이지
});

</script>
</body>
</html>
