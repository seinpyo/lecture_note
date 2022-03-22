package com.ezen.spg16.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spg16.dto.BoardVO;
import com.ezen.spg16.dto.Paging;
import com.ezen.spg16.service.BoardService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {
	@Autowired
	BoardService bs;
	
	@RequestMapping("/main")
	public ModelAndView goMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) 
			mav.setViewName("/");
		else {
			int page = 1; 
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if(session.getAttribute("page") != null) {
				page = (int) session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
		
			Paging paging = new Paging();
			paging.setPage(page);
			
			HashMap<String,Object> paramMap = new HashMap<>();
			paramMap.put("cnt", 0);
			bs.getAllCount(paramMap);
			int count = (Integer)paramMap.get("cnt");
			
			paging.setTotalCount(count);
			paging.paging(); 
			
			paramMap.put("ref_cursor", null);
			paramMap.put("startNum", paging.getStartNum());
			paramMap.put("endNum", paging.getEndNum());
			
			bs.selectBoard(paramMap);
			
			ArrayList<HashMap<String,Object>> list = 
					(ArrayList<HashMap<String,Object>>) paramMap.get("ref_cursor");
			
			mav.addObject("boardList", list);
			mav.addObject("paging", paging);
			mav.setViewName("board/main");
			
		}
		return mav;
	}
	
	@RequestMapping("/boardView")
	 public ModelAndView board_view(@RequestParam("num") int num, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("num", num);
		paramMap.put("ref_cursor1", null);
		paramMap.put("ref_cursor2", null);
		
		bs.boardView(paramMap);
		ArrayList<HashMap<String, Object>> list1 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor1");
		ArrayList<HashMap<String, Object>> list2 
		= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor2");
		
		mav.addObject("board", list1.get(0));
		mav.addObject("replyList", list2);
		mav.setViewName("board/boardView");
		
		mav.setViewName("board/boardView");
		return mav;
	}
	
	@RequestMapping("/addReply")
	public String addReply(
			@RequestParam("boardnum") int boardnum, 
			@RequestParam("userid") String userid, @RequestParam("content") String content,
			HttpServletRequest request) {
		
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("boardnum", boardnum);
		paramMap.put("content", content);
		
		bs.insertReply(paramMap);
	
		return "redirect:/boardViewWithoutCount?num="+boardnum;
	}
	
	
	@RequestMapping("/boardViewWithoutCount")
	 public ModelAndView board_view_without_count(
			 @RequestParam("num") int num, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("num", num);
		paramMap.put("ref_cursor1", null);
		paramMap.put("ref_cursor2", null);
		
		bs.boardViewWithOutCount(paramMap);
		ArrayList<HashMap<String, Object>> list1 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor1");
		ArrayList<HashMap<String, Object>> list2 
		= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor2");
		
		mav.addObject("board", list1.get(0));
		mav.addObject("replyList", list2);
		mav.setViewName("board/boardView");
		
		mav.setViewName("board/boardView");
		return mav;
	}
	
	@RequestMapping("/deleteReply")
	public String reply_delete(@RequestParam("num") int num, 
			@RequestParam("boardnum") int boardnum,
			HttpServletRequest reqeust) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("num", num);
		bs.deleteReply(paramMap);
		return "redirect:/boardViewWithoutCount?num="+boardnum;
	}
	
	@RequestMapping("/boardEditForm")
	public String board_edit_form(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		model.addAttribute("num", num);
		return "board/boardCheckPassForm";
	}
	
	@RequestMapping("/boardEdit")
	public String board_edit(Model model, @RequestParam("num") int num, 
			@RequestParam("pass") String pass, HttpServletRequest request) {
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("num", num);
		paramMap.put("ref_cursor", null);
		bs.getBoard(paramMap);
		
		ArrayList<HashMap<String, Object>> list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		HashMap<String, Object> bvo = list.get(0);
		model.addAttribute("num", num);
		
		if(pass.equals(bvo.get("PASS"))) {
			return "board/boardCheckPass";
		} else {
			model.addAttribute("message", "비밀번호가 틀렸습니다.");
			return "board/boardCheckPassForm";
		}
	}
	
	@RequestMapping("/boardUpdateForm")
	public String board_update_form(@RequestParam("num") int num, Model model, 
			HttpServletRequest request) {
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("num", num);
		paramMap.put("ref_cursor", null);
		bs.getBoard(paramMap);
		ArrayList<HashMap<String, Object>> list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		HashMap<String, Object> bvo = list.get(0);
		BoardVO dto = new BoardVO();
		dto.setNum(Integer.parseInt(String.valueOf(bvo.get("NUM"))));
		dto.setUserid((String) bvo.get("USERID"));
		dto.setPass((String) bvo.get("PASS"));
		dto.setEmail((String) bvo.get("EMAIL"));
		dto.setImgfilename((String) bvo.get("IMGFILENAME"));
		dto.setTitle((String) bvo.get("TITLE"));
		dto.setContent((String) bvo.get("CONTENT"));
		
		model.addAttribute("num", num);
		model.addAttribute("dto", dto);
		return "board/boardEditForm";
	}
	
	@RequestMapping("/selectimg")
	public String selectimg() {
		return "board/selectimg";
	}
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	public String fileupload(Model model, HttpServletRequest request) {
		
		String path = context.getRealPath("/upload");
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			model.addAttribute("image", multi.getFilesystemName("image"));
		} catch (Exception e) { e.printStackTrace();
		}
		return "board/completeupload";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(@ModelAttribute("dto") @Valid BoardVO boardvo,
			BindingResult result, @RequestParam("oldfilename") String oldfilename,
			HttpServletRequest request, Model model) {
		
		String url = "board/boardEditForm";
		
		if(result.getFieldError("pass") != null) {
			model.addAttribute("message", "비밀번호를 입력해주세요");
		} else if(result.getFieldError("title") != null) {
			model.addAttribute("message", "제목을 입력해주세요");
		} else if(result.getFieldError("content") != null) {
			model.addAttribute("message", "내용을 입력해주세요");
		} else {
			if(boardvo.getImgfilename().equals("") || boardvo.getImgfilename() == null) 
				boardvo.setImgfilename(oldfilename);
			
			
			//bs.updateBoard(boardvo);
			url = "redirect:/boardViewWithoutCount?num=" + boardvo.getNum();
		}
		return url;
	}
	
}
