<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import = "javax.servlet.ServletContext" %>
<c:if test="${empty loginUser}">
	<jsp:forward page = 'board.do?command=index' />
</c:if>
<!-- 로그인 유저가 없을 경우 로그인창으로 돌아감 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/script.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>게시글 등록</h1>
<form name="frm" method="post" action="board.do?command=boardwrite" enctype="multipart/form-data">
	<table>
		<tr>
			<th>작성자</th>
			<td>
				${ loginUser.userid }
				<input type="hidden" name="userid" value="${ loginUser.userid }">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pass">
				* 필수 (게시물 수정/삭제 시 필요합니다.)
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email" value="${ loginUser.email }">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" size="70" name="title"> *필수
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea cols="70" rows="15" name="content"></textarea> *필수
			</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
				<input type="file" name="imgfilename"/>
			</td>
		</tr>
	</table>
		<input type="submit" value="등록" onClick="return boardCheck();">
		<input type="reset" value="다시 작성" >
		<input type="button" value="목록으로" onClick="location.href='board.do?command=main'" >
	
</form>
</div>
</body>
</html>