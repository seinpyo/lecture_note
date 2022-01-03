<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08_Imort.jsp</title>
</head>
<body>
<c:import url="http://localhost:8090/WEB07_JSP_SERVLET/05/06_ForEach.jsp" 
	var="data1"></c:import>
${data1}
<hr>
<br>

<c:url value="../images/dog.jpg" var="date2"></c:url>
<h3>${ date2 }</h3>
<img src = "${ date2 }" width='150' height='150'>

</body>
</html>