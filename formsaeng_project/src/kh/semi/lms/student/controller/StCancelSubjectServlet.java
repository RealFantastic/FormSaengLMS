package kh.semi.lms.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.enrolment.model.service.EnrolmentService;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class StCancelSubjectServlet
 */
@WebServlet("/st/cancelSubject.ajx")
public class StCancelSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StCancelSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost : /st/cancelSubject.ajx");
		MemberVo vo = (MemberVo)request.getSession().getAttribute("ssMemberVo");
		System.out.println("취소 서블릿 / 로그인한 유저 : " + vo);
		String[] cancelList = request.getParameterValues("cancelList");
		
		int result = 0;
		
		result = new EnrolmentService().cancelSubject(vo,cancelList);
		PrintWriter out = response.getWriter();
		
		System.out.println("servlet에 돌아온 취소 result : " + result);
		if(result <=0) {
			out.print(0);
			out.flush();
			out.close();
		}else {
			out.print(result);
			out.flush();
			out.close();
			
		}
		
		
		
	}

}
