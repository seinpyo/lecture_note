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
@WebServlet("/login.do")
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
		
		//서블릿에서 세션은 아래와 같이 request에서 getSession()으로 전달받아야 사용 가능함
		HttpSession session = request.getSession();
		//.jsp파일에는 이미 jequest와 response와 session, application등이
		//존재하기 때문에 session을 바로 사용하는 것이 가능하지만 서블릿은 불가
		//request와 response를 전달받아 사용하기 때문에
		//전달된 request를 통해 session을 꺼내어 사용
		
		if (session.getAttribute("loginUser") != null ) {
			//loginUser 세션값이 null이 아니라면
			url = "main.do"; //누군가 로그인되어 있는 상태라면 포워딩될 경로를 변경
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전달된 아이디 비번 변수
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		//전달된 id로 member 테이블에서 회원을 검색하여
		//결과에 따라 pwd와 비교, 정상 로그인 여부를 결정함 
		
		//로그인 실패했을 때를 대비해 포워딩할 경로를 먼저 설정함
		String url = "member/loginForm.jsp";
		//정상 로그인시에 url값이 main.jsp로 변경됨
		
		//Dao의 메소드를 호출하기 위해 겍체 생성
		MemberDao mdao = MemberDao.getInstance();
		//아이디로 검색해서 해당 아이디의 멤버정보를 모두 dto 형태로 리턴받음
		MemberDto mdto = mdao.getMember(id);
		
		if(mdto == null) {
			request.setAttribute("message", "아이디가 없어요");
		} else if(mdto.getPwd()==null) {
			request.setAttribute("message", "암호 오류. 관리자에게 문의하세요");
		} else if( !mdto.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 틀립니다");
		} else if(mdto.getPwd().equals(pwd)) {
			url="main.do";
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto); //세션에 검색된 사용자를 저장함
		} else { //어쨌든 로그인 실패
			request.setAttribute("message", "무슨 이유에선지 로그인이 안됩니다");
		}
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}
}