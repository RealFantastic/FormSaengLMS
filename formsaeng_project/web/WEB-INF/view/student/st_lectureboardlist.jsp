<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/template.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/stWeekList.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>템플릿만들기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/ef09f998fc.js" crossorigin="anonymous"></script>  
  </head>
<body>

  <jsp:include page="/WEB-INF/view/student/stHeader.jsp"/>
  
	<section id="template_content">
		<div class="template_container">
			<div class="template-title">
			<% String subName = (String)request.getAttribute("subName"); %>
 			<% String subCode = (String)request.getAttribute("subCode"); %> 
 		
				<h1 id="subName"><%= subName %></h1>
 			<input id="subCode" name="subCode" type="hidden" value="${subCode }">
				<hr>	
			</div>
			<div class="content_container">
				
				<!-- 템플릿 -->

				<div class="accordion" id="accordionExample">
					<c:if test="${not empty lectureVolist }">
						<c:forEach items="${lectureVolist}" var="vo">
							<c:set var="i" value="${i+1 }" />
							<div class="accordion-item">
								<h2 class="accordion-header" id="heading${vo.cName }">
									<c:choose>
										<c:when test="${ i == 0}">
											<button class="accordion-button collapsed" type="button"
												data-bs-toggle="collapse"
												data-bs-target="#collapse${vo.cName }" aria-expanded="true"
												aria-controls="collapse${vo.cName }"></button>
										</c:when>
										<c:otherwise>
											<button class="accordion-button collapsed" type="button"
												data-bs-toggle="collapse"
												data-bs-target="#collapse${vo.cName }" aria-expanded="false"
												aria-controls="collapse${vo.cName }">
												${i }주차
									</button>
										</c:otherwise>
									</c:choose>
									
								</h2>
								<div id="collapse${vo.cName }"
									class="accordion-collapse collapse"
									aria-labelledby="heading${vo.cName }"
									data-bs-parent="#accordionExample">
									<div class="accordion-body">
										<a href="<%=request.getContextPath()%>/st/week/video?lecNo=${vo.lecNo}&s=${subCode}&n=${subName}" style="text-decoration: none;"><strong>${vo.vTitle }</strong></a>
										<input type="hidden" id="video" value="" />
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>

				</div>
				<div class="list-tap">
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a href="<%=request.getContextPath()%>/st/reflist?s=${subCode}">강의 자료실</a></li>
						<li class="list-group-item"><a href="<%=request.getContextPath()%>/st/asgboard">과제 게시판</a></li>
						<li class="list-group-item"><a href="<%=request.getContextPath()%>/st/studygroup?s=${subCode}">사용자 및 그룹</a></li>
					 </ul>
				</div>
	</section>
</body>
</html>