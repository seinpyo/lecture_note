<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.net.URLEncoder" %>

<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//원하는 아이디 비밀번호가 전달되었는지 확인 후 맞으면 다음 페이지로 이동
//jsp에서 페이지 이동은 response.sendRedirect();

if(id.equals("hong") && pwd.equals("1234")) 
	response.sendRedirect("073_loginOk.jsp?name=" + URLEncoder.encode("홍길동", "UTF-8"));
//전달인수로 한글을 전달
else response.sendRedirect("071_loginForm.jsp");
%>