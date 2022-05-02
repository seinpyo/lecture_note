package com.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemberDao;
import com.dto.MemberDto;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/UpdateForm.jsp";
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser")==null)
			url = "member/loginForm.jsp";
		
		/*
		//수정할 회원을 조회해서 dto에서 리턴받고 이를 request에 저장하여 이동함
		//이자료는 수정할 입력란에 최초value 값으로 사용됨
		
		String userid = request.getParameter("userid");
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		request.setAttribute("updateMember", mdto);
		
		해당코드 사용해도 상관은, 없으나 session에서 
		loginUser라는 이름으로 저장하고 있으므로 굳이 사용할 필요가 없음*/
		
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberDto mdto = new MemberDto();
		mdto.setName( request.getParameter("name"));
		mdto.setUserid(request.getParameter("userid"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.updateMember(mdto);
		
		if(result==1) { 
			request.setAttribute("message", "회원 정보를 수정했습니다");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto); //세션 로그인 정보 교체
		}else {
			request.setAttribute("message", "회원 정보 수정 오류. 관리자에게 문의하세요");
		}
		RequestDispatcher dp = request.getRequestDispatcher("main.do");
		dp.forward(request, response);
	}
}