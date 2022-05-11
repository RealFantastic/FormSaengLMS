<%@page import="kh.semi.lms.reference.vo.ReferenceVo"%>
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
    <title>템플릿만들기</title>
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
  </head>
<body>
  <jsp:include page = "/WEB-INF/view/professor/pfHeader.jsp"/>
  <section id="template_content">
    <div class="template_container">
      <div class="template-title">
        <h1>공지사항</h1>
        <hr>
      </div>
      <div class="content_container">
  			<form id="pf_readform"action="<%=request.getContextPath()%>/detailview" method="post">
  			<% String subCode = request.getParameter("s"); %>
  			
		<div class="body_div">
			
			<div class=title_search>
				<div class="title">강의자료실 상세보기</div>
				<div class="button_enroll">
					
				</div>
			</div>

			<% ReferenceVo volist = (ReferenceVo)request.getAttribute("refview"); %>
			<input id="lbAno" type="hidden" value="<%=volist.getLbAno() %>">
			<div class="mb-3 room">
				<div class="font4">제목</div>
				<div class="form-floating">
					<div class="ref_title" name="ref_title">
						<%= volist.getLbATitle() %>
					</div>
				</div>
			</div>
			<div class="mb-3 room">
				<div class="font4">내용</div>
				<div class="form-floating">
					<div class="ref_content" name="ref_content">
						<%= volist.getLbAContent() %>
					</div> 
				</div>
			</div>
	</div>
	<button type=button id="ref_list" class="btn_list">목록</button>
	</form>

	</div>
      </div>
  </section>
  <script>
  $("#ref_list").click(function() {
	  history.back();
  });
  
  </script>
</body>
</html>