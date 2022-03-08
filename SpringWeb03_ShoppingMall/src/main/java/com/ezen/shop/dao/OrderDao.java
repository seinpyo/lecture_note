package com.ezen.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.shop.dto.CartVO;
import com.ezen.shop.dto.OrderVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class OrderDao {
	private JdbcTemplate template;
	
	@Autowired
	public OrderDao (ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	public void insertOrders(String userid) {
		String sql = "insert into orders (oseq, id) values(orders_seq.nextVal, ?)";
		template.update(sql, userid);
	}

	public int lookupMaxOseq() {
		String sql = "select max(oseq) as moseq from orders";
		List<Integer> list = template.query(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int maxoseq = rs.getInt("moseq");
				return maxoseq;
			}
		});
		return list.get(0);
	}

	public void insertOrderDetail(CartVO cvo, int oseq) {
		String sql = "insert into order_detail (odseq, oseq, pseq, quantity) "
				+ "value (order_detail_seq.nextVal, ?, ?, ?)";
		template.update(sql, oseq, cvo.getPseq(), cvo.getQuantity());
	}

	public void deleteCart(Integer cseq) {
		String sql = "delete from cart where cseq=?";
		template.update(sql, cseq);
	}

	public List<OrderVO> listOrderBtOseq(int oseq) {
		String sql = "select * from order_view where oseq = ?";
		List <OrderVO> list = template.query(sql, new RowMapper<OrderVO>() {

			@Override
			public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderVO ovo = new OrderVO();
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setId(rs.getString("userid"));
				ovo.setMname(rs.getString("mname"));
				ovo.setZipnum(rs.getString("zip_num"));
				ovo.setAddress(rs.getString("adress"));
				ovo.setPhone(rs.getString("phone"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setPname(rs.getString("pname"));
				ovo.setPrice2(rs.getInt("price2"));
				ovo.setResult(rs.getString("result"));
				
				return null;
			}
			
		});
		
		return null;
	}
	
	
}
