package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.deleteBoard(num);
		
		String url = "board.do?command=main";

		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
