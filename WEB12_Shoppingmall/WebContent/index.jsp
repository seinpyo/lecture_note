<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>

<!-- 메인이미지 -->
<div id="main_img" align="center">
	<img src="images/main_img.jpg" style="border-radius:20px 20px 20px 20px; border:2px solid white;">
</div>

<!-- 신상품 -->
<h2>New Item</h2>   
<div id="bestProduct">
	<c:forEach items="${newList}"  var = "productVO" >
		<div id="item">
			<a href="shop.do?command=productDetail&pseq=${productVO.pseq}">
				<img src="product_images/${productVO.image}" /> 
				<h3> ${productVO.name} - <fmt:formatNumber value="${productVO.price2}" 
				   			type="currency"></fmt:formatNumber></h3> 
			</a>
		</div>
	</c:forEach>
</div>
<div class="clear"></div>
<!-- 베스트 상품 -->
<h2> Best Item</h2>  
<div id="bestProduct">
	<c:forEach items="${bestList}"  var = "productVO" >
		<div id="item">
			<a href="shop.do?command=productDetail&pseq=${productVO.pseq}">
				<img src="product_images/${productVO.image}" />
				<h3> ${productVO.name} - <fmt:formatNumber value="${productVO.price2}" 
			   			type="currency"></fmt:formatNumber></h3>
			</a>
		</div>
	</c:forEach>
</div>
<%@ include file = "footer.jsp" %>
