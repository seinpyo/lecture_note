package com.ac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ac.dto.CartVO;
import com.ac.dto.OrderVO;
import com.ac.dto.ProductVO;
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
				//result를 2로 바꾸거나 그냥 삭제해 버릴 수도 있음
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, cvo.getCseq());
				pstmt.executeUpdate();
			}
			//주문자의 카트목록의 제품들을 oseq와 함께 order_detail에 추가하고
			//result를 2로 변경 
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return oseq;
	} //나중에 작성할 때는 메서드를 4개로 나눠서 작성할 것

	
	public ArrayList<OrderVO> listOrderById(String id, int oseq) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		String sql = "select * from order_view where oseq = ?";
		con = Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO ovo = new OrderVO();
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setId(rs.getString("id"));
				ovo.setIndate(rs.getTimestamp("Indate"));
				ovo.setMname(rs.getString("mname"));
				ovo.setPname(rs.getString("pname"));
				ovo.setZip_num(rs.getString("zip_num"));
				ovo.setAddress(rs.getString("address"));
				ovo.setPhone(rs.getString("phone"));
				ovo.setResult(rs.getString("result"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setPrice2(rs.getInt("price2"));
				list.add(ovo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		
		return list;
	}

	public ArrayList<Integer> selectOSeqOrderIng(String id) {
		ArrayList<Integer> list = new ArrayList<>();
		String sql = "select distinct oseq from order_view "
				+ " where id=? and result='1' order by oseq desc";
		con = Dbman.getConnection();
		try {
		  pstmt = con.prepareStatement(sql); 
		  pstmt.setString(1, id);
		  rs = pstmt.executeQuery();
		  while (rs.next()) 
				list.add(rs.getInt(1));
		} catch (Exception e) { e.printStackTrace();
	    } finally { Dbman.close(con, pstmt, rs); }    
		return list;
	}

	public ArrayList<OrderVO> listOrderByOseq(Integer oseq) {
		 ArrayList<OrderVO> list = new ArrayList<OrderVO>();
			String sql = "select * from order_view where oseq=?";
			con = Dbman.getConnection();
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, oseq);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					OrderVO ovo = new OrderVO();
					ovo.setOdseq(rs.getInt("odseq"));
					ovo.setOseq(rs.getInt("oseq"));
					ovo.setId(rs.getString("id"));
					ovo.setIndate(rs.getTimestamp("indate"));
					ovo.setMname(rs.getString("mname"));
					ovo.setZip_num(rs.getString("zip_num"));
					ovo.setAddress(rs.getString("address"));
					ovo.setPhone(rs.getString("phone"));
					ovo.setPseq(rs.getInt("pseq"));
					ovo.setQuantity(rs.getInt("quantity"));
					ovo.setPname(rs.getString("pname"));
					ovo.setPrice2(rs.getInt("price2"));
					ovo.setResult(rs.getString("result"));
					list.add(ovo);
				}
			} catch (SQLException e) { e.printStackTrace();
			} finally { Dbman.close(con, pstmt, rs); }
		 return list;
		
	}
	
	public ArrayList<Integer> selectOSeqOrderAll(String id) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select distinct oseq,result from order_view "
				+ "where id=? order by result, oseq desc";
		con = Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
	 return list;
	}


	public int insertOrderOne(ProductVO pvo, String id, int quantity) {
		int oseq = 0;
		String sql = "insert into orders(oseq, id) values(ORDER_SEQ.NEXTVAL, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		
	        sql="select max(oseq) as max_oseq from orders";
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        if(rs.next()) oseq = rs.getInt("max_oseq");
	        //방금 생성한 주문번호 조회
	        
			pstmt.close();
	        
			sql = "insert into order_detail(odseq,oseq,pseq,quantity) values(order_detail_seq.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			pstmt.setInt(2, pvo.getPseq());
			pstmt.setInt(3, quantity);
			pstmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return oseq;
	}
	
}

