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
  </head>
<body>
  <jsp:include page = "/WEB-INF/view/professor/pfHeader.jsp"/>
  <section id="template_content">
    <div class="template_container">
      <div class="template-title">
        <h1>강의자료실</h1>
      </div>
      <div class="content_container">
        <form id="refinsertform">
      	<% String subCode = request.getParameter("s"); %>
			<input type="hidden" name = "code" value="<%=subCode %>">
			<div class="mb-3 room">
				<div class="form-group">
				    <label for="reftitle">제목</label>
				    <input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력하세요.">
				</div>
			</div>
			<div class="mb-3 room">
				<div class="form-group">
				    <label for="refcontent">내용</label>
					<textarea class="form-control" name="content" rows="20" id="content" placeholder="내용을 입력하세요."></textarea>
				</div>
			</div>
			<div class="button_enroll">
					<button type="button" class="btn btn-primary" id="insertBtn">공지사항
						등록</button>
					<button type="button" id="ref_list_btn" class="btn btn-primary">공지사항 목록</button>
					
				</div>
		</form>
      </div>
      </div>
      <script>
      	$("#insertBtn").click(function(){
      		var queryString = $("#refinsertform").serialize();
      		console.log(queryString);
      		if(queryString != null){
      			$.ajax({
      				url:"<%=request.getContextPath()%>/pf/refinsert.do",
      				data:queryString,
      				type:"post",
      				dataType:"text",
      				success:function(data){
      					if(data ==0){
      						alert("자료등록실패");
      						history.back();
      					}else{
      						alert("자료등록 성공");
      						location.href='<%= request.getContextPath()%>/pf/reflist?s=<%=subCode %>';
      					}
      				}
      			})
      		}
      	});
      </script>
  </section>
</body>
</html>