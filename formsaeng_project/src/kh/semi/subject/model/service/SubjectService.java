package kh.semi.subject.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;

import kh.semi.subject.model.dao.SubjectDao;
import kh.semi.subject.model.vo.SubjectVo;

public class SubjectService {
	public int insertSubject(SubjectVo vo) {
		Connection conn = getConnection();
		int result = 0;
		
		result = new SubjectDao().insertSubject(conn, vo);

		return result;
	}
}
