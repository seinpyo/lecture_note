<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String sAge = request.getParameter("age");
int age = Integer.parseInt( sAge );
String abc = request.getParameter("abc");

if(age<=19) {
%>
	<script type="text/javascript">
		alert("20세 이상부터 입장 가능합니다.")
		history.go(-1);
	</script>
<%
} else {
	
	//파라미터 저장
	request.setAttribute("name","홍길동");
	
	//포워드를 위한 객체 생성 및 이동 페이지 설정
	RequestDispatcher dp = request.getRequestDispatcher("083_ForwardResult.jsp");
	//현재의 request와 response를 가지고 목적이로 이동
	dp.forward(request, response);
	
	
}
%>
