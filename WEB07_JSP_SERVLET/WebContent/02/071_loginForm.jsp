<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>071_loginForm</title>
</head>
<body>
 <!-- DB연동 없는 약식 로그인 폼 -->
 	<form method="post" action="072_Login_do.jsp">
 		<label for="id"> 아이디 : </label>
 		<input type="text" id="id" name="id"><br> 		
 		<label for="pwd">암 &nbsp; 호 : </label>
 		<input type="password" id="pwd" name="pwd"><br> 		
 		<input type="submit" value="로그인"><br> 		
 		
 	
 	</form>
</body>
</html>