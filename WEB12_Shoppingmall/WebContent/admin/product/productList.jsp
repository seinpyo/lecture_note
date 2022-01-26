<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp" %>   
<%@ include file="/admin/sub_menu.jsp" %>

<article>

<h1>상품 리스트</h1>
<form name="frm" method="post">
	<tr>
		<td width="642"> 
			상품명 <input type="text" name="key" value="${key}">
			<input class="btn" type="button" name="btn_serach" value="검색" onClick="go_search('adminProductList');">
			<input class="btn" type="button" name="btn_total" value="전체보기" onClick="go_total('adminProductList');">
			<input class="btn" type="button" name="btn_write" value="상품 등록" onClick="go_wrt();">
		</td>
	</tr>
</form>
<table id="productList" >
	<tr>
		<th>번호</th>
		<th>상품명</th>
		<th>사입가</th>
		<th>판매가</th>
		<th>등록일</th>
		<th>사용유무</th>
	</tr>
	<c:forEach items="${productList}" var="productVO">
		<tr>
			<td height="23" align="center"> ${productVO.pseq}</td>
			<td style="text-align:left; padding-left:50px;">
				<a href="#" onClick="go_detail('${productVO.pseq}');">${productVO.name}</a>
			</td>
			<td><fmt:formatNumber value="${productVO.price1}"/></td>
			<td><fmt:formatNumber value="${productVO.price2}"/></td>
			<td><fmt:formatDate value="${productVO.indate}"/></td>
			<td><c:choose>
				<c:when test='${productVO.useyn=="n"}'>미사용</c:when>
				<c:otherwise>사용</c:otherwise>
				</c:choose>
	</c:forEach>
</table>
<br><br>

<jsp:include page="/admin/paging/paging.jsp">
	<jsp:param name="command" value="shop.do?command=adminProductList"/>
</jsp:include>
<!-- include로 paging.jsp를 불러 오면서 그 페이지에 파라미터로써 command 변수를 전달 -->
<!-- command 이외에 변경될 값이 필요하다면 추가로 파라미터로 보내면 됨 -->
<br><br>
</article>

<%@ include file="/admin/footer.jsp" %>
