package com.ezen.spg02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class SpringBootController {

	@RequestMapping("") 
	public @ResponseBody String root() {
		//함수 이름에 @ResponseBody가 있으면 리턴되는 문자열이 웹브라우저에 직접 작성됨 
		return "JSP in Gradle!";
	}
	
	@RequestMapping("/test1") 
	public String test1() {
		return "main";
	}
	
	@RequestMapping("/test2") 
	public String test2() {
		return "sub/sub";
	}

}

