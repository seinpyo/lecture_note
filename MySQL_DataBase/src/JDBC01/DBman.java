package JDBC01;

import java.sql.*;

public class DBman {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/scott";
	//다른 컴퓨터에서 접속 시에는 localhost 대신 아이피 주소
	private static String id = "root";
	private static String pw = "adminuser";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
			try {
				if(con != null)con.close();
				if(pstmt != null)con.close();
				if(rs != null)con.close();
			} catch (SQLException e) {e.printStackTrace();
			}
		
	}
}
