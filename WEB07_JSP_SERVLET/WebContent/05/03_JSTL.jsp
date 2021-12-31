<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_JSTL</title>
</head>
<body>
단춘 출력 <br>
<c:out value = "Hello"/>
<c:out value = "Hello"> </c:out> 
<br><br><br>

<h4>변수 생성 및 초기화1 </h4>
<c:set var="msg" value="Hello"> </c:set><br>
\${ msg } = ${ msg }
<br><br><br>

<h4>변수 생성 및 초기화2 </h4>
<c:set var="age"> 30 </c:set><br>
생성한 변수를 EL로 출력<br>
\${ age } = ${ age }
<br><br><br>


<h4>객체 생성</h4>
<c:set var="member" value="<%=new com.dto.MemberBean()%>"/>
<!-- 멤버 변수 값 변경 -->
<c:set target="${member}" property="name" value="홍길동"/>
<c:set target="${member}" property="userid"> HONG </c:set>
EL에 의한 멤버변수 출력 : 객체와 멤버변수 이름만으로 setter 기능이 대체 된다 <br>
\${ member.name } = ${ member.name }<br>
\${ member.userid } = ${ member.userid }<br>
<br><br><br>


<h4>JSTL과 EL의 혼합 사용</h4>
<c:set var="add" value="${ 10+5 }"/>
\${ add } = ${ add }<br>
<c:set var="flag" value="${ 10>5 }"/>
\${ flag } = ${ flag }<br>
<br><br><br>

<input type="text" value="${ member.userid }"> <br>

</body>
</html>