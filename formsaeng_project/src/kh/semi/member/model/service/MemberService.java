package kh.semi.member.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

import java.sql.Connection;

import kh.semi.member.model.dao.MemberDao;
import kh.semi.member.model.vo.MemberVo;

public class MemberService {
	public MemberVo login(MemberVo vo) {
		Connection conn = getConnection();
		
		MemberVo result = null;

		result = new MemberDao().login(conn,vo);
		
		close(conn);
		return result;
	
	}
}
