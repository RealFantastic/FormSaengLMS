<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/SubjectsList.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
					<a href="/WEB-INF/view/manager/mgmain.jsp"><img class="logo2"
						src="<%=request.getContextPath()%>/resources/images/fromsaenglogo.png"
						alt="폼생대로고"></a> <a href="/WEB-INF/view/manager/mgmain.jsp"><img class="logo1"
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
				<h2 class="font5">추가한 과목 목록</h2>
			</div>
			<div class="search">
				<select class="select_design font2" name="search" id="requirement">
					<option class="option_design font2" value="dept" selected>학과 검색</option>
					<option class="option_design font2" value="name">과목 검색</option>
					<option class="option_design font2" value="type">이수구분 검색</option>
					<option class="option_design font2" value="grade">학년 검색</option>
				</select> <input type="text" class="form-control search_input"
					id="search_word" name="search_word" placeholder="검색어를 입력하세요">
				<button type="button" class="btn btn-secondary">검색</button>
			</div>
		</div>
		<div class="subject_list_container">
			<form id= 'frmCheck'>
				<table class="table">
					<thead>
						<tr>
							<th scope="col"><input type="checkbox" name="allCheck"
								id="allCheck"></th>
							<th scope="col">학과명</th>
							<th scope="col">과목명</th>
							<th scope="col">학점</th>
							<th scope="col">과목 구분</th>
							<th scope="col">담당 교수</th>
							<th scope="col">강의실명</th>
							<th scope="col">강의 교시</th>
						</tr>
					</thead>
					<tbody>
	
						<c:forEach var="subject" items="${subList}">
							<tr>
								<th scope="row"><input type="checkbox" name="checkRow"
									class="checkRow" value='${subject.subCode }'></th>
								<th scope="row">${subject.deptName }</th>
								<th scope="row">${subject.subName }</th>
								<td>${subject.courseCredit }</td>
								<td>${subject.classType }</td>
								<td>${subject.pfName }</td>
								<td>${subject.courseClass }</td>
								<td>${subject.coursePeriod }</td>
							</tr>
						</c:forEach>
				</table>
			</form>
			<div id= "page_box">
				<div id = "paging">
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					  <c:if test="${startPage gt 1 }">
					   <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/mg/Subjects?p=${startPage-1}">Previous</a></li>
					  </c:if>
					  <c:if test="${startPage le 1 }">
					    <li class="page-item disabled">
					   		<a class="page-link" href="<%=request.getContextPath()%>/mg/Subjects">Previous</a>
					   </li>
					  </c:if>
					  <c:forEach step="1" begin="${startPage }" end="${endPage }" var="index">
					  	<c:if test="${index eq currentPage }">
					  		<li class="page-item active" aria-current="page">
					  			<a class="page-link" href="<%=request.getContextPath()%>/mg/Subjects?p=${index}">${index }</a>
					  		</li>
					  	</c:if>
					  	<c:if test="${index ne currentPage }">
					  		<li class="page-item">
					  			<a class="page-link" href="<%=request.getContextPath()%>/mg/Subjects?p=${index}">${index}</a>
					  		</li>
					  	</c:if>
					  </c:forEach>
					  <c:if test="${endPage lt pageCnt }">
					   <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/mg/Subjects?p=${endPage + 1}">Next</a></li>
					  </c:if>
					  <c:if test="${endPage ge pageCnt }">
					   	<li class="page-item disabled">
					   		<a class="page-link" href="<%=request.getContextPath()%>/mg/Subjects?p=${endPage + 1}">Next</a>
					   	</li>
					  </c:if>
					  </ul>
					</nav>
				</div>
				<div id = button_box>
					<button type="button" id="addSubject" class="btn btn-primary">과목
						추가하기</button>
					<button type="button" id="delSubject" class="btn btn-primary">선택 과목
						삭제하기</button>
				</div>
			</div>
		</div>
	</section>
	<script>
		$("#addSubject").click(function() {
			location.href = "addSubject";
		});
		//전체선택 전체선택 해제 설정
		$("#allCheck").click(function(){
			if($("#allCheck").prop("checked")){
				console.log("전체 누름");
				$(".checkRow").prop("checked",true);
				var checkedVal= new Array();
				$("input[name='checkRow']:checked").each(function(){
					checkedVal.push(this.value);
				});
				console.log(checkedVal);
			}else{
				console.log("전체 지움");
				$(".checkRow").prop("checked",false);
			}
		});
		//하나라도 선택 해제시 전체선택 해제
		$(".checkRow").click(function(){
			if($("#allCheck").prop("checked")){
				$("#allCheck").prop("checked",false)
			}
		});
		
		//체크박스 값 넘기기
		$("#delSubject").on("click",function(){
			let queryString = $("#frmCheck").serialize();
			console.log(queryString);
			
			if(queryString == "" || queryString == null){
				alert("삭제할 과목을 선택하세요.");
			}else{
				$.ajax({
					url:"delSubject.ajx",
					type:"post",
					data:queryString,
					dataType:"text",
					success:function(result){
						console.log("칸츄롤라 갔다왔지롱");
						if(result == 0){
							alert("삭제에 실패했습니다. 다시 시도해주세요.");
						}else if(result != 0){
							console.log(result);
							alert(result + "개의 선택 과목을 삭제 완료했습니다.");
							location.href = "mgSubjects";
						}
						
					}
					
				});
			}
		});
	</script>
</body>
</html>