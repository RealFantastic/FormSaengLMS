<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/template.css">
<%@page import="kh.semi.lms.asg.model.vo.AsgListVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>게시글 작성</title>
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
        <h1>공지사항</h1>
        <hr>
      </div>
      <div class="content_container">
        <!-- 템플릿 -->
<%--        <% 
     //세션에 값이 담겨있는지 체크
     String id = null;
        if(Session.getAttribute("id"))
      
       %>  --%>
        
        
        

	<div>
<form id="pfAsgBoardform"
			action="<%=request.getContextPath()%>/pf/asgboard/modify.do" method="post">
			<div class=title_asg>
				<div class="title">과제게시판 등록하기</div>
			</div>
<% AsgListVo volist = (AsgListVo)request.getAttribute("ssAsgListVo"); %>
			<div class="mb-3 room">
				<div class="font4">제목</div>
				<div class="form-floating">
			<input id="bANo" type="hidden" name="bANo" value="<%= volist.getbANo() %>">
					<textarea class="form-control"
						name="title" placeholder="Leave a comment here"
						id="floatingTextarea"><%= volist.getbATitle() %></textarea>
					<label for="floatingTextarea">제목을 입력하세요.</label>
				</div>
			</div>
			<div class="mb-3 room">
				<div class="font4">내용</div>
				<div class="form-floating">
					<textarea class="form-control"
						name="content" placeholder="Leave a comment here"
						id="floatingTextarea2" style="height: 300px" ><%= volist.getbAContent() %></textarea>
					<label for="floatingTextarea2">내용을 입력하세요.</label>
				</div>
			</div>	
					<button type="submit" class="btn btn-primary" id="modifyBtn">수정하기</button>
					<button type="button" class="btn btn-primary" id="cancelBtn">취소하기</button>
		</form>
	</div>
      </div>
  </section>
</body>
<% if(request.getAttribute("msg") != null) { %>

<script>
window.alert('<%= request.getAttribute("msg") %>');

				
</script>
<% } %>
<!-- <script>
$("#modifyBtn").click(function(){
	console.log("눌렸나 ");
	var frm = $("#pfAsgBoardform");
	frm.attr("action", "asgmodifydo");
	frm.attr("method", "post");
	frm.submit();
});	

$("#cancelBtn").click(function() {
	console.log("안눌러져? ");
});
</script>   -->
</html>