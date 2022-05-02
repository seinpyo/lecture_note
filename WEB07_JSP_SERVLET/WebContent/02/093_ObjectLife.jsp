<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
third의 pageContext 속성 :  <%=pageContext.getAttribute("name") %> <br>
third의 request 속성 :  <%=request.getAttribute("name") %> <br>
third의 session 속성 :  <%=session.getAttribute("name") %> <br>
third의 application 속성 :  <%=application.getAttribute("name") %> <br>
</body>
</html>