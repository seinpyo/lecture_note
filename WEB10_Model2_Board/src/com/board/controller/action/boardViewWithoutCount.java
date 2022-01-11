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

public class boardViewWithoutCount implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		
		BoardDto bdto = bdao.getBoard(num);
		request.setAttribute("board", bdto);
		
		ArrayList<ReplyDto> list = bdao.selectReply(num);
		request.setAttribute("replyList", list);
		
		RequestDispatcher dp = request.getRequestDispatcher("board/boardview.jsp");
		dp.forward(request, response);

	}

}
