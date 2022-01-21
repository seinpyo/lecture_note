<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %>

<article>
<h2> ${title} </h2>
<form>
<table id = "cartList">
	<tr><th>주문 일자</th><th>주문 번호</th><th>상품 명</th><th>결제 금액</th><th>주문 상세</th><th>처리 상태</th></tr>
	<c:forEach items="${orderList}" var="orderVO">
		<tr>
			<td><fmt:formatDate value="${orderVO.indate}" type="date"/></td>
			<td>${orderVO.oseq}</td><td>${orderVO.pname}</td>
			<td><fmt:formatNumber value="${orderVO.price2}" type="currency"/></td>
			<td><a href="shop.do?command=orderDetail&oseq="${orderVO.oseq}>조회</a></td>
			<td>
				<c:if test="${orderVO.result=='1'}">미처리</c:if>
				<c:if test="${orderVO.result=='2'}">처리 완료</c:if>
			</td></tr>
 	</c:forEach>
</table><div class="clear"></div>
<div id="buttons" style="float:right">
	<input type="button" value="쇼핑계속하기" class="cancel" onClick="location.href='shop.do?command=index'">
</div>
</form>
</article>

<%@ include file="../footer.jsp" %>