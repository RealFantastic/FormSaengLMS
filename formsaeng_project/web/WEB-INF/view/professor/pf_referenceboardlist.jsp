<%@page import="com.sun.tools.javac.util.Context"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reset.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/template.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/pfRefBoard.css">
<%@page import="kh.semi.lms.reference.*"%>
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
	<style type="text/css">
	</style>
  </head>
<body>
 <jsp:include page = "/WEB-INF/view/professor/pfHeader.jsp"/>
  <section id="template_content">
    <div class="template_container">
    <% String subCode = request.getParameter("s"); %>
      <input type="hidden" name = "code" value="<%=subCode %>">
      <div class="template-title">
        <h1>강의자료실</h1>
        <hr>
      </div>
      <div class="content_container">
      <div class="board_div">
      <form id = "multidelete" >
        <table class="table table-striped">
        	<thead>
				<tr class = "tcl">
					<th class="bth">
						<input type="checkbox" name="allCheck" onclick="allChk(event);"/>
					</th>
						<th class = "bht2" scope="col">NO</th>
						<th class = "bht3" scope="col">제목</th>
						<th class = "bht4"scope="col">작성자</th>
						<th class = "bht5"scope="col">작성일자</th>
						<th class = "bht6"scope="col">코드</th>
				</tr>
			</thead>
				<tbody>
					<c:forEach var="reference" items="${boardVolist}">
						<tr style="cursor: pointer" data-refno="${reference.lbAno}">
							<td><input class = "ick"id="rowCheck" name="chk" type="checkbox" value="${reference.lbAno}"></td>
							<th scope="row" class ="refno">${reference.lbAno}</th>
							<td id="reflist" class="ref_list">${reference.lbATitle }</td>
							<td class="ref_wr">${reference.lbAWriter}</td>
							<td class="ref_da">${reference.lbADate }</td>
							<td class="ref_co">${reference.lbACode }</td>
						</tr>
					</c:forEach>
				</tbody>
        </table>
        <div class="insert_delet">
			<button type="button" id="ref_in_btn" class="btn btn-secondary">등록</button>
			<input type="button" id="ref_del_btn" class="btn btn-secondary" value="삭제">
		</div>
        </form>
        <!-- 페이징 박스 -->
						<div id="pagingBox">
							<ul class="pagination justify-content-center">
								<!-- startPage에서 -1일 때 -->
								<c:if test="${ startPage > 1 }">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/reflist?pageNum=${startPage-1}">Previous</a></li>
								</c:if>
								<c:if test="${ startPage <= 1 }">
									<li class="page-item disabled"><a class="page-link"
										href="<%=request.getContextPath()%>/reflist?pageNum=${startPage-1}">Previous</a></li>
								</c:if>
								<c:forEach step="1" begin="${startPage }" end="${ endPage}"
									var="idx">
									<c:if test="${idx eq currentPage }">
										<li class="page-item active"><a class="page-link"
											href="<%=request.getContextPath()%>/reflist?pageNum=${idx }">${idx }
										</a></li>
									</c:if>
									<c:if test="${idx ne currentPage }">
										<li class="page-item"><a class="page-link"
											href="<%=request.getContextPath()%>/reflist?pageNum=${idx }">${idx }
										</a></li>
									</c:if>
								</c:forEach>
								<!-- endPage에서 +1일 때 -->
								<c:if test="${endPage < pageCnt }">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/reflist?pageNum=${endPage+1}">next</a></li>
								</c:if>
								<c:if test="${endPage >= pageCnt }">
									<li class="page-item disabled"><a class="page-link"
										href="<%=request.getContextPath()%>/reflist?pageNum=${endPage+1}">next</a></li>
								</c:if>
							</ul>
						</div>
						<div class="list-tap">
						<ul class="list-group list-group-flush">
							<li class="list-group-item"><a href="<%=request.getContextPath()%>/pf/reflist?s=${subCode}">강의 자료실</a></li>
							<li class="list-group-item"><a href="<%=request.getContextPath()%>/pf/asgboard">과제 게시판</a></li>
							<li class="list-group-item"><a href="<%=request.getContextPath()%>/pf/studygroup?s=${subCode}">사용자 및 그룹</a></li>
					    </ul>
					</div>
						</div>
        </div>
        
      </div>
  </section>

  <script>
  		//게시판 insert
		$("#ref_in_btn").click(function() {
			location.href = "<%=request.getContextPath()%>/pf/refinsert?s=${s}";
		})
		//게시판 view
		$(".ref_list").click(function() {		
	/* 			var trArr = new Array();
				var ta = document.getElementById("refno");
				var td = ta.innerText;
				console.log(ta,td); */
				//<th scope="row" class="refno">${reference.lbAno}</th>
			console.log(this);                 
			console.log($(this).parents("tr").children(".refno").text());                 
			let tdValue = $(this).parents("tr").children(".refno").text();
			location.href = "<%=request.getContextPath()%>/pf/detailview?lbAno=" + tdValue;
		});

		function allChk(e){
			if(e.target.checked){
				$("input:checkbox[name=chk]").each(function(i,iVal) {
					if(iVal.checked){
						return;
					}else{
						iVal.click()
					}
				});
				
			}else{
				$("input:checkbox[name=chk]").each(function(i,iVal) {
					if(iVal.checked){
						iVal.click()
					}else{
						return;
					}
				});
			}
		}
//		게시판 삭제 ajax
		$(function() {
			$("#ref_del_btn").click(function() {
				var queryStr = $("#multidelete").serialize();
				if(queryStr == ""){
					alert("삭제할 게시물을 선택하세요.");
				} else {
					$.ajax({
						url : "<%=request.getContextPath()%>/refdelete.ajx",
						type : "post",
						data : queryStr,
						dataType : "text",
						success : function(result){
							if(result == 0){
								alert("삭제 실패했습니다.");
							} else {
								alert(result+"건을 삭제에 성공했습니다.");
								location.reload();
							}
						}
						
						
					});
				}
			});
		});
		
	</script>
</body>
</html>