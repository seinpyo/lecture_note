<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="paging" align="center" style="font-size:110%; font-wight:bold;">
	    <!-- 페이지가 클릭될때마다 이동할 링크 기본 경로를 변수에 저장 -->
	    <c:url var="action" value="${param.command}"/>
	    <c:if test="${param.prev}">
	        <a href="${action}&page=${param.beginPage-1}">◀</a>&nbsp;
	    </c:if>
	
	    <!-- 실제 페이지들이 표시되는 곳 -->
	    <c:forEach begin="${param.beginPage}" end="${param.endPage}" var="index">
	
	        <c:choose>
	            <c:when test="${param.page==index}">
	                <span style="color:red">${index}&nbsp;</span>
	            </c:when>
	            <c:otherwise>
	                <a href="${action}&page=${index}">${index}</a> &nbsp;
	            </c:otherwise>
	        </c:choose>
	    </c:forEach>
	    <c:if test="${paging.next}">
	        <a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
	    </c:if>
	</div>
</body>
</html>