<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board.css'/>">
<script src ="<c:url value="/resources/script/board.js"/>"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>회원 정보 수정</h1>
	<form action="memberEdit" method="post" name="frm">
	<input type="hidden" name="command" value="join">
	<table class="list">
		<tr>
			<th>아이디</th>
			<td>${loginUser.userid}<input type = "hidden" name="id" value="${loginUser.userid}">
			</td>
		</tr>
		<tr>	
			<th>비밀번호</th>
			<td><input type = "password" name="pw" size="20"> &nbsp; * </td>
		</tr>
		<tr>	
			<th>비밀번호 확인</th>
			<td><input type = "password" name="pw_check" size="20"> &nbsp; * </td>
		</tr>
		<tr>	
			<th>이름</th>
			<td><input type = "text" name="name" size="20" value="${loginUser.name}"> &nbsp; * </td>
		</tr>
		<tr>
		<tr>
			<th>이메일</th>
			<td><input type = "text" name="email" size="20" value="${loginUser.email}"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type = "text" name="phone" size="20" value="${loginUser.phone}"></td>
		</tr>
	</table><br><br>
	<input type = "submit" value="수정" onClick="return editCheck();"/>
	<input type = "reset" value="다시 작성" >
	<input type = "button" value="목록으로" onClick="location.href='boardList'">
	</form>
</div>
</body>
</html>