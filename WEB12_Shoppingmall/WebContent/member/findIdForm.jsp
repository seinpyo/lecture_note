<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/shopping.css" rel="stylesheet"> 
</head>
<body>
<center><h2>Id 찾기</h2></center>
<form method="post" name="frm" action="shop.do">
<input type="hidden" name="command" value="findIdStep1">
<table align="center" bgcolor="black" cellspacing="1" width="400">
	<tr align="center" bgcolor="#fde8ff">
		<td width=430><h3>성&nbsp;&nbsp;&nbsp;&nbsp;명 <input type="text" name="name" value="${name}"></h3></td>
		<!-- 인증번호가 일치 하지 않아 이 화면으로 돌아올 때는 parameter에 name, phone을
		가지고 오게 하여 이미 입력한 name과 phone을 다시 입력하지 않아도 되도록 함 -->
	</tr>
	<tr align="center" bgcolor="#fde8ff">
		<td width=430><h3>전화번호 <input type="text" name="phone" value="${phone}"></h3></td>
	</tr>
	<tr align="center" bgcolor="#fde8ff">
		<td width=430><h3><input type="submit"value="인증번호 전송"></h3> ${msg} </td>
	</tr>	
</table>
</form>
</body>
</html>