package com.upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet({ "/UploadServlet", "/upload.do" })
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//1) 파일이 업로드 될 타겟 폴더 이름 저장 
		String savePath = "upload";
		
		//2) 업로드될 파일의 용량을 제한 지정
		int uploadFileSizeLimit=5*1024*1024; //5Mb
		
		//3) 인코딩 방식 저장
		String encType="UTF-8";
		
		//4) 업로드 될 서버의 실제 저장 장소
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		System.out.println(uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
				uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		System.out.println("multi로 처리 : " + multi.getParameter("name"));
		
		String name = multi.getParameter("name");
		String title = multi.getParameter("title");
		String fileName = multi.getFilesystemName("uploadFile");
		
		request.setAttribute("name", name);
		request.setAttribute("title", title);
		request.setAttribute("fileName", fileName);
		
		RequestDispatcher dp = request.getRequestDispatcher("01_result.jsp");
		dp.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
