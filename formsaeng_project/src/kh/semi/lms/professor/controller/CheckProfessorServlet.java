package kh.semi.lms.professor.controller;

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
@WebServlet("/checkPf.ajx")
public class CheckProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckProfessorServlet() {
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
		System.out.println("doPost : /checkSt.ajx");
		String pfName = request.getParameter("name");
		String pfId = request.getParameter("id");
		System.out.println(pfName);
		System.out.println(pfId);
		MemberVo result = null;
		PrintWriter out = response.getWriter();		
		
		result = new MemberService().findPassword(pfName, pfId);
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
