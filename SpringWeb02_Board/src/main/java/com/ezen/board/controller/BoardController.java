package com.ezen.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.service.BoardService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@RequestMapping("boardList")
	public String main(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null) return "Member/loginForm";
		else {
			ArrayList<BoardDto> list = bs.getBoardsMain();
			model.addAttribute("boardList", list);
			
		}
		
		return "board/main";
	}
	
	@RequestMapping("/boardWriteForm")
	public String write_form(HttpServletRequest request, Model model) {
		String url = "board/boardWriteForm";
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) url = "Member/loginForm";
		return url;
	}
	
	@Autowired 
	ServletContext context;
	
	@RequestMapping(value="boardWrite", method = RequestMethod.POST)
	public String board_write(HttpServletRequest request, Model model) {
		
		//HttpSession session = request.getSession();
		//ServletContext context = session.getServletContext();
		
		//스프링 컨테이너에 이미 ServletContext 가 존재 하기 때문에 만들지 않더라도 
		//@Autowired 해서 사용할 수 있다.
		String path = context.getRealPath("/resources/upload"); 
		try {
		MultipartRequest multi = new MultipartRequest(request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		BoardDto bdto = new BoardDto();
		bdto.setContent(multi.getParameter("content"));
		bdto.setEmail(multi.getParameter("email"));
		bdto.setImagefilename(multi.getFilesystemName("imgfilename"));
		bdto.setPass(multi.getParameter("pass"));
		bdto.setTitle(multi.getParameter("title"));
		bdto.setUserid(multi.getParameter("userid"));

		bs.insertBoard(bdto);
		
		} catch (IOException e) { e.printStackTrace();
		}
		
		return "redirect:/boardList";
	}
	
	@RequestMapping("/boardView")
	public String boardView(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
//		BoardDto bdto = bs.boardView(num);
//		model.addAttribute("board", bdto);
//		
//		ArrayList<ReplyVO> list = bs.getReplysOne(num);
//		model.addAttribute("replyList", list);
		
		HashMap<String, Object> paramMap = new HashMap<>();
	
		//1)
		paramMap.compute("bdto", null);
		paramMap.compute("replyList", null);
		paramMap.put("num", num);
		bs.boardView(paramMap);
		
		
		//2)
		paramMap = bs.boardView(num);
		
		
		
		return "board/boardView";
	}
	
}
