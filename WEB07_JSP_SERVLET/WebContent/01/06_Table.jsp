<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_Table.jsp</title>
</head>
<body>

<!-- html로 테이블 만들기 -->

<table cellspacing="1" bgcolor="black" width="500">
	<tr bgcolor="white" height="80">
		<td>1*1</td><td>1*2</td><td>1*3</td><td>1*4</td><td>1*5</td>
	</tr>
	<tr bgcolor="white" height="80">
		<td>2*1</td><td>2*2</td><td>2*3</td><td>2*4</td><td>2*5</td>
	</tr>
	<tr bgcolor="white" height="80">
		<td>3*1</td><td>3*2</td><td>3*3</td><td>3*4</td><td>3*5</td>
	</tr>
		<tr bgcolor="white" height="80">
		<td>4*1</td><td>4*2</td><td>4*3</td><td>4*4</td><td>4*5</td>
	</tr>
		<tr bgcolor="white" height="80">
		<td>5*1</td><td>5*2</td><td>5*3</td><td>5*4</td><td>5*5</td>
	</tr>
</table>
<br><br><br>

<!-- jsp로 테이블 만들기 -->

<table cellspacing="1" bgcolor="black" width="500">

<%for(int i=1; i<=5; i++){%>
	<tr bgcolor="white" height="80">
		<%for(int j=1; j<=5;j++){ %>
			<td><%=i%>*<%=j%></td>
		<% } %>
	</tr>
<% } %>
</table>
</body>
</html>