package kh.semi.lms.reference.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.lms.reference.dao.ReferenceDao;
import kh.semi.lms.reference.vo.ReferenceVo;


public class ReferenceService {
	public ArrayList<ReferenceVo> LectureBoardlist(){
		
		ArrayList<ReferenceVo> result = null;
		Connection conn = getConnection();
		
		result = new ReferenceDao().LectureBoardlist(conn);
		
		close(conn);
		
		return result;
	}

}
