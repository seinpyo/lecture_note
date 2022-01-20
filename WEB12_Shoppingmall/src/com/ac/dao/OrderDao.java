package com.ac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ac.dto.CartVO;
import com.ac.util.Dbman;

public class OrderDao {
	private OrderDao() {}
	private static OrderDao itc = new OrderDao();
	public static OrderDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int insertOrder(ArrayList<CartVO> list, String id) {
		int oseq = 0;
		con = Dbman.getConnection();
		String sql = "insert into orders(oseq, id) values(ORDER_SEQ.NEXTVAL, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			//새로운 주문번호 생성 
			
			pstmt.close();
			sql="select max(oseq) as max_oseq from orders";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) oseq = rs.getInt("max_oseq");
			//방금 생성한 주문번호 조회
			
			pstmt.close();
			for(CartVO cvo : list) {
				sql = "insert into order_detail(odseq,oseq, pseq, quantity) "
						+ "values(order_detail_seq.nextVal,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, oseq);
				pstmt.setInt(2, cvo.getPseq());
				pstmt.setInt(3, cvo.getQuantity());
				pstmt.executeUpdate();
				
				pstmt.close();
				sql = "Update cart set result='2' where cseq=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, cvo.getCseq());
				pstmt.executeUpdate();
			}
			//주문자의 카트목록의 제품들을 oseq와 함께 order_detail에 추가하고
			//result를 2로 변경 
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return oseq;
	}
	
	
	
	
}

