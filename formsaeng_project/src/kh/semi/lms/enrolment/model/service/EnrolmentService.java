package kh.semi.lms.enrolment.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;

import kh.semi.lms.enrolment.model.dao.EnrolmentDao;
import kh.semi.member.model.vo.MemberVo;

public class EnrolmentService {
	
	public int applySubject(MemberVo vo, String[] subCode) {
		Connection conn = getConnection();
		int result = 0;
		
		result = new EnrolmentDao().applySubject(vo, subCode, conn);	
		
		return result;
	}
}
