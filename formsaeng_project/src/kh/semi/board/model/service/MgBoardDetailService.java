package kh.semi.board.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;

import kh.semi.board.model.dao.MgBoardDetailDao;
import kh.semi.board.model.vo.MgBoardListVo;

public class MgBoardDetailService {

	public String detailBoardView() {
		Connection conn = getConnection();

		String result = null;

		result = new MgBoardDetailDao().detailBoardView(conn);

		close(conn);
		return result;
	}
}
