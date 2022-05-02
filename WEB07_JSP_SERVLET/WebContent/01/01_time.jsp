<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>안녕하세요</h2>
<h2>JAVA SERVER PAGE(JSP)</h2>
<% java.util.Date d = new java.util.Date(); %>
<h2>현재시간 : <%= new java.util.Date() %></h2>
<!-- 일반 텍스트의 주석 -->
<%-- <% jsp 명령이 포함된 열의 명령 %> 안녕하세요 --%>

<h2> <%= d %> => 계산된 현재 날짜 시간을 body의 해당 위치에 표시 </h2>
</body>
</html>