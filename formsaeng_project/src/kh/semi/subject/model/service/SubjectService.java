package kh.semi.subject.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.lms.department.model.vo.DepartmentVo;
import kh.semi.member.model.vo.MemberVo;
import kh.semi.subject.model.dao.SubjectDao;
import kh.semi.subject.model.vo.SubjectVo;

public class SubjectService {
	
	public ArrayList<DepartmentVo> selectDept() {
		ArrayList<DepartmentVo> result = null;
		Connection conn = getConnection();
		
		result = new SubjectDao().selectDept(conn);
		
		close(conn);
		return result;
	}
	//관리자 수강신청 과목 추가
	public int insertSubject(SubjectVo vo) {
		Connection conn = getConnection();
		int result = 0;
		
		result = new SubjectDao().insertSubject(conn, vo);
		
		close(conn);
		return result;
	}
	//관리자 수강신청관리 목록
	public ArrayList<SubjectVo> mgSubjectList() {
		ArrayList<SubjectVo> result = null;
		Connection conn = getConnection();
		
		
		result = new SubjectDao().mgSubjectList(conn);
		
		close(conn);
		return result;
	}
	//페이징된 수강신청 관리 목록
	public ArrayList<SubjectVo> mgSubjectList(int startRnum, int endRnum,String searchType, String searchWord) {
		ArrayList<SubjectVo> result = null;
		Connection conn = getConnection();
		
		
		result = new SubjectDao().mgSubjectList(conn, startRnum, endRnum, searchType, searchWord);
		
		close(conn);
		return result;
	}
	
	//학생 수강신청 목록
	public ArrayList<SubjectVo> stSubjectList(MemberVo vo) {
		ArrayList<SubjectVo> result = null;
		Connection conn = getConnection();
		
		result = new SubjectDao().stSubjectList(conn,vo);
		
		close(conn);
		return result;
	}
	//학생 수강신청 목록 페이징
		public ArrayList<SubjectVo> stSubjectList(MemberVo vo,int startRnum, int endRnum) {
			ArrayList<SubjectVo> result = null;
			Connection conn = getConnection();
			
			result = new SubjectDao().stSubjectList(conn,vo,startRnum,endRnum);
			
			close(conn);
			return result;
		}
	//학생 수강신청 검색 목록 페이징
			public ArrayList<SubjectVo> stSubjectList(MemberVo vo,int startRnum, int endRnum,String searchType, String searchWord) {
				ArrayList<SubjectVo> result = null;
				Connection conn = getConnection();
				
				result = new SubjectDao().stSubjectList(conn, vo, startRnum, endRnum, searchType, searchWord);
				
				close(conn);
				return result;
			}

	
	public int deleteSubejct(String[] delist) {
		int result = 0;
		Connection conn = getConnection();
		
		result = new SubjectDao().deleteSubejct(conn, delist);
		
		close(conn);
		return result;
	}
	//각각 교수의 과목 목록
	public ArrayList<SubjectVo> teachList(MemberVo vo){
		ArrayList<SubjectVo> result = null;
		Connection conn = getConnection();
		result = new SubjectDao().teachList(conn, vo);
		
		System.out.println("service 교수의 과목 목록 : " + result);
		
		close(conn);
		return result;
	}
	
	//수강신청 관리목록 갯수
	public int countMgSubject() {
		Connection conn = getConnection();
		int result = 0;
		
		result = new SubjectDao().countMgSubject(conn);
		close(conn);
		return result;
	}
	//검색한 과목 목록 개수
	public int countMgSubject(String searchType, String searchWord) {
		Connection conn = getConnection();
		int result = 0;
		
		result = new SubjectDao().countMgSubject(conn, searchType,searchWord);
		close(conn);
		return result;
	}
	
	//학생 수강신청 가능 갯수
		public int countStSubject(MemberVo vo) {
			Connection conn = getConnection();
			int result = 0;
			
			result = new SubjectDao().countStSubject(conn, vo);
			close(conn);
			return result;
		}
	//학생 수강신청 가능 갯수
			public int countStSubject(MemberVo vo, String searchType, String searchWord) {
				Connection conn = getConnection();
				int result = 0;
				
				result = new SubjectDao().countStSubject(conn, vo, searchType, searchWord);
				close(conn);
				return result;
			}
}
