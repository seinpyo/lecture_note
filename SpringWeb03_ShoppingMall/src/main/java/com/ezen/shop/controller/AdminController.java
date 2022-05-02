package com.ezen.shop.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.shop.dto.OrderVO;
import com.ezen.shop.dto.Paging;
import com.ezen.shop.dto.ProductVO;
import com.ezen.shop.service.AdminService;
import com.ezen.shop.service.ProductService;
import com.ezen.shop.service.QnaService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class AdminController {
	@Autowired
	AdminService as;
	
	@Autowired
	ProductService ps;
	
	@Autowired
	QnaService qs; 
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/admin")
	public String admi() {
		return "admin/adminLoginForm";
	}
	
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(HttpServletRequest request, @RequestParam("workId") String workId,
			@RequestParam("workPwd") String workPwd) {
		
		ModelAndView mav = new ModelAndView();
		
		int result = as.workerCheck(workId, workPwd);
		//-1:id 없음, 0:비번오류, 1:정상로그인
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("WorkId", workId);
			mav.setViewName("redirect:/productList");
		} else if(result == 0) {
			mav.addObject("message", "비밀번호를 확인하세요");
			mav.setViewName("admin/adminLoginForm");
		} else if (result == -1) {
			mav.addObject("message", "존재하지 않는 회원 아이디입니다.");
			mav.setViewName("admin/adminLoginForm");
		} else { 
			mav.addObject("message", "알 수 없는 오류. 관리자에게 문의하세요");
			mav.setViewName("admin/adminLoginForm");
		}
		return mav;
	} 
	
	@RequestMapping("/productList")
	public ModelAndView product_list(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("WorkId");
		
		if(id==null) mav.setViewName("redirect:/admin");
		else {
			if(request.getParameter("first") != null)  {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			
			int page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if(session.getAttribute("page") != null) {
				page = (Integer)session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
			
			String key = "";
			if(request.getParameter("key") != null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if (session.getAttribute("key") != null) {
				key = (String)session.getAttribute("key");
			} else {
				session.removeAttribute("key");
			}
			
			HashMap<String, Object> resultMap = as.productList(page, key);
			
			List<ProductVO> list = (List<ProductVO>) resultMap.get("productList");
			Paging paging = (Paging) resultMap.get("paging");
			
			mav.addObject("paging", paging);
			mav.addObject("productList", list);
			mav.addObject("key", key);
			mav.setViewName("admin/product/productList");
		}
		return mav;
	}
	
	//상품 등록
	
	@RequestMapping("/productWriteForm")
	public ModelAndView product_write_form(HttpServletRequest request) {
		String kindList[] = {"Heels", "Boots","Sandals","Sneakers","Sliper","Sale"};
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("kindList", kindList);
		mav.setViewName("admin/product/productWriteForm");
		return mav;
	}
	
	@RequestMapping(value="/productWrite", method=RequestMethod.POST)
	public String product_wirte(HttpServletRequest request) {
		
		String savePath = context.getRealPath("resources/product_images");
		//context는 @Autowired 됨
		
		ProductVO pvo = new ProductVO();
		try {
			MultipartRequest multi = 
					new MultipartRequest(request, savePath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			pvo.setName(multi.getParameter("name"));
			pvo.setKind(multi.getParameter("kind"));
			pvo.setPrice1(Integer.parseInt(multi.getParameter("price1")));
			pvo.setPrice2(Integer.parseInt(multi.getParameter("price2")));
			pvo.setPrice3(Integer.parseInt(multi.getParameter("price2"))
					- Integer.parseInt(multi.getParameter("price2")));
			pvo.setContent(multi.getParameter("content"));
			pvo.setImage(multi.getFilesystemName("image"));
			
			as.insertProduct(pvo);
			
		} catch (IOException e) { e.printStackTrace();
		}
		return "redirect:/productList";
	}
	
	@RequestMapping("/adminProductDetail")
	public ModelAndView product_detail(HttpServletRequest request, @RequestParam("pseq") int pseq) {
		ModelAndView mav = new ModelAndView();
		ProductVO pvo = ps.getProduct(pseq);
		String kindList[] = {"0", "Heels", "Boots","Sandals","Sneakers","Sliper","Sale"};
		int index = Integer.parseInt(pvo.getKind());
		
		mav.addObject("productVO", pvo);
		mav.addObject("kind", kindList[index]);
		mav.setViewName("admin/product/productDetail");
		
		return mav;
	}
	
	@RequestMapping("/productUpdateForm")
	public ModelAndView product_update_form(HttpServletRequest request, @RequestParam("pseq") int pseq) {
		ModelAndView mav = new ModelAndView();
		ProductVO pvo = ps.getProduct(pseq);
		mav.addObject("productVO", pvo);
		String kindList[] = {"Heels", "Boots","Sandals","Sneakers","Sliper","Sale"};
		mav.addObject("kindList", kindList);
		mav.setViewName("admin/product/productUpdate");
		return mav;
	}
	
	@RequestMapping(value="/productUpdate", method=RequestMethod.POST)
	public String product_update(HttpServletRequest request) {
		
		ProductVO pvo = new ProductVO();
		int pseq = 0;
		
		String savePath = context.getRealPath("resources/product_images");
		try {
			MultipartRequest multi = 
					new MultipartRequest(request, savePath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			pvo.setPseq(Integer.parseInt(multi.getParameter("pseq")));
			pseq = Integer.parseInt(multi.getParameter("pseq"));
			pvo.setName(multi.getParameter("name"));
			pvo.setKind(multi.getParameter("kind"));
			pvo.setPrice1(Integer.parseInt(multi.getParameter("price1")));
			pvo.setPrice2(Integer.parseInt(multi.getParameter("price2")));
			pvo.setPrice3(Integer.parseInt(multi.getParameter("price2"))
					- Integer.parseInt(multi.getParameter("price2")));
			pvo.setContent(multi.getParameter("content"));
			pvo.setUseyn(multi.getParameter("useyn"));
			pvo.setBestyn(multi.getParameter("bestyn"));
			if(multi.getFilesystemName("image")==null) pvo.setImage(multi.getParameter("oldfilename"));
			else pvo.setImage(multi.getFilesystemName("image"));
		} catch (IOException e) { e.printStackTrace();
		}
		as.updateProduct(pvo);
		
		return "redirect:/adminProductDetail?pseq=" + pseq;
	}
	
	@RequestMapping("/adminOrderList")
	public ModelAndView adminOrderList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("WorkId");
		if(id==null) mav.setViewName("redirect:/admin");
		else {
			if(request.getParameter("first") != null)  {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			
			int page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if(session.getAttribute("page") != null) {
				page = (Integer)session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
			
			String key = "";
			if(request.getParameter("key") != null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if (session.getAttribute("key") != null) {
				key = (String)session.getAttribute("key");
			} else {
				session.removeAttribute("key");
			}
			
			HashMap<String, Object> resultMap = as.orderList(page, key);
			
			List<OrderVO> list = (List<OrderVO>) resultMap.get("orderList");
			Paging paging = (Paging) resultMap.get("paging");
			
			mav.addObject("paging", paging);
			mav.addObject("orderList", list);
			mav.addObject("key", key);
			mav.setViewName("admin/order/orderList");
		}
		return mav;
	}
}
