package com.ezen.spg03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {

	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Model  & View";
	}
	
	@RequestMapping("/test1")
	public String test1(Model model, HttpServletRequest request) {
		model.addAttribute("name1", "홍길동");
		request.setAttribute("name2", "김하나");
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2(Model model, HttpServletRequest request) {
		model.addAttribute("name1", "홍길동");
		request.setAttribute("name2", "김하나");
		request.setAttribute("model", model);
		return "redirect:/test3";
	}

	@RequestMapping("/test3")
	public String test3(Model model, HttpServletRequest request) {
		model = (Model) request.getAttribute("model");
		String name2 = (String) request.getAttribute("model");
		request.setAttribute("name2",name2);
		return "test2";
	}
	
	@RequestMapping("/mv")
	public ModelAndView test2() {
		ModelAndView mv = new ModelAndView();
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		mv.addObject("lists", list);
		mv.addObject("ObjectTest", "테스트입니다.");
		mv.addObject("name", "홍길동");
		mv.setViewName("view/myView");
		return mv;
	}
}
