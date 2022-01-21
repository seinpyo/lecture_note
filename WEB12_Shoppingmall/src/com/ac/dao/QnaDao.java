package com.ac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ac.dto.QnaVO;
import com.ac.util.Dbman;

public class QnaDao {
	private QnaDao() {}
	private static QnaDao itc = new QnaDao();
	public static QnaDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<QnaVO> listQna(String id) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = "select * from qna where id=? order by qseq desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
		    	QnaVO qvo = new QnaVO();
		    	qvo.setQseq(rs.getInt("qseq"));
		    	qvo.setSubject(rs.getString("subject"));
		    	qvo.setContent(rs.getString("content"));
		    	qvo.setId(rs.getString("id"));
		    	qvo.setIndate(rs.getTimestamp("indate"));
		    	qvo.setReply(rs.getString("reply"));
		    	qvo.setRep(rs.getString("rep"));		    	
		    	list.add(qvo);
		    }
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return list;
	}

	public QnaVO getQna(int qseq) {
		QnaVO qvo = new QnaVO();
		String sql = "select * from qna where qseq = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
		    	qvo.setQseq(rs.getInt("qseq"));
		    	qvo.setSubject(rs.getString("subject"));
		    	qvo.setContent(rs.getString("content"));
		    	qvo.setId(rs.getString("id"));
		    	qvo.setIndate(rs.getTimestamp("indate"));
		    	qvo.setReply(rs.getString("reply"));
		    	qvo.setRep(rs.getString("rep"));		    	
		    }
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return qvo;
	}
	
	
	
}
