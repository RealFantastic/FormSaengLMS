package kh.semi.member.model.service;
import static kh.semi.lms.common.jdbc.JdbcDbcp.*;


import java.sql.Connection;

import kh.semi.member.model.dao.MemberDao;
import kh.semi.member.model.vo.MemberVo;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public MemberVo login(MemberVo vo) {
		Connection conn = getConnection();
		
		MemberVo result = null;

		result = dao.login(conn,vo);
		
		close(conn);
		return result;
	
	}
	
	public MemberVo readMember(MemberVo vo) {
		MemberVo result = null;
		Connection conn = getConnection();
		result = dao.readMember(conn, vo);
		
		close(conn);
		return result;
	}
	
	public int updateMember(MemberVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.updateMember(conn, vo);
		
		close(conn);
		return result;
	}
	
	
	
	public MemberVo findId(MemberVo vo) {
		Connection conn = getConnection();
		
		MemberVo result = null;
		
		result = new MemberDao().findId(conn, vo);
		
		return result;
	}
	
}
