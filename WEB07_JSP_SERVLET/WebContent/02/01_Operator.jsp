<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_Operator.jsp</title>
</head>
<body>
<%
int num1 = 20; 
int num2 = 7;
double num3;
int add = num1+num2;
out.print(num1+"+"+num2+"=" + add + "<br>");
add = num1 - num2;
out.print(num1+"-"+num2+"=" + add + "<br>");
add = num1 * num2;
out.print(num1+"*"+num2+"=" + add + "<br>");
num3 = num1/(double)num2;
out.print(num1+"/"+num2+"=" + num3 + "<br>");
%>
</body>
</html>