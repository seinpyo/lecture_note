<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_ForEach</title>
</head>
<body>
<% 
	String[] movieList = {"미저리", "미스트", "샤이닝", "캐리"};
	request.setAttribute("movieList", movieList);
	//Attribute는 해쉬맵 형식의 리스트이므로 키값만 존재하면 어떤 자료형도 보관 가능
	//ArrayList 등도 손쉽게 보관하거나 전달할 수 있다.
%>

<h3>JSP 반복실행</h3>
<%
String[] mlist = (String []) request.getAttribute("movieList");
for(String s : mlist)
	out.print(s+"<br>");
%>
<br><br>

<h3>EL과 JSTL을 이용한 반복 실행</h3>
<c:forEach items="${ movieList }" var="movie"> 
<!-- items : 반복 실행에 이용할 리스트 또는 배열을 지정 -->
<!-- var 변수 : 배열 또는 리스트의 값을 한번에 하나씩 저장할 때 사용 -->
	${movie}<br>
</c:forEach>
</body>
</html>