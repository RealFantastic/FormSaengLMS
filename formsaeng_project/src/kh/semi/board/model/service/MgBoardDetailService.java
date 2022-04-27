package kh.semi.board.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;

import kh.semi.board.model.dao.MgBoardDetailDao;
import kh.semi.board.model.vo.MgBoardListVo;

public class MgBoardDetailService {

	private MgBoardDetailDao dao=new MgBoardDetailDao();
	
	public MgBoardListVo detailBoardView(int nno) {
		Connection conn = getConnection();

		MgBoardListVo vo = new MgBoardDetailDao().detailBoardView(conn, nno);
		
		close(conn);
		return vo;
	}
}
