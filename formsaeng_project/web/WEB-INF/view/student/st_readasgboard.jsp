<%@page import="java.io.PrintWriter"%>
<%@page import="kh.semi.member.model.vo.MemberVo"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/template.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/stAsgBoardView.css">
<%@page import="kh.semi.lms.asg.model.vo.AsgListVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>템플릿만들기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
    crossorigin="anonymous">
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
				<h1>과제 게시판</h1>
				<hr>
			</div>
			<div class="content_container">
				<!-- 템플릿 -->

				<div class="body_div">
					<%
					// 현재 세션 상태를 체크
					String id = null;
					MemberVo vo = (MemberVo) request.getSession().getAttribute("ssMemberVo");
					if(vo.getId() != null){
						id = vo.getId();
					}
					
					
					%>

					<%
						AsgListVo volist = (AsgListVo) request.getAttribute("readBoard");
					%>
					

					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">
							제목</label> <input type="text" class="form-control" id="asg_title"
							name="asg_title" value="<%=volist.getbATitle()%>" readonly>
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">
							작성자</label> <input type="text" class="form-control" id="asg_writer"
							name="asg_writer" value="<%=volist.getbAWriter()%>" readonly>
					</div>
					<div class="mb-3">
						<label for="exampleFormControlTextarea1" class="form-label">내용</label>
						<textarea class="form-control" id="asg_content" name="asg_content"
							rows="3" readonly><%=volist.getbAContent()%></textarea>
					</div>
					
					<div class="view-btn">
						<button type="button" id="asg_list" class="btn btn-secondary">목록</button>
					</div>
					<br><br>

					<form id="fileForm" method="post" enctype="multipart/form-data">
					<input id="bANo" name="bANo" type="hidden" value="<%=volist.getbANo()%>">
					<hr>
					<div>
						<div class="comment-txt">
							<textarea id="cmtCnt" name="cmtCnt"
								placeholder="여러분의 소중한 댓글을 입력해주세요."></textarea>
						</div>
						<div class="view-btn">
						<!-- 파일 업로드 -->
						<span><input type="file" name="fileName1" id="fileName1" required></span>
						<!-- 댓글 달기 버튼 -->
							<button type="button" id="cmtCnt-btn" class="btn btn-secondary" onclick="fn_insertFile();">댓글달기</button>
						</div>
					</div>
					</form>
					<hr>
					<div>
						
						<table class="cmt-tb">
								<tr class="row-cmt-tb">
									<td class="th-cmt-tb">댓글번호</td>
									<td class="th-cmt-tb">작성자</td>
									<td class="th-cmt-tb">내용</td>
									<td class="th-cmt-tb">시간</td>
									<td class="th-cmt-tb">파일</td>
									<td class="th-cmt-tb"></td>
								</tr>
							<c:forEach items="${commentList}" var="avo">
								<tr class="row-cmt-tb">
<%-- 							<input type="hidden" id="cNo" value="${avo.cNo }"> --%>
									<td class="th-cmt-tb cNo">${avo.cNo }</td>
									<td class="th-cmt-tb">${avo.cWriter }</td>
									<td class="th-cmt-tb">${avo.cContent }</td>
									<td class="th-cmt-tb">${avo.cDate }</td>
									<td class="th-cmt-tb"><a href="<%=request.getContextPath()%>/st/asgboard/read/down?file=${avo.fName}">${avo.fName }</a></td>
									<td>
									<c:if test ="${avo.id eq ssMemberVo.id}">
									<button type="button" id="delCmt-btn" class="delCmt-btn" cno="${avo.cNo}">삭제</button>
									</c:if>
									</td>
								</tr>
							</c:forEach>
						</table>
						
					</div>
				</div>
				<!-- 목록 탭 -->
				<div class="list-tap">
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a href="">강의 목록</a></li>
						<li class="list-group-item"><a href="">강의 자료실</a></li>
						<li class="list-group-item"><a href="">과제 게시판</a></li>
						<li class="list-group-item"><a href="">사용자 및 그룹</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<script>
		
		// asgboard 리스트 메인으로 이동
		$("#asg_list").click(function() {
			location.href = "<%=request.getContextPath()%>/st/asgboard";
  	});
	 
  //댓글 작성
  	function fn_insertFile(){
	  var fileForm = $("#fileForm").serialize();
	  console.log(fileForm);
	  var form = $("#fileForm")[0];
	  console.log(form);
	  var data = new FormData(form);
	  
	  $.ajax({
			url : "<%=request.getContextPath()%>/st/asgboard/read/comment",
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
					location.reload();
				}
			},
			error : function(request, status, error){
	        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	  })
	  
  };
  
  
  //댓글 삭제
  $(".delCmt-btn").click(function(){
	 	var cNo = $(this).attr('cno');
	 	console.log(cNo);
	 		$.ajax({
	 			url : "<%=request.getContextPath()%>/st/asgboard/read/delete.ax",
	 			type : "post",
	 			data : { cNo : cNo },
	 			dataType : "json",
	 			success : function(result){
	 				console.log(result);
	 				console.log("컨트롤러 다녀옴.")
	 				if(result == 0){
	 					alert("실패했습니다.")
	 				} else{
	 					alert("성공했습니다")
	 					location.reload();
	 				}
	 			}
	 		})
	 	
  });
  
  </script>
  <% session.removeAttribute("msg"); %>

</body>
</html>