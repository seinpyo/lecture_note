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
<center><h2>비밀번호 찾기</h2></center>
<form method="post" name="frm" action="shop.do">
	<input type="hidden" name="command" value="findPwStep2">
	<table align="center" bgcolor="black" cellspacing="1" width="400">
		<tr align="center" bgcolor="#fde8ff">
			<td width="430"><h3>아이디 : ${member.id}</h3>
			<input type="hidden" name="id" value="${member.id}"></td></tr>
		<tr align="center" bgcolor="#fde8ff">
			<td width="430"><h3>성명 : ${member.name}</h3>
				<input type="hidden" name="name" value="${member.name}"></td></tr>
		<tr align="center" bgcolor="#fde8ff">
			<td width="430"><h3>전화번호 : ${member.phone}</h3>
				<input type="hidden" name="phone" value="${member.phone}">
		<tr align="center" bgcolor="#fde8ff">
			<td width="430"><h3>인증번호 
				<input type="text" name="confirmNum"></h3> 전송받은 번호를 입력하세요<br>
				${msg}<br><input type="submit" value="인증번호 확인"></td></tr>
	</table>
 </form>
</body>
</html>