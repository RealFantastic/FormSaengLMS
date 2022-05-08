package kh.semi.lms.enrolment.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.member.model.vo.MemberVo;
import kh.semi.subject.model.vo.SubjectVo;

public class EnrolmentDao {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public int applySubject(MemberVo vo, String[] subCode, Connection conn) {
		int result = 0;
		
		String sql = "INSERT INTO ENROLLMENT_STUDENT VALUES	(?,?)";
		
		try {
			for(int i = 0; i< subCode.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, subCode[i]);
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		System.out.println("쿼리 결과로 인서트된 과묵 개수 : " + result);

		
		return result;
	}
	//학생이 신청한 과목 목록
	public ArrayList<SubjectVo> appliedList(Connection conn, MemberVo vo){
		ArrayList<SubjectVo> aplist = null;
		System.out.println("dao 오자마자 vo 값 : " + vo);
		
		String sql = "SELECT ENROLLMENT_STUDENT.ID ID, ENROLLMENT_STUDENT.SUBJECT_CODE SUB_CODE,DEPT_NAME, "
				+ 				"SUBJECT.DEPT_CODE DEPT_CODE, SUBJECT_NAME, COURSE_CREDIT, "
				+ 				"CLASS_TYPE, COURSE_DAY,COURSE_PERIOD,PF_ID, NAME, COURSE_CLASS "
				+ 	 "FROM SUBJECT "
				+ 	 "JOIN ENROLLMENT_STUDENT ON SUBJECT.SUBJECT_CODE = ENROLLMENT_STUDENT.SUBJECT_CODE "
				+ 	 "JOIN MEMBER ON PF_ID = MEMBER.ID "
				+ 	 "JOIN DEPARTMENT ON SUBJECT.DEPT_CODE = DEPARTMENT.DEPT_CODE "
				+ "WHERE ENROLLMENT_STUDENT.ID=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			rs = pstmt.executeQuery();
			
			aplist = new ArrayList<SubjectVo>();
			
			if(rs.next()) {
				do {
					SubjectVo svo = new SubjectVo();
					svo.setSubCode(rs.getString("sub_Code"));
					svo.setDeptCode(rs.getString("dept_Code"));
					svo.setDeptName(rs.getString("dept_Name"));
					svo.setSubName(rs.getString("subject_Name"));
					svo.setCourseCredit(rs.getInt("course_Credit"));
					svo.setClassType(rs.getString("class_Type"));
					svo.setCourseClass(rs.getString("course_Class"));
					svo.setCourseDay(rs.getString("course_Day"));
					svo.setCoursePeriod(rs.getString("course_Period"));
					svo.setPfName(rs.getString("Name"));
					
					aplist.add(svo);
					
				}while(rs.next());
				
				System.out.println("dao 쿼리문 직후 aplist : " + aplist);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return aplist;
	}
	
	//신청과목 취소
	public int cancelSubject(Connection conn,MemberVo vo,String[] cancelList) {
		int result = 0;
		System.out.println("dao 도착 id" + vo.getId());
		String sql = "DELETE FROM ENROLLMENT_STUDENT WHERE ID = ? AND SUBJECT_CODE= ?";
		
		try {
			for(int i = 0; i<cancelList.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, cancelList[i]);
				result += pstmt.executeUpdate();
			}
			
			System.out.println("dao에서 삭제된 과목 수 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		System.out.println("dao에서 리턴 직전의 result" + result);
		return result;
	}
}
