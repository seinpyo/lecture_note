package com.ezen.useServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Join_servlet
 */
@WebServlet("/Join_servlet")
public class Join_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String gender = request.getParameter("gender");
		String[] item = request.getParameterValues("item");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String chk_mail = request.getParameter("chk_mail");
		String job = request.getParameter("job");
		String[] interest = request.getParameterValues("interest");
		
		
		//아이디 비밀번호 
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		
		//성별
		if(gender.equals("1")) request.setAttribute("gender", "남성");
		else  request.setAttribute("gender", "여성");
		
		//메일수신
		
		if(gender.equals("0")) request.setAttribute("chk_mail", "거부");
		else  request.setAttribute("chk_mail", "수신");
		
		//item 
		String[] sItem = new String[item.length];
		for(int i=0; i<item.length; i++) {
			switch(item[i]) {
			case "1": sItem[i] = "신발"; break;
			case "2": sItem[i] = "가방"; break;
			case "3": sItem[i] = "벨트"; break;
			case "4": sItem[i] = "모자"; break;
			case "5": sItem[i] = "시계"; break;
			case "6": sItem[i] = "쥬얼리"; break;
			}
		}	//전달될 파라미터 value값들에 따른 상품명을 별도의 배열에 저장
		//작성된 배열을 request에 items라는 이름으로 저장
		request.setAttribute("items", sItem);
		
		//직업
		request.setAttribute("job", job);
		
		//관심분야
		String[] inter = new String[interest.length];
		for(int i=0; i<interest.length; i++) {
			switch(interest[i]) {
			case "1" : inter[i] = "에스프레소"; break;
			case "2" : inter[i] = "로스팅"; break;
			case "3" : inter[i] = "생두"; break;
			case "4" : inter[i] = "원두"; break;
			case "5" : inter[i] = "핸드드립"; break;
			}
		}
		request.setAttribute("interest", inter);
		
		
		RequestDispatcher dp = request.getRequestDispatcher("02/112_JSP_Servlet_Ex02.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
