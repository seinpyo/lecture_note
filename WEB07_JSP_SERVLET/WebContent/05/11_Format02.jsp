<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11_Format02</title>
</head>
<body>
<h3> 톰캣 서버의 기본 로케일 : <%=response.getLocale() %></h3>
<fmt:setLocale value ="ja_JP"/>
<h3>로케일을 미국으로 설정 후 로케일 확인 : <%=response.getLocale() %></h3>

<h3>
통화(currency) :
<fmt:formatNumber value="10000" type="currency"/><br>
숫자(Number) :
<fmt:formatNumber value="1000.1234" type="number" maxFractionDigits="2"/><br>
<c:set var="now" value="<%=new java.util.Date() %>"/>
날짜 : <fmt:formatDate value="${now}"/>

<fmt:requestEncoding value = "UTF-8"/>

</h3>
</body>
</html>