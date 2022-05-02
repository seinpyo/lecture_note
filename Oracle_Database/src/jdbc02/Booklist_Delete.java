package jdbc02;

import java.sql.*;
import java.util.Scanner;

public class Booklist_Delete {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");

			Scanner sc = new Scanner(System.in);
			System.out.printf("삭제할 도서의 번호를 입력하세요 : ");
			String num = sc.nextLine();

			String sql = "DELETE BOOKLIST WHERE NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));

			int result = pstmt.executeUpdate();
			if (result == 1)
				System.out.println("성공");
			else
				System.out.println("실패");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
