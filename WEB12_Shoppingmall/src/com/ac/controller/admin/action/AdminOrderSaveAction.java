package com.ac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.controller.action.Action;
import com.ac.dao.AdminDao;
import com.ac.dto.AdminVO;
import com.ac.dto.OrderVO;

public class AdminOrderSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "shop.do?command=adminOrderList";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "shop.do?command=admin"; 
		} else {
			String[] resultArr = request.getParameterValues("result");
			AdminDao adao = AdminDao.getInstance();
			for(String odseq : resultArr) {
				adao.updateOrderResult(odseq);
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
