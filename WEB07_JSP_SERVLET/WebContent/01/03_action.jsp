<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name ="joinForm" action="03_Action_to.jsp" method="post">
	<label for="name"> 이름 </label><span style="color = red;">*</span>
	<input type= text" id="name" name="name" value=""><br>
	<label for="id"> 아이디 </label><span style="color = red;">*</span>
	<input type="text" id="id" name="id" value=""><br>
	<label for="pwd"> 비밀번호 </label><span style="color = red;">*</span>
	<input type="password" id="pwd" name="pwd" value=""><br>
	<label for="pwd_re"> 비밀번호 확인 </label><span style="color = red;">*</span>
	<input type="password" id="pwd_re" name="pwd_re" value=""><br>
	<input type="submit" value="회원가입">
	<input type="reset" value="다시작성">
</form>

<a href = "03_Action_to.jsp?useritem=superCar">유저아이템만 보내기</a>

</body>
</html>