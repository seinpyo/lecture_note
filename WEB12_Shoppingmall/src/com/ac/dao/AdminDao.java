package com.ac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ac.dto.AdminVO;
import com.ac.dto.MemberVO;
import com.ac.dto.OrderVO;
import com.ac.dto.ProductVO;
import com.ac.util.Dbman;
import com.ac.util.Paging;

public class AdminDao {
	private AdminDao() {}
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() { return itc; } 

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminVO workerCheck(String workId) {
		AdminVO avo = null;
		String sql = "select * from worker where id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, workId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				avo = new AdminVO();
				avo.setId(rs.getString("id"));
				avo.setName(rs.getString("name"));
				avo.setPhone(rs.getString("phone"));
				avo.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return avo;
	}

	public ArrayList<ProductVO> listProduct(Paging paging, String key) {
		ArrayList<ProductVO> list = new ArrayList<>();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, p.* from "
				+ "((select * from product where name like '%'||?||'%'order by pseq desc) p)"
				+ ") where rn >= ?) where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setContent(rs.getString("content"));
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setImage(rs.getString("image"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setUseyn(rs.getString("useyn"));
				list.add(pvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return list;
	}

	public int getAllCount(String tablename, String fieldname, String key) {
		int count=0;
		String sql = "select count(*) as cnt from " + tablename 
				+ " where " + fieldname + " like '%'||?||'%'";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return count;
	}

	public void insertProduct(ProductVO pvo) {
		String sql = "insert into product(pseq, kind, name, price1, price2, price3, content, image) "
				+ "values(product_seq.nextVal,?,?,?,?,?,?,?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getName());
			pstmt.setInt(3, pvo.getPrice1());
			pstmt.setInt(4, pvo.getPrice2());
			pstmt.setInt(5, pvo.getPrice3());
			pstmt.setString(6, pvo.getContent());
			pstmt.setString(7, pvo.getImage());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
	}

	public void updateProduct(ProductVO pvo) {
		String sql = "update product set kind=?, name=?, price1=?, price2=?, price3=?, "
				+ "content=?, image=?, bestyn=?, useyn=? where pseq=?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getName());
			pstmt.setInt(3, pvo.getPrice1());
			pstmt.setInt(4, pvo.getPrice2());
			pstmt.setInt(5, pvo.getPrice3());
			pstmt.setString(6, pvo.getContent());
			pstmt.setString(7, pvo.getImage());
			pstmt.setString(8, pvo.getBestyn());
			pstmt.setString(9, pvo.getUseyn());
			pstmt.setInt(10, pvo.getPseq());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
	}

	public ArrayList<OrderVO> listOrder(Paging paging, String key) {
		ArrayList<OrderVO> list = new ArrayList<>();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, p.* from "
				+ "((select * from order_view where mname like '%'||?||'%'"
				+ " order by result, odseq desc) p)"
				+ ") where rn >= ?) where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO avo = new OrderVO();
				avo.setAddress(rs.getString("address"));
				avo.setId(rs.getString("id"));
				avo.setIndate(rs.getTimestamp("indate"));
				avo.setMname(rs.getString("mname"));
				avo.setOdseq(rs.getInt("odseq"));
				avo.setOseq(rs.getInt("oseq"));
				avo.setPhone(rs.getString("phone"));
				avo.setPname(rs.getString("pname"));
				avo.setPrice2(rs.getInt("price2"));
				avo.setPseq(rs.getInt("pseq"));
				avo.setQuantity(rs.getInt("quantity"));
				avo.setResult(rs.getString("result"));
				avo.setZip_num(rs.getString("zip_num"));
				list.add(avo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return list;
	}

	public void updateOrderResult(String odseq) {
		String sql = "Update order_detail set result='2' where odseq=?";
		con = Dbman.getConnection();
		try {
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setInt(1,  Integer.parseInt(odseq));
			  pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
	    } finally { Dbman.close(con, pstmt, rs); }
	}

	public ArrayList<MemberVO> listMember(Paging paging, String key) {
		ArrayList<MemberVO> list = new ArrayList<>();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, p.* from "
				+ "((select * from member where name like '%'||?||'%'order by indate desc) p)"
				+ ") where rn >= ?) where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO mvo = new MemberVO();
				mvo.setAddress(rs.getString("address"));
				mvo.setEmail(rs.getString("email"));
				mvo.setId(rs.getString("id"));
				mvo.setIndate(rs.getTimestamp("indate"));
				mvo.setName(rs.getString("name"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setUseyn(rs.getString("useyn"));
				mvo.setZip_num(rs.getString("zip_num"));
				list.add(mvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		return list;
	}
}