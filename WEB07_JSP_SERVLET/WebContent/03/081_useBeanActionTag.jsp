<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.dto.MemberBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>081_useBeanActionTag</title>
</head>
<body>

<%
//jsp 문법으로 객체를 생성하는 방법
MemberBean member1 = new MemberBean(); 
//생성한 MemberBean 클래스 import 필요
com.dto.MemberBean meber2 = new com.dto.MemberBean(); 
//import없이 경로를 적어 생성
%>

<!-- 액션 태그를 이용한 객체 생성 -->
<jsp:useBean id="member" class="com.dto.MemberBean"/>


@java Bean 객체에 저장된 정보 출력하기 <br>
이름 : <%=member.getName() %> <br>
아이디 : <%=member.getUserid() %> <br><br>

@정보를 변경한 후 변경된 정보 출력하기 <br>
<%
member.setName("홍길동");
member.setUserid("HongGilDong");
%>
이름 : <%=member.getName() %> <br>
아이디 : <%=member.getUserid() %> <br><br>

@액션 태그로 정보 변경 후 변경된 정보 출력하기 <br>
<jsp:setProperty name="member" property="name" value="홍길서"/>
<jsp:setProperty name="member" property="userid" value="HongGilSeo"/>
이름 : <jsp:getProperty name="member" property="name"/>  <br>
이름 : <jsp:getProperty name="member" property="userid"/>

</body>
</html>