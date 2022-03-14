package com.ezen.spg10.dao;

import java.util.List;

import com.ezen.spg10.BbsDto;

public interface IBbsDao {
	public List<BbsDto> list();	//게시물 전체 조회
	public int write(BbsDto bdto); //쓰기
	public int update(BbsDto bdto); //수정
	public int delete(int id); //삭제
	public BbsDto view(int id); //게시물 하나 보기
}
