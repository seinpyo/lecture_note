package com.ezen.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.ReplyVO;

@Service
public class BoardService {

	@Autowired
	BoardDao bdao;

	public ArrayList<BoardDto> getBoardsMain() {
		ArrayList<BoardDto> list = bdao.getBoardsMain();
		return list;
	}

	public void insertBoard(BoardDto bdto) {
		bdao.insert(bdto);
	}


	//hashmap을 사용할 경우 boardView 메서드
	public HashMap<String, Object> boardView(int num) {
		HashMap<String, Object> paramMap = new HashMap<>();
		
		//조회수 +1
		bdao.plusReadCount(num);
		
		//게시물 조회 
		BoardDto bdto = bdao.getBoard(num);
		paramMap.put("bdto", bdto);
		
		//댓글 조회
		ArrayList<ReplyVO> list = bdao.getReply(num);
		paramMap.put("replyList", list);
		
		return paramMap;
	}

	public void addReply(ReplyVO rvo) {
		bdao.addReply(rvo);
	}

	public HashMap<String, Object> boardViewWithoutCount(int num) {
		HashMap<String, Object> paramMap = new HashMap<>();
		
		//게시물 조회 
		BoardDto bdto = bdao.getBoard(num);
		paramMap.put("bdto", bdto);
		
		//댓글 조회
		ArrayList<ReplyVO> list = bdao.getReply(num);
		paramMap.put("replyList", list);
		
		return paramMap;
	}
	
	
	

}
