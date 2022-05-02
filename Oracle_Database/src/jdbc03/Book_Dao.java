package jdbc03;

import java.sql.*;
import java.util.ArrayList;

public class Book_Dao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con = null;  
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public ArrayList<Book_Dto> select() {
		//테이블 내용을 조회해서 결과를 리턴해주는 메서드
		
		String sql = "SELECT * FROM BOOKLIST ORDER BY NUM DESC";
		ArrayList<Book_Dto> list = new ArrayList<>();
		
		//db연결
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book_Dto bdto = new Book_Dto();
				int num = rs.getInt("num");
				bdto.setNum(num);
				//위 두줄과 아래 한줄은 동일한 기능
				bdto.setSubject(rs.getString("subject"));
				bdto.setMakeyear(rs.getInt("makeyear"));
				bdto.setInprice(rs.getInt("inprice"));
				bdto.setRentprice(rs.getInt("rentprice"));
				bdto.setGrade(rs.getString("grade"));
				list.add(bdto);
				//list에 bdto를 넣음 (object형태로)
			}
		
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		} finally {
			try {
				if(con != null) con.close();	
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}catch (SQLException e) { e.printStackTrace();}	
			
		}
		return list;
	}
	
	public int insert(Book_Dto bdto) {
		int result = 0;
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
			
			result = pstmt.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(con != null) con.close();	
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) { e.printStackTrace();}	
		}
		return result;
	}
	
	public int update(Book_Dto bdto) {
		//전달된 값으로 레코드를 수정하는 메서드
		int result = 0;
		String sql = "UPDATE BOOKLIST SET SUBJECT=?, MAKEYEAR=?, INPRICE=?, RENTPRICE=?, GRADE=? WHERE NUM = ?";
		//콤마, 스펠링 주의
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getSubject());
			pstmt.setInt(2, bdto.getMakeyear());
			pstmt.setInt(3, bdto.getInprice());
			pstmt.setInt(4, bdto.getRentprice());
			pstmt.setString(5, bdto.getGrade());
			pstmt.setInt(6, bdto.getNum());
			
			result = pstmt.executeUpdate();
	
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try{
				if(con != null) con.close();	
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) { e.printStackTrace();}	
		}
		return result;
	}
	
	public int delete(int num) {
		//전달된 값으로 레코드를 삭제하는 메서드
		int result = 0;
		String sql = "DELETE FROM BOOKLIST WHERE NUM=?";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			//테이블 내용을 표시하지 않아도 되므로 rs 필요 x
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}finally {
			try{
				if(con != null) con.close();	
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) { e.printStackTrace();}	
		}
		return result;
	}

	public Book_Dto getBook(int num) {
		//Book_Dto가 리턴되는 검색 조회 메서드
		Book_Dto bdto = null;
		String sql = "SELECT * FROM BOOKLIST WHERE NUM = ?";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			//검색 결과는 한개(PK로 검색했으므로)이므로 while이 아닌 if사용
			if(rs.next()) {
				bdto = new Book_Dto();
				bdto.setNum(rs.getInt("num"));
				bdto.setSubject(rs.getString("subject"));
				bdto.setMakeyear(rs.getInt("makeyear"));
				bdto.setInprice(rs.getInt("inprice"));
				bdto.setRentprice(rs.getInt("rentprice"));
				bdto.setGrade(rs.getString("grade"));
				//검색 결과가 있을 경우 새 DTO 객체 생성, 내용 저장 -> return
			} 
			//검색 결과가 없는 경우 bdto는 처음에 지정한대로 null이므로 null이 return
			
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try{
				if(con != null) con.close();	
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}catch (SQLException e) { e.printStackTrace();}	
		}
		return bdto;
	}
}
