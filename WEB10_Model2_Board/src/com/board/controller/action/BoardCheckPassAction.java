package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pass = request.getParameter("pass");
		int num = Integer.parseInt(request.getParameter("num"));
		String url = null;
		
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = bdao.getBoard(num);
		
		//비밀번호가 다르거나 오류이면 비밀번호 입력페이지로 복귀
		//맞으면 checkSuccess.jsp로 이동 
		
		if(bdto==null) {
			request.setAttribute("message", "존재하지 않는 게시물입니다.");
			url = "main.jsp";
		} else if(bdto.getPass()==null) {
			request.setAttribute("message", "비밀번호 오류. 관리자에게 문의하세요.");
			url = "board/boardCheckPass.jsp";
		} else if(!bdto.getPass().equals(pass)) {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			url = "board/boardCheckPass.jsp";
		} else if(bdto.getPass().equals(pass)) {
			url = "board/checkSuccess.jsp";
		} else {
			request.setAttribute("message", "오류가 발생했습니다. 관리자에게 문의하세요");
			url = "board/boardCheckPass.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
