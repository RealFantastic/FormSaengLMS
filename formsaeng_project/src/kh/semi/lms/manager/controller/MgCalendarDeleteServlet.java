package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.calendar.service.CalendarService;

/**
 * Servlet implementation class MgCalendarDeleteServlet
 */
@WebServlet("/mg/cal/delete.ajx")
public class MgCalendarDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgCalendarDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost/mg/cal/delete.ajx");
		System.out.println("delId"+request.getParameter("delId"));
		int delId = Integer.parseInt(request.getParameter("delId"));
		int result=new CalendarService().deletecalendar(delId);
		PrintWriter out = response.getWriter();		
		
		if(result < 1) {
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
