package kh.semi.subject.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.lms.department.model.vo.DepartmentVo;
import kh.semi.subject.model.dao.SubjectDao;
import kh.semi.subject.model.vo.SubjectVo;

public class SubjectService {
	
	public ArrayList<DepartmentVo> selectDept() {
		ArrayList<DepartmentVo> result = null;
		Connection conn = getConnection();
		
		result = new SubjectDao().selectDept(conn);
		
		return result;
	}
	//관리자 수강신청 과목 추가
	public int insertSubject(SubjectVo vo) {
		Connection conn = getConnection();
		int result = 0;
		
		result = new SubjectDao().insertSubject(conn, vo);

		return result;
	}
	//관리자 수강신청관리 목록
	public ArrayList<SubjectVo> mgSubjectList() {
		ArrayList<SubjectVo> result = null;
		Connection conn = getConnection();
		
		
		result = new SubjectDao().mgSubjectList(conn);
		
		return result;
	}
	
	//학생 수강신청 목록
	public ArrayList<SubjectVo> stSubjectList(SubjectVo vo) {
		ArrayList<SubjectVo> result = null;
		Connection conn = getConnection();
		
		result = new SubjectDao().stSubjectList(conn, vo);
		
		
		return result;
	}
}
