package com.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.board.dto.ReplyDto;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		
		//조회수 1 올리기, 한사람이 같은 게시물을 계속 클릭 할 때 조회수가 올라가는 것을 
		//방지하고 싶다면 쿠키를 이용하는 방법도 있다. 
		bdao.viewCount(num);
		
		//게시물을 읽어와서 request에 담고 글 내용을 표시할 jsp로 이동 
		BoardDto bdto = bdao.getBoard(num);
		request.setAttribute("board", bdto);
		
		//덧글도 함께 가져감, 여러개의 덧글이 함께 가기 위해 list
		ArrayList<ReplyDto> list = bdao.selectReply(num);
		request.setAttribute("replyList", list);
		
		RequestDispatcher dp = request.getRequestDispatcher("board/boardview.jsp");
		dp.forward(request, response);
	}
}
