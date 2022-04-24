package kh.semi.board.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;

import kh.semi.board.model.dao.MgBoardEnrollDao;
import kh.semi.board.model.vo.MgBoardListVo;

public class MgBoardEnrollService {

	public int insertBoard(MgBoardListVo vo) {
		int result=0;
		
		Connection conn=getConnection();
		
		result=new MgBoardEnrollDao().insertBoard(conn, vo);
		
		return result;
	}
}
