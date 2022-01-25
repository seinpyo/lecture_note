package com.ac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.controller.action.Action;
import com.ac.dao.ProductDao;
import com.ac.dto.AdminVO;
import com.ac.dto.ProductVO;

public class AdminProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String url = "admin/product/productDetail.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO) session.getAttribute("loginAdmin");
		if(avo==null) url = "shop.do?command=admin";
		else {
			String pseq = request.getParameter("pseq");
			ProductDao pdao = ProductDao.getInstance();
			ProductVO pvo = pdao.getProduct(Integer.parseInt(pseq));
			
			String kindList[] = {"0","Heels","Boots","Sandals","Sneakers","On Sale"};
			int index = Integer.parseInt(pvo.getKind());
			
			request.setAttribute("kind", kindList[index]);
			request.setAttribute("productVO", pvo);
		}
		request.getRequestDispatcher(url).forward(request,response);
	}
}
