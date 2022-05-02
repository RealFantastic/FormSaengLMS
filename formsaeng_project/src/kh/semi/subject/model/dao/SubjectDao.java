package kh.semi.subject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import kh.semi.lms.department.model.vo.DepartmentVo;
import kh.semi.subject.model.vo.SubjectVo;

public class SubjectDao {
	
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	
	public ArrayList<DepartmentVo> selectDept(Connection conn) {
		ArrayList<DepartmentVo> result = null;
		
		String sql = "SELECT DEPT_CODE,DEPT_NAME FROM DEPARTMENT WHERE NOT DEPT_CODE = 'ADMIN'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<DepartmentVo>();
			
			if(rs.next()) {
				do {
					DepartmentVo dvo = new DepartmentVo();
					
					dvo.setDeptCode(rs.getString("dept_Code"));
					dvo.setDeptName(rs.getString("dept_Name"));
					
					System.out.println(dvo);
					
					result.add(dvo);
				}while(rs.next());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result);
		
		
		return result;
	}
	
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
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, x);
//			pstmt.setString(2, x);
//			pstmt.setInt(3, x);
//			pstmt.setInt(4, x);
//			pstmt.setInt(5, x);
//			pstmt.setString(6, x);
//			pstmt.setInt(7, x);
//			pstmt.setString(8, x);
//			pstmt.setString(9, x);
//			pstmt.setString(10, x);
//			pstmt.setString(11, x);
//			pstmt.setString(12, x);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	//관리자 수강신청 리스트용
	public ArrayList<SubjectVo> mgSubjectList(Connection conn) {
		ArrayList<SubjectVo> result = null;
		
		String sql = "SELECT *"
				+ " FROM(SELECT ROWNUM RNUM, SUB.*"
				+ " FROM(SELECT DEPT_NAME, SUBJECT_NAME, COURSE_CREDIT,CLASS_TYPE, COURSE_CLASS, COURSE_DAY,COURSE_PERIOD,NAME"
				+ "        FROM SUBJECT JOIN DEPARTMENT"
				+ "        USING (DEPT_CODE)"
				+ "        JOIN MEMBER ON SUBJECT.PF_ID = MEMBER.ID) SUB)"
		/* + "WHERE RNUM BETWEEN ? AND ?" */;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<SubjectVo>();
			
			if(rs.next()) {
				do {
					SubjectVo vo = new SubjectVo();
					vo.setDeptName(rs.getString("dept_Name"));
					vo.setSubName(rs.getString("subject_Name"));
					vo.setCourseCredit(rs.getInt("course_Credit"));
					vo.setClassType(rs.getString("class_Type"));
					vo.setCourseClass(rs.getString("course_Class"));
					vo.setCourseDay(rs.getString("course_Day"));
					vo.setCoursePeriod(rs.getString("course_Period"));
					vo.setPfName(rs.getString("name"));
					
					System.out.println("쿼리 직후 vo값 : " + vo);
					result.add(vo);
				}while(rs.next());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		System.out.println("dao에서 리턴 전 result값 : " + result);
		

		return result;
	}
	//학생 수강신청 교과목 리스트용
	public ArrayList<SubjectVo> stSubjectList(Connection conn, SubjectVo vo) {
		ArrayList<SubjectVo> result = null;
		
		String sql = "SELECT SUB_ROW.* "
				+ "FROM(SELECT ROWNUM RNUM, SUB.* "
				+ "        FROM(SELECT SUBJECT.DEPT_CODE, DEPT_NAME, SUBJECT_NAME, COURSE_CREDIT,CLASS_TYPE, COURSE_CLASS, COURSE_DAY,COURSE_PERIOD,NAME\r\n"
				+ "                FROM SUBJECT JOIN DEPARTMENT "
				+ "                ON SUBJECT.DEPT_CODE = DEPARTMENT.DEPT_CODE "
				+ "                JOIN MEMBER ON SUBJECT.PF_ID = MEMBER.ID "
				+ "                WHERE SUBJECT.DEPT_CODE = ?) SUB)SUB_ROW "
				+ "WHERE (RNUM BETWEEN ? AND ?)";
		

		return result;
	}
}
