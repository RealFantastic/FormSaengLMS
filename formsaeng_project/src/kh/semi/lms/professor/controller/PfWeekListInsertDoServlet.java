package kh.semi.lms.professor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kh.semi.lms.lecture.model.service.LectureService;
import kh.semi.lms.lecture.model.vo.LectureVo;


/**
 * Servlet implementation class PfWeekListInsertDoServlet
 */
@WebServlet("/pf/week/insert.do")
//Annotation을 통한 파일 크기 및 업로드 위치 지정
@MultipartConfig(maxFileSize = 1024 * 1024 * 1024, location = "C:\\z_workspace\\z_java\\formsaeng_semi_project\\web\\upload")
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
		
//		request.setCharacterEncoding("utf-8");
		
		
		System.out.println(request.getPart("fileName1").getName());
		System.out.println(request.getPart("fileName1").getSize());
		
		Part part = request.getPart("fileName1");
		String weekNo = request.getParameter("week");
		String fileName1 = getFileName(part);
		
		int week = Integer.parseInt(weekNo);
		String lName = request.getParameter("lectureName");
		String fName =  fileName1;
		String fPath = "/pf/week/view"; // 논리적 주소 -> ex ) /pf/week/view
		// "c:\\exDownload"
		part.write(fileName1); //폴더에 업로드 완료
		// 1. 해당 동영상 파일이름 또는 경로 db
		
		System.out.println(request.getParameter("lectureName"));
		System.out.println(request.getParameter("week"));
		System.out.println(fileName1); // 영상 제목만 넣을건지 아니면 해당 경로 
		
		LectureVo vo = new LectureVo();
		vo.setWeekNo(week);
		vo.setvTitle(lName);
		vo.setfName(fName);
		vo.setfPath(fPath);
		
		System.out.println("서블릿 vo 값은 ? "+vo);
		
		int result = new LectureService().insertVideo(vo);
		
		System.out.println("result : "+result);
		
//		PrintWriter out = response.getWriter();
//		
//		if(result <= 0) {
//			out.print(0);
//			out.flush();
//			out.close();
//			return;
//		} else {
//			out.print(result);
//			out.flush();
//			out.close();
//		}
		
//		if(result < 1) {
//			System.out.println("등록에 실패했습니다.");
//			request.setAttribute("wmsg", "강의 등록에 실패했습니다.");
//		} else {
//			System.out.println("등록에 성공했습니다.");
//			request.setAttribute("wmsg", "강의 등록에 성공했습니다.");
//		}
		
		/*
		 * String week = multi.getParameter("week");
		 * System.out.println("week 값은 ? "+week); String title =
		 * multi.getParameter("lectureName"); System.out.println("title 값은 ? "+title);
		 * String fileName1 = multi.getFilesystemName("fileName1");
		 * System.out.println("fileName1 값은 ? "+fileName1);
		 */
		
//		Part part = (Part) request.getPart("fileName1");
//		System.out.println(part);
		
		
		

		
		
	}
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println(" LOG :: content-disposition 헤더 :: = "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
            	System.out.println(" LOG :: 파일 이름 :: " + token);
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }

}


