package jdbc02;

import java.sql.*;
import java.sql.SQLException;

public class Book_Select {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;  
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");	
			String sql = "SELECT * FROM BOOKLIST";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("도서번호\t출판년도\t입고가격\t출고가격\t제목");
			System.out.println("-----------------------------------------------------------------------------------");
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String subject = rs.getString("subject");
				int makeyear = rs.getInt("makeyear");
				int inprice = rs.getInt("inprice");
				int rentprice = rs.getInt("rentprice");
				System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%s\n",num, makeyear, inprice, rentprice, subject);
			}
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();		
		}
		try { 
			if(con != null) con.close();	
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}catch (SQLException e) { e.printStackTrace();	
		}	
	}
}