package kh.semi.subject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kh.semi.subject.model.vo.SubjectVo;

public class SubjectDao {
	
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	
	public int insertSubject(Connection conn, SubjectVo vo) {
		int result = 0;
		
//		private String subCode;
//		private String subName;
//		private int courseGrade;
//		private int courseSemester;
//		private int courseCredit;
//		private String courseClass;
//		private int courseCapacity;
//		private String openYN;
//		private String deptCode;
//		private String classType;
//		private String courseDay;
//		private String coursePeriod;
		String sql = "INSERT INTO subject VALUES (,,,,,,,,,,,)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, x);
			pstmt.setString(2, x);
			pstmt.setInt(3, x);
			pstmt.setInt(4, x);
			pstmt.setInt(5, x);
			pstmt.setString(6, x);
			pstmt.setInt(7, x);
			pstmt.setString(8, x);
			pstmt.setString(9, x);
			pstmt.setString(10, x);
			pstmt.setString(11, x);
			pstmt.setString(12, x);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
