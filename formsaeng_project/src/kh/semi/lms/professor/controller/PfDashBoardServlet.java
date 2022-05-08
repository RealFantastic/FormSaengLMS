package kh.semi.lms.professor.controller;

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
 * Servlet implementation class PfDashBoardServlet
 */
@WebServlet("/pf/DashBoard")
public class PfDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfDashBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /pf/DashBoard");
		MemberVo vo = (MemberVo) request.getSession().getAttribute("ssMemberVo");
		System.out.println("교수 로그인 정보 : " + vo);
		
		ArrayList<SubjectVo> teachList = new SubjectService().teachList(vo);
		System.out.println("서블릿에 돌아온 teachList : " + teachList);
		
		request.setAttribute("teachList", teachList);
		request.getRequestDispatcher("/WEB-INF/view/professor/pfDashBoard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
