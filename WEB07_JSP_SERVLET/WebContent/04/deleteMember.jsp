<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%
Connection con = null;
PreparedStatement pstmt = null;

String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String uid = "scott";
String pass = "tiger";
String id = request.getParameter("userid");
String sql = "DELETE FROM MEM WHERE ID =?";

try{
	Class.forName(driver); 
	con = DriverManager.getConnection(url,uid,pass);
	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.executeUpdate();
	} catch(Exception e) { e.printStackTrace();
	} finally {
		try {
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
		} catch (Exception e) { e.printStackTrace(); }
	}
response.sendRedirect("01_MemberMGR.jsp");
%>