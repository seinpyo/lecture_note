package com.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MemberDao;
import com.dto.MemberDto;

/**
 * Servlet implementation class idCheckServlet
 */
@WebServlet("/idcheck.do")
public class idCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public idCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		MemberDao mdao = MemberDao.getInstance();
		
		MemberDto mdto = mdao.getMember(userid);
		if(mdto == null) request.setAttribute("result", -1);
		else  request.setAttribute("result", 1);
		request.setAttribute("userid", userid);
		 
		RequestDispatcher dp = request.getRequestDispatcher("member/idcheck.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
