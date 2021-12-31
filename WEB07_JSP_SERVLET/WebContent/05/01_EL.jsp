<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_EL</title>
</head>
<body>

JSP 문법 사용 1 : <%="Hello" %> <br>
JSP 문법 사용 2 : <% out.print("Hello"); %> <br>
EL 문법 사용 :  ${ "Hello" } <br>

<br><br>
정수형 : ${10} <br>
실수형 : ${5.6} <br>
문자열 : ${"홍길동"} <br>
논리형 : ${true} <br>
null : ${null} <br>

<br><br>
10 + 2 = ${ 10+2 } <br>  <!-- 산술 연산 후 출력 -->
\${ 10 - 2 }  <!-- 문자 그대로 출력 -->
 = ${ 10-2 }  <br> 
 \${ 10 * 2 } = ${ 10 * 2 }  <br> 
 \${ 10 / 2 } = ${ 10 / 2 }  <br> 
 \${ 10 % 2 } = ${ 10 % 2 }  <br> 
 \${ 10 mod 2 } = ${ 10 mod 2 }  <br> 

<br><br>
\${ 10 == 2 } = ${ 10 == 2 } <br>
\${ 10 eq 2 } = ${ 10 eq 2 } <br>
\${ 10 < 2 } = ${ 10 < 2 } <br>
\${ 10 >= 2 } = ${ 10 >= 2 } <br>
\${ empty("") } = ${ empty("") } <br>

<br><br>
\${ "2" + 5 } = ${ "2" + 5 } <br>
\${ "2" * 5 } = ${ "2" * 5 } <br>
\${ null + 1 } = ${ null + 1 } <br>

<br><br>
\${ "문자" += "열" += "연결" } = ${ "문자" += "열" += "연결"  }<br>

<br><br>
<%
request.setAttribute("name","홍길동");
pageContext.setAttribute("name", "홍길서");
session.setAttribute("name", "홍길남");
application.setAttribute("name", "홍길북");
%>

JSP 문법 : <%= request.getAttribute("name") %> <br>
JSP 문법 : <% String str = (String)request.getAttribute("name"); %> 
			<%= str %> <br>

EL 문법 : ${ name } <br>
EL 문법 : ${ requestScope.name } <br>
EL 문법 : ${ sessionScope.name } <br>
EL 문법 : ${ applicationScope.name } <br>

</body>
</html>