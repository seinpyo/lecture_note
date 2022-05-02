<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>076_myPage</title>
</head>
<body>
<%
if(session.getAttribute("loginUser")==null){
	response.sendRedirect("071_LoginForm.jsp");
} else {
%>
	아이디 : <%=session.getAttribute("loginUser") %> <br>
	이름 : 홍길동 <br>
	주소 : 서울시 마포구 노고산동 ... <br>
	전화번호 : 010-2342-5456 <br>
	<input type="button" value="정보 수정">
<%
}
%>
</body>
</html>