<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String job = request.getParameter("job");
	String[] interests = request.getParameterValues("interest");
%>
<h3> 직업 : <%=job %> </h1>
<br><br>
<h3> 관심분야 : </h1>
<%
if (interests == null) out.print("선택 항목이 없습니다.");
else {
	for(String in : interests) {	
%>
	<%=in %>
<%
	}
}
%>
</body>
</html>