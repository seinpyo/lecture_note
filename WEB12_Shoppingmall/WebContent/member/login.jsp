<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<%@ include file = "sub_img.html" %>
<%@ include file = "sub_menu.html" %>
<article>
<h1>Login</h1>
<form method="post" action="shop.do" name="loginForm">
	<input type="hidden" name="command" value="login">
	
	<fieldset>
		<legend></legend>
			<label>UserID</label><input type="text" name="id" ><br>
			<label>Password</label><input type="password" name="pwd" ><br>
	</fieldset>
	<div id="buttons">
		<input type="submit" value="Login" class="submit" onclick="return loginCheck()">
		<input type="button" value="join" class="cancel" 
		onclick="location.href='shop.do?command=contract'">
		<input type="button" value="아이디 비밀번호 찾기" class="submit" onclick="find_id()">
	</div>
	<div> ${message}</div>
</form>
</article>
<%@ include file = "../footer.jsp" %>