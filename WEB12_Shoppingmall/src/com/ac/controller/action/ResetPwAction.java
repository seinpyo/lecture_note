package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ac.dao.MemberDao;
import com.ac.dto.MemberVO;

public class ResetPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		
		MemberDao mado = MemberDao.getInstance();
		mado.resetPw(mvo);
		
		String url="member/resetPwComplete.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
