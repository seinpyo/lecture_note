package com.ac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ac.dto.AddressVO;
import com.ac.dto.MemberVO;
import com.ac.util.Dbman;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberVO getMember(String id) {
		MemberVO mvo = null;
		String sql="select * from member where id = ?";
		con = Dbman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setZip_num(rs.getString("zip_num"));
				mvo.setAddress(rs.getString("address"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setUseyn(rs.getString("useyn"));
				mvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return mvo;
	}

	public ArrayList<AddressVO> selectAdress(String dong) {
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		String sql = "select * from address where dong like '%'||?||'%'";
		con = Dbman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while(rs.next()){
				AddressVO avo = new AddressVO();
				avo.setZip_num(rs.getString("zip_num"));
				avo.setSido(rs.getString("sido"));
				avo.setGugun(rs.getString("gugun"));
				avo.setDong(rs.getString("dong"));
				avo.setZip_code(rs.getString("zip_code"));
				avo.setBunji(rs.getString("bunji"));
				list.add(avo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return list;
	}

	public int insertMember(MemberVO mvo) {
		String sql = "insert into member(id, name, pwd, phone, email, zip_num, address) " +
				"values (?,?,?,?,?,?,?)";
		int result = 0;
		con=Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getPwd());
			pstmt.setString(4, mvo.getPhone());
			pstmt.setString(5, mvo.getEmail());
			pstmt.setString(6, mvo.getZip_num());
			pstmt.setString(7, mvo.getAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return result;
	}
	
	public void updateMember(MemberVO mvo) {
		
		String sql = "update member set name=?, pwd=?, phone=?, email=?, zip_num=?, address=? where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getPhone());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getZip_num());
			pstmt.setString(6, mvo.getAddress());
			pstmt.setString(7, mvo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { Dbman.close(con,pstmt,rs); }
	
		}
}
