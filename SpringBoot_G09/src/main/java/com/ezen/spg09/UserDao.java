package com.ezen.spg09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate template;
	//servlet-context.xml에 bean으로 넣거나 할 필요 x 
	
	public List<UserDto> list() {
		String sql = "select * from myuser";
		List<UserDto> list = template.query(sql, new BeanPropertyRowMapper<UserDto>(UserDto.class));
		//ResultSet 사용 없이 검색 결과 레코드의 필드를 Dto 변수에 넣고 list에 add 동작을 실행
		
		return list;
	}

}
