<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>122_ParameterTo.jsp</title>
</head>
<body>
입력하신 정보를 확인해주세요 (JSP) <hr>
아이디 : <%= request.getParameter("id") %> <br>
비밀번호 : <%= request.getParameter("pwd") %> <br><br>

입력하신 정보를 확인해주세요 (EL) <hr>
아이디 : ${param.id} <br>
비밀번호 : ${param["pwd"]} <br><br>

</body>
</html>