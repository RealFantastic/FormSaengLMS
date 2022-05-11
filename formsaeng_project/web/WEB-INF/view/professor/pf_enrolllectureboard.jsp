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
    <title>강의추가하기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/ef09f998fc.js" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  </head>
<body>

  <jsp:include page="/WEB-INF/view/professor/pfHeader.jsp"/>
  
  <section id="template_content">
    <div class="template_container">
      <div class="template-title">
        <h1>강의추가</h1>
        <hr>
      </div>
      <div class="content_container">
        <!-- 템플릿 -->
        <form id="fileForm" method="post" enctype="multipart/form-data">
        
        <% String subCode = (String)request.getAttribute("subCode"); %> 
 		<% String subName = (String)request.getAttribute("subName"); %>
 		
 		<input id="subCode" name="subCode" type="hidden" value="${subCode }">
 		<input id="subName" name="subName" type="hidden" value="${subName }">
        
       <!-- 주차 -->
       <select id="week" name="week" required>
        <option value="" selected>주차선택</option>
       	<option class="weekSelect" value="2201">1주차</option>
       	<option class="weekSelect" value="2202">2주차</option>
       	<option class="weekSelect" value="2203">3주차</option>
       	<option class="weekSelect" value="2204">4주차</option>
       	<option class="weekSelect" value="2205">5주차</option>
       	<option class="weekSelect" value="2206">6주차</option>
       	<option class="weekSelect" value="2207">7주차</option>
       	<option class="weekSelect" value="2208">8주차</option>
       	<option class="weekSelect" value="2209">9주차</option>
       	<option class="weekSelect" value="2210">10주차</option>
       	<option class="weekSelect" value="2211">11주차</option>
       	<option class="weekSelect" value="2212">12주차</option>
       	<option class="weekSelect" value="2213">13주차</option>
       	<option class="weekSelect" value="2214">14주차</option>
       	<option class="weekSelect" value="2215">15주차</option>
       </select>
       
       <!-- 영상 업로드 -->
					<table border=1>
						<tr>
							<td colspan=2 align="center"><h3>파일 업로드</h3></td>
						</tr>
						<tr>
							<td>제목 :</td>
							<td><input type="text" name="lectureName" required></td>
							<br>
						</tr>
						<tr>
							<td>파일명1 :</td>
							<td><input type="file" name="fileName1" id="fileName1" required></td>
							<br>
						</tr>
						<tr>
							<td>파일명2 :</td>
							<td><input type="file" name="fileName2" id="fileName2"></td>
							<br>
						</tr>
					</table>
							<button type="button" onclick="fn_insertFile();">파일업로드</button>
				</form>
       
        </div>
      </div>
  </section>
</body>
<script>
	function fn_insertFile(){
		var fileForm = $("#fileForm").serialize();
		console.log(fileForm);
		var form = $("#fileForm")[0];
		console.log(form);
		var data = new FormData(form);
		
		/* data.append('file', $('input[type=file]')[0].files[0]); */
		
		$.ajax({
			url : "<%=request.getContextPath()%>/pf/week/insert.do",
			type : "post",
			data : data,
			enctype : "multipart/form-data",
			contentType: false,
			processData: false,
			success : function(data){
				console.log(data);
				console.log("컨트롤러 다녀옴.");
				if(data == 0){
					alert("실패했습니다.");
				} else {
					alert(data+"성공했습니다.");
					var subCode = $("#subCode").val();
					var subName = $("#subName").val();
					location.reload();
					location.href="<%=request.getContextPath()%>/pf/week?s="+subCode+"&n="+subName;
				}
			},
			error : function(request, status, error){
	        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
		});
		
	};
</script>

</html>