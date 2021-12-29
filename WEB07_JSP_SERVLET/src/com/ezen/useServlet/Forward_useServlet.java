package com.ezen.useServlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forward_useServlet
 */
@WebServlet("/Forward_useServlet")
public class Forward_useServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forward_useServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//form에서 get방식으로 이동되었을 때 실행할 명령을 작성
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,response);
		//form에서 post방식으로 이동되었을 때 실행할 명령을 작성
		
		//전달된 파라미터 혹은 내보낼 데이터에 한글이 있다면 인코딩방식 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//전달된 파라미터 변수에 저장
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id.equals("hong")&&pwd.equals("1234")) {
			request.setAttribute("name", "홍길동");
			RequestDispatcher dp = request.getRequestDispatcher("02/102_Forward_UserSerblet_ok.jsp");
			dp.forward(request, response);
		} else {
			response.sendRedirect("02/101_Forward_UseServlet.jsp");
		}
	}
}
