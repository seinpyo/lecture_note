package JDBC01;

import java.sql.*;
import java.util.ArrayList;

public class MemberDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() { return itc; }
	
	public ArrayList<MemberDto>selectAll(){
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "SELECT NUM, NAME, PHONE, BIRTH, BPOINT, "
				+ "DATE_FORMAT(BIRTH, '%Y-%m-%d') AS BT, DATE_FORMAT(JOINDATE, '%Y-%m-%d') AS JD"
				+ ", AGE, GENDER FROM MEMBERLIST ORDER BY NUM DESC";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setNum(rs.getInt("num"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getString("BT"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setJoindate(rs.getString("JD"));
				mdto.setGender(rs.getString("gender"));
				mdto.setAge(rs.getInt("age"));
				list.add(mdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBman.close(con,pstmt,rs);
		}
		
		return list;
	}
	
	public int insert(MemberDto mdto){
		int result = 0;
		String sql = "INSERT INTO MEMBERLIST(NAME, PHONE, BIRTH, GENDER, AGE) "
				+ "VALUES (?, ?, STR_TO_DATE(CONCAT('',?,''),'%Y-%m-%d'), ?, ?)";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName() );
			pstmt.setString(2, mdto.getPhone() );
			pstmt.setString(3, mdto.getBirth() );
			pstmt.setString(4, mdto.getGender() );
			pstmt.setInt(5, mdto.getAge() );
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBman.close(con,pstmt,rs);
		}
		return result;
	}
	
	public int update(MemberDto mdto){
		int result = 0;
		String sql = "UPDATE MEMBERLIST SET NAME=?, PHONE=?, "
				+ "BIRTH=STR_TO_DATE(CONCAT('',?,''),'%Y-%m-%d'),"
				+ "JOINDATE=STR_TO_DATE(CONCAT('',?,''),'%Y-%m-%d'), BPOINT=?,"
				+ " AGE=?, GENDER=? WHERE NUM=?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName() );
			pstmt.setString(2, mdto.getPhone() );
			pstmt.setString(3, mdto.getBirth() );
			pstmt.setString(4, mdto.getJoindate() );
			pstmt.setInt(5, mdto.getBpoint());
			pstmt.setInt(6, mdto.getAge() );
			pstmt.setString(7, mdto.getGender() );	
			pstmt.setInt(8, mdto.getNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBman.close(con,pstmt,rs);
		}
		return result;
	}
	
	public int delete(int num){
		int result = 0;
		String sql = "DELETE FROM MEMBERLIST WHERE NUM=?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBman.close(con,pstmt,rs);
		}
		return result;	
	}
	
	public MemberDto selectOne(int num){
		MemberDto mdto = null;
		String sql = "SELECT NUM, NAME, PHONE, BPOINT, AGE, GENDER,"
				+ "DATE_FORMAT(BIRTH, '%Y-%m-%d') AS BT, DATE_FORMAT(JOINDATE, '%Y-%m-%d') AS JD"
				+ " FROM MEMBERLIST WHERE NUM = ?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setNum(rs.getInt("num"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getString("BT"));
				mdto.setJoindate(rs.getString("JD"));
				mdto.setAge(rs.getInt("age"));
				mdto.setGender(rs.getString("gender"));
				mdto.setBpoint(rs.getInt("bpoint"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBman.close(con,pstmt,rs);
		}
		return mdto; 
	}
}
