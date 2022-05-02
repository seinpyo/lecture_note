package com.ezen.spg04;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormDataController {

	@RequestMapping("/")
	public String root() throws Exception {
		return "testForm";
	}
	
	@RequestMapping("test1") 
	public String test1(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test1";
	}
	
	@RequestMapping("test2") 
	public String test2(Model model,
			@RequestParam("id") String id, @RequestParam("name") String name) {
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test2";
	}
	
	@RequestMapping("test3") 
	public String test3(@ModelAttribute("member") Member member) { 
		//파라미터와 일치하는 멤버변수가 있는 객체를 만들고 매개변수로 사용
		//전달된 파라미터는 매개변수(객체)에 자동으로 입력됨
		//ModelAttiribute 어노테이션을 통해 Model에도 저장되게 할 수 있다. 
		
		/*
		 * model.addAttribute("id", member.getId()); model.addAttribute("name",
		 * member.getName());
		 */
		return "test3";
	}
	
	@RequestMapping("/test4/{studentId}/{name}") 
	public String test4(@PathVariable String studentId, @PathVariable String name, Model model) {
		
		model.addAttribute("id", studentId);
		model.addAttribute("name", name);
		
		return "test4";
	}
}
