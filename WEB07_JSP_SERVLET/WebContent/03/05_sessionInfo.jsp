<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_sessionInfo</title>
</head>
<body>
<h3>세션 정보를 얻어오는 메소드를 사용하기</h3>
<%
String id_str = session.getId();
long lasttime = session.getLastAccessedTime(); //마지막 접근 시간:밀리초
long createdtime = session.getCreationTime(); //생성시간 : 밀리초 
//사용시간(마지막접근시간 - 생성시간) : 밀리초 
long time_used = (lasttime - createdtime) / 1000; 
session.setMaxInactiveInterval(3600); //세션의 수명 : 초
int inactive = session.getMaxInactiveInterval()/60; //수명을 분 단위로 변환
boolean b_new = session.isNew(); //새로 만든 세션이 있는지 없는지
%>
[1] 세션 아이디 (<%=id_str %>) <br>
[2] 페이지에 머문 시간 (<%=time_used %>초)  <br>
[3] 세션의 유효시간 (<%=inactive %>분)  <br>
[4] 새 세션 생성 여부 <%
if(b_new) out.print("yes");
else out.print("no");
%>  <br>
</body>
</html>