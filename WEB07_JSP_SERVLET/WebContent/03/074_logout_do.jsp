<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate(); //세션에 저장된 내용을 모두 지운다
%>
<script type="text/javascript">
alert("로그아웃되었습니다.");
location.href="071_LoginForm.jsp";
</script>