package kh.semi.lms.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.enrolment.model.service.EnrolmentService;
import kh.semi.member.model.vo.MemberVo;
import kh.semi.subject.model.vo.SubjectVo;

/**
 * Servlet implementation class StDashBoardServlet
 */
@WebServlet("/st/DashBoard")
public class StDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StDashBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /st/DashBoard");
		MemberVo loginId = (MemberVo) request.getSession().getAttribute("ssMemberVo");
		System.out.println("대시보드 서블릿에 온 id 값 : " + loginId);
		
		ArrayList<SubjectVo> result = new EnrolmentService().appliedList(loginId);
		
		System.out.println("서블릿으로 돌아온 result : " + result);
		
		request.setAttribute("appliedList", result);
		
		request.getRequestDispatcher("/WEB-INF/view/student/stDashBoard.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
