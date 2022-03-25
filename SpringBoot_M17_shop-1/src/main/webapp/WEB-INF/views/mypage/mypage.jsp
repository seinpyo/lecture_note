<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter/header.jsp" %>
<%@ include file="../include/sub03/sub_image.html" %> 
<%@ include file="../include/sub03/sub_menu.jsp" %>
<article>
<h2> ${title} </h2>
<form name="formm" method="post">
<table id = "cartList">
	<tr><th>주문 일자</th><th>주문 번호</th><th>상품 명</th><th>결제 금액</th><th>주문 상세</th><th>처리 상태</th></tr>
	<c:forEach items="${orderList}" var="orderVO">
		<tr>
			<td><fmt:formatDate value="${orderVO.INDATE}" type="date"/></td>
			<td>${orderVO.oseq}</td><td>${orderVO.PNAME}</td>
			<td><fmt:formatNumber value="${orderVO.PRICE2}" type="currency"/></td>
			<td><a href="orderDetail&oseq="${orderVO.OSEQ}>조회</a></td>
			<td>
				<c:if test="${orderVO.RESULT=='1'}">미처리</c:if>
				<c:if test="${orderVO.RESULT=='2'}">처리 완료</c:if>
			</td></tr>
 	</c:forEach>
</table><div class="clear"></div>
<div id="buttons" style="float:right">
	<input type="button" value="쇼핑계속하기" class="cancel" onClick="location.href='/shop/'">
</div>
</form>
</article>

<%@ include file="../include/headerfooter/footer.jsp" %>