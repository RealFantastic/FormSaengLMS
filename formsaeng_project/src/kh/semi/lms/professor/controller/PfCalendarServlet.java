package kh.semi.lms.professor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.calendar.service.CalendarService;
import kh.semi.lms.calendar.vo.CalendarVo;

/**
 * Servlet implementation class PfCalendarServlet
 */
@WebServlet("/pf/calendar")
public class PfCalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfCalendarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getRequestDispatcher=페이지 이동 getContextPath()=(root : /lms)+경로
				System.out.println("doGet : /pf/calendar" );
				
				String calendar_content=request.getParameter("calendar_content");
				String calendar_start_date=request.getParameter("calendar_start_date");
				String calendar_end_date=request.getParameter("calendar_end_date");
				
				ArrayList<CalendarVo> result=new CalendarService().selectcalendar();
				System.out.println(result);
				request.setAttribute("calVoList", result);
				request.getRequestDispatcher("/WEB-INF/view/professor/pfCalendar.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
