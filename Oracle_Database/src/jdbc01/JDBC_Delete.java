package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Delete {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "tiger";
		Connection con = null;  
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);	
			
			Scanner sc = new Scanner(System.in);
			System.out.printf("삭제할 회원의 번호를 입력하세요 : ");
			String num = sc.nextLine();
			
			String sql="DELETE CUSTOMER WHERE NUM=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			
			int result = pstmt.executeUpdate();
			if(result ==1) System.out.println("성공");
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
