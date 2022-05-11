<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/template.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stg.css">
<%@page import="kh.semi.lms.group.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>강의자료실</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/ef09f998fc.js" crossorigin="anonymous"></script> 
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
	<style>
	</style>
  </head>
<body>
  <jsp:include page = "/WEB-INF/view/professor/pfHeader.jsp"/>
  <section id="template_content">
    <div class="template_container">
      <div class="template-title">
        <h1>사용자 및 그룹</h1>
        <hr>
      </div>
      <div class="content_container">
      <table class = "ta">
        	<thead>
				<tr Class = "stgtop">
					<th class = "th1" scope="col">학번</th>
					<th class = "th2"scope="col">코드</th>
					<th class = "th3"scope="col">이름</th>
					<th class = "th4"scope="col">과목이름</th>
				</tr>
			</thead>
				<tbody class = "tbc">
					<c:forEach var="StudyGroup" items="${StudyGrouplist}">
				 		<tr class = "rowtr">
						<td Class="sgp_id">${StudyGroup.eId}</td>
							<th  class = "sgp_code "scope="row" id ="">${StudyGroup.sCode}</th>
							<td id="sgplist" class="sgp_name">${StudyGroup.mName}</td>
							<td class="sgp_sname">${StudyGroup.sName}</td>
							</tr>
					</c:forEach>
				</tbody>
        </table>
        <div class="list-tap">
            <ul class="list-group list-group-flush">
				<li class="list-group-item"><a href="<%=request.getContextPath()%>/st/reflist?s=${subCode}">강의 자료실</a></li>
				<li class="list-group-item"><a href="<%=request.getContextPath()%>/st/asgboard">과제 게시판</a></li>
				<li class="list-group-item"><a href="<%=request.getContextPath()%>/st/studygroup?s=${subCode}">사용자 및 그룹</a></li>
			</ul>
        </div>
      </div>
  </section>

</body>
</html>