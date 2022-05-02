package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Insert {
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
			System.out.print("이름을 입력하세요.");
			String name = sc.nextLine();
			System.out.print("이메일을 입력하세요.");
			String email = sc.nextLine();
			System.out.print("전화번호를 입력하세요.");
			String tel = sc.nextLine();
			
			String sql = "INSERT INTO CUSTOMER VALUES(NUM_SEQ.NEXTVAL,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,name);
			pstmt.setString(2,email);
			pstmt.setString(3,tel);
			//인덱스 번호 변경
			
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
