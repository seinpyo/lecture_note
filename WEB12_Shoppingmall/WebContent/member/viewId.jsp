<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/shopping.css" rel="stylesheet">
<script type="text/javascript">
	function move_login(){
		opener.location.href='shop.do?command=loginForm';
		self.close();
	}
</script>
</head>
<body>
<form>
<h2 align="center">Id 찾기</h2>
	<table align="center" bgcolor="black" cellspacing="1" width="400">
		<tr align="center" bgcolor="#fde8ff">
			<td width="430"><h3>성명 : ${name}</h3></td></tr>
		<tr align="center" bgcolor="#fde8ff">
			<td width="430"><h3>전화번호 : ${phone}</h3></td></tr>
		<tr align="center" bgcolor="#fde8ff">
			<td width="430"><h3>회원님의 아이디는 ${id}입니다</h3>
				<input type="button" class="submit" value="로그인창으로" onClick="move_login();">
				<input type="button" class="submit" value="비밀번호찾기" 
				onClick="location.href='shop.do?command=findPwForm&id=${id}'">
				</td></tr>
	</table>
 </form>
</body>
</html>