package com.word.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

public class DataBaseManager {
	private String driver;
	private String url;
	private String id;
	private String pw;
	
	@Autowired 
	
	private DataBaseUserinfo dbi;
	
//	public DataBaseManager(DataBaseUserinfo dbi) {
//		this.dbi = dbi;
//	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(dbi.getDriver());
			con = DriverManager.getConnection(dbi.getUrl(), dbi.getId(), dbi.getPw());
		} catch (SQLException e) { e.printStackTrace();
		} catch (ClassNotFoundException e) { e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}catch (SQLException e) { e.printStackTrace(); }
	}
}
