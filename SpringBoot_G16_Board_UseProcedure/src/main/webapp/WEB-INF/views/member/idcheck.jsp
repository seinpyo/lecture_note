<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="/script/board.js"></script>
</head>
<body>
<form action="idcheck" name="frm">
	아이디 <input type="text" name="userid" value="${userid}">
	<input type="submit" value="중복 체크"> <br><br><br>
	<c:if test="${result==1}">
		<script type="text/javascript">
			opener.document.frm.userid.value=""; 
		</script>
		${userid}는 이미 사용 중인 아이디입니다. 
	</c:if>
	<c:if test="${result==-1}">
		${userid}는 사용가능한 아이디 입니다.
		<input type="button" value="사용" class="cancel" onClick="idok('${userid}');">
	</c:if>
</form>
</body>
</html>