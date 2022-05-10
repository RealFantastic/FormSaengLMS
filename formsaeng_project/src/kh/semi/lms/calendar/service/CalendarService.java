package kh.semi.lms.calendar.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.lms.calendar.dao.CalendarDao;
import kh.semi.lms.calendar.vo.CalendarVo;

public class CalendarService {

	public int insertcalendar(CalendarVo vo) {
		int result=0;
		
		Connection conn=getConnection();
		
		result=new CalendarDao().insertcalendar(conn, vo);
		close(conn);
		return result;
	}
	
	
	public ArrayList<CalendarVo> selectcalendar(){
		
		Connection conn=getConnection();
		
		ArrayList<CalendarVo> result=new CalendarDao().selectcalendar(conn);
		close(conn);
		return result;
	}
	
	
	public int deletecalendar() {
		
		Connection conn=getConnection();
		
		int result=new CalendarDao().deleteCalendar(conn);
		
		close(conn);
		return result;
	}
}
