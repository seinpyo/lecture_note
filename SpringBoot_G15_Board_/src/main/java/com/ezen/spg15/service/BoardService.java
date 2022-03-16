package com.ezen.spg15.service;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spg15.dao.IBoardDao;
import com.ezen.spg15.dto.BoardVO;
import com.ezen.spg15.dto.Paging;

@Service
public class BoardService {

	@Autowired
	IBoardDao bdao;

	public int getAllCount() {
		return bdao.getAllCount();
	}

	public List<BoardVO> selectBoardAll(Paging paging) {
		return bdao.selectBoardAll(paging);
	}

	public void insertBoard(BoardVO boardvo) {
		bdao.insertBoard(boardvo);
	}

	public HashMap<String, Object> boardView(int num) {
		
		HashMap<String, Object> paramMap = new HashMap<>();
		
		//조회수 증가
		bdao.plusReadCount(num);
		
		//게시물 조회
		paramMap.put("board", bdao.getBoard(num));
		
		//덧글 조회
		paramMap.put("replyList", bdao.selectReply(num));
		
		
		return paramMap;
	}
			 
	public void addReply(int boardnum, String userid, String content) {
		bdao.addReply(boardnum, userid, content); 
	}
	  
	
	public HashMap<String, Object> boardViewWithoutCount(int num) {
		HashMap<String, Object> paramMap = new HashMap<>();
		  
		paramMap.put("board", bdao.getBoard(num)); paramMap.put("replyList",
		bdao.selectReply(num));
		  
		return paramMap; 
	}
 
}
