<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSP import -->
<%@ page import = "java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07_Calendar.jsp</title>
<style type="text/css">
	td{font-weight:bold; font-size:110%;}
	tr>td:first-child{color:red;}
	tr>td:last-child{color:blue;}
</style>
</head>
<body>
<%
Calendar sDay = Calendar.getInstance(); // 시작 날짜
Calendar eDay = Calendar.getInstance();	// 끝 날짜

int sYear = sDay.get(Calendar.YEAR);	
int sMonth = sDay.get(Calendar.MONTH); //(0~11의 값으로 유지, 마지막에 +1로 출력)
if(request.getParameter("sYear")!=null) sYear= Integer.parseInt(request.getParameter("sYear"));
if(request.getParameter("sMonth")!=null) {
	sMonth= Integer.parseInt(request.getParameter("sMonth"));
	if(sMonth==12) {
		sMonth = 0;
		sYear++;
	}
	if(sMonth==-1) {
		sMonth = 11;
		sYear--;
	}
}

sDay.set(sYear, sMonth, 1); //2020-01-01
//eDay는 현재 날짜의 다음달 1일로 세팅 후 -1 = 이번달의 마지막 날
eDay.set(sYear, sMonth+1, 1); //다음달 1일
eDay.add(Calendar.DATE, -1); //이번달 말일

//출력하려는 월의 1일자가 무슨 요일인지 정수값으로 계산
//1:일요일, 2:월요일 ...
int START_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
int i, k, cnt = 0;
//i는 반복실행, k는 날짜 출력에 사용, cnt는 줄바꿈
%>

<h1><a href="07_Calendar.jsp?sYear=<%=sYear%>&sMonth=<%=sMonth-1%>">이전달</a>
	&nbsp;&nbsp;&nbsp;  <%=sYear %>년 <%=sMonth+1 %>월 &nbsp;&nbsp;&nbsp; 
	<a href="07_Calendar.jsp?sYear=<%=sYear%>&sMonth=<%=sMonth+1%>">다음달</a></h1>
<table width="560" align="left" cellspacing="1" bgcolor="black">
	<tr bgcolor="white" height="50">
		<td align="center" width="80">월</td>
		<td align="center" width="80">화</td>
		<td align="center" width="80">수</td>
		<td align="center" width="80">목</td>
		<td align="center" width="80">금</td>
		<td align="center" width="80">토</td>
		<td align="center" width="80">일</td>
	</tr>
	<!-- 첫줄에 나올 날짜들 1일자 요일 전까지 공백 1,2,3 -->
	<tr bgcolor="white" height="50">
		<% for(i=1; i<START_WEEK; i++){ %>
			<td>&nbsp;</td>
			<!-- 첫칸부터 시작요일의 바로 전칸까지 빈칸 -->
		<% } %>
		<% for(i=1; i<=8-START_WEEK; i++){ %>
			<td align="right"> <%=i %> &nbsp; </td>
		<%} %>
	</tr>
	<tr bgcolor="white" height="60">
		<%for(k=i; k<=eDay.get(Calendar.DATE); k++) {%>
			<td align="right"> <%=k %> &nbsp; </td>
			<!-- 일요일부터 날자가 출력되고 있기 때문에 1부터 시작한 cnt변수로 카운트해서 줄바꿈 실행 -->
			<%cnt++;
				if(cnt%7 == 0) { %>
					</tr><tr bgcolor="white" height="60"> <!--tr태그 끝내고 다시 시작 = 줄바꿈 -->
				<% } %>
			<% } %>
			<%for(i=1; i<=7-(cnt%7); i++) { %>
				<td>&nbsp;</td>
		<% } %>
	</tr>
</table>
</body>
</html>