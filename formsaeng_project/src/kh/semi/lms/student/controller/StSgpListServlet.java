package kh.semi.lms.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.group.service.StudyGroupService;
import kh.semi.lms.group.vo.StudyGroupVo;

/**
 * Servlet implementation class StSgpListServlet
 */
@WebServlet("/st/studygroup")
public class StSgpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StSgpListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subcode = request.getParameter("s");
		System.out.println(subcode);
		ArrayList<StudyGroupVo> volist = new StudyGroupService().StudyGrouplist(subcode);
		System.out.println(volist);	
		request.setAttribute("StudyGrouplist", volist);
		request.setAttribute("s", subcode);
		System.out.println();
		request.getRequestDispatcher("/WEB-INF/view/student/st_studygroupboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
