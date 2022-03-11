package com.ezen.spg05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LombokController {
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "testForm";
	}
	
	
	@RequestMapping("/test1")
	public String test1(Member member, Model model) {
		//@ModelAttribute을 사용하지 않으면 모델에 저장되는 이름은 member로 유지된다.
		//객체의 이름 = 클래스를 소문자로 정확히 작성할것
		// member(o) mem(x) mbr(x) Member(x)
		
	  System.out.println(member.getId() + " " + member.getName());
	  return "test1";
	}
	
}
