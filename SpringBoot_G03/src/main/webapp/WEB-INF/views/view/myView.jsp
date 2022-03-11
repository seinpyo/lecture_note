<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><% out.println("Modle(sub) : Hello World"); %></h1>
<h2>${ObjectTest }</h2>
<h2>${lists }</h2>
<br>
<c:forEach var = "mylist" items="${lists }">
	<h3>${mylist }</h3>
</c:forEach>
</body>
</html>