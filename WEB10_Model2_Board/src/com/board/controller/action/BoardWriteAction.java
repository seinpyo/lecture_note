package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("images");
		MultipartRequest multi = new MultipartRequest(request, path, 
				5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		BoardDto bdto = new BoardDto();
		
		bdto.setUserid(multi.getParameter("userid"));
		bdto.setPass(multi.getParameter("pass"));
		bdto.setEmail(multi.getParameter("email"));
		bdto.setTitle(multi.getParameter("title"));
		bdto.setContent(multi.getParameter("content"));
		bdto.setImgfilename(multi.getFilesystemName("imgfilename"));

		BoardDao bdao = BoardDao.getInstance();
		bdao.insertBoard(bdto);
		
		response.sendRedirect("board.do?command=main");
//		RequestDispatcher dp = request.getRequestDispatcher("board.do?command=main");
//		dp.forward(request, response);
	}
}
