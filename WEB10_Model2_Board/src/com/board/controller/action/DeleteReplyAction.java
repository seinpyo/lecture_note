package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;

public class DeleteReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.deleteReply(num);
		
		//전달받은 boardnum번의 게시물로 돌아감
		String url = "board.do?command=boardViewWithoutCount&num="+boardnum;
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
