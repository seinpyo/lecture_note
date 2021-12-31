<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_ParameterNull</title>
</head>
<body>
<h3> JSP 코드 : 
<% String id = request.getParameter("id"); %>
<%=id %> </h3>

<h3>EL 코드 : ${ param.id }</h3>

JSP 코드 
<br>
<!-- request.getParameter("id").equals("hong") -->
equals() 사용 결과 : error => equals 메서드는 "null"값과 비교 시 오류! <br> 
에러를 방지하기 위해 아래와 같은 연산자 사용 <br>
request.getParameter(id) == "hong" -> 
<%= request.getParameter(id)!=null && request.getParameter(id).equals("hong") %>
<hr>
EL코드 
'==' 연산자 사용 결과 : \${ param.id=="hong" } -> ${ param.id=="hong" }

<pre>
if(request.getParameter("id")!=null){
	if(request.getParameter("id").equals("hong")){
	}
}
</pre>

</body>
</html>