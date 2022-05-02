package com.ezen.spg10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spg10.dao.BbsDao;

@Controller
public class BbsController {
	
	@Autowired
	BbsDao bdao;
	
	
//메인페이지
	@RequestMapping("/")
	public String root(Model model) {
		model.addAttribute("list", bdao.list());
		return "list";
	}
	 
//글 작성 폼으로 이동
	@RequestMapping("/writeForm")
	public String writeFrom(Model model) {
		return "writeForm";
	}
	
//insert 
	@RequestMapping("write")
	public String write(BbsDto bbsdto) {
		//매개변수명은 클래스이름을 소문자로 적는다 
		bdao.write(bbsdto);
		return "redirect:/";
	}
	
//상세보기 
	@RequestMapping("view")
	public String view(Model model, @RequestParam("id") int id) {
		model.addAttribute("dto",bdao.view(id));
		return "view";
	}
	
//삭제
	@RequestMapping("delete")
	public String delete(@RequestParam("id") int id) {
		bdao.delete(id);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
}
