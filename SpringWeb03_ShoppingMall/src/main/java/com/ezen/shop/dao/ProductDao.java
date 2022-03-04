package com.ezen.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.shop.dto.ProductVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class ProductDao {
	
	private JdbcTemplate template; //com, pstmt,rs가 존재하는 객체
	
	public ProductDao(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
		//데이터베이스에서 데이터의 CRUD를 담당할 객체 선언+초기화
	}
	
	public List<ProductVO> getNewList() {
		String sql = "select * from new_pro_view";
		//템플릿을 이용한 테이블 조회 
		//new RowMapper<ProductVO>(){} : 익명 클래스 호출
		List<ProductVO> list = template.query(sql, new RowMapper<ProductVO>(){
			@Override
			public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setImage(rs.getString("image"));
				return pvo;
			}
		});
		
		
		
		return null;
	}

	public List<ProductVO> getBestList() {
		return null;
	}

}
