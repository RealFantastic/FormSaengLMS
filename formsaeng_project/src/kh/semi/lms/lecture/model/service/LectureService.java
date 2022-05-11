package kh.semi.lms.lecture.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.lms.lecture.model.dao.LectureDao;
import kh.semi.lms.lecture.model.vo.LectureVo;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;
public class LectureService {

	public int insertVideo(LectureVo vo) {
		Connection conn = getConnection();
		int result = new LectureDao().insertVideo(conn, vo);
		System.out.println("vo : "+vo);
		close(conn);
		return result;
	}
	
	public ArrayList<LectureVo> lectureBoardListP(String user_id, String user_subCode){
		Connection conn = getConnection();
		ArrayList<LectureVo> volist = new LectureDao().lectureBoardListP(conn,user_id,user_subCode);
		close(conn);
		return volist;
	}
	
	public ArrayList<LectureVo> lectureBoardListS(String user_id, String user_subCode){
		Connection conn = getConnection();
		ArrayList<LectureVo> volist = new LectureDao().lectureBoardListS(conn,user_id,user_subCode);
		close(conn);
		return volist;
	}
	
	public LectureVo lecturePath(int lecNo) {
		Connection conn = getConnection();
		LectureVo vo = new LectureDao().lecturePath(conn, lecNo);
		close(conn);
		return vo;
	}
}
