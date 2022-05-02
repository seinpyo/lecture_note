<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_getSeesion</title>
</head>
<body>
<h3>세션에 저장된 값 하나씩 추출</h3>
<%
String id= (String) session.getAttribute("id");
String pwd= (String) session.getAttribute("pwd");
Integer age= (Integer) session.getAttribute("age");
%>

id : <%=id %> <br>
pwd : <%=pwd %> <br>
age : <%=age %> <br>

<h3>세션에 설정된 모든 값 얻어오기</h3>
<%
Enumeration<String>names = session.getAttributeNames();
//import 필요 : java.util.Enumeration

while(names.hasMoreElements()){
	//iterator의 hasNext() 역할 
	String name = names.nextElement().toString();
	//Enumeraion 요소의 형변환
	String value = session.getAttribute(name).toString();
	out.print(name + " : " + value + "<br>");
}
%>

</body>
</html>