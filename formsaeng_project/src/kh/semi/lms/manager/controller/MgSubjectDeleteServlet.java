package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.subject.model.service.SubjectService;

/**
 * Servlet implementation class MgSubjectDeleteServlet
 */
@WebServlet("/mg/delSubject.ajx")
public class MgSubjectDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgSubjectDeleteServlet() {
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
		System.out.println("doPost : /delSubject.ajx");
		String[] delist = request.getParameterValues("checkRow");
		
		int result = 0;
		
		result = new SubjectService().deleteSubejct(delist);
		
		PrintWriter out = response.getWriter();
		
		if(result <= 0) {
			out.print(0); //삭제 실패
			out.flush();
			out.close();
			return;
		}else {
			out.print(result);	//삭제 성공
			out.flush();
			out.close();
		}
	}

}
