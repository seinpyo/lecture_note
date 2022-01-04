<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
<script type = "text/javascript">
	function idCheck(){
		//중복 확인
		if(document.frm.userid.value.length == 0) {
			//id란에 아무것도 입력되지 않은 경우 
			alert("아이디를 입력하세요");
			document.frm.userid.focus();
			return; //함수 종료
		} 
		
		var inputid = document.frm.userid.value;
		var opt = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=200";
		window.open("idcheck.do?userid="+ inputid, "idcheck" , opt);
		//팝업창 오픈메뉴의 idcheck.do는 서블릿, 서블릿에서 아이디 중복체크 작업을 한후 결과를 싣고
		//포워딩 되는 페이지의 팝업창에 표시될것
		//서블릿 호출 시 호출되는 주소에 ?와 함게 전달 가능 
	}
</script>
</head>
<body>
<form action="join.do" method="post" name="frm">
<table>
	<tr>	
		<td>이름</td>
		<td><input type = "text" name="pwd" size="20"> &nbsp; * </td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type = "text" name="userid" size="20"> &nbsp; * &nbsp;
		<input type="button" value="중복체크" onClick="idCheck();"/>
		<input type="hidden" name="reid" value=""/>
		</td>
	</tr>
	<tr>	
		<td>비밀번호</td>
		<td><input type = "password" name="pwd" size="20"> &nbsp; * </td>
	</tr>
	<tr>	
		<td>비밀번호 확인</td>
		<td><input type = "password" name="pwd_check" size="20"> &nbsp; * </td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type = "text" name="email" size="20"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type = "text" name="phone" size="20"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>
			<input type = "radio" name="admin" value="0" checked="chedcked">일반회원 &nbsp;
			<input type = "radio" name="admin" value="2">관리자 &nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type = "submit" value="회원 가입" onClick="return joinCheck()"/>
			<input type = "reset" value="취소" >
		</td>
	</tr>
</table>
</form>
</body>
</html>