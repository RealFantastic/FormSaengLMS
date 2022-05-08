package kh.semi.subject.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.lms.department.model.vo.DepartmentVo;
import kh.semi.member.model.vo.MemberVo;
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
			close(rs);
			close(pstmt);
		}
		System.out.println(result);
		
		
		return result;
	}
	//관리자 수강신청 과목추가
	public int insertSubject(Connection conn, SubjectVo vo) {
		int result = 0;
		
//		SUBJECT_CODE    NOT NULL VARCHAR2(30) 
//		SUBJECT_NAME    NOT NULL VARCHAR2(30) 
//		COURSE_GRADE    NOT NULL NUMBER(1)    
//		COURSE_SEMESTER NOT NULL NUMBER(4)    
//		COURSE_CREDIT   NOT NULL NUMBER(1)    
//		COURSE_CLASS    NOT NULL VARCHAR2(90) 
//		COURSE_CAPACITY NOT NULL NUMBER       
//		OPEN_YN         NOT NULL VARCHAR2(3)  
//		DEPT_CODE       NOT NULL VARCHAR2(20) 
//		CLASS_TYPE               VARCHAR2(12) 
//		COURSE_DAY               VARCHAR2(3)  
//		COURSE_PERIOD            VARCHAR2(20) 
//		PF_ID                    VARCHAR2(12)
		String sql = "INSERT INTO subject VALUES (?,?,?,?,?,?,?,default,?,?,?,?,?)";
		
		System.out.println("dao에 넘어온 insert용 vo값 : " + vo);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubCode());
			pstmt.setString(2, vo.getSubName());
			pstmt.setInt(3, vo.getCourseGrade());
			pstmt.setInt(4, vo.getCourseSemester());
			pstmt.setInt(5, vo.getCourseCredit());
			pstmt.setString(6, vo.getCourseClass());
			pstmt.setInt(7, vo.getCourseCapacity());
			pstmt.setString(8, vo.getDeptCode());
			pstmt.setString(9, vo.getClassType());
			pstmt.setString(10, vo.getCourseDay());
			pstmt.setString(11, vo.getCoursePeriod());
			pstmt.setString(12, vo.getPfName());
			
			result = pstmt.executeUpdate();
			
			if(result >0) {
				System.out.println("dao 입력성공");
			}
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
				+ " FROM(SELECT SUBJECT_CODE,DEPT_NAME, SUBJECT_NAME, COURSE_CREDIT,CLASS_TYPE, COURSE_CLASS, COURSE_DAY,COURSE_PERIOD,NAME"
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
					vo.setSubCode(rs.getString("SUBJECT_CODE"));
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
			close(rs);
			close(stmt);
		}
		
		System.out.println("dao에서 리턴 전 result값 : " + result);
		

		return result;
	}
	//관리자 수강신청 삭제
	public int deleteSubejct(Connection conn, String [] delist) {
		int result = 0;
		
		String sql = "DELETE FROM SUBJECT WHERE SUBJECT_CODE = ?";
		
		try {
			for(int i = 0; i<delist.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, delist[i]);
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		
		return result;
	}
	
	//학생 수강신청 교과목 리스트용
	public ArrayList<SubjectVo> stSubjectList(Connection conn, MemberVo vo) {
		ArrayList<SubjectVo> result = null;
		
		String sql = "SELECT SUB_ROW.* "
				+ "FROM(SELECT ROWNUM RNUM, SUB.* "
				+ "        FROM(SELECT SUBJECT_CODE, SUBJECT.DEPT_CODE, DEPT_NAME, SUBJECT_NAME, COURSE_CREDIT,CLASS_TYPE, COURSE_CLASS, COURSE_DAY,COURSE_PERIOD,NAME "
				+ "                FROM SUBJECT JOIN DEPARTMENT "
				+ "                ON SUBJECT.DEPT_CODE = DEPARTMENT.DEPT_CODE "
				+ "                JOIN MEMBER ON SUBJECT.PF_ID = MEMBER.ID "
				+ "                WHERE SUBJECT.DEPT_CODE = ?) SUB)SUB_ROW ";
		
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDeptCode());
			rs = pstmt.executeQuery();
			
			result = new ArrayList<SubjectVo>();
			if(rs.next()) {
				do {
					SubjectVo svo = new SubjectVo();
					svo.setSubCode(rs.getString("subject_Code"));
					svo.setDeptCode(rs.getString("dept_Code"));
					svo.setDeptName(rs.getString("dept_Name"));
					svo.setSubName(rs.getString("subject_Name"));
					svo.setCourseCredit(rs.getInt("course_Credit"));
					svo.setClassType(rs.getString("class_Type"));
					svo.setCourseClass(rs.getString("course_Class"));
					svo.setCourseDay(rs.getString("course_Day"));
					svo.setCoursePeriod(rs.getString("course_Period"));
					svo.setPfName(rs.getString("Name"));
					
					result.add(svo);
				}while(rs.next());
				
				System.out.println("dao 쿼리문 직후 result : " + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		
		return result;
	}
	//각각 교수가 가르치는 과목 목록
	public ArrayList<SubjectVo> teachList(Connection conn, MemberVo vo){
		ArrayList<SubjectVo> result = null;
		
		String sql = "SELECT SUBJECT_CODE, SUBJECT_NAME, COURSE_DAY, COURSE_PERIOD, COURSE_CAPACITY "
					+ "FROM SUBJECT WHERE PF_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			
			rs = pstmt.executeQuery();
			result = new ArrayList<SubjectVo>();
			
			if(rs.next()) {
				do {
					SubjectVo svo = new SubjectVo();
					svo.setSubCode(rs.getString("subject_Code"));
					svo.setSubName(rs.getString("subject_Name"));
					svo.setCourseDay(rs.getString("course_Day"));
					svo.setCoursePeriod(rs.getString("course_Period"));
					svo.setCourseCapacity(rs.getInt("course_Capacity"));
					
					result.add(svo);
				}while(rs.next());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		System.out.println("dao 교수의 과목 목록 : " + result);
		return result;
	}
	
}
