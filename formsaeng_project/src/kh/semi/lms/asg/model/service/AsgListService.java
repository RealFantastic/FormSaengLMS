package kh.semi.lms.asg.model.service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kh.semi.lms.asg.model.dao.AsgListDao;
import kh.semi.lms.asg.model.vo.AsgCommentVo;
import kh.semi.lms.asg.model.vo.AsgFileVo;
import kh.semi.lms.asg.model.vo.AsgListVo;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

public class AsgListService {
	
	//게시글 추가하기
	public int insertBoard(AsgListVo vo) {
		Connection conn = getConnection();
		int result =  new AsgListDao().insertBoard(conn, vo);
		close(conn);
		return result;
	}
	
	//게시글 상세보기
	public AsgListVo readBoard(AsgCommentVo avo) {
		Connection conn = getConnection();
		AsgListVo vo = new AsgListDao().readBoard(conn, avo);
		close(conn);
		return vo;
	}
	
	public AsgListVo readBoard(int bANo) {
		Connection conn = getConnection();
		AsgListVo vo = new AsgListDao().readBoard(conn, bANo);
		close(conn);
		return vo;
	}
	
	//게시글 수정하기
	public int updateBoard(AsgListVo vo) {
		Connection conn = getConnection();
		int result = new AsgListDao().updateBoard(conn, vo);
		close(conn);
		return result;
	}

	//게시글 삭제하기
	public int deleteBoard(int bANo) {
		Connection conn = getConnection();
		int result = new AsgListDao().deleteBoard(conn, bANo);
		close(conn);
		return result;
	}
	
	//게시글 여러개 삭제하기
	public int multiDeleteBoard(String[] delNo) {
		Connection conn = getConnection();
		int result = new AsgListDao().multiDeleteBoard(conn, delNo);
		close(conn);
		return result;
	}
	
	//게시판 목록 띄우기
	public ArrayList<AsgListVo> AssignmentBoardlist() {
		Connection conn = getConnection();
		ArrayList<AsgListVo> volist = new AsgListDao().AssignmentBoardlist(conn);
		close(conn);
		return volist;
	}
	
	//게시판 목록 띄우기(페이징처리)
	public ArrayList<AsgListVo> AssignmentBoardlist(int startRnum,int endRnum) {
		Connection conn = getConnection();
		ArrayList<AsgListVo> volist = new AsgListDao().AssignmentBoardlist(conn,startRnum,endRnum);
		close(conn);
		return volist;
	}

	//게시판 갯수 구하기
	public int countListBoard() {
		Connection conn = getConnection();
		int result = new AsgListDao().countListBoard(conn);
		close(conn);
		return result;
	}
	
	//댓글 달기
	public int insertAsgComments(AsgCommentVo avo) {
		Connection conn = getConnection();
		int result = new AsgListDao().insertAsgComments(conn,avo);
		close(conn);
		return result;
	}
	
	//댓글 삭제
	public int deleteComment(int cNo) {
		Connection conn = getConnection();
		int result = new AsgListDao().deleteComment(conn, cNo);
		close(conn);
		return result;
	}
	
	//게시글 내용,댓글 
		public ArrayList<AsgCommentVo> readBoardAndComment(AsgCommentVo avo) {
			Connection conn = getConnection();
			ArrayList<AsgCommentVo> volist = new AsgListDao().readBoardAndComment(conn, avo);
			close(conn);
			return volist;
	}
	
	public int insertAsgComment(AsgCommentVo avo, AsgFileVo fvo) {
		Connection conn = getConnection();
		setAutoCommit(conn, false);
		
		AsgListDao dao = new AsgListDao();
		int nextVal = dao.selectSeqCommentNoNextVal(conn);
		
		int result = dao.insertAsgComment(conn, avo, nextVal);
		
		if(result > 0 && fvo != null) {
			result = dao.insertAsgFile(conn, fvo, nextVal);
		}
		if(result >0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
	
//	//댓글 추가(파일업로드)
//		public int insertAsgComment(AsgCommentVo avo) {
//			Connection conn = getConnection();
//			int result = new AsgListDao().insertAsgComment(conn, avo);
//			close(conn);
//			return result;
//		}
//	
//	//파일 추가
//		public int insertAsgFile(AsgFileVo fvo) {
//			Connection conn = getConnection();
//			int result = new AsgListDao().insertAsgFile(conn, fvo);
//			close(conn);
//			return result;
//		}
		
}