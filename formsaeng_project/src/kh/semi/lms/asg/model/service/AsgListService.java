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
	
	//�Խñ� �߰��ϱ�
	public int insertBoard(AsgListVo vo) {
		Connection conn = getConnection();
		int result =  new AsgListDao().insertBoard(conn, vo);
		close(conn);
		return result;
	}
	
	//�Խñ� �󼼺���
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
	
	//�Խñ� �����ϱ�
	public int updateBoard(AsgListVo vo) {
		Connection conn = getConnection();
		int result = new AsgListDao().updateBoard(conn, vo);
		close(conn);
		return result;
	}

	//�Խñ� �����ϱ�
	public int deleteBoard(int bANo) {
		Connection conn = getConnection();
		int result = new AsgListDao().deleteBoard(conn, bANo);
		close(conn);
		return result;
	}
	
	//�Խñ� ������ �����ϱ�
	public int multiDeleteBoard(String[] delNo) {
		Connection conn = getConnection();
		int result = new AsgListDao().multiDeleteBoard(conn, delNo);
		close(conn);
		return result;
	}
	
	//�Խ��� ��� ����
	public ArrayList<AsgListVo> AssignmentBoardlist() {
		Connection conn = getConnection();
		ArrayList<AsgListVo> volist = new AsgListDao().AssignmentBoardlist(conn);
		close(conn);
		return volist;
	}
	
	//�Խ��� ��� ����(����¡ó��)
	public ArrayList<AsgListVo> AssignmentBoardlist(int startRnum,int endRnum) {
		Connection conn = getConnection();
		ArrayList<AsgListVo> volist = new AsgListDao().AssignmentBoardlist(conn,startRnum,endRnum);
		close(conn);
		return volist;
	}

	//�Խ��� ���� ���ϱ�
	public int countListBoard() {
		Connection conn = getConnection();
		int result = new AsgListDao().countListBoard(conn);
		close(conn);
		return result;
	}
	
	//��� �ޱ�
	public int insertAsgComment(AsgCommentVo avo) {
		Connection conn = getConnection();
		int result = new AsgListDao().insertAsgComment(conn,avo);
		close(conn);
		return result;
	}
	
	//�Խñ� ����,��� 
		public ArrayList<AsgCommentVo> readBoardAndComments(AsgCommentVo avo) {
			Connection conn = getConnection();
//			AsgListVo vo = new AsgListDao().readBoard(conn,avo);
			ArrayList<AsgCommentVo> volist = new AsgListDao().readBoardAndComments(conn, avo);
			close(conn);
			
//			vo.setReVolist(reVolist);
			
			return volist;
		}
		
		
		//�Խñ� ����,��� - Map���
//		public Map<String, Object> readBoardAndReCommentMap(int bNo) {
//			Connection conn = getConnection();
//			BoardVo vo = dao.readBoard(conn,bNo);
//			ArrayList<ReCommentVo> rVolist = dao.readBoardReComments(conn,bNo);
//			close(conn);
//			
//			Map<String, Object> result = new HashMap<String, Object>();
//			result.put("board", vo);
//			result.put("rVolist", rVolist);
//			
//			return result;
//		}
//		ArrayList<AsgCommentVo> reVolist
	
//	public AsgListVo readBoardAndComment(int bNo) {
//		Connection conn = getConnection();
//		AsgListVo vo = new AsgListDao().readBoard(conn, bNo);
//		vo.setReVolist(new AsgListDao().readBoardAndComments(conn, bNo));
//		close(conn);
//		
//		return vo;
//	}
}