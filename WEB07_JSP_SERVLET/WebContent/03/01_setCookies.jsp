<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_setCookies</title>
</head>
<body>
<%
//1. cookie 객체 생성
Cookie c = new Cookie("id", "hong123");

//2. 유효기간 설정
c.setMaxAge(365*24*60*60); //1년간 쿠키 수명 유지 

//3. 클라이언트에 쿠키 전송
response.addCookie(c);

//4. new 쿠키를 생성하여 클라이언트에 바로 전송
response.addCookie(new Cookie("pwd", "test1234"));
response.addCookie(new Cookie("age", "20"));

%>
</body>
</html>