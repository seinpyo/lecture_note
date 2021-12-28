<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_Variable2</title>
<%!
	int global_cnt=0;
%>
</head>
<body>
<%
	int local_cnt=0;
%>
<h1>local_cnt : <%= ++local_cnt %></h1>
<h1>global_cnt : <%= ++global_cnt %></h1>
</body>
</html>