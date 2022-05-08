package kh.semi.lms.calendar.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;

import kh.semi.lms.calendar.dao.CalendarDao;
import kh.semi.lms.calendar.vo.CalendarVo;

public class CalendarService {

	public int insertcalendar(CalendarVo vo) {
		int result=0;
		
		Connection conn=getConnection();
		
		result=new CalendarDao().insertcalendar(conn, vo);
		
		return result;
	}
}
