package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = new BoardDto();	
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("images");
		
		MultipartRequest multi = new MultipartRequest(request, path, 5*1024*1024,
				"UTF-8", new DefaultFileRenamePolicy());
		
		bdto.setUserid(multi.getParameter("userid"));
		bdto.setPass(multi.getParameter("pass"));
		bdto.setEmail(multi.getParameter("email"));
		bdto.setTitle(multi.getParameter("title"));
		bdto.setContent(multi.getParameter("content"));
		bdto.setNum(num);
		
		String filename = multi.getFilesystemName("imgfilename");
		if(filename == null) filename=multi.getParameter("oldfilename");
		
		bdto.setImgfilename(filename);
		
		bdao.updateBoard(bdto);
		String url = "board.do?command=boardViewWithoutCount&num="+num;
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}
}
