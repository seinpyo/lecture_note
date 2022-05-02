<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07_ForEach2</title>
</head>
<body>
<% 
	String[] movieList = {"미저리", "미스트", "샤이닝", "캐리"};
	request.setAttribute("movieList", movieList);
%>
<table border="1" style="width:700px; text-align:center">
	<tr><th>index</th><th>count</th><th>title</th></tr>
	<c:forEach items="${movieList}" var="movie" varStatus="state">
		<tr><td>${state.index}</td><td>${state.count}</td><td>${movie}</td>
	</c:forEach>
</table>

<br><hr><br>

<table border="1" style="width:400px; text-align:center">
	<tr><th>title</th></tr>
	<c:forEach items="${movieList}" var="movie" varStatus= "status">
		<c:choose>
			<c:when test="${status.first}">
				<tr><td style="color:red;">${movie}</td></tr>
			</c:when>
			<c:otherwise>
				<tr><td style="color:black;">${movie}</td></tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>

<ul>
	<c:forEach items="${movieList}" var="movie" varStatus= "status">
		<c:choose>
			<c:when test="${status.first}">
				<li style="font-weight:bold; color:red;">${ movie }</li>
			</c:when>
			<c:otherwise>
				<li>${ movie }</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</ul>

<c:forEach items="${movieList}" var="movie" varStatus= "status">
 ${ status.current } <c:if test="${ not status.last }">, </c:if>
</c:forEach>

<br><br>
<c:forEach var="cnt" begin="1" end="10" varStatus="status">
	${ cnt } <c:if test="${ not status.last }">, </c:if>
</c:forEach>

<br><hr><br>
<table border="1" style="width:50%; text-align:center;" align="left">
	<tr><th>index</th><th>count</th><th>cnt</th></tr>
	<c:forEach var="cnt" begin="7" end="10" varStatus="status">
		<tr><td>${ status.index }</td><td>${ status.count }</td><td>${ cnt }</td></tr>
	</c:forEach>
</table>

</body>
</html>