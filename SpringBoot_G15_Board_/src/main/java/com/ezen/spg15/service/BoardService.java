package com.ezen.spg15.service;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

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
		List<BoardVO> list =   bdao.selectBoardAll(paging);
		for(BoardVO bvo : list ) {
			int count = bdao.getCount(bvo.getNum());
			bvo.setReplycnt(count);
		}
		return list;
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

	public void deleteReply(int num) {
		bdao.deleteReply(num);
	}

	public BoardVO getBoard(int num) {
		return bdao.getBoard(num);
	}

	public void updateBoard( BoardVO boardvo) {
		bdao.updateBoard(boardvo);
	}

	public void removeBoard(int num) {
		//덧글 삭제
		bdao.deleteReplyBoard(num);
		//게시글 삭제
		bdao.deleteBoard(num);
	}
 
}
