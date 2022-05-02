package com.ezen.spm17.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spm17.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@RequestMapping("/")
	public ModelAndView index( HttpServletRequest request, Model model) {
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("ref_cursor1", null);
		paramMap.put("ref_cursor2", null);
		
		ps.getBestNewProduct(paramMap);
		
		ArrayList<HashMap<String, Object>> list1
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor1");
		
		ArrayList<HashMap<String, Object>> list2 
		= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor2");
		
		mav.addObject("newProductList", list1);
		mav.addObject("bestProductList", list2);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping("/catagory")
	public ModelAndView catagore (Model model, HttpServletRequest request,
			@RequestParam("kind") String kind) {

		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("ref_cursor", null);
		paramMap.put("kind", kind);
		
		ps.getKindList(paramMap);
		
		ArrayList<HashMap<String, Object>> list
		= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		mav.addObject("productKindList", list);
		mav.setViewName("product/productKind");
		return mav;
		
	}
	
	@RequestMapping("/productDetail")
	public ModelAndView productDetail (Model model, HttpServletRequest request,
			@RequestParam("pseq") int pseq) {
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("ref_cursor", null);
		paramMap.put("pseq", pseq);
		ps.getProduct(paramMap);
		
		ArrayList<HashMap<String, Object>> list
		= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		HashMap<String, Object> resultMap = list.get(0);
		mav.addObject("productVO", resultMap);
		mav.setViewName("product/productDetail");
		return mav;
		
	}
	
	
}
