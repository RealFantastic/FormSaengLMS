package kh.semi.lms.manager.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubjectAddDoServlet
 */
@WebServlet("/addSubject.ajx")
public class SubjectAddDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectAddDoServlet() {
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
		System.out.println("doPost : /addSubject.ajx");
		System.out.println(request.getParameter("a"));
//		BufferedReader reader = request.getReader();
//		
//		System.out.println("parameter로 읽은 값 : " + request.getParameter("queryString"));
//		System.out.println("reader로 읽은 값 : " + reader.readLine());
		String department = request.getParameter("department");
		String subjectName = request.getParameter("subjectName");
		String subjectCode = request.getParameter("subjectCode");
		String semester = request.getParameter("semester");
		String periods[] = request.getParameterValues("period");
		System.out.println(department);
		System.out.println(subjectName);
		System.out.println(semester);
		System.out.println(periods);
		//여기 구현...
		
	}

}
