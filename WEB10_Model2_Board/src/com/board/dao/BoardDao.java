package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.dto.BoardDto;
import com.board.dto.ReplyDto;
import com.board.util.Dbman;
import com.board.util.Paging;

public class BoardDao {
	private BoardDao() {}
	private static BoardDao itc = new BoardDao();
	public static BoardDao getInstance() { return itc; }
	

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardDto> selectBoard(Paging paging){
		ArrayList<BoardDto> list = new ArrayList<>();
		//String sql = "select * from board order by num desc";
		String sql = "select * from " 
					+"(select * from " 
					+ "(select rownum as rn, sub.* "
					+ "from (select * from board order by num desc) sub) " 
					+ "where rn>=?) where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  paging.getStartNum());
			pstmt.setInt(2,  paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setTitle(rs.getString("title"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				list.add(bdto);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		
		return list;
	}

	
	public void viewCount(int num) {
		String sql = "update board set READCOUNT=READCOUNT+1 where num=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
	}


	public BoardDto getBoard(int num) {
		BoardDto bdto = null;
		String sql = "select * from board where num=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setPass(rs.getString("pass"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setEmail(rs.getString("email"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		
		return bdto;
	}


	public void insertBoard(BoardDto bdto) {
		String sql = "insert into board(num, userid, pass, email, title, content)"
				+ " values (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		con=Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getUserid());
			pstmt.setString(2, bdto.getPass());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getTitle());
			pstmt.setString(5, bdto.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con,pstmt,rs); }
	}


	public void updateBoard(BoardDto bdto) {
		String sql = "update board set userid=?, pass=?, email=?, title=?, content=? where num=?";
		
		con=Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getUserid());
			pstmt.setString(2, bdto.getPass());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getTitle());
			pstmt.setString(5, bdto.getContent());
			pstmt.setInt(6, bdto.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);} 
	}


	public void deleteBoard(int num) {
		String sql = "delete from board where num=?";
		
		con=Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}


	public void insertReply(ReplyDto rdto) {
		String sql = "insert into reply(num, boardnum, userid, content) "
				+ "values (reply_seq.nextVal, ?, ?, ?)";
		
		con=Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rdto.getBoardnum());
			pstmt.setString(2, rdto.getUserid());
			pstmt.setString(3, rdto.getContent());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}


	public ArrayList<ReplyDto> selectReply(int num) {
		ArrayList<ReplyDto> list = new ArrayList<>();
		String sql = "select * from reply where boardnum=? order by num desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyDto rdto = new ReplyDto();
				rdto.setNum(rs.getInt("num"));
				rdto.setBoardnum(rs.getInt("boardnum"));
				rdto.setUserid(rs.getString("userid"));
				rdto.setWritedate(rs.getTimestamp("writedate"));
				rdto.setContent(rs.getString("content"));
				list.add(rdto);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		
		return list;
	}


	public void deleteReply(int num) {
		String sql = "delete from reply where num=?";
		
		con=Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}


	public int getAllCount() {
		int count = 0;
		String sql = "select count(*) as cnt from board";
		con=Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return count;
	}


	public int getReplycnt(int num) {
		int cnt = 0; 
		String sql = "select count(*) as cnt from reply where boardnum=?";
		con=Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) cnt = rs.getInt("cnt");
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return cnt;
	}

}
