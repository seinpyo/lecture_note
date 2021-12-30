<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("userid");
String name = request.getParameter("name");
String nickname = request.getParameter("nickname");
String pwd = request.getParameter("pwd");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
%>

<!-- dto 객체 생성 & request에 getAttribute로 저장까지 한번에 실행 -->
<jsp:useBean id="member" class="com.dto.MemberBean" scope="request"/>

<!-- 전달된 파라미터로 멤버 변수 변경 -->
<jsp:setProperty name="member" property="name" value="<%=name%>"/>
<jsp:setProperty name="member" property="userid" value="<%=id%>"/>
<jsp:setProperty name="member" property="pwd" value="<%=pwd%>"/>
<jsp:setProperty name="member" property="nickname" value="<%=nickname%>"/>
<jsp:setProperty name="member" property="email" value="<%=email%>"/>
<jsp:setProperty name="member" property="phone" value="<%=phone%>"/>

<%
RequestDispatcher dp = request.getRequestDispatcher("084_useBeanAction.jsp");
dp.forward(request,response);
%>