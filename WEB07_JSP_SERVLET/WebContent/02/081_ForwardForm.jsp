<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>081_ForwardForm.jsp</title>
</head>
<body>
입장하려면 나이를 입력하세요 <br>
<form action="082_Forward_do.jsp">
	<input type="text" name="age">
	<input type="hidden" name="abc" value="가나다라"> <!-- 숨겨져있는 태그 -->
	<input type="submit" value="입장">	
 </form>
</body>
</html>