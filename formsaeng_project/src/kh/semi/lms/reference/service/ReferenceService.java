package kh.semi.lms.reference.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;



import kh.semi.lms.reference.dao.ReferenceDao;
import kh.semi.lms.reference.vo.ReferenceVo;


public class ReferenceService {
	public ArrayList<ReferenceVo> referenceboardlist(){
		
		ArrayList<ReferenceVo> result = null;
		Connection conn = getConnection();
		
		result = new ReferenceDao().ReferenceBoardlist(conn);
		
		close(conn);
		
		return result;
	}
	public int insertReferenceBoard(ReferenceVo vo) {
		Connection conn =getConnection();
		int result = new ReferenceDao().ReferenceinsertBoard(conn, vo);
		close(conn);
		return result;
	}
	public int deletReferenceBoard(ReferenceVo vo) {
		Connection conn =getConnection();
		int result = new ReferenceDao().ReferencedeleteBoard(conn, vo);
		close(conn);
		return result;
	}
	public ReferenceVo detailBoardView(int nno) {
		Connection conn = getConnection();
		ReferenceVo vo = new ReferenceDao().detailBoard(conn, nno);
		close(conn);
		return vo;
	}

}
