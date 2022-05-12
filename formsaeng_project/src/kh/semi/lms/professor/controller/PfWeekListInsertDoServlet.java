package kh.semi.lms.professor.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.lms.lecture.model.service.LectureService;
import kh.semi.lms.lecture.model.vo.LectureVo;


/**
 * Servlet implementation class PfWeekListInsertDoServlet
 */
@WebServlet("/pf/week/insert.do")
//Annotation을 통한 파일 크기 및 업로드 위치 지정
/* @MultipartConfig(maxFileSize = 1024 * 1024 * 1024, location = "/upload") */
public class PfWeekListInsertDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfWeekListInsertDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//MultipartRequest이거 떄문에 post 안됐었음
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost 들어왔는가");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해줘야함)
		String fileSavePath = "upload";
		
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10*1024*1024;
		String encType = "UTF-8";
		
		if(!ServletFileUpload.isMultipartContent(request))
			response.sendRedirect("");
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);
		
		File filePath = new File(uploadPath);
		if(!filePath.exists()) filePath.mkdirs();
		
		MultipartRequest multi = new MultipartRequest(request,
				uploadPath,
				uploadSizeLimit,
				encType,
				new DefaultFileRenamePolicy());
		
		// 업로드 된 파일 이름 얻어오기
		String fileName1 = multi.getFilesystemName("fileName1");
		System.out.println(fileName1);
		if(fileName1 == null) {
			System.out.println("업로드 실패");
			out.print(0);
			out.flush();
			out.close();
			return;
		} 
		
		String weekNo = multi.getParameter("week");
		String subCode = multi.getParameter("subCode");
		System.out.println("subCode 의 값은 ?"+subCode);
		
		System.out.println("week 의 값은 ? "+weekNo);
		System.out.println("subCode 의 값은 ? "+subCode);
		
		int week = Integer.parseInt(weekNo);
		String lName = multi.getParameter("lectureName");
		String fName =  fileName1;
		String fPath = "/upload/";
		
		System.out.println(lName);
		System.out.println(weekNo);
		System.out.println(fileName1);
		
		LectureVo vo = new LectureVo();
		vo.setWeekNo(week);
		vo.setvTitle(lName);
		vo.setfName(fName);
		vo.setfPath(fPath);
		vo.setSubCode(subCode);
		
		System.out.println("서블릿 vo 값은 ? "+vo);
		
		int result = new LectureService().insertVideo(vo);
		
		System.out.println("result : "+result);
		
		if(result <= 0) {
			out.print(0);
			out.flush();
			out.close();
			return;
		} else {
			out.print(result);
			out.flush();
			out.close();
		}
		
//		request.getRequestDispatcher("/WEB-INF/view/professor/pf_lectureboardlsit.jsp").forward(request, response);
		
		
//		if(result < 1) {
//			System.out.println("등록에 실패했습니다.");
//			request.setAttribute("wmsg", "강의 등록에 실패했습니다.");
//		} else {
//			System.out.println("등록에 성공했습니다.");
//			request.setAttribute("wmsg", "강의 등록에 성공했습니다.");
//		}
		
		/*
		
		 * System.out.println("week 값은 ? "+week); String title =
		 * multi.getParameter("lectureName"); System.out.println("title 값은 ? "+title);
		 * String fileName1 = multi.getFilesystemName("fileName1");
		 * System.out.println("fileName1 값은 ? "+fileName1);
		 */
		
//		Part part = (Part) request.getPart("fileName1");
//		System.out.println(part);
		
		
		

		
		
	}
//	private String getFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        System.out.println(" LOG :: content-disposition 헤더 :: = "+contentDisp);
//        String[] tokens = contentDisp.split(";");
//        for (String token : tokens) {
//            if (token.trim().startsWith("filename")) {
//            	System.out.println(" LOG :: 파일 이름 :: " + token);
//                return token.substring(token.indexOf("=") + 2, token.length()-1);
//            }
//        }
//        return "";
//    }

}


