<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_MemberMGR</title>
<%!
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	String sql = "SELECT * FROM MEM";
%>
</head>
<body>
<table width="800" border="1">

<!-- 항목 -->
	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>전화번호</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	
<!-- 데이터 입력 -->
	<% 
	try{ //자바페이지가 아니라 try~catch 를 수동으로 써줘야함
	Class.forName(driver); 
	con = DriverManager.getConnection(url,uid,pass);
	pstmt = con.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){ //while문이 한번 돌때마다 1개의 행이 생성
		out.print("<tr>");
		out.print("<td>" + rs.getString("name") + "</td>");
		out.print("<td>" + rs.getString("id") + "</td>");
		out.print("<td>" + rs.getString("pwd") + "</td>");
		out.print("<td>" + rs.getString("phone") + "</td>");
		out.print("<td><a href='updateMemberForm.jsp?userid="
				+ rs.getString("id") + "'>수정</a></td>");
		out.print("<td><a href='deleteMember.jsp?userid="
		+ rs.getString("id") + "'>삭제</a></td>");
		out.print("</tr>");
	}
	} catch(Exception e) { e.printStackTrace();
	}
	
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	} catch(Exception e) { e.printStackTrace();
	}
	%>
</table>
<a href="addMemberForm.jsp"> 멤버추가</a>

</body>
</html>