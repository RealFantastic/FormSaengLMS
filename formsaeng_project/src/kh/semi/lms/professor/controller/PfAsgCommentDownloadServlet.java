package kh.semi.lms.professor.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PfAsgCommentDownloadServlet
 */
@WebServlet("/pf/asgboard/read/down")
public class PfAsgCommentDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgCommentDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget 잘들어왔는가?");
		
		
		
		request.setCharacterEncoding("utf-8");
		
		// 파일 저장 경로 (web 경로 밑에 해당 폴더가 있어야함)
		String fileSavePath = "fUpload";
		
		String readFolder = request.getSession().getServletContext().getRealPath(fileSavePath);
		
		System.out.println("readFolder : " + readFolder);
//		
		String file = request.getParameter("file");
		System.out.println("fName 값은 ? "+file);
//		
//		//클라이언트로 내보낼 출력 스트림 생성
		ServletOutputStream downOut = response.getOutputStream();
		
		File downFile = new File(readFolder+ '\\' + file);
		System.out.println("downFile : " + downFile);
		response.setContentType("text/plain; charset=utf-8");
		
		//한글 파일명 인코딩 처리함
		response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(file.getBytes("UTF-8"), "ISO-8859-1") + "\"");
		
		response.setContentLength((int)downFile.length());
		
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
		int read = -1;
		while((read = bin.read()) != -1) {
			downOut.write(read);
			downOut.flush();
		} 
		
		downOut.close();
		bin.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
