<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/shopping.css" rel="stylesheet">
<script src="member/member.js"></script>
</head>
<body>
	<div id="popup"> 
		<h2> 우편번호 검색 </h2>
		<form method="post" name="formm" action="shop.do">
			<input type="hidden" name="command" value="findZipNum"/>
			동 이름 : <input name="dong" type="text"/>
			<input type="submit" value="찾기" class="submit">
		</form>
		
		<table id="zipcode">
			<tr>
				<th width="100">우편 번호</th>
				<th> 주소 </th>
			</tr>
			<c:forEach items="${addressList}" var="addressVO">
				<tr>
					<td>${addressVO.zip_num}</td>
					<td><a href="#" onClick="result( '${addressVO.zip_num}' ,  '${addressVO.sido}' , '${addressVO.gugun}' , '${addressVO.dong}'  );" >
				${addressVO.sido} ${addressVO.gugun} ${addressVO.dong} ${addressVO.bunji}</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>