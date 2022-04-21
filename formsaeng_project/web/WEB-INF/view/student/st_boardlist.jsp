<%@page import="kh.semi.board.model.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
ArrayList<BoardVo> volist = (ArrayList<BoardVo>)request.getAttribute("boardVolist");
%>
<%-- <%=volist.size() %> --%>
	<div><button onclick="location.href='boardwriter';">글쓰기</button></div>
	<div>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>제목 [댓글수]</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
	<% for(BoardVo vo : volist){ %>
			<tr>
				<td><%=vo.getBANo() %></td>
		<!-- Todo:수정 -->		<td><a href="boardread?bno=<%=vo.getBANo()%>"><%=vo.getBATitle() %> [<%=vo.getReCommentCnt() %>]</a></td>
				<td><%=vo.getBAWriter() %></td>
				<td><%=vo.getBADate() %></td>
				
			</tr>
	<%} %>
		</table>
	</div>
</body>
</html>