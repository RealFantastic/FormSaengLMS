package kh.semi.lms.asg.model.service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kh.semi.lms.asg.model.dao.AsgListDao;
import kh.semi.lms.asg.model.vo.AsgCommentVo;
import kh.semi.lms.asg.model.vo.AsgListVo;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

public class AsgListService {
	
	public int insertBoard(AsgListVo vo) {
		Connection conn = getConnection();
		int result =  new AsgListDao().insertBoard(conn, vo);
		close(conn);
		return result;
	}
	
	public AsgListVo readBoard(int bANo) {
		Connection conn = getConnection();
		AsgListVo vo = new AsgListDao().readBoard(conn, bANo);
		close(conn);
		return vo;
	}
	
	public int updateBoard(AsgListVo vo) {
		Connection conn = getConnection();
		int result = new AsgListDao().updateBoard(conn, vo);
		close(conn);
		return result;
	}

	public int deleteBoard(int bANo) {
		Connection conn = getConnection();
		int result = new AsgListDao().deleteBoard(conn, bANo);
		close(conn);
		return result;
	}
	
	public int multiDeleteBoard(String[] delNo) {
		Connection conn = getConnection();
		int result = new AsgListDao().multiDeleteBoard(conn, delNo);
		close(conn);
		return result;
	}
	
	public ArrayList<AsgListVo> AssignmentBoardlist() {
		Connection conn = getConnection();
		ArrayList<AsgListVo> volist = new AsgListDao().AssignmentBoardlist(conn);
		close(conn);
		return volist;
	}
	
	public ArrayList<AsgListVo> AssignmentBoardlist(int startRnum,int endRnum) {
		Connection conn = getConnection();
		ArrayList<AsgListVo> volist = new AsgListDao().AssignmentBoardlist(conn,startRnum,endRnum);
		close(conn);
		return volist;
	}
	
	
	
	public int countListBoard() {
		Connection conn = getConnection();
		int result = new AsgListDao().countListBoard(conn);
		close(conn);
		return result;
	}
	

	
	public AsgListVo readBoardAndComment(int bNo) {
		Connection conn = getConnection();
		AsgListVo vo = new AsgListDao().readBoard(conn, bNo);
		vo.setReVolist(new AsgListDao().readBoardAndComments(conn, bNo));
		close(conn);
		
		return vo;
	}
}