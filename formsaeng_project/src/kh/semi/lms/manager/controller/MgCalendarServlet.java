package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.semi.lms.calendar.service.CalendarService;
import kh.semi.lms.calendar.vo.CalendarVo;

/**
 * Servlet implementation class MgCalenderServlet
 */
@WebServlet("/mg/calendar")
public class MgCalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgCalendarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getRequestDispatcher=페이지 이동 getContextPath()=(root : /lms)+경로
		System.out.println("doGet : /mg/calendar" );
		
		String calendar_content=request.getParameter("calendar_content");
		String calendar_start_date=request.getParameter("calendar_start_date");
		String calendar_end_date=request.getParameter("calendar_end_date");
		
		ArrayList<CalendarVo> result=new CalendarService().selectcalendar();
		System.out.println(result);
		request.setAttribute("calVoList", result);
		request.getRequestDispatcher("/WEB-INF/view/manager/mgCalendar.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
