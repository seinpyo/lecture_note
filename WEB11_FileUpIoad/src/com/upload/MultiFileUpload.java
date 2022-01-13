package com.upload;

import java.io.IOException;
import java.util.Enumeration;

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
 * Servlet implementation class MultiFileUpload
 */
@WebServlet({ "/MultiFileUpload", "/upload2.do" })
public class MultiFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiFileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath("upload");
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath,
					5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			int i=1;
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String file = (String) files.nextElement(); // 파일 요소를 하나씩 추출
				String file_name = multi.getFilesystemName(file); //업로드된 파일 이름 추출
				String ori_file_name = multi.getOriginalFileName(file); 
				//DefaultFileRenamePolicy로 변경되었을 수도 있으므로 원래의 파일이름 추출
				
				request.setAttribute("file_name"+i, file_name);
				//"file+i"라는 이름으로 파일을 attribute에 저장
				request.setAttribute("ori_file_name"+i, ori_file_name);
				i++;
				}
			} catch(Exception e) {
				System.out.print("파일 업로드 실패 : " + e);
			}
			
				RequestDispatcher dp = request.getRequestDispatcher("02_result.jsp");
				dp.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
