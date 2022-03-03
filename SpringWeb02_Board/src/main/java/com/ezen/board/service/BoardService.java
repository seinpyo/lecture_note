package com.ezen.board.service;

import java.util.ArrayList;

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

	public BoardDto boardView(int num) {
		//게시물 조회
		BoardDto bdto = bdao.getBoard(num);
		
		//조회수 +1
		bdao.plusReadCount(num);

		return bdto;
	}
	
	public ArrayList<ReplyVO> getReplysOne(int num) {
		ArrayList<ReplyVO> list = bdao.getReply(num);
		return list;
	}
}
