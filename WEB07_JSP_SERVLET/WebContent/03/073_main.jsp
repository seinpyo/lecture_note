<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>073_main</title>
</head>
<body>
<%
if(session.getAttribute("loginUser") == null){
	response.sendRedirect("071_LoginForm.jsp"); 
	//로그인 해야 id가 세션에 저장되므로 세션에 저장된 id가 없는 경우
	//로그인 폼으로 돌아가기
} else {
%>
	로그인 관리자 <br> 전화번호 010-1234-1234  <br>
	<%=session.getAttribute("loginUser")%>님 안녕하세요! <br>
	<form method="get" action="075_myPage_do.jsp">
		<input type=submit value="마이페이지">
	</form>
	<form method="get" action="074_logout_do.jsp">
		<input type=submit value="로그아웃">
	</form>
<%} %>
</body>
</html>