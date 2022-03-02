package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.board.dto.MemberDto;
import com.ezen.board.util.DataBaseManager;

@Repository
public class MemberDao {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Autowired
	DataBaseManager dbm;

	public MemberDto getMember(String id) {
		MemberDto mdto = null;
		String sql = "select * from member2 where userid=?";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setEmail(rs.getString("email"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { dbm.close(con,pstmt,rs); } 
		return mdto;
	}

}
