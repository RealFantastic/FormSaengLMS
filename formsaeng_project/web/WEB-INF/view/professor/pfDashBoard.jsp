<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/dashBoard.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>대시보드 - 교수</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/ef09f998fc.js" crossorigin="anonymous"></script>  
  </head>
<body>
  <jsp:include page = "/WEB-INF/view/professor/pfHeader.jsp"/>
  <section id="template_content">
    <div class="template_container">
		<div class="template-title">
		  <h1>대시보드</h1>
		  <hr>
		</div>
		<div class="content_container">
			<div class="dashboard_box">
				<c:forEach var="subject" items="${teachList }">
						<div class="card subject_card" style="width: 16rem;">
							<a href = "<%=request.getContextPath()%>#?subCode='${subject.subCode }'">
								<p class="random_color"></p>
								<div class="card-body">
									<h5 class="card-title">${subject.subName }</h5><span class=font2>정원 : ${subject.courseCapacity }명</span>
									<p class="card-text">${subject.courseDay} / ${subject.coursePeriod } 교시</p>
								</div>
							</a>
						</div>
				</c:forEach>
			</div>
		</div>
	</div>
  </section>
  
  
  <script>
  window.onload = function(){
	  colorChange();	
  }
  
  function colorChange(){
		let colorDiv = document.getElementsByClassName("random_color"); 
		console.log(colorDiv);
		
		for(var i =0; i <colorDiv.length; i++){
			var colorCode = "#" + Math.round(Math.random() * 0xffffff).toString(16);
			colorDiv[i].style.backgroundColor = colorCode;
		}
  }
  		
  </script>
</body>
</html>