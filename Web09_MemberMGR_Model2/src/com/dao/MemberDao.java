package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.MemberDto;

public class MemberDao {

	private MemberDao() {}
	private static MemberDao it = new MemberDao();
	public static MemberDao getInstance() { return it; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "scott";
	String pwd = "tiger";
	
	//연결
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id, pwd);
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace(); }
		
		return con;
	}
	
	//단절 함수
	private void close() {
		
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {e.printStackTrace();
		}
	}

	public MemberDto getMember(String userid) {
		MemberDto mdto = null;
		String sql = "select * from member where userid=?";
		
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setName(rs.getString("name"));
				mdto.setUserid(rs.getString("userid"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setEmail(rs.getString("email"));
				mdto.setAdmin(rs.getInt("admin"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { close(); }
	
		return mdto;
	}

	public int insertMember(MemberDto mdto) {
		int result = 0;
		String sql = "insert into member(userid, name, pwd, phone, email, admin)" +
		"values(?, ?, ?, ?, ?, ?)";
		
		con=getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mdto.getUserid());
			pstmt.setString(2, mdto.getName());
			pstmt.setString(3, mdto.getPwd());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getEmail());
			pstmt.setInt(6, mdto.getAdmin());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { close(); }
		
		return result;
	}

	public int updateMember(MemberDto mdto) {
		  int result = 0;
		  String sql = "update member set name = ?, pwd=?, phone=?, email=?, admin=?"
		  + "where userid=?";
		  con = getConnection();
		  try {
		  pstmt = con.prepareStatement(sql);

		    pstmt.setString(1, mdto.getName());
		    pstmt.setString(2, mdto.getPwd());
		    pstmt.setString(3, mdto.getPhone());
		    pstmt.setString(4, mdto.getEmail());
		    pstmt.setInt(5, mdto.getAdmin());
		    pstmt.setString(6, mdto.getUserid());

		    result = pstmt.executeUpdate();
		  } catch (SQLException e) { e.printStackTrace(); 
		  } finally {close(); }
		  return result;
		  }
	
}
