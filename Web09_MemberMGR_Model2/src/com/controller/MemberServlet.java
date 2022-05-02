package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.controller.action.JoinFormAction;
import com.controller.action.LoginAction;
import com.controller.action.LoginFormAction;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet({ "/MemberServlet", "/member.do" })
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//전달된 command 파라미터를 getParameter메서드로 받는다.
		String command = request.getParameter("command");
		
		Action ac = null; //com.controller.action을 import
		
		ActionFactory af = ActionFactory.getInstance();
		ac = af.getAction(command);
		
		if(ac==null) System.out.println("ac가 null입니다. command를 확인해 주세요. "
				+ "현재 commnad : " + command);
		//command 변수 오탈자로 인해 ac가 초기의 null값으로 온 경우 
		//command를 확인 할 수 있게 콘솔 작성
		else ac.execute(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
