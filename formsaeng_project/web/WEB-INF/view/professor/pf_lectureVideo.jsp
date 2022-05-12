<%@page import="kh.semi.lms.lecture.model.vo.LectureVo"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/template.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>동영상강의</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/ef09f998fc.js" crossorigin="anonymous"></script>  
  </head>
<body>
 
 <jsp:include page="/WEB-INF/view/professor/pfHeader.jsp"/>
 
  <section id="template_content">
    <div class="template_container">
      <div class="template-title">
        <h1>동영상강의</h1>
        <hr>
      </div>
      <div class="content_container">
        <!-- 템플릿 -->
        <% String subCode = (String)request.getAttribute("subCode"); %>
        <% String subName = (String)request.getAttribute("subName"); %>
        <input name=subCode id="subCode" type="hidden" value="${subCode}">
        <input name=subName id="subName" type="hidden" value="${subName}">
        
        <% LectureVo vo = (LectureVo)request.getAttribute("lecturePath"); %>
        <input name=subCode id="subCode" type="hidden" value="<%=vo.getSubCode() %>">
        <div><button type="button" id="list_btn" class="btn btn btn-secondary">목록</button></div>
        
        <video id="videoPlay" width="700" height="600" controls autoplay>      
			    <source type="video/ogg" src="<%=request.getContextPath()%><%=vo.getfPath() %><%=vo.getfName() %>"/>      
			    <source type="video/mp4" src="<%=request.getContextPath()%>${vo.fPath }${vo.fName}"/>
			    <source type="video/wav" src="<%=request.getContextPath()%>${vo.fPath }${vo.fName}"/>
			</video>
        
        
       </div>
      </div>
        
  </section>
  <script>
  $("#list_btn").click(function(){
	  console.log($("#subCode").val());
	  var s = $("#subCode").val();
	  var n = $("#subName").val();
	  location.href="<%=request.getContextPath()%>/pf/week?s="+s+"&n="+n;
  }) 
  </script>;
</body>
</html>