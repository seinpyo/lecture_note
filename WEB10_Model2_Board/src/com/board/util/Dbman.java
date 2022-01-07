package com.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbman {
	
	//static 메소드는 인스턴스변수를 사용할 수 없기 때문에
	//driver와 url도 static 선언한다.
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott", "tiger");
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace(); }
		
		return con;

	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
}
