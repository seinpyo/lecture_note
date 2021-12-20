package jdbc03;

import java.sql.*;
import java.util.Scanner;

public class Book_Dao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con = null;  
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public void select() {
		//테이블 내용을 조회해서 결과를 리턴해주는 메서드
	}
	
	public void insert(Book_Dto bdto) {
		//전달된 데이터를 테이블에 레코드로 추가하는 메서드
		//DTO에 담긴 데이터가 전달인수로 받는다
		String sql = "INSERT INTO BOOKLIST VALUES(BOOK_SEQ.NEXTVAL,?,?,?,?,?)";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getSubject());
			pstmt.setInt(2, bdto.getMakeyear());
			pstmt.setInt(3, bdto.getInprice());
			pstmt.setInt(4, bdto.getRentprice());
			pstmt.setString(5, bdto.getGrade());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(con != null) con.close();	
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}catch (SQLException e) { e.printStackTrace();}	
		}
		
	}
	
	public void update() {
		//전달된 값으로 레코드를 수정하는 메서드
	}
	
	public void delete() {
		//전달된 값으로 레코드를 삭제하는 메서드
	}

}
