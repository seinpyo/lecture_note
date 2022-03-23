package com.ezen.spm17.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
