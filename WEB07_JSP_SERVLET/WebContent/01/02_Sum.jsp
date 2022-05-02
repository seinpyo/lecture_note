<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int sum = 0;
	for(int i=1; i<=100; i++) {
		sum+=i;	
%>
<h2><%= sum%></h2>	
<%
	}
%>
<h2><%= sum %></h2>
<% 
	sum = 0;
	for(int i=1; i<=1000; i++){
		sum += i;
	}
%>
<h2><%= sum %></h2>

</body>
</html>