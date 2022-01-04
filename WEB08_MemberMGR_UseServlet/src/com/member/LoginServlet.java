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
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/loginForm.jsp";
		
		//세션 가지고 오기
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null ) {
			//loginUser(doPost()에서 생성됨) -> 로그인한 사람이 없으면 null;
			url = "main.do"; // 이 경로에 들어온 사람이 이미 로그인 되어 있다면 포워딩 		
		}	
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전달된 아이디 비밀번호를 변수에 저장
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		//전달된 id로 member테이블에서 회원을 검색 -> pwd 비교
		
		//로그인 실패시 포워딩할 경로를 지정하고 정상 로그인 시 url값을 변경 시킨다
		String url = "member/loginForm.jsp";
		
		//Dao의 매서드를 호출하기 위해 객체 생성
		MemberDao mdao = MemberDao.getInstacne();
		
		//해당 id의 정보를 모두 가져와 dto에 저장하는 메서드
		MemberDto mdto = mdao.getMember(id); 
		
		
		if(mdto==null) {  //아이디가 존재하지 않을 때 
			request.setAttribute("message", "존재하지 않는 회원 아이디입니다.");
		} else if (mdto.getPwd()==null) { //오류로 회원정보에 비밀번호가 저장되지 않은 경우
			request.setAttribute("message", "비밀번호 오류. 관리자에게 문의하세요.");
		} else if (!mdto.getPwd().equals(pwd)) { //비밀번호가 일치하지 않을 때 
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
		} else if (mdto.getPwd().equals(pwd)) { //로그인 성공
			url = "main.do";
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto); //세션에 로그인한 사용자를 저장
		} else { //모종의 이유로 로그인이 실패한 경우
			request.setAttribute("message", "로그인 오류. 관리자에게 문의하세요.");
		}
	 	
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);

	}
}
