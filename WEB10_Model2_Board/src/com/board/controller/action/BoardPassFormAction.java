package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardPassFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardCheckPass.jsp";
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		//open_win 함수로 부터 전달 받은 num 값이 여기로 와서 
		//forward를 통해 boardCheckPass.jsp로 그대로 넘어감 -> ${param.num} 사용 가능
	}
}
