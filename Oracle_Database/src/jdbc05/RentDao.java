package jdbc05;

import java.sql.*;
import java.util.ArrayList;

import jdbc04.MemberDto;

public class RentDao {

	private RentDao() {}
	private static RentDao itc = new RentDao();
	public static RentDao getInstance() { return itc; }
	//싱글턴 객체
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<RentDto> select(){
		ArrayList<RentDto> list = new ArrayList<>();
		con = DBManager.getConnection();
		String sql = "SELECT TO_CHAR(RENTDATE,'YYYY-MM-DD') AS RENTDATE, "
				+ "NUM, BOOKNUM, MEMBERNUM, DISCOUNT FROM RENTLIST ORDER BY NUM DESC";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RentDto rdto = new RentDto();
				//rentdate 필드 : Date 형식 => DTO의 rentDate : String으로 변환필요
				//=> Select 문 안에서 to_Char() 함수 사용
				rdto.setRentdate(rs.getString("rentdate"));
				rdto.setNum(rs.getInt("num"));
				rdto.setBooknum(rs.getInt("booknum"));
				rdto.setMembernum(rs.getInt("membernum"));
				rdto.setDiscount(rs.getInt("discount"));
				list.add(rdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);
		}
		return list;
	}
	
	public boolean checkBooknum(int booknum) {
		con = DBManager.getConnection();
		boolean state = false;
		String sql = "SELECT * FROM RENTLIST WHERE BOOKNUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, booknum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				state = true;
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);
		}
		return state;
	}
	
	public boolean checkMembernum(int membernum) {
		con = DBManager.getConnection();
		boolean state = false;
		String sql = "SELECT * FROM RENTLIST WHERE MEMBERNUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, membernum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				state = true;
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);
		}
		return state;
	}	
	
	public int insert( RentDto rdto ){
		int result = 0;
		con = DBManager.getConnection();
		String sql = "insert into rentlist values(sysdate, rent_seq.nextVal, ? , ? , ? )";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  rdto.getBooknum() );
			pstmt.setInt(2,  rdto.getMembernum() );
			pstmt.setInt(3,  rdto.getDiscount() );
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {	DBManager.close( con, pstmt, rs ); }
		return result;
	}

	
	public RentDto getRent(int num) {
		RentDto rdto = null;
		con = DBManager.getConnection();
		String sql = "SELECT TO_DATE(RENTDATE,'YYYY-MM-DD') AS RENTDATE, NUM, BOOKNUM,"
				+ "MEMBERNUM, DISCOUNT FROM RENTLIST WHERE NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rdto = new RentDto();
				rdto.setRentdate(rs.getString("rentdate"));
				rdto.setBooknum(rs.getInt("booknum"));
				rdto.setMembernum(rs.getInt("membernum"));
				rdto.setDiscount(rs.getInt("discount"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);
		}
		return rdto;
	}
	
	public int update(RentDto rdto) {
		int result = 0;
		con = DBManager.getConnection();
		String sql = "UPDATE RENTLIST SET RENTDATE=TO_DATE(''||?||'', 'YYYYMMDD'), BOOKNUM=?, MEMBERNUM=?, DISCOUNT=? WHERE NUM =?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, rdto.getRentdate());
			pstmt.setInt(2, rdto.getBooknum());
			pstmt.setInt(3, rdto.getMembernum());
			pstmt.setInt(4, rdto.getDiscount());
			pstmt.setInt(5, rdto.getNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);
		}
		return result;
	}
	
	public int delete(int num) {
		int result = 0;
		con = DBManager.getConnection();
		String sql = "DELETE FROM RENTLIST WHERE NUM = ?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con,pstmt,rs);		
		}
		
		return result;
	}

	public ArrayList<RentDetailDto> selectAll() {
		
		ArrayList<RentDetailDto> list = new ArrayList<>();
		con = DBManager.getConnection();
		String sql = "SELECT * FROM RENTDETAIL";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RentDetailDto rdto = new RentDetailDto();
				rdto.setRentdate(rs.getString("rentdate"));
				rdto.setRentnum(rs.getInt("rentnum"));
				rdto.setMembernum(rs.getInt("membernum"));
				rdto.setMembername(rs.getString("membername"));
				rdto.setPrice(rs.getInt("price"));
				rdto.setBooknum(rs.getInt("booknum"));
				rdto.setSubject(rs.getString("subject"));
				list.add(rdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);
		}
		
		return list;
	}
}
	