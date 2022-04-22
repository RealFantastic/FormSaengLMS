package kh.semi.board.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.board.model.dao.MgBoardListDao;
import kh.semi.board.model.vo.MgBoardListVo;

public class MgBoardListService {

		public ArrayList<MgBoardListVo> view(){
			Connection conn = getConnection();
			
			ArrayList<MgBoardListVo> result=null;
			
			result=new MgBoardListDao().view(conn);
			
			close(conn);
			return result;
		}
}