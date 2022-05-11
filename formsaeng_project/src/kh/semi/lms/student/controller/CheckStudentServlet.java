package kh.semi.lms.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.member.model.service.MemberService;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class CheckProfessorServlet
 */
@WebServlet("/checkSt.ajx")
public class CheckStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost : /checkPf.ajx");
		String stName = request.getParameter("name");
		String stId = request.getParameter("id");
		System.out.println(stName);
		System.out.println(stId);
		MemberVo result = null;
		PrintWriter out = response.getWriter();		
		
		result = new MemberService().findPassword(stName, stId);
		System.out.println("서블릿에 돌아온 멤버정보 : " + result);
		
		request.getSession().setAttribute("getMemberInfo", result);
		
		
		if(result == null) {
			out.print(0);
			out.flush();
			out.close();
			return;
		}else {
			out.print(1);
			out.flush();
			out.close();
		}
	}

}
