package kh.semi.lms.calendar.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kh.semi.lms.calendar.vo.CalendarVo;

public class CalendarDao {
	
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	
	

	public int insertcalendar(Connection conn, CalendarVo vo) {
		
		int result=0;
		
		String sql="insert into academic_calendar ACADEMIC_NO, ACADEMIC_NAME, START_DATE, END_DATE)"
				+ "values(SEQ_ACADEMIC_NO.nextval,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAcademicName());
			pstmt.setDate(2, new java.sql.Date( vo.getStartDate().getTime() ) );
			pstmt.setDate(3, new java.sql.Date( vo.getEndDate().getTime() ) );
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}
}
