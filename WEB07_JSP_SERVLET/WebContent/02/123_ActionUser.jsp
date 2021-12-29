<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.net.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>123_ActionUser</title>
</head>
<body>
<h3>사용자로 로그인</h3>

<!-- response.sendRedirect나 Action Tag를 사용한 경우 -->
<%
String userName = URLDecoder.decode(request.getParameter("userName"), "UTF-8");
out.print(userName);
%> 
(<%=request.getParameter("userID")%>)님 환영합니다.

<%-- 
<!-- forward를 사용한 경우  -->
<%
out.print(request.getAttribute("userName"));
%>
(<%=request.getParameter("userID")%>)님 환영합니다. --%>
</body>
</html>