<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%! //선언부 시작 : 변수, 메서드 등을 정의 
//변수 선언 
String str = "안녕하세요";
int a=5, b=-5;
//메서드 정의
public int abs(int n) {
	if(n<0) n=-n; // n = n*-1
	return n;
} //JSP 메서드는 static 선언하지 않아도 사용 가능
%>
</head>
<body>
<% //JSP 실행부 시작
int c=10;
c++;
a++;
out.print(str+"<br>");
out.print(a + "의 절대값 : " + abs(a) +"<br>");
out.print(c + "의 절대값 : " + abs(c) +"<br>");
%>
<br><br>
<%=str %><br>
<%=a %>의 절대값 : <%=abs(a) %>
<%=c %>의 절대값 : <%=abs(c) %>

</body>
</html>