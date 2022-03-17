package com.ezen.spg15.controller;

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

import com.ezen.spg15.dto.BoardVO;
import com.ezen.spg15.dto.Paging;
import com.ezen.spg15.service.BoardService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/main") 
	public ModelAndView goMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();

		//로그인 체크		
		if(session.getAttribute("loginUser") == null) 
			mav.setViewName("member/loginForm");
		else {
			//페이지체크
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
			int count = bs.getAllCount();
			paging.setTotalCount(count);
			paging.paging(); 
			//setter에 의한 자동 실행이 불가(롬복으로 setter를 만들어서)하므로 수동으로 실행
			
			mav.addObject("boardList", bs.selectBoardAll(paging));
			mav.addObject("paging", paging);
			mav.setViewName("board/main");
		} 

		return mav;
	} 
	
//글쓰기
	
	@RequestMapping("/boardWriteForm")
	public String write_form(HttpServletRequest request) {
		String url = "board/boardWriteForm";
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) url = "member/loginform";
		
		return url;
	}
	
	//파일 업로드 창으로 이동
	@RequestMapping("/selectimg")
	public String selectimg() {
		return "board/selectimg";
	}
	
	//파일을 업로드
	@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	public String fileupload(Model model, HttpServletRequest request) {
		//static 폴더와 webapp 폴더 안에 각각 upload 폴더 생성
		//upload 하면 webapp/upload 에 들어가고 꺼내 쓸 때는 static/upload에서 꺼낸다
		//반드시 두 폴더 다 생성할 것
		
		String path = context.getRealPath("/upload");
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			model.addAttribute("image", multi.getFilesystemName("image"));
		} catch (Exception e) { e.printStackTrace();
		}
		return "board/completeupload";
	}
	
	//Validation 후 DB에 데이터 insert 
	@RequestMapping("/boardWrite")
	public String board_write(@ModelAttribute("dto") @Valid BoardVO boardvo,
			BindingResult result, Model model, HttpServletRequest request) {
		
		String url = "board/boardWriteForm";
		
		if(result.getFieldError("pass") != null) 
			model.addAttribute("message", result.getFieldError("pass").getDefaultMessage());
		else if(result.getFieldError("title") != null) 
			model.addAttribute("message", result.getFieldError("title").getDefaultMessage());
		else if(result.getFieldError("content") != null) 
			model.addAttribute("message", result.getFieldError("content").getDefaultMessage());
		else { 
			url = "redirect:/main";
			bs.insertBoard(boardvo);
		}
	
		return url;
	}
	
	
//게시글 열람	
	@RequestMapping("/boardView")
	 public ModelAndView board_view(@RequestParam("num") int num, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		//덧글과 게시글 내용을 한번에 가져오기 위해 Hashmap 사용
		HashMap<String, Object> resultMap = bs.boardView(num);
		mav.addObject("board", resultMap.get("board"));
		mav.addObject("replyList", resultMap.get("replyList"));
		
		mav.setViewName("board/boardView");
		return mav;
	}
	
	
//댓글 작성
	@RequestMapping("/addReply")
	public String addReply(@RequestParam("boardnum") int boardnum, 
			@RequestParam("userid") String userid, @RequestParam("content") String content,
			HttpServletRequest request) {
		
		bs.addReply(boardnum, userid, content);
	
		return "redirect:/boardViewWithoutCount?num="+boardnum;
	}

	@RequestMapping("/boardViewWithoutCount")
	 public ModelAndView board_view_without_count(
			 @RequestParam("num") int num, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		//덧글과 게시글 내용을 한번에 가져오기 위해 Hashmap 사용
		HashMap<String, Object> resultMap = bs.boardViewWithoutCount(num);
		mav.addObject("board", resultMap.get("board"));
		mav.addObject("replyList", resultMap.get("replyList"));
		
		mav.setViewName("board/boardView");
		return mav;
	}
	
//댓글 삭제
	@RequestMapping("/deleteReply")
	public String reply_delete(@RequestParam("num") int num, 
			@RequestParam("boardnum") int boardnum,
			HttpServletRequest reqeust) {
		bs.deleteReply(num);
		return "redirect:/boardViewWithoutCount?num="+boardnum;
	}
	
	
//게시물 수정
	@RequestMapping("/boardEditForm")
	public String board_edit_form(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		model.addAttribute("num", num);
		return "board/boardCheckPassForm";
	}
	
	@RequestMapping("/boardEdit")
	public String board_edit(Model model, @RequestParam("num") int num, 
			@RequestParam("pass") String pass, HttpServletRequest request) {
		BoardVO bvo = bs.getBoard(num);
		model.addAttribute("num", num);
		if(pass.equals(bvo.getPass())) {
			return "board/boardCheckPass";
		} else {
			model.addAttribute("message", "비밀번호가 틀렸습니다.");
			return "board/boardCheckPassForm";
		}
	}
	
	@RequestMapping("/boardUpdateForm")
	public String board_update_form(@RequestParam("num") int num, Model model, 
			HttpServletRequest request) {
		BoardVO bvo = bs.getBoard(num);
		model.addAttribute("num", num);
		model.addAttribute("dto", bvo);
		return "board/boardEditForm";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(@ModelAttribute("dto") @Valid BoardVO boardvo,
			BindingResult result, @RequestParam("oldfilename") String oldfilename,
			HttpServletRequest request, Model model			) {
		
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
			bs.updateBoard(boardvo);
			url = "redirect:/boardViewWithoutCount?num=" + boardvo.getNum();
		}
		return url;
	}

//삭제
	@RequestMapping("/boardDeleteForm")
	public String board_delete_form(@RequestParam("num") int num, Model model,
			HttpServletRequest request) {
		model.addAttribute("num", num);
		return "board/boardCheckPassForm";
	}
	
	@RequestMapping("/boardDelete")
	public String board_delete(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		
		bs.removeBoard(num);
		return "redirect:/main";
	}
}
