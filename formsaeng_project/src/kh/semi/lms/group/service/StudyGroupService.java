package kh.semi.lms.group.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.lms.group.dao.StudygroupDao;
import kh.semi.lms.group.vo.StudyGroupVo;

public class StudyGroupService {
	public ArrayList<StudyGroupVo> StudyGrouplist(String subcode){
		
		ArrayList<StudyGroupVo> result = null;
		Connection conn = getConnection();
		
		result = new StudygroupDao().StudyGrouplist(conn, subcode);
		close(conn);
		
		return result;
	}
}
