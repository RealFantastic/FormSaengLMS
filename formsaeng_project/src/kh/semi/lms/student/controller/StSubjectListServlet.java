package kh.semi.lms.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.member.model.vo.MemberVo;
import kh.semi.subject.model.service.SubjectService;
import kh.semi.subject.model.vo.SubjectVo;

/**
 * Servlet implementation class StSubjectListServlet
 */
@WebServlet("/stSubjectList")
public class StSubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StSubjectListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /stSubjectList");
		MemberVo vo = (MemberVo) request.getSession().getAttribute("ssMemberVo");
		System.out.println("학생 수강신청 페이지 넘어갈떄 들어온 세션값" + vo);
		ArrayList<SubjectVo> result = new SubjectService().stSubjectList(vo);
		System.out.println("서블릿으로 돌아온 result : " + result);
	
		request.setAttribute("subjects", result);
		request.getRequestDispatcher("/WEB-INF/view/student/stSubjectsList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
