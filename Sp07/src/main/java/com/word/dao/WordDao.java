package com.word.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.word.dto.WordSet;
import com.word.util.DataBaseManager;

public class WordDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Autowired
	DataBaseManager dbm;
	
//	public WordDao(DataBaseManager dbm) {
//		this.dbm = dbm;
//	}

	public void insert(WordSet wordSet) {
		String sql = "insert into wordset values(?,?)";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"wordset");
			pstmt.setString(2,"wordvalue");
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs); }
	
	}

	public WordSet search(String kw) {
		WordSet ws = null;
		String sql = "select * from wordset where wordkey=?";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"wordkey");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ws = new WordSet(rs.getString("wordkey"), rs.getString("wordvalue"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs); }
		
		return ws;  
	}
}
