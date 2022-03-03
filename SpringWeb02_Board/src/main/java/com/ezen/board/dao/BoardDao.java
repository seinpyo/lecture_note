package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.util.DataBaseManager;

@Repository
public class BoardDao {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Autowired
	DataBaseManager dbm;

	public ArrayList<BoardDto> getBoardsMain() {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select * from board order by num desc";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto bdto = new BoardDto();
				bdto.setContent(rs.getString("content"));
				bdto.setEmail(rs.getString("email"));
				bdto.setImagefilename(rs.getString("imgfilename"));
				bdto.setNum(rs.getInt("num"));
				bdto.setPass(rs.getString("pass"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setReplycnt(rs.getInt("replycnt"));
				bdto.setTitle(rs.getString("title"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				list.add(bdto);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs); }
		return list;
	}
	
	
}
