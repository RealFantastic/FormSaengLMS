package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.calendar.service.CalendarService;
import kh.semi.lms.calendar.vo.CalendarVo;

/**
 * Servlet implementation class MgCalendarEnrollServlet
 */
@WebServlet("/mg/calendar/enroll")
public class MgCalendarEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgCalendarEnrollServlet() {
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
		System.out.println("메시지 들어오는지 확인용");
		
		String calendar_content=request.getParameter("calendar_content");
		String calendar_start_date=request.getParameter("calendar_start_date");
		String calendar_end_date=request.getParameter("calendar_end_date");
		System.out.println(calendar_content);
		System.out.println(calendar_start_date);
		System.out.println(calendar_end_date);
		
		CalendarVo vo=new CalendarVo();
		vo.setAcademicName(calendar_content);
		
		//"yyyy-MM-dd" 유형의 String으로 전달된 calendar_start_date
		//	-> java.util.Date 타입으로 변환
		//	-> SimpleDateFormat 클래스를 사용한다
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date result = null;
		try {
			result = sdf.parse(calendar_start_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vo.setStartDate( result );

		result = null;
		try {
			result = sdf.parse(calendar_end_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vo.setEndDate( result );
		
		int rst=new CalendarService().insertcalendar(vo);
		
		response.sendRedirect(request.getContextPath()+"/mg/calendar");
	}

}
