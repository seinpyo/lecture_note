package com.ac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ac.dto.CartVO;
import com.ac.util.Dbman;

public class CartDao {
	private CartDao() {}
	private static CartDao itc = new CartDao();
	public static CartDao getInstance() { return itc; }
	

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertCart(CartVO cvo) {
		String sql = "insert into cart(cseq, id, pseq, quantity) values(cart_seq.nextVal,?,?,?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cvo.getId());
			pstmt.setInt(2, cvo.getPseq());
			pstmt.setInt(3, cvo.getQuantity());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
	}

	public ArrayList<CartVO> selectCart(String id) {
		ArrayList<CartVO> list = new ArrayList<>();
		String sql = "select * from cart_view where id = ? and result='1'";
		//result=1 : 미처리 result=2 : 처리 
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVO cvo = new CartVO();
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setId(rs.getString("id"));
				cvo.setMname(rs.getString("mname"));
				cvo.setPname(rs.getString("pname"));
				cvo.setPseq(rs.getInt("pseq"));
				cvo.setQuantity(rs.getInt("quantity"));
				cvo.setPrice2(rs.getInt("price2"));
				cvo.setIndate(rs.getTimestamp("indate"));
				list.add(cvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return list;
	}

	public void deleteCart(int cseq) {
		String sql = "delete from cart where cseq = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
	}
}
