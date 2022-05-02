<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>083_ForwardResult.jsp</title>
</head>
<body>
<%
String age = request.getParameter("age");
String name = (String) request.getAttribute("name");
%>

<h3>forward 방식으로 이동한 페이지</h3>
<h3>나이 : <%=age%></h3>
<h3>이름 : <%=name%></h3>

</body>
</html>