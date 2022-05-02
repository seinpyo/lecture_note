package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ac.dao.MemberDao;
import com.ac.dto.MemberVO;

public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);
		
		if(mvo == null) 
			request.setAttribute("result", -1);
		else 
			request.setAttribute("result", 1);

		request.setAttribute("id", id);
		
		RequestDispatcher dp = request.getRequestDispatcher("member/idcheck.jsp");
		dp.forward(request, response);
	}

}
