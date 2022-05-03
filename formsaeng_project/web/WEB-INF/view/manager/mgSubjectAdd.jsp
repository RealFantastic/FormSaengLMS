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
	
	
<script>
$(function(){
	console.log("페이지 로드 - jQuery 실행확인");
	deptOption();
	
});
function deptOption(){
	console.log("몇번돌고있니?");
	$.ajax({
		url:"<%=request.getContextPath()%>/deptLoad.ajx",
		type:"post",
		dataType:"json",
		success:function(result){
			console.log(result[0].deptName);
			$("#department").empty();

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
				<form id="frmAdd">
				<!-- 학과명(value = 학과코드) -->
				<select class="select_design font2" name="department" id="department" required onchange="itemChange()">
				</select><br>
				<!-- 생성할 과목명 -->
				과목명 : <input type="text" name="subjectName" id="subjectName" required><br>
				<!-- 과목코드명 -->
				과목코드명 : <input type="text" name="subjectCode" id="subjectCode" required><br>
				<!-- 학년 -->
				<select class="select_design font2" name="grade" id="grade" required>
					<option class='option_design font2' value='' selected>학년 선택</option>
					<option class='option_design font2' value='1' >1학년</option>
					<option class='option_design font2' value='2' >2학년</option>
					<option class='option_design font2' value='3' >3학년</option>
					<option class='option_design font2' value='4' >4학년</option>
				</select><br>
				<!-- 학기 -->
				<select class="select_design font2" name="semester" id="semester" required>
					<option class='option_design font2' value='' selected>학기 선택</option>
					<option class='option_design font2' value='2201' >22학년도 1학기</option>
					<option class='option_design font2' value='2202' >22학년도 2학기</option>
				</select><br>
				<!-- 학점 -->
				<select class="select_design font2" name="credit" id="credit" required>
					<option class='option_design font2' value='' selected>학점 선택</option>
					<option class='option_design font2' value='2' >2학점</option>
					<option class='option_design font2' value='3' >3학점</option>
				</select><br>
				<!-- 강의실 -->
				강의실 : <input type="text" name="classroom" id="classroom" required><br>
				<!-- 강의 정원 -->
				강의 정원 : <input type="text" name="capacity" id="capacity" required><br>
				<!-- 이수구분 전공필수 = 1, 전공 선택 = 0 -->
				<select class="select_design font2" name="classType" id="classType" required>
					<option class='option_design font2' value='' selected>이수구분 선택</option>
					<option class='option_design font2' value='1' >전공필수</option>
					<option class='option_design font2' value='0' >전공선택</option>
				</select><br>
				<!-- 강의요일 선택 -->
				<select class="select_design font2" name="classDate" id="classDate" required>
					<option class='option_design font2' value='' selected>강의요일 선택</option>
					<option class='option_design font2' value='월' >월요일</option>
					<option class='option_design font2' value='화' >화요일</option>
					<option class='option_design font2' value='수' >수요일</option>
					<option class='option_design font2' value='목' >목요일</option>
					<option class='option_design font2' value='금' >금요일</option>
				</select><br>
				<!-- 강의교시 선택 -->
				강의교시 선택
				<lable for="first">1교시<input type='checkbox' id="first" name='period' value='1'></lable>
				<lable for="second">2교시<input type='checkbox' id="second" name='period' value='2'></lable>
				<lable for="third">3교시<input type='checkbox' id="third" name='period' value='3'></lable>
				<lable for="fourth">4교시<input type='checkbox' id="fourth" name='period' value='4'></lable>
				<lable for="fifth">5교시<input type='checkbox' id="fifth" name='period' value='5'></lable>
				<lable for="sixth">6교시<input type='checkbox' id="sixth" name='period' value='6'></lable>
				<lable for="seventh">7교시<input type='checkbox' id="seventh" name='period' value='7'></lable><br>
				<!-- 담당교수명(value = 교수ID) -->
				<select class="select_design font2" name="professor" id="professor" required>
				</select>
			</form>
				<button type="button" onclick="insertSubject()">추가하기</button>
		</div>
	</section>
	
	
	
	<script>
	//학과 선택시 해당 학과 소속의 교수목록을 가져오는 ajax
		function itemChange(){
			console.log($("#department").val());
			var selectDept = $("#department").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/mg/selectPf.ajx",
				type:"get",
				data:{
					"department":selectDept
				},
				//contentType:"application/json; charset:UTF-8",
				dataType:"json",
				success:function(pflist){
					console.log(pflist);
					console.log(pflist[0].name);
					$("#professor").empty();
					var html = "";
					html+="<option class='option_design font2' value='' selected>교수 선택</option>";
					for(var i=0; i<pflist.length; i++){
					html+="<option class='option_design font2' value='"+ pflist[i].id +"'>" + pflist[i].name +"</option>";						
					}
					$("#professor").append(html);
				}
			});	
		}
	//추가 버튼 누를 시 과목 추가하는 ajax
		function insertSubject(){
		 	var deptCode = $("#department").val();
			var subName = $("#subjectName").val();
			var subCode = $("#subjectCode").val();
			var courseGrade = $("#grade").val();
			var courseSemester = $("#semester").val();
			var courseCredit = $("#credit").val();
			var courseClass = $("#classroom").val();
			var courseCapacity = $("#capacity").val();
			var classType = $("#classType").val();
			var courseDay = $("#classDate").val();
			var coursePeriod = new Array();
			var pfName = $("#professor").val();
			var professor = $("#professor").val();
			console.log($("input[name='period']:checked")[0]);
			console.log(deptCode);
			console.log(subName);
			console.log(subCode);
			console.log(courseGrade);
			console.log(courseSemester);
			console.log(courseCredit);
			console.log(courseClass);
			console.log(courseCapacity);
			console.log(classType);
			console.log(courseDay);
			console.log(coursePeriod);
			console.log(pfName);
			
			console.log($("#frmAdd").serialize());
			
			let queryString = $("#frmAdd").serialize();
			
			
			 var timeChecked = $("input[name='period']:checked");
			timeChecked.each(function(){
				coursePeriod.push(this.value);
				console.log(coursePeriod);
			});
			 
			  $.ajax({
				url:"<%=request.getContextPath()%>/mg/addSubject.ajx",
				type:"post",
				data:queryString,
				dataType:"text",
				success:function(result){
					if(result == 0){
						alert("과목 추가에 실패했습니다. 다시 입력해주세요.");
					}else if(result ==1){
						alert("과목 추가에 성공했습니다. 목록으로 돌아갑니다.");
						location.href = "<%=request.getContextPath()%>/mg/mgSubjects";
					}
				}
			  });	
			
		}
	</script>
</body>
</html>