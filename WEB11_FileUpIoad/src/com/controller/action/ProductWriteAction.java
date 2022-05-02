package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Dto.ProductVO;
import com.controller.dao.ProductDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//서블릿이 아니라 java class에 작성하고 있으므로 
		//ServletContext context = getServletContext(); 만 해서 context를 받아올 수 없음
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		//request에서 session을 추출한 후 session.getServletContext()를 사용
		String path = context.getRealPath("upload");
		
		ProductVO pvo = new ProductVO();
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 
					5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			pvo.setName(multi.getParameter("name"));
			pvo.setPrice(Integer.parseInt(multi.getParameter("price")));
			pvo.setDescription(multi.getParameter("description"));
			pvo.setPictureurl(multi.getFilesystemName("pictureurl"));
		}catch(Exception e){
			System.out.println("파일 업로드 실패 : " + e);
		}
		ProductDao pdao = ProductDao.getInstance();
		pdao.insertProduct(pvo);
		response.sendRedirect("product.do?command=index");
	}
}
