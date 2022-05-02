<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>111_JSP_Servlet_Ex01</title>
</head>
<body>
<form method="post" action="../Join_servlet">
	<label for="userid"> 아이디 : </label> <input type="text" name="id" id="userid"> <br><br>
	<label for="userpwd"> 암 &nbsp; 호 : </label> <input type="password" name="pwd" id="userpwd"> <br><br>
	<label for="gender"> 성별 : </label> 
	<input type="radio" id="gender" name="gender" value="1"> 남성
	<input type="radio" id="gender" name="gender" value="2"> 여성 <br><br>
	<label for="chk_mail"> 메일 정보 수신 여부 : </label>
	<input type="radio" id="chk_mail" name="chk_mail" value="1"> 수신 
	<input type="radio" id="chk_mail" name="chk_mail" value="0"> 거부 <br><br>
	<label for="content"> 가입 인사를 적어주세요 </label> <br>
	<textarea name = "content" rows="3" cols="35"></textarea> <br><br>
	
	<label for="item">구입 항목</label>	<br><br>
	<input type="checkbox" name="item" value="1"> 신발
	<input type="checkbox" name="item" value="2"> 가방
	<input type="checkbox" name="item" value="3"> 벨트 	<br>
	<input type="checkbox" name="item" value="4"> 모자
	<input type="checkbox" name="item" value="5"> 시계
	<input type="checkbox" name="item" value="6"> 쥬얼리
	<br><br>
	<span style="float:left; margin-right:20px">
		<label for="job">직업</label>
		<select id="job" name="job" size="1">
			<option value="">선택하세요</option>
			<option value="학생">학생</option>
			<option value="IT">IT</option>
			<option value="언론">언론</option>
			<option value="공무원">공무원</option>
			<option value="군인">군인</option>
			<option value="서비스업">서비스업</option>
			<option value="교육">교육</option>
		</select>
	</span><br><br>
	<label for="interest" style="float:left;">관심분야 : </label>
	<select id="interest" name="interest" size="5" multiple="multiple">
		<option value="1">에스프레소</option>
		<option value="2">로스팅</option>
		<option value="3">생두</option>
		<option value="4">원두</option>
		<option value="5">핸드드립</option>
	</select> <br><br>
	<input type="submit" value="전송">
</form>
</body>
</html>