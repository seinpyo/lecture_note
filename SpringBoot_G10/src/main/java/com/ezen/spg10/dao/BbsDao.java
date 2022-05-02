package com.ezen.spg10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.spg10.BbsDto;

@Repository
public class BbsDao implements IBbsDao{
	
	@Autowired
	private JdbcTemplate template;
	
	//전체 조회
	@Override
	public List<BbsDto> list() {
		String sql = "select * from bbs";
		List<BbsDto> list = template.query(sql, new BeanPropertyRowMapper<BbsDto>(BbsDto.class));
		return list;
	}

	//작성
	@Override
	public int write(BbsDto bdto) {
		String sql = "insert into bbs values(bbs_seq.nextVal, ?,?,?)";
		int result = template.update(sql, bdto.getWriter(), bdto.getTitle(), bdto.getContent());
		return result;
	}

	//수정
	@Override
	public int update(BbsDto bdto) {
		return 0;
	}

	//삭제
	@Override
	public int delete(int id) {
		String sql = "delete from bbs where id = ?";
		return template.update(sql, id);
	}

	//상세보기
	@Override
	public BbsDto view(int id) {
		String sql = "select * from bbs where id=?";
		BbsDto dto = template.queryForObject(sql, new BeanPropertyRowMapper<BbsDto>(BbsDto.class), id);
		return dto;
	}
}
