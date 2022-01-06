package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MemberDao;
import com.dto.MemberDto;

public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);

		if(mdto == null) request.setAttribute("result", -1); //사용가능
		else request.setAttribute("result", 1); //사용불가능
		
		request.setAttribute("userid", userid);
		
		RequestDispatcher dp = request.getRequestDispatcher("member/idcheck.jsp");
		dp.forward(request, response);
	}
}
