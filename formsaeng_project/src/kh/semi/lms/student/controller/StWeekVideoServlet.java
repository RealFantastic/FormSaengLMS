package kh.semi.lms.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.lecture.model.service.LectureService;
import kh.semi.lms.lecture.model.vo.LectureVo;

/**
 * Servlet implementation class StWeekVideoServlet
 */
@WebServlet("/st/week/video")
public class StWeekVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StWeekVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("lecNo");
		int lecNo = Integer.parseInt(no);
		
		String subCode = request.getParameter("s");
		System.out.println(subCode);
		String subName = request.getParameter("n");
		System.out.println(subName);
		
		LectureVo vo = new LectureService().lecturePath(lecNo);
		
		request.setAttribute("lecturePath", vo);
		request.setAttribute("subCode", subCode);
		request.setAttribute("subName", subName);
	
		request.getRequestDispatcher("/WEB-INF/view/student/st_lectureVideo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
