package jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Book_Insert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;  
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");	
			
			Scanner sc = new Scanner(System.in);
			System.out.print("출판년도를 입력하세요.");
			String makeyear = sc.nextLine();
			System.out.print("입고가격을 입력하세요.");
			String inprice = sc.nextLine();
			System.out.print("출고가격을 입력하세요.");
			String outprice = sc.nextLine();
			System.out.print("제목을 입력하세요.");
			String suject = sc.nextLine();

			String sql = "INSERT INTO BOOKLIST(NUM, MAKEYEAR, INPRICE, RENTPRICE, SUBJECT) VALUES(BOOK_SEQ.NEXTVAL,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,makeyear);
			pstmt.setString(2,inprice);
			pstmt.setString(3,outprice);
			pstmt.setString(4,suject);
			
			int result = pstmt.executeUpdate();
			if(result == 1) System.out.println("성공");
			else System.out.println("실패");
			
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();		
		}
		try { 
			if(con != null) con.close();	
			if(pstmt != null) pstmt.close();
		}catch (SQLException e) { e.printStackTrace();	
		}	
	}
}
