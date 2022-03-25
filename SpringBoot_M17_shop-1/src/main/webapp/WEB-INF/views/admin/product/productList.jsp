<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/admin/header.jsp" %>
<%@ include file="../../include/admin/sub_menu.jsp" %>  

<article>

<h1>상품 리스트</h1>
<form name="frm" method="post">
<table>
	<tr>
		<td width="642"> 
			상품명 <input type="text" name="key" value="${key}">
			<input class="btn" type="button" name="btn_serach" value="검색" onClick="go_search();">
			<input class="btn" type="button" name="btn_total" value="전체보기" onClick="go_total();">
			<input class="btn" type="button" name="btn_write" value="상품 등록" onClick="go_wrt();">
		</td>
	</tr>
</table>	
<table id="productList" >
	<tr>
		<th>번호</th>
		<th>상품명</th>
		<th>사입가</th>
		<th>판매가</th>
		<th>등록일</th>
		<th>사용유무</th>
	</tr>
	
	<c:choose>
		<c:when test="${productListSize<=0}">
			<tr><td height="23" align="center" colspan="7" width=100%> 등록된 상품이 없습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${productList}" var="productVO">
			<tr><td height="23" align="center"> ${productVO.PSEQ}</td>
			<td style="text-align:left; padding-left:50px;">
				<a href="#" onClick="go_detail('${productVO.PSEQ}');">${productVO.NAME}</a>
			</td>
			<td><fmt:formatNumber value="${productVO.PRICE1}"/></td>
			<td><fmt:formatNumber value="${productVO.PRICE2}"/></td>
			<td><fmt:formatDate value="${productVO.INDATE}"/></td>
			<td><c:choose>
				<c:when test='${productVO.USEYN=="n"}'>미사용</c:when>
				<c:otherwise>사용</c:otherwise>
				</c:choose>	</td>
		</tr>
	</c:forEach>
		</c:otherwise>
		
	</c:choose>
		<tr>
			
</table>
</form>
<br><br>

<div id="paging">
	<c:if test="${paging.prev}"><a href="productList?page=${paging.beginPage-1}"> ◀ </a></c:if>
	
	<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" step="1" var="index">
		<c:choose>
			<c:when test="${paging.page==index}"> ${index} </c:when>
			<c:otherwise><a href="productList?page=${index}"> ${index}</a> </c:otherwise>
		</c:choose>
	</c:forEach>	
	
	<c:if test="${paing.next}"><a href="productList?page=${paging.endPage+1}">▶</a></c:if>
</div> 

<br><br>
</article>
<%@ include file="../../include/admin/footer.jsp" %>  