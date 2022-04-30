<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/SubjectsList.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 - 수강신청</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link
	href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<div class="header_container">
			<div class="header_wrapper">
				<div class="univ_logo">
					<a href="#"><img class="logo2"
						src="<%=request.getContextPath()%>/resources/images/fromsaenglogo.png"
						alt="폼생대로고"></a> <a href="#"><img class="logo1"
						src="<%=request.getContextPath()%>/resources/images/name_logo.png"
						alt="폼생대학교"></a>
				</div>
				<div class="move_page_buttons">
					<button class="btn btn-success" id="myPage">마이 페이지</button>
					<button class="btn btn-success" id="move_lms">LMS 바로가기</button>
				</div>
			</div>
		</div>
	</header>
	<section id="subjects">
		<div class="content_title">
			<div class="title_name">
				<h2 class="font5">수강신청 과목 추가</h2>
			</div>
		</div>
		<div class="add_field">
			<select class="select_design font2" name="department" id="department">
			</select>
			<input type="text" name="deptCode" id="deptCode" readonly="readonly">
		</div>
	</section>
	
	
	
	<script>
		$(function(){
			console.log("페이지 로드 - jQuery 실행확인");
			deptOption();
			
		});
		function deptOption(){
			$.ajax({
				url:"deptLoad.ajx",
				type:"post",
				dataType:"json",
				success:function(result){
					console.log(result[0].deptName);
					var html ="<option class='option_design font2' value='' selected>학과 선택</option>";
					for(var i = 0; i < result.length; i++){						
					html+= "<option class='option_design font2' value='"+ result[i].deptCode +"'>" +result[i].deptName +"</option>";
					}
					$("#department").append(html);
					

				},
				error : function(request,status,error){
					console.log(request);
					alert("code:"+request.status+"\n"+"message:"+request.responseText+
							"\n"+"error:"+error);
					console.log("code:"+request.status+"\n"+"message:"+request.responseText+
							"\n"+"error:"+error);
				}
			});
		}
	</script>
</body>
</html>