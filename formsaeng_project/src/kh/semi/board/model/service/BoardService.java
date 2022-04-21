package kh.semi.board.model.service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kh.semi.board.model.dao.BoardDao;
import kh.semi.board.model.vo.BoardVo;
import kh.semi.board.model.vo.CommentVo;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

public class BoardService {
	public int insertBoard(BoardVo vo) {
		Connection conn = getConnection();
		int result =  new BoardDao().insertBoard(conn, vo);
		close(conn);
		return result;
	}
	
	public ArrayList<BoardVo> AssignmentBoardlist() {
		Connection conn = getConnection();
		ArrayList<BoardVo> volist = new BoardDao().AssignmentBoardlist(conn);
		close(conn);
		return volist;
	}
	
	public ArrayList<BoardVo> AssignmentBoardlist(int startRnum,int endRnum) {
		Connection conn = getConnection();
		ArrayList<BoardVo> volist = new BoardDao().AssignmentBoardlist(conn,startRnum,endRnum);
		close(conn);
		return volist;
	}
	
	
	
	public int countListBoard() {
		Connection conn = getConnection();
		int result = new BoardDao().countListBoard(conn);
		close(conn);
		return result;
	}
	
	public BoardVo readBoard(int bNo) {
		Connection conn = getConnection();
		BoardVo vo = new BoardDao().readBoard(conn, bNo);
		return vo;
	}

	
	public BoardVo readBoardAndComment(int bNo) {
		Connection conn = getConnection();
		BoardVo vo = new BoardDao().readBoard(conn, bNo);
		vo.setReVolist(new BoardDao().readBoardAndComments(conn, bNo));
		close(conn);
		
		return vo;
	}
}