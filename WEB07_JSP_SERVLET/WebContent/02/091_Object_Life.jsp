<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>091_Object_Life.jsp</title>
</head>
<body>
<%
pageContext.setAttribute("name","page man"); 
request.setAttribute("name","request man"); 
session.setAttribute("name","session man");
application.setAttribute("name","application man"); 
//name들은 저장 장소가 다르기 때문에 다 다른 변수

System.out.println("firstPage.jsp : ");
System.out.println("First의 pageContext 객체 : " + pageContext.getAttribute("name"));
System.out.println("First의 request 객체 : " + request.getAttribute("name"));
System.out.println("First의 session 객체 : " + session.getAttribute("name"));
System.out.println("First의 application 객체 : " + application.getAttribute("name"));

RequestDispatcher dispatcher = request.getRequestDispatcher("092_ObjectLife.jsp");
dispatcher.forward(request, response);
%>
</body>
</html>