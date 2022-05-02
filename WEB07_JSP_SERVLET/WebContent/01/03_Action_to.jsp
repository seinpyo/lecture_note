<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_Action_to.jsp</title>
</head>
<body>
<h3> get 방식으로 요청된 주소 </h3>
<h4> http://localhost:8090/WEB07_JSP_SERVLET/01/03_Action_to.jsp?name=adel&id=adel123&pwd=1234&pwd_rd=1234 </h4>


<h3> post 방식으로 요청된 주소 </h3>
<h4> http://localhost:8090/WEB07_JSP_SERVLET/01/03_Action_to.jsp </h4>

<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String pwd_re = request.getParameter("pwd_re");
	String useritem = request.getParameter("useritem");
%>
성명 : <%=name %> <br>
아이디 : <%=id %> <br>
비밀번호 : <%=pwd %> <br>
비밀번호 확인 : <%=pwd_re %> <br>
사용자 아이템 : <%=useritem %> <br>
</body>
</html>