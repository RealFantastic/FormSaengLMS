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
 * Servlet implementation class StapplySubjectServlet
 */
@WebServlet("/st/applySubject.ajx")
public class StapplySubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StapplySubjectServlet() {
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
		System.out.println("doPost : /st/applySubject.ajx");
		MemberVo mvo = (MemberVo)request.getSession().getAttribute("ssMemberVo");
		System.out.println("학생 로그인정보 : " + mvo);
		String[] subCode = request.getParameterValues("checkRow");
		for(int i = 0; i<subCode.length; i++) {
			System.out.println("신청한 과목코드 목록 : "+subCode[i]);
		}
		
		int result = 0;
		
		result = new EnrolmentService().applySubject(mvo, subCode);
		
		PrintWriter out = response.getWriter();
		
		if(result <= 0) {
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
