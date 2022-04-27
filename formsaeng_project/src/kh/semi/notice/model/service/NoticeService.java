package kh.semi.notice.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.notice.model.dao.NoticeDao;
import kh.semi.notice.model.vo.NoticeVo;

public class NoticeService {

		public ArrayList<NoticeVo> view(){
			Connection conn = getConnection();
			
			ArrayList<NoticeVo> result=null;
			
			result=new NoticeDao().view(conn);
			
			close(conn);
			return result;
		}
		public NoticeVo detailBoardView(int nno) {
			Connection conn = getConnection();

			NoticeVo vo = new NoticeDao().detailBoardView(conn, nno);
			
			close(conn);
			return vo;
		}
		public int insertBoard(NoticeVo vo) {
			int result=0;
			
			Connection conn=getConnection();
			
			result=new NoticeDao().insertBoard(conn, vo);
			
			return result;
		}
}