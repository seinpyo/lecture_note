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
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dp = request.getRequestDispatcher("member/joinForm.jsp");
		dp.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberDto mdto = new MemberDto();
		MemberDao mdao = MemberDao.getInstance();
		
		//방법1
		String name = request.getParameter("name");
		mdto.setName(name); //한번만 사용하자고 변수를 만들기 번거로움
		
		//방법2
		mdto.setUserid(request.getParameter("userid"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")) );
		
		int result = mdao.insertMember(mdto);
		if(result==1)request.setAttribute("message", "회원가입 완료!! 로그인하세요!!");
		else request.setAttribute("message", "회원가입 실패!! 관리자에게 문의하세요!!");
		
		RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
		dp.forward(request, response);
		
		
	}
}