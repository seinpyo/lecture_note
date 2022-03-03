<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board.css'/>">
<script src ="<c:url value="/resources/script/board.js"/>"></script>
</head>
<body>
<div id="wrap" align="center">
 '*'표시는 필수 입력 항목입니다.
	<form action="memberJoin" method="post" name="frm">
	<input type="hidden" name="command" value="join">
	<table>
		<tr>	
			<td>이름</td>
			<td><input type = "text" name="name" size="20"> &nbsp; * </td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type = "text" name="id" size="20"> &nbsp; * &nbsp;
			<input type="button" value="중복체크" onClick="idCheck();"/>
			<input type="hidden" name="re_id" />
			</td>
		</tr>
		<tr>	
			<td>비밀번호</td>
			<td><input type = "password" name="pw" size="20"> &nbsp; * </td>
		</tr>
		<tr>	
			<td>비밀번호 확인</td>
			<td><input type = "password" name="pw_check" size="20"> &nbsp; * </td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type = "text" name="email" size="20"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type = "text" name="phone" size="20"></td>
		</tr>
	</table><br><br>
	<input type = "submit" value="회원 가입" onClick="return joinCheck();"/>
	<input type = "button" value="이전 페이지로" onClick="history.go(-1);">
	<input type = "button" value="로그인 페이지로" onClick="location.href='/board/'">
	
	</form>
</div>
</body>
</html>