<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_removeAttribute</title>
</head>
<body>
<%
session.setAttribute("s_name1", "세션에 저장된 값1");
session.setAttribute("s_name2", "세션에 저장된 값2");
session.setAttribute("s_name3", "세션에 저장된 값3");
out.print("<h3>> 세션 값을 삭제하기 전 <</h3>");
Enumeration names = session.getAttributeNames();
while(names.hasMoreElements()){
	String name = names.nextElement().toString();
	String value = session.getAttribute(name).toString();
	out.print(name + " : " + value + "<br>");
}
session.removeAttribute("s_name2"); //하나만 삭제
out.print("<hr><h3>> 세션 값을 삭제한 후 <</h3>");
names = session.getAttributeNames();
while(names.hasMoreElements()){
	String name = names.nextElement().toString();
	String value = session.getAttribute(name).toString();
	out.print(name + " : " + value + "<br>");
}
%>
</body>
</html>