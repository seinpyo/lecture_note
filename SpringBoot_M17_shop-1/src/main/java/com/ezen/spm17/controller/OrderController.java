package com.ezen.spm17.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spm17.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService os;
	
	@RequestMapping("/orderInsert")
	public String orderInsert(HttpServletRequest request) {
		
		int oseq = 0;
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		if(loginUser == null) {
			return "member/login";
		} else {
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("id", loginUser.get("USERID"));
			paramMap.put("oseq", 0);
			
			os.insertOrder(paramMap);
			//아이디로 카트검색
			//검색 내용으로 orders, order_detail 테이블에 레코드 추가
			//oseq에 주문번호를 가지고 돌아옴
			
			oseq = Integer.parseInt(paramMap.get("oseq").toString());
			System.out.println(oseq);
		}
		
		return "redirect:/orderList?oseq="+oseq;
	}
	
	@RequestMapping("/orderList")
	public ModelAndView orderList(@RequestParam("oseq") int oseq, HttpServletRequest request,
			Model model) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		if(loginUser == null) {
			mav.setViewName("member/login");
		} else {
			HashMap<String, Object> paramMap = new HashMap<String, Object> ();
			paramMap.put("oseq", oseq);
			paramMap.put("ref_cursor", null);
			
			os.listOrderByOseq(paramMap);
			ArrayList<HashMap<String, Object>> list
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			mav.addObject("orderList", list);
			
			int totalPrice = 0;
			for (HashMap<String, Object> ovo : list) {
				totalPrice += Integer.parseInt(ovo.get("QUANTITY").toString()) 
						*Integer.parseInt(ovo.get("PRICE2").toString());
			}
			mav.addObject("totalPrice", totalPrice);
			mav.setViewName("mypage/orderList");
		}
		
		return mav;
	}
	
	
	@RequestMapping("/myPage")
	public ModelAndView myPage(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		if(loginUser == null) {
			mav.setViewName("member/login");
		} else {
			ArrayList<HashMap<String, Object>> finalList 
			= new ArrayList<>(); 
			
			//1.아이디로 진행중인 주문의 주문번호를 조회 
			HashMap<String, Object> paramMap1 = new HashMap<String, Object>();
			paramMap1.put("id", loginUser.get("USERID"));
			paramMap1.put("ref_cursor", null);
			os.listOrderByIdIng(paramMap1); //현재 로그인 유저의 진행중인 모든 주문 조회
			ArrayList<HashMap<String, Object>> oseqList 
				= (ArrayList<HashMap<String, Object>>) paramMap1.get("ref_cursor");
			
			//2. 조회한 주문번호를 상세 조회
			for(HashMap<String, Object> result : oseqList) {
				int oseq = Integer.parseInt(result.get("OSEQ").toString());
				HashMap<String, Object> paramMap2 = new HashMap<String, Object>();
				paramMap2.put("oseq", oseq);
				paramMap2.put("ref_cursor", null);
				os.listOrderByOseq(paramMap2);
				ArrayList<HashMap<String, Object>> orderListByOseq
				= (ArrayList<HashMap<String, Object>>) paramMap2.get("ref_cursor");
				
				HashMap<String, Object> orderFirst = orderListByOseq.get(0);
				orderFirst.put("PNAME", (String)orderFirst.get("PNAME")+"포함"+
						orderListByOseq.size() + "건");
				
				int totalPrice = 0;
				for (HashMap<String, Object> order : orderListByOseq) {
					totalPrice += Integer.parseInt(order.get("QUANTITY").toString()) 
							* Integer.parseInt(order.get("PRICE2").toString());
				}
				
				orderFirst.put("PRICE2", totalPrice);
				//주문 번호별 대표 상품을 별도의 리스트에 모아서 model에 저장
				finalList.add(orderFirst);
			}
			
			mav.addObject("orderList", finalList);
			mav.addObject("title", "진행중인 주문내역");
			mav.setViewName("mypage/mypage");
		}
		return mav;
	}
	
	@RequestMapping("/orderAll")
	public ModelAndView orderAll(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		if(loginUser == null) {
			mav.setViewName("member/login");
		} else {
			ArrayList<HashMap<String, Object>> finalList 
			= new ArrayList<>(); 
			
			HashMap<String, Object> paramMap1 = new HashMap<String, Object>();
			paramMap1.put("id", loginUser.get("USERID"));
			paramMap1.put("ref_cursor", null);
			os.listOrderByIdAll(paramMap1); //현재 로그인 유저의 모든 주문 조회
			ArrayList<HashMap<String, Object>> oseqList 
				= (ArrayList<HashMap<String, Object>>) paramMap1.get("ref_cursor");
			
			for(HashMap<String, Object> result : oseqList) {
				int oseq = Integer.parseInt(result.get("OSEQ").toString());
				HashMap<String, Object> paramMap2 = new HashMap<String, Object>();
				paramMap2.put("oseq", oseq);
				paramMap2.put("ref_cursor", null);
				os.listOrderByOseq(paramMap2);
				ArrayList<HashMap<String, Object>> orderListByOseq
				= (ArrayList<HashMap<String, Object>>) paramMap2.get("ref_cursor");
				
				HashMap<String, Object> orderFirst = orderListByOseq.get(0);
				orderFirst.put("PNAME", (String)orderFirst.get("PNAME")+"포함"+
						orderListByOseq.size() + "건");
				
				int totalPrice = 0;
				for (HashMap<String, Object> order : orderListByOseq) {
					totalPrice += Integer.parseInt(order.get("QUANTITY").toString()) 
							* Integer.parseInt(order.get("PRICE2").toString());
				}
				
				orderFirst.put("PRICE2", totalPrice);
				finalList.add(orderFirst);
			}
			
			mav.addObject("orderList", finalList);
			mav.addObject("title", "총 주문내역");
			mav.setViewName("mypage/mypage");
		}
		return mav;
	}
	
	@RequestMapping("/orderDetail")
	public ModelAndView orderDetail(HttpServletRequest request,	Model model, @RequestParam("oseq") int oseq) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		if(loginUser == null) {
			mav.setViewName("member/login");
		} else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("oseq", oseq);
			paramMap.put("ref_cursor", null);
			os.listOrderByOseq(paramMap);
			ArrayList<HashMap<String, Object>> orderListByOseq
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			int totalPrice = 0;
			for (HashMap<String, Object> order : orderListByOseq) {
				totalPrice += Integer.parseInt(order.get("QUANTITY").toString()) 
						* Integer.parseInt(order.get("PRICE2").toString());
			}
			mav.addObject("totalPrice", totalPrice);
			mav.addObject("orderList", orderListByOseq);
			mav.addObject("orderDetail", orderListByOseq.get(0));
			mav.setViewName("mypage/orderDetail");
		}
		return mav;
	}
	
	@RequestMapping("/orderOne")
	public String orderDetail(HttpServletRequest request,	
			@RequestParam("pseq") int pseq,
			@RequestParam("quantity") int quantity) {
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		if(loginUser == null) {
			return "member/login";
		} else {
			int oseq = 0;
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", loginUser.get("USERID"));
			paramMap.put("oseq", 0);
			paramMap.put("pseq", pseq);
			paramMap.put("quantity", quantity);
			
			os.insertOrderOne(paramMap);
			oseq = Integer.parseInt(paramMap.get("oseq").toString());

			return "redirect:/orderList?oseq="+oseq;
		}
	}
}
