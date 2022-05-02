<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>071_LoginForm</title>
</head>
<body>
<%
if(session.getAttribute("loginUser") != null) {
	response.sendRedirect("073_main.jsp");
//로그인이 되어있는 상태라면 로그인 폼에 접속했을 때 바로 main으로 보냄
}
%>
<form method="post" action="072_Login_do.jsp">
	<label for="userid"> 아이디 :  </label>
	<input type="text" name="id" id="userid"> <br>
	<label for="userid"> 암 &nbsp; 호 :   </label>
	<input type="password" name="pwd" id="userpwd"> <br>
	<input type="submit" value="로그인">
</form>
</body>
</html>