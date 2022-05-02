<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheck</title>
<script type = "text/javascript">
	function idok(userid){
		opener.frm.userid.value = userid;
		opener.frm.reid.value = userid;
		self.close();
	}
</script>
</head>
<body>
<form action="member.do" name="frm"> <!-- 중복체크 재검색 -->
	<input type="hidden" name="command" value="idcheck">
	아이디 <input type="text" name="userid" value="${userid}">
	<input type="submit" value="중복 체크">
</form>
<c:if test="${result==1}">
	${userid}는 이미 사용 중인 아이디입니다. 
	<script type="text/javascript">
		opener.document.frm.userid.value=""; 
	</script>
</c:if>
<c:if test="${result==-1}">
	${userid}는 사용가능한 아이디 입니다.
	<input type="button" value="사용" class="cancel" onClick="idok('${userid}');">
</c:if>
</body>
</html>