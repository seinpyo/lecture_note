package com.ezen.spg06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidController {
	
	@RequestMapping("/")
	public String main() {
		return "startPage";
	}
	
	@RequestMapping("/create")
	public String create(@ModelAttribute("dto") ContentDto contentdto, Model model,
			BindingResult result) {
		//BindingResult result : 에러의 key와 value을 담을 객체
		
		ContentValidator validator = new ContentValidator();
		validator.validate(contentdto, result);
		//validate가 contentdto의 내용을 검사한 후 result에 오류 내용을 담아주고 
		//리턴되지 않아도 call by reference 이기 때문에 오류 내용(result)을 현재 위치에서도 사용 가능
	
		if(result.hasErrors()) {
			model.addAttribute("message", "모든 칸을 채워주세요");
			return "startPage";
		}
		else 
			return "DonePage";
	}
}
