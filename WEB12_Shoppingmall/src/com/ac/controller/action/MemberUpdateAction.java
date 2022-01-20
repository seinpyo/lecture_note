package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.dao.MemberDao;
import com.ac.dto.MemberVO;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO mvo = new MemberVO();
		mvo.setName(request.getParameter("name"));
		mvo.setId(request.getParameter("id"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setAddress( request.getParameter("addr1") + " " + request.getParameter("addr2"));
		
		MemberDao mdao = MemberDao.getInstance();
		mdao.updateMember(mvo);
		HttpSession session = request.getSession();
		
		String url = "shop.do?command=index";
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}
}
