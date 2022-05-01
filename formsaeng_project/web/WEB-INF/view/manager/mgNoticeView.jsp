<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/css/reset.css">
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/css/notice.css">
<%@page import="kh.semi.notice.model.vo.NoticeVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeView</title>
<!--부트스트랩-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<!-- J쿼리 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<!-- 글자 -->
<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">
</head>

<body>
	<form id="boardFrm" action="<%=request.getContextPath()%>/board/insert" method="post"></form>

	<div class="body_div">
		<header class="logo_button">
			<div class="logoimg">
				<img src="./resources/images/fromsaenglogo.png"
					class="fromsaenglogo"> <img src="./resources/images/logo.png"
					class="logo">
			</div>

			<div class="button">
				<button type="button" class="btn btn-success">마이페이지</button>
				<button type="button" class="btn btn-success">LMS바로가기</button>
			</div>
		</header>
		<div class=title_search>
			<div class="title font5">공지사항</div>
			<div class="dropdown notice_search">
				<div class=drop_search>
					<a class="btn btn-secondary dropdown-toggle font3" href="#" role="button"
						id="dropdownMenuLink" data-bs-toggle="dropdown"
						aria-expanded="false"> 전체 </a>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item" href="#">제목</a></li>
						<li><a class="dropdown-item" href="#">내용</a></li>
					</ul>
				</div class=drop_search>
				<div>
					<input class="form-control font3 notice_input" list="datalistOptions"
						id="exampleDataList" placeholder="공지사항 검색">
				</div>
				<div class=drop_search>
					<button type="button" class="btn btn-secondary">검색</button>
				</div>
			</div>
		</div>
		<div class="table_div">
			<table class="table font2 table-hover">
				<thead>
					<tr>
						<th>
							<input type="checkbox" name="allCheck" onclick="allChk(event);"/><!-- onclick 이벤트 -->

						</th>
						<th scope="col">NO</th>
						<th scope="col">제목</th>
						<th scope="col">내용</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일자</th>
					</tr>
				</thead>
				<tbody>
					<%--<tr onclick="detailview(' no ')" data-속성(넣고싶은 이름) ex(data-boardno = '+<%=noticeList.get(0).getBoardNoticeTitle() %>')> --%>
					<c:if test="${fn:length(boardVolist) == 0 }">
						<tr Class="no_list">
							<!-- 보여질 공지사항이 없을 경우 -->
							<td colspan="6"> 조회된 내용이 없습니다. </td>
						</tr>
					</c:if>
					<c:forEach var="notice" items="${boardVolist}">
						<tr Class="nt_detail_list" data-nno="${notice.boardNoticeNo}">
							<td><input type="checkbox" name="chk" value=${notice.boardNoticeNo}></td>
							<th scope="row" class="nno">${notice.rn }</th>
							<td>${notice.boardNoticeTitle }</td>
							<td>${notice.boardNoticeContent }</td>
							<td>${notice.boardNoticeWriter }</td>
							<td>${notice.boardNoticeDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br>

		<!-- 페이징처리 -->
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true"
						class="font3 Page_order">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link font3 Page_order" href="#">1</a></li>
				<li class="page-item"><a class="page-link font3 Page_order" href="#">2</a></li>
				<li class="page-item"><a class="page-link font3 Page_order" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true" class=" font3 Page_order">&raquo;</span>
				</a></li>
			</ul>
		</nav>

		<div class="add_delete">
			<button type="button" id="nt_add_btn" class="btn btn-secondary">공지사항 추가</button>
			<button type="button" id="nt_del_btn" class="btn btn-secondary">공지사항 삭제</button>
		</div>
	</div>


	<script>
		/* 공지사항 추가 버튼 클릭 시 공지사항 등록하기 페이지로 이동 */
		$("#nt_add_btn").click(function() {
			location.href = "mgbinsert";
		})


		/* 공지사항 1건 클릭 시 공지사항 상세 페이지로 이동 */
		/* 강사님 도움 */
		$(".nt_detail_list").click(function(e) {
			if(e.target.type  == 'checkbox'){
				
				return;
				
			}else{
				var noticeNo =$(this).data("nno");
				location.href = "mgbdetail?nno="+noticeNo;
			}
// 			debugger
		})


		/* 공지사항 삭제 버튼 클릭 시 공지사항 삭제하기(앞 체크박스 체크) */
// 		모두 체크 
		function allChk(e){
			// onclick=이벤트가 발생한 정보를 담고있다 여기서는 onclick=allChk(event) 이부분을 얘기함.
			if(e.target.checked){
			// 만약에 e에. target이. checked상태면
				$("input:checkbox[name=chk]").each(function(i,iVal) {
				// input에서 type에서 checkbox이고 name이 chk인것을 each개별로 돌린다.
					if(iVal.checked){
					// 만약 iVal이.checked되어 있으면 
						return;
						//아무것도 안해요
					}else{
					//iVal이.checked <안>되어 있으면
						iVal.click()
						//iVal을.click하세요.
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

		// 공지사항 삭제
		$("#nt_del_btn").click(function() {
			var delList = [];
// 			delList에 배열로 저장된다
			$("input:checkbox[name=chk]").each(function(i,iVal) {
// 			input에서 type이 checkbox인것에 name이 chk인것을 개별로 돌린다.
				if(iVal.checked){
// 				만약에 iVal가 checked면
					delList.push(iVal.value);
// 					delList에 push한다. iVal에 value(값)을
				}
			});

			$.ajax({
				url:"delete.ax",
// 				MgNoticeDeleteServlet.java에 delete.ax로 URL보냄
				type: "post",
// 				타입은 post임
				contentType:"application/json; charset:UTF-8",
// 				json형식으로 바꿔준다
				dataType:"text", 
// 				데이터 타입은 text임
				data: JSON.stringify(delList),
// 				데이터 delList를 json형식으로 바꿔준다. stringfy
				success: function(data){
// 				성공했으면 data를 가지고 함수 실행한다.
					console.log("data : "+ data)
					// 단순값 전달받음. "성공","실패", 1, 0 - 주로 login성공여부, 글작성성공여부
					if(data == "succeess"){
						alert("삭제 되었습니다.");
						
						location.reload();
// 						페이지를 다시 로드한다.
					} else {
						alert("삭제실패");
					}
				},
				error : function(request,status,error) {
				//에러가 나면 함수실행 (ajax를 실행하고 받을 수 있는 값들 request, status, error)
					console.log(request);
					alert("code:"+request.status+"\n"+"message:"+request.responseText+
					"\n"+"error:"+error);
			 	}
			});
			
		});
		
	</script>
</body>
</html>