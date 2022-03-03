package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.ReplyVO;
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

	public void insert(BoardDto bdto) {
		String sql = "insert into board (num, userid, pass, email, title, content, imgfilename) "
				+ "values(board_seq.nextVal,?,?,?,?,?,?)";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getUserid());
			pstmt.setString(2, bdto.getPass());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getTitle());
			pstmt.setString(5, bdto.getContent());
			pstmt.setString(6, bdto.getImagefilename());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs); }
	}

	public BoardDto getBoard(int num) {
		BoardDto bdto = new BoardDto();
		String sql = "select * from board where num=?";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs); }
		return bdto;
	}

	public void plusReadCount(int num) {
		String sql = "update board set readcount = readcount+1 where num=?";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs); }
	}

	public ArrayList<ReplyVO> getReply(int num) {
		ArrayList<ReplyVO> list = new ArrayList<>();
		String sql = "select * from reply2 where boardnum = ? order by num desc";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO rvo = new ReplyVO();
				rvo.setNum(rs.getInt("num"));
				rvo.setBoardnum(rs.getInt("boardnum"));
				rvo.setUserid(rs.getString("userid"));
				rvo.setWritedate(rs.getTimestamp("writedate"));
				rvo.setContent(rs.getString("content"));
				list.add(rvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs); }
		return list;
	}

	public void addReply(ReplyVO rvo) {
		String sql = "insert into reply2 (num, userid, content, boardnum) "
				+ "values (reply_seq.nextVal, ?, ?, ?)";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rvo.getUserid());
			pstmt.setString(2, rvo.getContent());
			pstmt.setInt(3, rvo.getBoardnum());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { dbm.close(con, pstmt, rs); }
	}
	
	
}
