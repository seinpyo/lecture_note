package com.ezen.spm17.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spm17.dto.Paging;
import com.ezen.spm17.service.AdminService;
import com.ezen.spm17.service.ProductService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class AdminController {

	@Autowired
	AdminService as;
	
	@Autowired
	ProductService ps;
	
	@Autowired
	ServletContext context;
	
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/adminLoginForm";
	}

	//로그인
	@RequestMapping("/adminLogin")
	public String adminLogin(HttpServletRequest request, @RequestParam("workId") String workId,
			@RequestParam("workPwd") String workPwd,  Model model) {
		
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("workId", workId);
		paramMap.put("ref_cursor", null);
		as.getAdmin(paramMap);
		
		ArrayList< HashMap<String,Object> > list =
				(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		if(list.size() == 0) {
			model.addAttribute("message", "no id");
			return "admin/adminLoginForm";
		} 
		
		HashMap<String,Object> resultMap = list.get(0);
		if(resultMap.get("PWD") == null) {
			model.addAttribute("message", "관리자에게 문의하세요 ");
			return "admin/adminLoginForm";
		} else if(workPwd.equals((String)resultMap.get("PWD"))) {
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", resultMap);
			return "redirect:/productList";
		} else {
			model.addAttribute("message", "wrong password");
			return "admin/adminLoginForm";
		}
	}
	
	
	//상품 리스트
	@RequestMapping("/productList")
	public ModelAndView product_list(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginAdmin") == null) {
			mav.setViewName("admin/adminLoginForm");
		} else {
			int page = 1;
			String key = "";
			if(request.getParameter("first") != null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			} 
			
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if(session.getAttribute("page") != null) {
				page = (int) session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
			
			if(request.getParameter("key") != null) {
				page = Integer.parseInt(request.getParameter("key"));
				session.setAttribute("key", key);
			} else if(session.getAttribute("key") != null) {
				page = (int) session.getAttribute("key");
			} else {
				session.removeAttribute("key");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("cnt", 0);
			paramMap.put("key", key);
			as.getAllCountProduct(paramMap);
			int cnt = Integer.parseInt(paramMap.get("cnt").toString());
			paging.setTotalCount(cnt);
			paging.paging();
			
			
			paramMap.put("startNum",paging.getStartNum());
			paramMap.put("endNum",paging.getEndNum());
			paramMap.put("key", key);
			paramMap.put("ref_cursor", null);
			as.getProductList(paramMap);
			
			ArrayList <HashMap<String,Object>> list = 
					(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			mav.addObject("productList",list);
			mav.addObject("paging",paging);
			mav.addObject("key", key);
			mav.setViewName("admin/product/productList");
		}
		return mav;
	}
	
	
	//상품 등록 
	@RequestMapping("/productWriteForm")
	public String product_write_form(HttpServletRequest request, Model model) {
		String kindList[] =  {"Heels", "Boots","Sandals","Sneakers","Sliper","Sale"};
		return "admin/product/productWriteForm";
		
	}
	
	
	@RequestMapping("/fileup")
	@ResponseBody
	public Map<String, Object> fileup(Model model, HttpServletRequest request) {
		
		String savePath = context.getRealPath("/product_images");
		HashMap<String,Object> resultMap = new HashMap<>();
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, savePath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
			);
			resultMap.put("STATUS", 1);
			resultMap.put("FILENAME", multi.getFilesystemName("fileimage"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}
	
	
}
