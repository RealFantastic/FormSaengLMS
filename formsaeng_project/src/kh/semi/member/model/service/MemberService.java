package kh.semi.member.model.service;
import static kh.semi.lms.common.jdbc.JdbcDbcp.*;


import java.sql.Connection;
import java.util.ArrayList;

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

	
	public int updatePnum(MemberVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.updatePnum(conn, vo);
		
		close(conn);
		return result;
	}
	
	public int updateAddress(MemberVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.updateAddress(conn, vo);
		
		close(conn);
		return result;
	}
	
	public int updateEmail(MemberVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.updateEmail(conn, vo);
		
		close(conn);
		return result;
	}
	
	public int updatePwd(MemberVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.updatePwd(conn, vo);
		
		close(conn);
		return result;
	}
	
	
	
	public MemberVo findId(MemberVo vo) {
		Connection conn = getConnection();
		
		MemberVo result = null;
		
		result = new MemberDao().findId(conn, vo);
		
		close(conn);
		return result;
	}
	//해당 학과 소속된 교수 찾기
	public ArrayList<MemberVo> selectPf(MemberVo vo) {
		Connection conn = getConnection();
		
		ArrayList<MemberVo> result = null;
		
		
		result = new MemberDao().selectPf(conn, vo);
		close(conn);
		return result;
	}
	//비밀번호 찾기(입력정보 확인)
	public MemberVo findPassword(String name, String id) {
		Connection conn = getConnection();
		
		MemberVo result = null;
		
		result = new MemberDao().findPassword(conn, name, id);
		
		close(conn);
		return result;
	}

	
}
