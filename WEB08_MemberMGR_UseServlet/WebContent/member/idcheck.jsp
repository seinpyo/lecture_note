<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck</title>
<script type="text/javascript">
	function idok() {
		opener.document.frm.userid.value="${userid}";
		opener.document.frm.reid.value="${userid}";
		self.close() //나 자신(팝업창)을 지칭
	}
</script>
</head>
<body>
<form action="idcheck.do" method="get" name="frm">
	아이디 : <input type = "text" name="userid" value="${userid}">
	<input type = "submit" value="중복 체크">
</form> <br>
<c:if test="${result==1}">
	${userid}는 이미 사용중인 아이디입니다
	<script type="text/javascript">
		opener.document.frm.userid.value="";//팝업창을 오픈한 주체 : opner
	</script>
</c:if>
<c:if test="${result==-1}">
	${userid}는 사용 가능한 아이디입니다
	<input type="button" value="사용" onClick="idok();">
</c:if>
</body>
</html>