package kh.semi.lms.lecture.board.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.lms.lectureboard.dao.LectureBoardDao;
import kh.semi.lms.lectureboard.vo.LectureBoardVo;


public class LectureBoardService {
	public ArrayList<LectureBoardVo> LectureBoardlist(){
		
		ArrayList<LectureBoardVo> result = null;
		Connection conn = getConnection();
		
		result = new LectureBoardDao().LectureBoardlist(conn);
		
		close(conn);
		
		return result;
	}

}
