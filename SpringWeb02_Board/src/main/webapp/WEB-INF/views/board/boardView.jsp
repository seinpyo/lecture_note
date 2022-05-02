<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board.css'/>">
<script src ="<c:url value="/resources/script/board.js"/>"></script>
</head>
<body>
<div id="wrap" align="center">
<h1> 게시글 상세보기 </h1>
<table>
	<tr>
		<th>작성자</th>
		<td>${ board.userid }</td>
		<th>이메일</th>
		<td>${ board.email }</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><fmt:formatDate value="${ board.writedate }"/></td>
		<th>조회수</th>
		<td>${ board.readcount }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td  colspan="3">${ board.title }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="2"><pre>${ board.content }</pre></td>
		<th width="100">이미지</th>
		<td width="300" align="center">
		 <c:choose>
		 	<c:when test="${empty board.imagefilename}">
		 		<img src="resources/upload/noname.jpg" width="200">
		 	</c:when>
		 	<c:otherwise>
		 		<img src ="resources/upload/${board.imagefilename}" width="200">
		 	</c:otherwise>
		 </c:choose>
		</td>
	</tr>
</table><br><br>
<input type="button" value="리스트" onClick="location.href='boardList'">
<input type="button" value="수정" onClick="open_win('boardEditForm?num=${board.num}', 'update');">
<input type="button" value="삭제" onClick="open_win('boardDeleteForm?${board.num}', 'delete');">
<br><br>
<!-- 댓글 영역 -->
<!-- 오늘 날짜 표시 -->
<c:set var="now" value="<%=new java.util.Date()%>"></c:set> 
<form action="addReply" method="post" name="frm2">
<input type="hidden" name="boardnum" value="${board.num}">
<table>
	<tr align="center">
		<th>작성자</th>
		<th>작성일시</th>
		<th>내용</th>
		<th>수정/삭제</th>
	</tr>
	<tr align="center">
		<td width="100">${loginUser.userid}
			<input type="hidden" name="userid" value="${loginUser.userid}">
		</td>
		<td width="100"><fmt:formatDate value="${now}" pattern="MM/dd HH:mm" /></td>
		<td width="760"><input type="text" name="content" size="80"></td>
		<td width="100"><input type="submit" value="작성" onClick="return reply_check();"></td>
	</tr>
	<c:forEach var="reply" items="${replyList}">
		<tr>
			<td align="center">${reply.userid}</td>
			<td><fmt:formatDate value="${reply.writedate}" pattern="MM/dd HH:mm"></fmt:formatDate></td>
			<td>${reply.content}</td>
			<td align="center">
				<c:if test="${reply.userid==loginUser.userid}">
					<input type="button" value="삭제" 
					onClick="location.href='deleteReply?num=${reply.num}&boardnum=${reply.boardnum}'">
				</c:if>&nbsp;
			</td>
		</tr>
	</c:forEach>
</table>
</form>
</div>
</body>
</html>