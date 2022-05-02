<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Calendar" %>
<%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04.import.jsp</title>
</head>
<body>
<%Calendar date = Calendar.getInstance();
SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");
SimpleDateFormat now = new SimpleDateFormat("hh시 mm분 ss초");
%>
<h1>오늘은
<%Date d = date.getTime();
	out.print(today.format(d));%>
입니다</h1>
<h1>현재 시각은 <%out.print(now.format(date.getTime())); %> 입니다.</h1>
</body>
</html>