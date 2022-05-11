package kh.semi.lms.calendar.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.lms.calendar.vo.CalendarVo;

public class CalendarDao {
	
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	
	

	public int insertcalendar(Connection conn, CalendarVo vo) {
		
		int result=0;
		
		String sql="insert into ACADEMIC_CALENDAR (ACADEMIC_NO, ACADEMIC_NAME, START_DATE, END_DATE) values (SEQ_ACADEMIC_NO.nextval, ?, ?, ?)";
		
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
	
	
	public ArrayList<CalendarVo> selectcalendar(Connection conn) {
		ArrayList<CalendarVo> result=null;
		String sql="select ACADEMIC_NO, ACADEMIC_NAME, START_DATE, END_DATE from ACADEMIC_CALENDAR";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result = new ArrayList<CalendarVo>();
				do {
					CalendarVo vo = new CalendarVo();
					vo.setAcademicNo(rs.getInt("ACADEMIC_NO"));
					vo.setAcademicName(rs.getString("ACADEMIC_NAME"));
					vo.setStartDate(rs.getDate("START_DATE"));
					vo.setEndDate(rs.getDate("END_DATE"));
					result.add(vo);
				}while(rs.next());				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return result;
	}
	
	
	public int deleteCalendar(Connection conn, int delId) {
		int result=0;
		
		String sql="Delete from ACADEMIC_CALENDAR where ACADEMIC_NO=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, delId);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
}
