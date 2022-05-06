package kh.semi.lms.enrolment.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.lms.enrolment.model.dao.EnrolmentDao;
import kh.semi.member.model.vo.MemberVo;
import kh.semi.subject.model.vo.SubjectVo;

public class EnrolmentService {
	//수강신청
	public int applySubject(MemberVo vo, String[] subCode) {
		Connection conn = getConnection();
		int result = 0;
		
		result = new EnrolmentDao().applySubject(vo, subCode, conn);	
		
		close(conn);
		return result;
	}
	//학생 수강신청목록 조회
	public ArrayList<SubjectVo> appliedList(MemberVo vo){
		Connection conn = getConnection();
		ArrayList<SubjectVo> aplist = null;
		System.out.println("service 오자마자 vo 값 : " + vo);
		
		
		aplist = new EnrolmentDao().appliedList(conn, vo);
			
		
		close(conn);
		return aplist;
	}
	
	//신청과목 취소
	public int cancelSubject(MemberVo vo,String[] cancelList) {
		Connection conn = getConnection();
		int result = 0;
		System.out.println("service 도착 id" + vo.getId());
		for(int i = 0; i<cancelList.length; i++) {
			System.out.println("service 도착 cancelList : " + cancelList[i]);
		}
		
		result = new EnrolmentDao().cancelSubject(conn,vo,cancelList);
		
		close(conn);
		return result;
	}
}
