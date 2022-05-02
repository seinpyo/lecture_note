package com.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.board.util.Paging;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao bdao = BoardDao.getInstance();
		
		
		Paging paging = new Paging();
		int page = 1;
		//2페이지 클릭 시 : board.do?command = main&page=2
		if(request.getParameter("page") != null) 
			page = Integer.parseInt(request.getParameter("page"));
		paging.setPage(page);
		
		int count = bdao.getAllCount();
		//setToTalCount 안에서 page()메서드를 호출하므로 
		paging.setTotalCount(count); //레코드 총 갯수 세팅, 멤버변수값계산
		
		ArrayList<BoardDto> list = bdao.selectBoard(paging);
		
		for(BoardDto bdto : list) {
			int cnt = bdao.getReplycnt(bdto.getNum());
			bdto.setReplycnt(cnt);
		}
		
		request.setAttribute("boardList", list);
		request.setAttribute("paging", paging);
		
		RequestDispatcher dp = request.getRequestDispatcher("main.jsp");
		dp.forward(request, response);
	}

}
