package com.ac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.controller.action.Action;
import com.ac.dto.AdminVO;

public class AdminProductwriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="admin/product/productWrite.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO) session.getAttribute("loginAdmin");
		
		if(avo==null) url = "shop.do?command=admin";
		else {
			String[] kindList = {"Heels","Boots","Sandals","Sneakers","Slipers","On sale"};
			request.setAttribute("kindList", kindList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
